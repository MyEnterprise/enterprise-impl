package com.voyager.enterprise.impl.financial;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.comercial.ServerCommercial;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.financial.ManagerFinancial;

public class ServerFinancial implements ManagerFinancial, Runnable {

	public static final  ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();
	private ServerManager sm;
	
	public ServerFinancial(ServerManager server) {
		this.sm = server;
	}

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
	
}
