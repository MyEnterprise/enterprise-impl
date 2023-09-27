package com.voyager;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
import com.voyager.pluginTest.MyPluginInClass;
import com.voyager.util.MyPair;


public class PluginLoader extends URLClassLoader {

	private final JarFile jarFile;
	private final Class<?> plugin;

	private final Map<String, MyPair<Class<?>, Constructor<?>>> classesPlugin = new HashMap<>();
	private final Map<String, MyPair<Class<?>, Constructor<?>>> classesListener = new HashMap<>();

	private Map<String, List<Entry<String, Optional<Class<?>>>>> dependenciesPlugin = new HashMap<>();
	private Map<String, List<Entry<String, Optional<Class<?>>>>> dependenciesListener = new HashMap<>();

	public PluginLoader(File file) throws IOException {
		super( new URL[] {file.toURI().toURL()}  );
		this.jarFile = new JarFile(file);
		this.plugin = null;
    }

	public PluginLoader(Class plugin){
		super( new URL[0] );
		this.jarFile = null;
		this.plugin = plugin;
    }

	public PluginLoader build() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		if( jarFile != null )
			return buildJar();
		else
			return buildClassPlugin();
	}

	private PluginLoader buildClassPlugin() {

		String packageName = plugin.getPackage().getName();
        
        List<Class<?>> classesInPackage = getClassesInPackageAndSubpackages(packageName);
        
        indexClassesAndDependencies(classesInPackage);
		
		return this;
	}

	private void indexClassesAndDependencies(List<Class<?>> classesInPackage ) {
		
		for(Class<?> pluginClass : classesInPackage) {
			
			boolean notInterface = !pluginClass.isInterface();
            boolean isAssignablePluginAndClass = notInterface && Plugin.class.isAssignableFrom(pluginClass);  
            boolean isAssignableEventListenerAndClass = notInterface && EventListener.class.isAssignableFrom(pluginClass);
            
            if( isAssignablePluginAndClass ) {

            	classesPlugin.put(
            			pluginClass.getName(), // package
            			new MyPair<Class<?>, Constructor<?>>(pluginClass, getListConstructorsPlugin(pluginClass)[0])
            	);
            }

            if( isAssignableEventListenerAndClass ) {
            	
            	classesListener.put(
            			pluginClass.getName(), // package
            			new MyPair<Class<?>, Constructor<?>>(pluginClass, getListConstructorsPlugin(pluginClass)[0])
            	);
            }
		}
		
		// Dependencies Plugin
        for (Entry<String,MyPair<Class<?>, Constructor<?>>> plugin : classesPlugin.entrySet()) {
        	dependenciesPlugin.put( plugin.getKey() , dependencies( plugin ) );
        }

        // Dependencies Listener
        for (Entry<String,MyPair<Class<?>, Constructor<?>>> listener : classesListener.entrySet()) {
        	dependenciesListener.put( listener.getKey() , dependencies( listener ) );
        }
        
	}
	private PluginLoader buildJar() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
    	Enumeration<JarEntry> e = jarFile.entries();
    	
    	List<Class<?>> classesInPackage = new ArrayList<>();
    	
        while (e.hasMoreElements()) {
            JarEntry jarEntry = e.nextElement();
            
            if (jarEntry.getName().endsWith(".class")) {
                String className = jarEntry.getName()
                        .replace("/", ".")
                        .replace(".class", "");
                
                Class<?> pluginClass = this.loadClass(className);
                classesInPackage.add(pluginClass);
                

            } else {
            	//System.out.println("FILE resource: ");
            	//System.out.println(jarEntry.getName());
            }
        }
        
        indexClassesAndDependencies(classesInPackage);
        
        return this;
    }

	private List<Entry<String, Optional<Class<?>>>> dependencies( Entry<String, MyPair<Class<?>, Constructor<?>>> plugin) {

		Constructor<?> construtor = plugin.getValue().getValue();

		List<Entry<String, Optional<Class<?>>>> listDependencies =  new ArrayList<>(construtor.getParameters().length);


        Parameter[] parametros = construtor.getParameters();
        for (Parameter parametro : parametros) {

            listDependencies.add(new MyPair<String, Optional<Class<?>>>(parametro.getType().getName(), null ));

        }

		return listDependencies;
	}

	public static List<Class<?>> getClassesInPackageAndSubpackages(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try {
            Enumeration<URL> resources = classLoader.getResources(packagePath);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.getFile());

                if (directory.isDirectory()) {
                    classes.addAll(searchClassesInDirectory(directory, packageName));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classes;
    }

    private static List<Class<?>> searchClassesInDirectory(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(searchClassesInDirectory(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }

        return classes;
    }
	

	private Constructor<?>[] getListConstructorsPlugin(Class<?> classe) {
		return classe.getDeclaredConstructors();
	}

	public Map<String, List<Entry<String, Optional<Class<?>>>>> getDependenciesPlugin() {
		return dependenciesPlugin;
	}

	public void setDependenciesPlugin(Map<String, List<Entry<String, Optional<Class<?>>>>> dependenciesPlugin) {
		this.dependenciesPlugin = dependenciesPlugin;
	}

	public Map<String, List<Entry<String, Optional<Class<?>>>>> getDependenciesListener() {
		return dependenciesListener;
	}

	public void setDependenciesListener(Map<String, List<Entry<String, Optional<Class<?>>>>> dependenciesListener) {
		this.dependenciesListener = dependenciesListener;
	}

	public JarFile getJarFile() {
		return jarFile;
	}

	public Map<String, MyPair<Class<?>, Constructor<?>>> getClassesPlugin() {
		return classesPlugin;
	}

	public Map<String, MyPair<Class<?>, Constructor<?>>> getClassesListener() {
		return classesListener;
	}

	
}
