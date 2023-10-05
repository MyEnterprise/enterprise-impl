package com.voyager.enterprise.impl;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.comercial.ServerCommercial;
import com.voyager.enterprise.impl.economy.ServerEconomy;
import com.voyager.enterprise.impl.financial.ServerFinancial;
import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.impl.people.ServerPeople;
import com.voyager.enterprise.impl.plugin.ServerPlugin;
import com.voyager.enterprise.impl.project.ServerProject;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.economy.ManagerEconomy;
import com.voyager.enterprise.manager.financial.ManagerFinancial;
import com.voyager.enterprise.manager.logistics.ManagerLogistics;
import com.voyager.enterprise.manager.people.ManagerPeople;
import com.voyager.enterprise.manager.project.ManagerProject;
import com.voyager.enterprise.server.Server;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;


public class ServerManager implements Server, Runnable {
	
	public static final ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();

	private Database db;
	
	private Thread tManager;
	private ServerCommercial commercial;
	private Thread tCommercial;
	private ServerEconomy economy;
	private Thread tEconomy;
	private ServerFinancial financial;
	private Thread tFinancial;
	private ServerLogistics logistics;
	private Thread tLogistics;
	private ServerOperation operation;
	private Thread tOperation;
	private ServerPeople people;
	private Thread tPeople;
	private ServerPlugin plugin;
	private Thread tPlugin;
	private ServerProject project;
	private Thread tProject;

	// Config args
	public static ServerManager build() {
		var server = new ServerManager();
		
		server.setCommercial( new ServerCommercial(server) )
		.setEconomy(new ServerEconomy(server))
		.setFinancial(new ServerFinancial(server))
		.setLogistics(new ServerLogistics(server))
		.setOperation(new ServerOperation(server))
		.setPeople(new ServerPeople(server))
		.setPlugin(new ServerPlugin(server))
		.setProject(new ServerProject(server));
		
		return server;
	}

	public void initialize() throws Throwable {
		
		this.initializeDB();
		this.initializeServers();
		
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
	
	private void initializeDB() throws IOException {
		//this.db = DB.getDefault();
		
		//DbMigration dbMigration = DbMigration.create();
		//dbMigration.setPlatform(Platform.POSTGRES);
		
		//dbMigration.generateMigration();
	}
	
	private void initializeServers() {
		tCommercial = new Thread(this.commercial);
		tEconomy = new Thread(this.economy);
		tFinancial = new Thread(this.financial);
		tLogistics = new Thread(this.logistics);
		tOperation = new Thread(this.operation);
		tPeople = new Thread(this.people);
		tPlugin = new Thread(this.plugin);
		tProject = new Thread(this.project);
		
		tManager = new Thread(this);
		tManager.start();
		
		tEconomy.start();
		tCommercial.start();
		tFinancial.start();
		tLogistics.start();
		tOperation.start();
		tPeople.start();
		tPlugin.start();
		tProject.start();
	}

	@Override
	public ManagerCommercial getManagerCommercial() {
		return commercial;
	}

	@Override
	public ManagerEconomy getManagerEconomy() {
		return economy;
	}

	@Override
	public ManagerFinancial getManagerFinancial() {
		return financial;
	}

	@Override
	public ManagerLogistics getManagerLogistics() {
		return logistics;
	}

	@Override
	public ManagerPeople getManagerPeople() {
		return people;
	}

	@Override
	public ManagerProject getManagerProject() {
		return project;
	}

	@Override
	public Properties getConfig() {
		return null;
	}

	public ServerCommercial getCommercial() {
		return commercial;
	}

	public ServerManager setCommercial(ServerCommercial commercial) {
		this.commercial = commercial;
		return this;
	}

	public ServerEconomy getEconomy() {
		return economy;
	}

	public ServerManager setEconomy(ServerEconomy economy) {
		this.economy = economy;
		return this;
	}

	public ServerFinancial getFinancial() {
		return financial;
	}

	public ServerManager setFinancial(ServerFinancial financial) {
		this.financial = financial;
		return this;
	}

	public ServerLogistics getLogistics() {
		return logistics;
	}

	public ServerManager setLogistics(ServerLogistics logistics) {
		this.logistics = logistics;
		return this;
	}

	public ServerOperation getOperation() {
		return operation;
	}

	public ServerManager setOperation(ServerOperation operation) {
		this.operation = operation;
		return this;
	}

	public ServerPeople getPeople() {
		return people;
	}

	public ServerManager setPeople(ServerPeople people) {
		this.people = people;
		return this;
	}

	public ServerPlugin getPlugin() {
		return plugin;
	}

	public ServerManager setPlugin(ServerPlugin plugin) {
		this.plugin = plugin;
		return this;
	}

	public ServerProject getProject() {
		return project;
	}

	public ServerManager setProject(ServerProject project) {
		this.project = project;
		return this;
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
