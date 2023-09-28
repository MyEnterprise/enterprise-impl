package com.voyager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;

import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.plugin.entity.Plugin;

import com.voyager.pluginTest.MyPluginInClass;

public class Main{

	public final static String jarPath = "/home/administrador/Desktop/Untitled.jar";

	public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InterruptedException {
		
		// Load Plugin from Jar File
		var pluginLoaderJar = new PluginLoader(new File(jarPath)).build();

		// Load Plugin from Class
		var pluginLoaderClass = new PluginLoader(MyPluginInClass.class).build();

		// Init Server
		System.out.println("INIT SERVER'S");
		
		var server = new ServerManager();
		new ServerOperation();
		
			Thread.sleep(300);
			System.out.println( "DATA: "+ ServerManager.circuitBreaker.decorateSupplier(()-> "SSEENNDD").get() );
		
	}

	/* Index listener
    System.out.println("List Listener in Jar:");
    System.out.println(classesListener);
    for(Entry<String,MyPair<Class<?>, Constructor<?>>> listener : classesListener.entrySet()) {
    	System.out.println("\t Class: "+ listener.getKey());
    	Method[] listMethod = listener.getValue().getKey().getMethods();
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
*/
	
	
	
	
	
	
	
	
	
	
	// Legacy
	public void teste01() {

        
        try {

            File jar = new File(jarPath);
            ArrayList<Plugin> listPluginClass = new ArrayList<>(); 
            // Crie o classloader com a URL do JAR
            URLClassLoader loader = new URLClassLoader(new URL[] { new URL("file://" + jarPath) });

        	JarFile jarFile = new JarFile(jar);
            Enumeration<JarEntry> e = jarFile.entries();

            while (e.hasMoreElements()) {
                JarEntry jarEntry = e.nextElement();
                
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName()
                            .replace("/", ".")
                            .replace(".class", "");
                    
                    Class<?> pluginClass = loader.loadClass(className);

                    // Verifique se a classe implementa a interface Plugin
                    boolean notInterface = !pluginClass.isInterface();
                    boolean isAssignablePluginAndClass = notInterface && Plugin.class.isAssignableFrom(pluginClass);  

                    if( isAssignablePluginAndClass ) {
                    	Plugin plugin = (Plugin) pluginClass.getDeclaredConstructor().newInstance();
		                listPluginClass.add( plugin );
                    }
                }
            }

            for(Plugin plugin : listPluginClass) {
            	plugin.initialize(null);
            }

            loader.close();
        
        } catch (Exception e) {
        	e.printStackTrace();
        }

	}
}	