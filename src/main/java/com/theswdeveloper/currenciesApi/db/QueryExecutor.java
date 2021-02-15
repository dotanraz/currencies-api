package com.theswdeveloper.currenciesApi.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryExecutor {

    private static final Logger logger = LoggerFactory.getLogger(QueryExecutor.class);

    public static void executeQuery(String query) throws SQLException {
        logger.info("going to execute query:\n" + query);
        Connection connection = null;
        try {
            connection = PostgresDbConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();
            ps.close();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        finally {
            connection.close();
        }
    }

    public static List<Map<String, Object>> executeQueryWithResults(String query) throws SQLException {
        logger.info("going to execute query:\n" + query);
        List<Map<String, Object>> list = null;
        Connection connection = null;
        try {
            connection = PostgresDbConnection.getInstance().getConnection();
            MapListHandler beanListHandler = new MapListHandler();
            QueryRunner runner = new QueryRunner();
            list = runner.query(connection, query, beanListHandler);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        finally {
            connection.close();
        }
        return list;
    }

}
