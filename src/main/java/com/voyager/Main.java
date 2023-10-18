package com.voyager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.voyager.enterprise.commercial.usercase.CaseSale;
import com.voyager.enterprise.config.Config;
import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.comercial.models.BuyerEntity;
import com.voyager.enterprise.impl.domain.DBFactory;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.plugin.entity.Plugin;

import com.voyager.pluginTest.MyPluginInClass;

import io.ebean.dbmigration.DbMigration;
import io.ebean.migration.MigrationConfig;
import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.annotation.Platform;
import io.ebean.config.DatabaseConfig;

public class Main{

	public static void main(String[] args) throws Throwable{

		// Load Plugin from Jar File
		//String jarPath = "/home/administrador/Desktop/Untitled.jar";
		//var pluginLoaderJar = new PluginLoader(new File(jarPath)).build();

		// Load Plugin from Class
		//var pluginLoaderClass = new PluginLoader(MyPluginInClass.class).build();

		// Init Server
		System.out.println("INIT SERVER'S");
		Config conf = new Config();

		var server = ServerManager.build(conf);
		
		server.initialize();

		CaseSale sale = server.getCommercial().useCase(CaseSale.class);
		System.out.println(sale);
		sale.create(null);
		/* Queue:
		 * server.queue.add(new ActionQueue<>(ServerManager::getLogistics)
				.data(null)
				.call(arg0 -> {
			
				}));
		*/
		
	    //MigrationConfig config = new MigrationConfig();
	    //config.setDbUsername("sa");
	    //config.setDbPassword("");
	    //config.setDbUrl("jdbc:h2:mem:db1");

	    // or load from Properties
	    //Properties properties = ...
	    //config.load(properties);

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