package com.voyager.enterprise.impl.comercial;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.voyager.enterprise.commercial.usercase.CaseSale;
import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.usercase.CaseGeneric;

public class ServerCommercial implements Runnable, ManagerCommercial {

	public static final ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();
	private ServerManager sm;
	
	public ServerCommercial(ServerManager sm) {	this.sm = sm; }

	public String teste(String data) {
		return "PROCESSS "+data;
	}

	@Override
	public void run() {
		
		do {
			var act = queue.poll();
			if( act == null ) {	sleepLoop(30); continue; }

			// check state servers
			// check queue
			applyQueue(act);

			// after time
			sleepLoop(15);			
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

	@Override
	public <T> T useCase(Class<T> usecase) {
		
		

		return null;
	}

}
