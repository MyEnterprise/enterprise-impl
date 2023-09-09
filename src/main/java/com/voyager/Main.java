package com.voyager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.plugin.entity.PluginManager;

public class Main{

	public final static String jarPath = "/home/administrador/Desktop/Untitled.jar";

	public static void main(String... args) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		var pluginLoader = new PluginLoader(new File(jarPath));
		pluginLoader.build( null );
	}

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