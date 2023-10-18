package com.voyager.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.server.listener.EventListener;

public class Reflections {

	public static Optional<Class<?>> findImplInterfaceInPackage(String packageName, Class<?> usecase) {

        List<Class<?>> classesInPackage = getClassesInPackageAndSubpackages(packageName);
        
        for(Class<?> classe : classesInPackage) {
			
			boolean notInterface = !classe.isInterface();
            boolean isAssignablePluginAndClass = notInterface && usecase.isAssignableFrom(classe);  
            
            if( isAssignablePluginAndClass ) {

            	return Optional.of(classe);
            	
            }

		}
        
        return Optional.empty(); 
        
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
}
