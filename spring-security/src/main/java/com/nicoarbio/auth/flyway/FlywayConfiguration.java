package com.nicoarbio.auth.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    /**
     * Flyway configuration will occur AFTER Hibertate performs ddl-auto=create
     * @param dataSource
     */
    @Autowired
    public FlywayConfiguration(DataSource dataSource) {
        Flyway.configure().baselineOnMigrate(true).baselineVersion("0.0").dataSource(dataSource).load().migrate();
    }

}
