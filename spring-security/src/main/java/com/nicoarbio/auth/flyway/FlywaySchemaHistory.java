package com.nicoarbio.auth.flyway;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

/**
 * This class is used to clean flyway_schema_history table when Hibertate performs ddl-auto=create
 */
@Entity
public class FlywaySchemaHistory {
    @Id
    @Column(nullable = false)
    private int installedRank;
    @Column(nullable = false)
    private String version;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String script;
    private int checksum;
    @Column(nullable = false)
    private String installedBy;
    @Column(nullable = false, columnDefinition = "timestamp without time zone default now()")
    private Timestamp installedOn;
    @Column(nullable = false)
    private int executionTime;
    @Column(nullable = false)
    private boolean success;
}
