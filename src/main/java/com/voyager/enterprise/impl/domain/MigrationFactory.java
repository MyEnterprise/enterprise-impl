package com.voyager.enterprise.impl.domain;

import java.io.IOException;

import io.ebean.Database;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import io.ebeaninternal.dbmigration.migration.Migration;

public class MigrationFactory {
    public static DbMigration build( Database db ){
        DbMigration dbMigration = DbMigration.create();
		
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
