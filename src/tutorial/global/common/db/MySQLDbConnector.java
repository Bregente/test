/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.google.appengine.api.rdbms.AppEngineDriver;

import tutorial.global.common.base.BaseDbConnector;
import tutorial.global.common.base.Logger;

/**
 * DBConnection implementation for MySQL-type connections.
 * @author richard.go
 */
public class MySQLDbConnector implements BaseDbConnector {

    /* -------------------------------------------------------------------------------------------------------------- */
    /* [AUTOWIRED CLASS MEMBERS] */
    /* -------------------------------------------------------------------------------------------------------------- */
    /** Current logger. */
    @Autowired
    @Qualifier("consoleLogger")
    private Logger logger;

    /** Database connection URL. */
    private String dbUrl = null;

    /** Database connection authorized user. */
    private String dbUser = null;

    /** Database connection authorized password. */
    private String dbPassword = null;

    /**
     * 現在保存したlogger値を取得する�?
     * @return logger値
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * 新た�?をloggerに設定する�?
     * @param logger値をlogger�?��に
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * 現在保存したdbUrl値を取得する�?
     * @return dbUrl値
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * 新た�?をdbUrlに設定する�?
     * @param dbUrl値をdbUrl�?��に
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     * 現在保存したdbUser値を取得する�?
     * @return dbUser値
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * 新た�?をdbUserに設定する�?
     * @param dbUser値をdbUser�?��に
     */
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    /**
     * 現在保存したdbPassword値を取得する�?
     * @return dbPassword値
     */
    public String getDbPassword() {
        return dbPassword;
    }

    /**
     * 新た�?をdbPasswordに設定する�?
     * @param dbPassword値をdbPassword�?��に
     */
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }


    /* -------------------------------------------------------------------------------------------------------------- */
    /* [AUTOWIRED CLASS METHODS] */
    /* -------------------------------------------------------------------------------------------------------------- */
    public MySQLDbConnector() {
        try {
            DriverManager.registerDriver(new AppEngineDriver()); 
        } catch (SQLException e) {
            logger.debug(this.getClass().getName(), "DB Initialization failed");
            e.printStackTrace();
        }
    }

    /**
     * Creates a connection to the SQL cloud instance.
     * @throws IOException invalid properties file
     * @throws SQLException invalid connection string
     */
    private Connection openConnection() throws SQLException, IOException {
        return DriverManager.getConnection(
            PropertiesLoaderUtils.loadAllProperties("db.properties").getProperty("db.gae.url"));
    }

    /**
     * Closes the parameter instance connection.
     * @param instance
     */
    private void closeConnection(Connection instance) {
        if (instance == null) { return; }
        try {
            instance.close();
        } catch (SQLException e) {
            logger.error(this.getClass().getName(), "unable to close connection properly.");
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.common.base.BaseDbConnector#doInsert(java.lang.String, java.lang.String[])
     */
    public int doInsert(String sql, String[] args, ParameterMapper mapper) {
        logger.debug(this.getClass().getName(), "-- doInsert " + " invoke --");
        Savepoint savepoint0 = null;
        Connection connection = null;
        int recordCount = -1;

        try {
            connection = this.openConnection();
            // Set auto commit to false then create savePoint
            connection.setAutoCommit(false);
            savepoint0 = connection.setSavepoint();

            PreparedStatement ps = connection.prepareStatement(sql);
            if (args != null && mapper != null) {
                mapper.map(ps, args);
            }
            ps.executeUpdate();

            // If all process is successful, set to true to commit items
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            // Print message
            logger.error(this.getClass().getName(), e.getMessage());
            try {
                // Try to rollBack transaction
                connection.rollback(savepoint0);
            } catch (SQLException e1) {
                logger.exception(this.getClass().getName(), "unable to rollback transaction");
            }
        } catch (IOException e) {
            logger.error(this.getClass().getName(), e.getMessage());
        } finally {
            this.closeConnection(connection);
            logger.debug(this.getClass().getName(), "-- doInsert " + " end --");
        }
        return recordCount;
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.common.base.BaseDbConnector#doUpdate(java.lang.String, java.lang.String[])
     */
    public int doUpdate(String sql, String[] args, ParameterMapper mapper) {
        logger.debug(this.getClass().getName(), "-- doUpdate " + " invoke --");
        Savepoint savepoint0 = null;
        Connection connection = null;
        int recordCount = -1;

        try {
            connection = this.openConnection();
            // Set auto commit to false then create savePoint
            connection.setAutoCommit(false);
            savepoint0 = connection.setSavepoint();

            PreparedStatement ps = connection.prepareStatement(sql);
            if (args != null && mapper != null) {
                mapper.map(ps, args);
            }
            ps.executeUpdate();

            // If all process is successful, set to true to commit items
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            // Print message
            logger.error(this.getClass().getName(), e.getMessage());
            try {
                // Try to rollBack transaction
                connection.rollback(savepoint0);
            } catch (SQLException e1) {
                logger.exception(this.getClass().getName(), "unable to rollback transaction");
            }
        } catch (IOException e) {
            // Print message
            logger.error(this.getClass().getName(), e.getMessage());
            e.printStackTrace();
        } finally {
            this.closeConnection(connection);
            logger.debug(this.getClass().getName(), "-- doUpdate " + " end --");
        }
        return recordCount;
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.common.base.BaseDbConnector#doQuery(java.lang.String, java.lang.String[])
     */
    public Map<Integer, Map<String, Object>> doQuery(String sql, String[] args, ParameterMapper mapper) {
        logger.debug(this.getClass().getName(), "-- doQuery " + " invoke --");

        Connection connection = null;
        Map<Integer, Map<String, Object>> results = null;
        try {
            connection = this.openConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            if (args != null && mapper != null) {
                mapper.map(ps, args);
            }
            ResultSet rs = ps.executeQuery();
            results = new HashMap<Integer, Map<String, Object>>();

            Map<String, Object> innerMap = null;
            int rowCount = -1;

            String debugString = null;
            while (rs.next()) {
                debugString = "";
                innerMap = new HashMap<String, Object>();
                for (int idx=1; idx<=rs.getMetaData().getColumnCount(); idx++) {
                    debugString += 
                        "[" + rs.getMetaData().getColumnName(idx) + "] " +
                        "[" + rs.getString(idx) + "] ";
                    innerMap.put(rs.getMetaData().getColumnName(idx), rs.getString(idx));
                }
                logger.debug(this.getClass().getName(), debugString);
                results.put(++rowCount, innerMap);
            }
        } catch (SQLException e) {
            logger.exception(this.getClass().getName(), "something wrong on query execution");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection(connection);
            logger.debug(this.getClass().getName(), "-- doQuery " + " end --");
        }
        return results;
    }
}
