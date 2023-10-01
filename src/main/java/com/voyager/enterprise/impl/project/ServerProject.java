package com.voyager.enterprise.impl.project;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.project.ManagerProject;

public class ServerProject implements ManagerProject, Runnable {
	
	public static final ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();
	private ServerManager sm;
	
	public ServerProject(ServerManager server) {
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
