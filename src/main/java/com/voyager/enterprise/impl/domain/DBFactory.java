package com.voyager.enterprise.impl.domain;

import java.util.Properties;

import com.voyager.enterprise.config.Config;
import com.voyager.enterprise.impl.comercial.models.BuyerEntity;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;

public class DBFactory {
	
	private static Database db;

	public static Database build(){

		if(DBFactory.db != null)return DBFactory.db;

		Properties properties = new Properties();
		properties.put("ebean.db.ddl.generate", "true");
		properties.put("ebean.db.ddl.run", "true");
		properties.put("datasource.db.username", "sa");
		properties.put("datasource.db.password", "");
		properties.put("datasource.db.databaseUrl","jdbc:h2:mem:app");
		properties.put("datasource.db.databaseDriver", "org.h2.Driver");

		DatabaseConfig cfg = new DatabaseConfig();
		cfg.loadFromProperties(properties);
        
		DBFactory.db = DatabaseFactory.create(cfg);

		return DBFactory.db;
	}

    public static Database build(Config conf){

        Database db;

		DatabaseConfig cfg = new DatabaseConfig();

		Properties properties = new Properties();
		properties.put("ebean.db.ddl.generate", conf.getProperty("ebean.db.ddl.generate"));
		properties.put("ebean.db.ddl.run", conf.getProperty("ebean.db.ddl.run"));
		properties.put("datasource.db.username", conf.getProperty("datasource.db.username"));
		properties.put("datasource.db.password", conf.getProperty("datasource.db.password"));
		properties.put("datasource.db.databaseUrl",conf.getProperty("datasource.db.databaseUrl"));
		properties.put("datasource.db.databaseDriver", conf.getProperty("datasource.db.databaseDriver"));

		
		cfg.loadFromProperties(properties);

		
		cfg.setDdlGenerate(true);
		cfg.setDdlRun(true);
		cfg.setDefaultServer(true);
		cfg.setRegister(true);
		    
		cfg.addClass(BuyerEntity.class);
		
		
		db = DatabaseFactory.create(cfg);
		
        return db;
    }
}
