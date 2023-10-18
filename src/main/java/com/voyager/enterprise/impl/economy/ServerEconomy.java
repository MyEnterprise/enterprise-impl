package com.voyager.enterprise.impl.economy;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.comercial.ServerCommercial;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.economy.ManagerEconomy;
import com.voyager.util.Reflections;

public class ServerEconomy implements ManagerEconomy, Runnable {

	public static final  ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();
	private ServerManager sm;

	public ServerEconomy(ServerManager sm) { this.sm = sm;	}

	@Override
	public void run() {
		do {
			var act = queue.poll();
			if( act == null ) {	sleepLoop(50); continue; }

			// check state servers
			// check queue
			applyQueue(act);


			// after time
			sleepLoop(25);			
		}while( true );
	}
	
	private void applyQueue(ActionQueue act) {
		var result = act.getAction().apply(act.getData());
		act.getCall().accept(result);
	}

	private void sleepLoop(long time) {
        try {  Thread.sleep( time ); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

	private Map<String, Object> dictUseCase = new HashMap<String, Object>();
	@Override
	public <T> T useCase(Class<T> usecase) throws UnsupportedOperationException {
		
		String packageFind = getClass().getPackage().getName();
		
		if( dictUseCase.containsKey(packageFind) ) return (T) dictUseCase.get(packageFind);
		
		
		T instance = (T) Reflections.findImplInterfaceInPackage(packageFind, usecase).map(classe -> {
			try {
				return classe.getConstructor(this.getClass()).newInstance(this);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				try {
					return classe.getConstructors()[0].newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			throw new UnsupportedOperationException("Unimplemented method 'listAll'");
		}).orElseThrow(()-> { throw new UnsupportedOperationException("Unimplemented method 'listAll'"); });

		
		dictUseCase.put( packageFind, instance);
		
		
		return instance;
	}

}