package com.theswdeveloper.currenciesApi.db;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * make sure to run postgres:
 * docker run --name postgres1 -e POSTGRES_PASSWORD=1234 -p 5432:5432 -d postgres
 */
public class PostgresDbConnection {

    private String appName;
    private static PostgresDbConnection postgresDbConnection;
    private BasicDataSource ds;

    private PostgresDbConnection() {
        ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setPassword("1234");
        ds.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");

        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
    }

    public static PostgresDbConnection getInstance() {
        if (postgresDbConnection == null) {
            postgresDbConnection = new PostgresDbConnection();
            return postgresDbConnection;
        } else {
            return postgresDbConnection;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
