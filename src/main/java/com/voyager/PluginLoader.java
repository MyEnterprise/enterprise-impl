package com.voyager;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.voyager.enterprise.event.CreateEnterprise;
import com.voyager.enterprise.event.EventHandler;
import com.voyager.enterprise.event.UpdateEnterprise;
import com.voyager.enterprise.financial.event.CreateBook;
import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.plugin.entity.PluginManager;
import com.voyager.enterprise.server.listener.EventListener;


public class PluginLoader extends URLClassLoader {

	private final JarFile jarFile;
	private final Map<String, Class<?>> classesPlugin = new HashMap<>();
	private final Map<String, Class<?>> classesListener = new HashMap<>();

	public PluginLoader(File file) throws IOException{
		super( new URL[] {file.toURI().toURL()}  );
		this.jarFile = new JarFile(file);
    }
	
	public Plugin build( PluginManager pm ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        
    	Enumeration<JarEntry> e = jarFile.entries();
    	
        while (e.hasMoreElements()) {
            JarEntry jarEntry = e.nextElement();
            
            if (jarEntry.getName().endsWith(".class")) {
                String className = jarEntry.getName()
                        .replace("/", ".")
                        .replace(".class", "");
                
                Class<?> pluginClass = this.loadClass(className);

                // Verifique se a classe implementa a interface Plugin
                boolean notInterface = !pluginClass.isInterface();
                boolean isAssignablePluginAndClass = notInterface && Plugin.class.isAssignableFrom(pluginClass);  
                boolean isAssignableEventListenerAndClass = notInterface && EventListener.class.isAssignableFrom(pluginClass);
                
                if( isAssignablePluginAndClass ) {
                	classesPlugin.put( className, 
                			pluginClass
                	);
                }

                if( isAssignableEventListenerAndClass ) {
                	
                	classesListener.put( className, 
                			pluginClass
                	);
                }
                
            } else {
            	//System.out.println("FILE resource: ");
            	//System.out.println(jarEntry.getName());
            }
        }
        
        
        System.out.println("List Listener in Jar:");
        System.out.println(classesListener);
        for(Entry<String, Class<?>> plugin : classesListener.entrySet()) {
        	System.out.println("\t Class: "+ plugin.getKey());
        	Method[] listMethod = plugin.getValue().getMethods();
        	for(Method method : listMethod) {
        		System.out.println("\t\t Method: "+method.getName());
        		if( !method.isAnnotationPresent(EventHandler.class) ){
        			
        			 Annotation[] annotations = method.getDeclaredAnnotations();

    		        // Itera sobre as annotations e imprime seus nomes
    		        for (Annotation annotation : annotations) {
    		            boolean isAssingedEventHandler = annotation.annotationType().isAnnotationPresent(EventHandler.class); 
    		            if( isAssingedEventHandler ) {
    		            	System.out.println("\t\t\tAnnotation: " + annotation.annotationType().getName());
    		            }
    		        }
        			
        		} else System.out.println("Vincular!!");
        	}
        }
        
        System.out.println("List Plugins in Jar:");
        System.out.println(classesPlugin);
        for(Entry<String, Class<?>> plugin : classesPlugin.entrySet()) {
        	
        }
        return null;
        
    }
}
