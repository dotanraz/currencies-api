package com.theswdeveloper.currenciesApi.db;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * make sure to run postgres:
 * docker run -e POSTGRES_PASSWORD=1234 -p 5432:5432 postgres
 */
public class PostgresDbConnection {

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

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = this.ds.getConnection();
        }
        catch (SQLException e) {
            System.out.println("ERROR: fail to create postgres connection. make sure postgres is running");
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }

}
