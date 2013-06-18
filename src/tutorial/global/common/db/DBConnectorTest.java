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
public class DBConnectorTest {

    //
    private static Connection con;

    //
    public Connection getConnection() throws SQLException{
        if (con == null || con.isClosed()) {
            try {
//                DriverManager.registerDriver(new AppEngineDriver());
//                con = DriverManager.getConnection(
//                PropertiesLoaderUtils.loadAllProperties("db.properties").getProperty("db.gae.url"));
                String url = "jdbc:mysql://localhost:3306/sbc";
                con = DriverManager.getConnection(url, "root","password");
//                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
