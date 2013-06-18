/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.base;

/**
 * Base Service Layer Class
 * @author richard.go
 */
public class BaseService {

    /** Holds logger instance for the current service. */
    private Logger logger;

    /** Holds current instance for the database connector. */
    private BaseDbConnector connector;

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
     * 現在保存したconnector値を取得する�?
     * @return connector値
     */
    public BaseDbConnector getConnector() {
        return connector;
    }

    /**
     * 新た�?をconnectorに設定する�?
     * @param connector値をconnector�?��に
     */
    public void setConnector(BaseDbConnector connector) {
        this.connector = connector;
    }
}
