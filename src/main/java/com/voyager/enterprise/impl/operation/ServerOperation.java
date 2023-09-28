package com.voyager.enterprise.impl.operation;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.operation.ManagerOperation;

public class ServerOperation implements ManagerOperation{

	public ServerOperation() {
		// send event e reciver response to service -> ServerManager.circuitBreaker.decorateSupplier();
		System.out.println("DATA: "+ ServerManager.circuitBreaker.decorateSupplier(()-> "SSEENNDD").get() );
		ServerManager.circuitBreaker.decorateConsumer(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("ServerOperation:");
				System.out.println(t);
			}
		});
	}
	
	

}
