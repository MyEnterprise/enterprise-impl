package com.voyager;

import com.voyager.enterprise.config.Config;
import com.voyager.enterprise.impl.ServerManager;

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

		//CaseSale sale = server.getCommercial().useCase(CaseSale.class);
		//System.out.println(sale);
		//sale.create(null);
		// Queue:
		// server.queue.add(new ActionQueue<>(ServerManager::getLogistics)
		//		.data(null)
		//		.call(arg0 -> {
		//
		//		}));

		
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