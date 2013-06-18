/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.common.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import tutorial.global.controller.base.BaseTest;
import tutorial.global.controller.service.LoginServiceImplTest;

import com.google.appengine.api.rdbms.AppEngineDriver;

/**
 * @author robert.lao
 */
public class DBConnector {

    //
    private static Connection con;

    //
    public static Connection getConnection() throws SQLException{
        if (con == null || con.isClosed()) {
            try {
                DriverManager.registerDriver(new AppEngineDriver());
                con = DriverManager.getConnection(
                PropertiesLoaderUtils.loadAllProperties("db.properties").getProperty("db.gae.url"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
