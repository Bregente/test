/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */

package tutorial.global.login.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.PreparedStatement;

import tutorial.global.common.base.BaseService;
import tutorial.global.common.base.Logger;
import tutorial.global.common.db.DBConnector;
import tutorial.global.common.db.DBConnectorTest;
import tutorial.global.controller.service.LoginServiceImplTest;
import tutorial.global.cool.login.service.LoginService;
import tutorial.global.cool.model.UserDAO;

/**
 * Database function for a user to log in.
 * @author vincent.racaza
 */
public class LoginServiceImpl extends BaseService implements LoginService {

    /**
     * 出力ログ対応クラス�?
     */
    @Autowired
    @Qualifier("consoleLogger")
    private Logger logger;
    
    private UserDAO userDao;
    private DBConnectorTest dbConnector;
    
    public LoginServiceImpl(){
        this.setDbConnector(new DBConnectorTest());
    }

    /**
     * This function will just check if username and password matches in the database.
     * @param memberUserDAO - contains account name and password.
     * @return UserDAO - returns a UserDAO if user's account name and password match on the database.
     */
    public UserDAO checkLogin(UserDAO memberUserDAO) {
        Connection con = null;
        try {
            con = this.dbConnector.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select i.user_id, m.user_type_id, m.email from user_info i " 
                    + "inner join user_master m on i.user_id = m.user_id where account_name=? and user_pass= ? and status=1 and (user_type_id = 2 or user_type_id=3)");
            ps.setString(1, memberUserDAO.getAccountName());
            ps.setString(2, memberUserDAO.getPassword());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                memberUserDAO.setUserId(rs.getString(1));
                memberUserDAO.setType(rs.getInt(2));
                memberUserDAO.setEmail(rs.getString(3));
            }
            if (memberUserDAO.getUserId() == null) {
                memberUserDAO.setErrorId("LoginIncorrectDataErrorID");
            } else {
                ps = (PreparedStatement) con.prepareStatement("update user_info set last_log = now() where user_id =?");
                ps.setString(1,memberUserDAO.getUserId()); 
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            memberUserDAO.setErrorId("DatabaseExceptionErrorID");
            e.printStackTrace();
        } catch(Exception e) {
            memberUserDAO.setErrorId("GeneralExceptionErrorID");
        } finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
                memberUserDAO.setErrorId("DatabaseExceptionErrorID");
                 e.printStackTrace();
            }
        }
        this.userDao = memberUserDAO;
        return memberUserDAO;
    }

    /**
     * This function will just check if email address is on the database.
     * @param userDAO - contains the email address.
     * @return UserDAO - returns a UserDAO if user's email address is on the database.
     */
    public UserDAO checkLoginOnEmail(UserDAO userDAO) {
        logger.debug(this.getClass().getName(), "-- query" + " invoke --");
        UserDAO user = new UserDAO();
        Connection con = null;
        try {
           
            con = DBConnector.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select i.user_id, m.user_type_id, m.email from user_info i " 
                    + "inner join user_master m on i.user_id = m.user_id where email=? and status=1 and (user_type_id = 0 or user_type_id = 1)");
            ps.setString(1, userDAO.getEmail());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getString(1));
                user.setType(rs.getInt(2));
                user.setEmail(rs.getString(3));
            }

            if (user.getUserId() == null) {
                user.setErrorId("LoginErrorID");
            } else {
                ps = (PreparedStatement) con.prepareStatement("update user_info set last_log = now() where user_id =?");
                ps.setString(1, user.getUserId()); 
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            user.setErrorId("DatabaseExceptionErrorID");
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } catch (Exception e) {
            user.setErrorId("GeneralExceptionErrorID");
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                 con.close();
            } catch (Exception e) {
                 user.setErrorId("DatabaseExceptionErrorID");
                 logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- query" + " end --");
        return user;
    }

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public DBConnectorTest getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DBConnectorTest dbConnector) {
        this.dbConnector = dbConnector;
    }
}
