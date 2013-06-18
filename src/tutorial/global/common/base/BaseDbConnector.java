/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.base;

import java.sql.PreparedStatement;
import java.util.Map;

/**
 * Base interface for database connections
 * @author richard.go
 */
public interface BaseDbConnector {

    /**
     * Initializes insert DB transaction sequence.
     * @param sql :target SQL to execute
     * @param args :(optional)target parameters with in the statement
     * @param mapper :(optional)target mapper implementation
     * @return number of affected records
     */
    public int doInsert(String sql, String[] args, ParameterMapper mapper);


    /**
     * Initializes update DB transaction sequence.
     * @param sql :target SQL to execute
     * @param args :(optional)target parameters with in the statement
     * @param mapper :(optional)target mapper implementation
     * @return number of affected records
     */
    public int doUpdate(String sql, String[] args, ParameterMapper mapper);


    /**
     * Initializes select DB transaction sequence.
     * @param sql :target SQL to execute
     * @param args :(optional)target parameters with in the statement
     * @param mapper :(optional)target mapper implementation
     * @return number of affected records
     */
    public Map<Integer, Map<String, Object>> doQuery(String sql, String[] args, ParameterMapper mapper);


    /**
     * Mapper interface.
     * @author richard.go
     */
    public interface ParameterMapper {
        /**
         * Maps the target statement with the provided values.
         * @param prepStmt target statement
         * @param args target parameter values in the statement
         */
        public void map(PreparedStatement prepStmt, String[] args);
    }
}
