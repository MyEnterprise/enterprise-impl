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

	public static void main(String[] args){
		
		// Load Plugin from Jar File
		//String jarPath = "/home/administrador/Desktop/Untitled.jar";
		//var pluginLoaderJar = new PluginLoader(new File(jarPath)).build();

		// Load Plugin from Class
		//var pluginLoaderClass = new PluginLoader(MyPluginInClass.class).build();

		// Init Server
		System.out.println("INIT SERVER'S");
		
		var server = ServerManager.build();
		
		server.initialize();
		
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
}	