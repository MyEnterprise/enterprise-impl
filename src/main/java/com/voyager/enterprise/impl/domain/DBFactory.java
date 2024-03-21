package com.voyager.enterprise.impl.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.voyager.enterprise.config.Config;
import com.voyager.enterprise.impl.domain.entities.BuyerEntity;
import com.voyager.enterprise.impl.domain.entities.MerchandiseEntity;
import com.voyager.enterprise.impl.domain.entities.TransactionEntity;
import com.voyager.enterprise.impl.domain.entities.lending.FeeEntity;
import com.voyager.enterprise.impl.domain.entities.merchandise.CoinEntity;
import com.voyager.enterprise.impl.domain.entities.transaction.TransferenceEntity;
import com.voyager.enterprise.impl.domain.entities.EnterpriseEntity;
import com.voyager.enterprise.impl.domain.entities.BookEntity;
import com.voyager.enterprise.impl.domain.entities.distribution.AddressEntity;
import com.voyager.enterprise.impl.domain.entities.storage.DepositEntity;
import com.voyager.enterprise.impl.domain.entities.storage.WareHouseEntity;
import com.voyager.enterprise.impl.domain.entities.storage.inventory.InBoundEntity;
import com.voyager.enterprise.impl.domain.entities.storage.inventory.bound.BoundStatusEntity;
import com.voyager.enterprise.impl.domain.entities.JobEntity;
import com.voyager.enterprise.impl.domain.entities.DepartmentEntity;
import com.voyager.enterprise.impl.domain.entities.PaymentEntity;
import com.voyager.enterprise.impl.domain.entities.TaxIdentificationEntity;
import com.voyager.util.Reflections;
import jakarta.persistence.EntityManager;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.service.ServiceRegistry;


public class DBFactory {
	
	private static Object db;

	public static Object build(){
/*
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

		return DBFactory.db;*/
		return null;
	}

    public static EntityManager build(Config config){

		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.jdbc.url", config.getProperty("datasource.db.databaseUrl"));
		properties.put("javax.persistence.jdbc.user", config.getProperty("datasource.db.username"));
		properties.put("javax.persistence.jdbc.password", config.getProperty("datasource.db.password"));
		properties.put("javax.persistence.jdbc.driver", config.getProperty("datasource.db.databaseDriver"));
		properties.put("hibernate.show_sql", "true");
		properties.put("javax.persistence.schema-generation.create-database-schemas", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		HibernatePersistenceProvider persistenceProvider = new HibernatePersistenceProvider();

		var prop = new Properties();

		for(Map.Entry<String,String> entry : properties.entrySet()){
			prop.setProperty(entry.getKey(), entry.getValue());
		}

		Configuration hibernateConfig = new Configuration();
		hibernateConfig.addPackage("com.voyager.enterprise.impl.domain.entities");
		hibernateConfig.addProperties(prop);
		ServiceRegistry sessionFactory = new StandardServiceRegistryBuilder()
				.applySettings(hibernateConfig.getProperties())
				.build();
//		https://www.baeldung.com/hibernate-5-bootstrapping-api		
//		https://www.baeldung.com/spring-data-jpa-generate-db-schema
	    MetadataSources metadataSources = new MetadataSources(sessionFactory);
	    metadataSources.addAnnotatedClass(Account.class);
	    metadataSources.addAnnotatedClass(AccountSettings.class);
	    Metadata metadata = metadataSources.buildMetadata();

	    SchemaExport schemaExport = new SchemaExport();
	    schemaExport.setFormat(true);
	    schemaExport.setOutputFile("create.sql");
	    schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);
	    
	    SchemaExport export = new SchemaExport(metadata);
	    
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setFormat(true);
		schemaExport.setOutputFile("create.sql");
		schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadata);

		// Cria a fábrica de gerenciamento de entidades
		var emf = persistenceProvider.createEntityManagerFactory("my-pdu", properties);

		EntityManager entityManager = emf.createEntityManager();


		emf.close();
		sessionFactory.close();

		return entityManager;
    }
}
