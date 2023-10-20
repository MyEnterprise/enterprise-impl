package com.voyager.enterprise.impl.domain;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.ebean.Database;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import io.ebeaninternal.dbmigration.migration.Migration;

public class MigrationFactory {

	private static final String pathResourceMigration = "dbmigration";

	private static File genDir() {
		ClassLoader loader = MigrationFactory.class.getClassLoader();
		File fileMigration = new File("./src/main/resources/"+pathResourceMigration);
    	// Error is not implemented in function 'ReadDarknetFromWeightsStream':  https://github.com/opencv/opencv/issues/19218
    	try {
    		
    		if( !fileMigration.exists() ) {
    			return new File("./");
    		//	File srcDir = new File( loader.getResource(pathResourceMigration).getFile() );
    		//	FileUtils.copyDirectory( srcDir, fileMigration);
    		}

		}catch (Exception e) {
			e.printStackTrace();
		}

    	return fileMigration;
	}
	
    public static DbMigration build( Database db ){
        DbMigration dbMigration = DbMigration.create();
// AQUI CONDIGURAR EXPORT REOSURCE FROM SYSTEM FILE	
        
        dbMigration.setPathToResources(genDir().getAbsolutePath());
		
        dbMigration.setServer(db);
		
        try {
            dbMigration.generateMigration();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dbMigration;
    }
}
