package com.voyager.enterprise.impl.domain;

import java.io.File;
import java.io.IOException;

import com.voyager.enterprise.config.Config;
import org.apache.commons.io.FileUtils;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;

public class MigrationFactory {

	private static final String pathResourceMigration = "dbmigration";

	private static String genDir() {
		ClassLoader loader = MigrationFactory.class.getClassLoader();
		File fileMigration = new File("./src/main/resources/"+pathResourceMigration);
    	// Error is not implemented in function 'ReadDarknetFromWeightsStream':  https://github.com/opencv/opencv/issues/19218
    	try {
    		
    		if( !fileMigration.exists() ) {
    			return "filesystem:"+new File("./").getAbsolutePath();
    			//File srcDir = new File( loader.getResource(pathResourceMigration).getFile() );
    			//FileUtils.copyDirectory( srcDir, fileMigration );
    		}

		}catch (Exception e) {
			e.printStackTrace();
		}

    	return "filesystem:"+fileMigration.getAbsolutePath();
	}
	
    public static MigrateResult build(Config config ){
		// Create the Flyway instance and point it to the database
		Flyway flyway = Flyway.configure()
								.dataSource(
										config.getProperty("datasource.db.databaseUrl"),
										config.getProperty("datasource.db.username"),
										config.getProperty("datasource.db.password")
							  	)
								.baselineOnMigrate(true)
								.createSchemas(true)
								.locations(genDir())
								.load();

		// Start the migration
		return flyway.migrate();
    }
}
