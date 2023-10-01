package com.voyager.enterprise.impl.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

import com.voyager.enterprise.impl.ServerManager;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.plugin.entity.Emitter;
import com.voyager.enterprise.plugin.entity.Plugin;
import com.voyager.enterprise.plugin.entity.PluginManager;
import com.voyager.enterprise.server.Server;

public class ServerPlugin implements PluginManager, Runnable {

	public static final ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();
	private ServerManager sm;
	
	public ServerPlugin(ServerManager server) {
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

	@Override
	public PluginManager register(Object eventFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager register(Method eventMethod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager register(String nameEvent, Function eventFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enablePlugin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disablePlugin() {
		// TODO Auto-generated method stub

	}

	@Override
	public Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getConfigGlobal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDB() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Plugin> findPluginByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Plugin> findPluginByPackage(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Class<?>> findPluginDependency(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Emitter emit() {
		// TODO Auto-generated method stub
		return null;
	}

}
