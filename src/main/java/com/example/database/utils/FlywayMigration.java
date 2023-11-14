package com.example.database.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;

public class FlywayMigration {

    private static final Logger LOG = LogManager.getLogger(FlywayMigration.class);
    private FlywayMigration() {
    }

    public static void migrateDatabase() {
        LOG.info("Flyway migration execute");

        Flyway.configure()
                .dataSource(Config.JDBC_URL, Config.USERNAME, Config.PASSWORD)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();

        LOG.info("Flyway migration completed");
    }
}
