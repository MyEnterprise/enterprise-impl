package com.voyager.enterprise.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;

import com.voyager.enterprise.config.Config;
import com.voyager.enterprise.impl.action.ActionQueue;
import com.voyager.enterprise.impl.comercial.ServerCommercial;
import com.voyager.enterprise.impl.comercial.entities.BuyerEntity;
import com.voyager.enterprise.impl.domain.DBFactory;
import com.voyager.enterprise.impl.domain.MigrationFactory;
import com.voyager.enterprise.impl.economy.ServerEconomy;
import com.voyager.enterprise.impl.financial.ServerFinancial;
import com.voyager.enterprise.impl.logistics.ServerLogistics;
import com.voyager.enterprise.impl.operation.ServerOperation;
import com.voyager.enterprise.impl.people.ServerPeople;
import com.voyager.enterprise.impl.plugin.ServerPlugin;
import com.voyager.enterprise.impl.project.ServerProject;
import com.voyager.enterprise.impl.usecase.EnterpriseCase;
import com.voyager.enterprise.manager.ManagerEnterprise;
import com.voyager.enterprise.manager.comercial.ManagerCommercial;
import com.voyager.enterprise.manager.economy.ManagerEconomy;
import com.voyager.enterprise.manager.financial.ManagerFinancial;
import com.voyager.enterprise.manager.logistics.ManagerLogistics;
import com.voyager.enterprise.manager.people.ManagerPeople;
import com.voyager.enterprise.manager.project.ManagerProject;
import com.voyager.enterprise.server.Server;
import com.voyager.util.MyPair;
import com.voyager.util.Reflections;

import io.ebean.Database;

import io.ebean.dbmigration.DbMigration;

public class ServerManager implements Server, ManagerEnterprise, Runnable {

	public static final ConcurrentLinkedQueue<ActionQueue> queue = new ConcurrentLinkedQueue<>();

	private Database db;
	private DbMigration migration;
	private Config config;

	private Thread tManager;

	private MyPair<Thread, ServerCommercial> commercial = new MyPair();

	private MyPair<Thread, ServerEconomy> economy = new MyPair();

	private MyPair<Thread, ServerFinancial> financial = new MyPair();

	private MyPair<Thread, ServerLogistics> logistics = new MyPair();

	private MyPair<Thread, ServerOperation> operation = new MyPair();

	private MyPair<Thread, ServerPeople> people = new MyPair();

	private MyPair<Thread, ServerPlugin> plugin = new MyPair();

	private MyPair<Thread, ServerProject> project = new MyPair();

	// Config args
	public static ServerManager build(Config config) {

		var server = new ServerManager();

		server.config = config;

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

		this.db = DBFactory.build(this.config);

		this.migration = MigrationFactory.build(db);
		
		/*BuyerEntity buyer = new BuyerEntity();
		buyer.setName("Gil");
		db.insert(buyer);*/

	}
	
	private void initializeServers() {

		/*commercial.setKey( new Thread(this.commercial.getValue()) );
		economy.setKey( new Thread(this.economy.getValue()) );
		financial.setKey( new Thread(this.financial.getValue()) );
		logistics.setKey( new Thread(this.logistics.getValue()) );
		operation.setKey( new Thread(this.operation.getValue()) );
		people.setKey( new Thread(this.people.getValue()) );
		project.setKey( new Thread(this.project.getValue()) );

		plugin.setKey( new Thread(this.plugin.getValue()) );
		tManager = new Thread(this);

		tManager.start();
		plugin.getKey().start();
*/
	}

	@Override
	public ManagerCommercial getManagerCommercial() {
		return commercial.getValue();
	}

	@Override
	public ManagerEconomy getManagerEconomy() {
		return economy.getValue();
	}

	@Override
	public ManagerFinancial getManagerFinancial() {
		return financial.getValue();
	}

	@Override
	public ManagerLogistics getManagerLogistics() {
		return logistics.getValue();
	}

	@Override
	public ManagerPeople getManagerPeople() {
		return people.getValue();
	}

	@Override
	public ManagerProject getManagerProject() {
		return project.getValue();
	}

	@Override
	public Properties getConfig() {
		return null;
	}

	public ServerCommercial getCommercial() {
		return commercial.getValue();
	}

	public ServerManager setCommercial(ServerCommercial commercial) {
		this.commercial.setValue(commercial);
		return this;
	}

	public ServerEconomy getEconomy() {
		return economy.getValue();
	}

	public ServerManager setEconomy(ServerEconomy economy) {
		this.economy.setValue(economy);
		return this;
	}

	public ServerFinancial getFinancial() {
		return financial.getValue();
	}

	public ServerManager setFinancial(ServerFinancial financial) {
		this.financial.setValue(financial);
		return this;
	}

	public ServerLogistics getLogistics() {
		return logistics.getValue();
	}

	public ServerManager setLogistics(ServerLogistics logistics) {
		this.logistics.setValue(logistics);
		return this;
	}

	public ServerOperation getOperation() {
		return operation.getValue();
	}

	public ServerManager setOperation(ServerOperation operation) {
		this.operation.setValue(operation);
		return this;
	}

	public ServerPeople getPeople() {
		return people.getValue();
	}

	public ServerManager setPeople(ServerPeople people) {
		this.people.setValue(people);
		return this;
	}

	public ServerPlugin getPlugin() {
		return plugin.getValue();
	}

	public ServerManager setPlugin(ServerPlugin plugin) {
		this.plugin.setValue(plugin);
		return this;
	}

	public ServerProject getProject() {
		return project.getValue();
	}

	public ServerManager setProject(ServerProject project) {
		this.project.setValue(project);
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

	private Map<String, Object> dictUseCase = new HashMap<String, Object>();
	@Override
	public <T> T useCase(Class<T> usecase) throws UnsupportedOperationException {
		
		String packageFind = EnterpriseCase.class.getPackage().getName();
		
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
