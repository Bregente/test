/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import tutorial.global.common.base.BaseService;
import tutorial.global.common.base.Logger;
import tutorial.global.common.base.BaseDbConnector.ParameterMapper;
import tutorial.global.common.constant.GlobalConstants;
import tutorial.global.common.db.DBConnector;
import tutorial.global.common.db.DBConnectorTest;
import tutorial.global.common.util.ConsoleLogger;
import tutorial.global.common.util.ConverterUtils;
import tutorial.global.cool.model.SearchUserDAO;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.user.service.UserService;

/**
 * Service Layer Implementation for Users.
 * @author robert.lao
 */
public class UserServiceImpl extends BaseService implements UserService{

    private DBConnectorTest dbConnector;
    
    public UserServiceImpl(){
        this.setDbConnector(new DBConnectorTest());
    }
    
    /**
     * 出力ログ対応クラス�?
     */
    @Autowired
    @Qualifier("consoleLogger")
    private Logger logger = new ConsoleLogger();

    public boolean checkExists(UserDAO user){
        boolean result = false;

        Connection con = null;
        try {
            con = DBConnector.getConnection();

            String statement = "SELECT * FROM user_master " +
            		"WHERE user_id = '"+user.getUserId()+"' AND status = "+GlobalConstants.STATUS_ACTIVE;
            PreparedStatement stmt = con.prepareStatement(statement);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                result = true;
            }
        } catch(SQLException e) {
            return result;
        } catch(Exception e) {
            return result;
        }

        return result;
    }

    public String deleteUser(UserDAO user){
        logger.debug(this.getClass().getName(), "-- deleteUser" + " invoke --");
        
        String result = null;

        Connection con = null;
        try {
            con = this.dbConnector.getConnection();
            con.setAutoCommit(false);
            
            String statement = "UPDATE user_master SET status = ? WHERE user_id = ?";
            PreparedStatement stmt = con.prepareStatement(statement);
            stmt.setInt(1, GlobalConstants.STATUS_INACTIVE);
            stmt.setString(2, user.getUserId());
            stmt.executeUpdate();
            con.commit();
        } catch(SQLException e) {
            result = "DatabaseExceptionErrorID";
            try {
                if(con!=null){
                    con.rollback();
                }
            } catch (SQLException e1) {
                result = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e1.toString());
            }
        } catch (Exception e) {
            result = "GeneralExceptionErrorID";
            try {
                if(con!=null){
                    con.rollback();
                }
            } catch (SQLException e1) {
                result = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e1.toString());
            }
        } finally {
            try {
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                result = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }

        logger.debug(this.getClass().getName(), "-- deleteUser" + " end --");
        return result;
    }

    public String deleteUser(List<UserDAO> userList) {
        String result = null;

        for (int i = 0; i < userList.size(); i++)  {
            result = deleteUser(userList.get(i));
            if (result != null) {
                return result;
            }
        }

        return result;
    }

    /**
     * This function is the implementation layer for retrieving user data.
     * @param user - contains the data userId.
     * @return UserDAO - contains user data.
     */
    public UserDAO listUsers(UserDAO user) {
        logger.debug(this.getClass().getName(), "-- listUsers" + " invoke --");
        try {
            user = query(user);

            if (user == null) {
                user = new UserDAO();
                user.setErrorId("NoDataFoundErrorID");
            } else {
                user.setErrorId(null);
            }
        } catch (SQLException e) {
            user.setErrorId("DatabaseExceptionErrorID");
        } catch (Exception e) {
            user.setErrorId("ExceptionErrorID");
        }
        logger.debug(this.getClass().getName(), "-- listUsers" + " end --");
        return user;
    }


    private UserDAO query(UserDAO userDao) throws SQLException {
        logger.debug(this.getClass().getName(), "-- query" + " invoke --");

        UserDAO user = null;
        Connection con = null;
        con = DBConnector.getConnection();

        PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                "SELECT * FROM user_master join user_info "
                + "on user_master.user_id = user_info.user_id "
                + "WHERE user_master.user_id = ?");
        ps.setString(1, userDao.getUserId());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new UserDAO();
            user.setAccountName(rs.getString("account_name"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setFirstKanaName(rs.getString("first_name_kana"));
            user.setLastKanaName(rs.getString("last_name_kana"));
            user.setAffiliation(rs.getString("affiliation"));
            user.setEmail(rs.getString("email"));
            user.setType(rs.getInt("user_type_id"));
            user.setUserId(rs.getString("user_id"));
            user.setPassword(rs.getString("user_pass"));
            user.setUpdateDate(rs.getString("update_date"));
        }

        con.close();

        logger.debug(this.getClass().getName(), "-- query" + " end --");
        return user;
    }

    /**
     * This function will update User information into the database.
     * @param UserDAO - contains the data to update.
     * @return String - return null if update is successful, else return an error id.
     */
    public String update(UserDAO userDAO, String loggedUserId){
        logger.debug(this.getClass().getName(), "-- update" + " invoke --");

        String errorID = null;
        Connection con = null;

        try {
            UserDAO currentData = query(userDAO);
            userDAO.setAccountName(userDAO.getAccountName().length()==0?currentData.getAccountName():userDAO.getAccountName());           
            userDAO.setType(userDAO.getType() == -1?currentData.getType():userDAO.getType());
            
            String query = "update user_info set ";
            int seqNo = 0;
            if(userDAO.getPassword().length()>0){
                query += "user_pass=md5(?), ";
                seqNo = 1;
            }
            query += "account_name=?, " +
                    "last_name=?, first_name=?, last_name_kana=?, first_name_kana=?, " +
                    "affiliation=?, update_by=?, update_date=now() where user_id=? and " +
                    "update_date=date_format(?,'%Y-%m-%d %T')";
            con = DBConnector.getConnection();
            con.setAutoCommit(false);
            PreparedStatement  ps = 
                    (PreparedStatement) con.prepareStatement(query);

            if(seqNo == 1){
                ps.setString(seqNo, userDAO.getPassword());
            }
            
            ps.setString(++seqNo, userDAO.getAccountName());
            ps.setString(++seqNo, userDAO.getLastName());
            ps.setString(++seqNo, userDAO.getFirstName());
            ps.setString(++seqNo, userDAO.getLastKanaName());
            ps.setString(++seqNo, userDAO.getFirstKanaName());
            ps.setString(++seqNo, userDAO.getAffiliation());
            ps.setString(++seqNo, loggedUserId);
            ps.setString(++seqNo, userDAO.getUserId());
            ps.setString(++seqNo, userDAO.getUpdateDate());
            
            int count = ps.executeUpdate();
            if(count > 0){
                ps = (PreparedStatement) con.prepareStatement("update user_master set email=?, user_type_id=? where user_id=?");
                ps.setString(1, userDAO.getEmail());
                ps.setInt(2, userDAO.getType());
                ps.setString(3, userDAO.getUserId());
                ps.execute();
            }

            con.commit();
        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            try {
                if(con!=null){
                    con.rollback();
                }
            } catch (SQLException e1) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e1.toString());
            }
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- update" + " end --");
        return errorID;
    }

    /**
     * This function will just check the existence of an account name.
     * @param memberUserDAO - contains the account name.
     * @return String - return null if account name does not exist, else return an error id.
     */
    public String checkExistsAccountName(UserDAO memberUserDAO) {
        logger.debug(this.getClass().getName(), "-- checkExistsAccountName" + " invoke --");
        String errorID = "";
        List<UserDAO> userDAO = new ArrayList<UserDAO>();
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select m.* from user_master m, user_info i where account_name = ? and i.user_id = m.user_id and status = 1");
            ps.setString(1, memberUserDAO.getAccountName()); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                UserDAO user = new UserDAO();
                user.setUserId(rs.getString(1));
                userDAO.add(user);
            }

            if (userDAO.size() == 0) {
                errorID = "AccountNameExistsErrorID";
            } 

        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- execute" + " end --");
        return errorID;
    }

    /**
     * This function will just check the existence of an account name other than self's account name.
     * @param memberUserDAO - contains the account name.
     * @return String - return null if account name does not exist, else return an error id.
     */
    public String checkExistsAccountNameOther(UserDAO memberUserDAO) {
        logger.debug(this.getClass().getName(), "-- checkExistsAccountNameOther" + " invoke --");

        String errorID = null;
        String accountName = null;
        Connection con = null;
        try {
            con = DBConnector.getConnection();

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select i.account_name from user_master m, user_info i where account_name = ? and i.user_id = m.user_id and status = 1");
            ps.setString(1, memberUserDAO.getAccountName()); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                accountName = rs.getString(1);
            }

            if (accountName != null && !accountName.isEmpty()) {
                errorID = "AccountNameExistsErrorID";
            } 

        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        System.out.println("=============UserService: "+errorID+"==============");
        logger.debug(this.getClass().getName(), "-- checkExistsAccountNameOther" + " end --");
        return errorID;
    }

    /**
     * This function will just check the existence of an email address.
     * @param memberUserDAO - contains the email address.
     * @return String - return null if email address does not exist, else return an error id.
     */
    public String checkExistsEmail(UserDAO memberUserDAO) {
        logger.debug(this.getClass().getName(), "-- execute" + " invoke --");
        String errorID = null;
        List<UserDAO> userDAO = new ArrayList<UserDAO>();
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            PreparedStatement  ps = (PreparedStatement) con.prepareStatement("select m.* from user_master m, user_info i where email = ? and i.user_id = m.user_id and status = 1");

            ps.setString(1, memberUserDAO.getEmail()); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDAO user = new UserDAO();
                user.setUserId(rs.getString(1));
                userDAO.add(user);
            }

            if (userDAO.size() > 0) {
                errorID = "EmailExistsErrorID";
            }
        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- execute" + " end --");
        return errorID;
    }

    /**
     * This function will just check the existence of an email address other than self's email.
     * @param memberUserDAO - contains the email address.
     * @return String - return null if email address does not exist, else return an error id.
     */
    public String checkExistsEmailOther(UserDAO userDao) {
        logger.debug(this.getClass().getName(), "-- checkExistsEmailOther" + " invoke --");
        String errorID = null;
        String email = null;
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            PreparedStatement  ps = (PreparedStatement) con.prepareStatement("select m.email from user_master m, user_info i where email = ? and i.user_id = m.user_id and status = 1");

            ps.setString(1, userDao.getEmail()); 
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                email = rs.getString(1);
            }

            if (email != null && !email.isEmpty()) {
                errorID = "EmailExistsErrorID";
            } 
        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- checkExistsEmailOther" + " end --");
        return errorID;
    }

    /**
     * This function will add a new member in the database
     * @param memberUserDAO - contains the userDAO
     * @return String - return null if successfully added, else return an error id.
     */
    public UserDAO add(UserDAO memberUserDAO) {
        logger.debug(this.getClass().getName(), "-- add" + " invoke --");
        String errorID = null;
        Connection con = null;

        try {
            String newID = queryGetNewID();
            con = this.dbConnector.getConnection();
            con.setAutoCommit(false);
            PreparedStatement  ps = (PreparedStatement) con.prepareStatement("insert into user_master(user_id, email, user_type_id, status) " +
                    "VALUES(?, ?, ?, ?)");

            ps.setString(1, newID);
            ps.setString(2, memberUserDAO.getEmail());
            ps.setInt(3, memberUserDAO.getType());
            ps.setInt(4, GlobalConstants.STATUS_ACTIVE);
            ps.executeUpdate();

            ps = (PreparedStatement) con.prepareStatement("insert into user_info(user_id, account_name, user_pass, register_date, update_date) " +
                    "values(?, ?, md5(?), NOW(), NOW())");
            ps.setString(1, newID);
            ps.setString(2, memberUserDAO.getAccountName());
            ps.setString(3, memberUserDAO.getPassword());
            ps.execute();
            con.commit();
            memberUserDAO.setUserId(newID);
        } catch (SQLException e) {
            errorID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        
            try {
                con.rollback();
            } catch (SQLException e1) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        } catch (Exception e) {
            errorID = "GeneralExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- Genexception: " + e.toString());
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                errorID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- add" + " end -- ");
        memberUserDAO.setErrorId(errorID);
        return memberUserDAO;
    }

    /**
     * This function will get the maximum ID in the database, then return a new autogenerated ID.
     * @return String - returns the new autogenerated ID.
     */
    public String queryGetNewID() {
        logger.debug(this.getClass().getName(), "-- queryGetNewID" + " invoke --");
        String newID = null;
        Connection con = null;
        try {
            con = DBConnector.getConnection();

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select max(user_id) from user_master");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               newID = rs.getString(1);
            }

            int id = Integer.parseInt(newID);
            id++;
            String autoID = Integer.toString(id);
            int len = autoID.length();
            newID = "";
            switch (8 - len) {
                case 7: newID = "0000000" + autoID; break;
                case 6: newID = "000000" + autoID; break;
                case 5: newID = "00000" + autoID; break;
                case 4: newID = "0000" + autoID; break;
                case 3: newID = "000" + autoID; break;
                case 2: newID = "00" + autoID; break;
                case 1: newID = "0" + autoID; break;
                case 0: newID = autoID; break;
            }

        } catch (SQLException e) {
            newID = "DatabaseExceptionErrorID";
            logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                newID = "DatabaseExceptionErrorID";
                logger.debug(this.getClass().getName(), "-- exception: " + e.toString());
            }
        }
        logger.debug(this.getClass().getName(), "-- queryGetNewID" + " end --");
        return newID;
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.user.service.UserService#listUsersAsList(tutorial.global.model.UserDAO)
     */
    public List<UserDAO> listUsersAsList(UserDAO userDAO) {
        super.getLogger().debug(this.getClass().getName(), "-- listUsersAsList" + " invoke --");
        // execute query
        Map<Integer, Map<String, Object>> resultList =
            super.getConnector().doQuery(
                "SELECT user_master.user_id," +
                "       user_master.email," +
                "       user_info.account_name, " +
                "       user_master.status," +
                "       DATE_FORMAT(user_info.register_date, '%Y/%m/%d') as register_date," +
                "       DATE_FORMAT(user_info.update_date, '%Y/%m/%d') as update_date, " +
                "       DATE_FORMAT(user_info.last_log, '%Y/%m/%d') as last_log " +
                "  FROM user_master " +
                "  LEFT JOIN user_info " +
                "         ON user_info.user_id = user_master.user_id " +
                " WHERE user_master.user_type_id = ?" +
                "   AND user_master.status = '1'",
                new String[] { Integer.toString(userDAO.getType()) },
                new ParameterMapper() {
                    public void map(PreparedStatement prepStmt, String[] args) {
                        try {
                            prepStmt.setString(1, args[0]);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
        // iterate query result then map to a UserDAO instance
        List<UserDAO> results = new ArrayList<UserDAO>();
        UserDAO rowItem = null;
        if (resultList != null) {
            for (Integer key : resultList.keySet()) {
                rowItem = new UserDAO();
                rowItem.setUserId(ConverterUtils.objToString(resultList.get(key).get("user_id")));
                rowItem.setEmail(ConverterUtils.objToString(resultList.get(key).get("email")));
                rowItem.setStatus(ConverterUtils.objToInt(resultList.get(key).get("status")));
                rowItem.setRegisterDate(ConverterUtils.objToString(resultList.get(key).get("register_date")));
                rowItem.setUpdateDate(ConverterUtils.objToString(resultList.get(key).get("update_date")));
                rowItem.setLastLog(ConverterUtils.objToString(resultList.get(key).get("last_log")));
                results.add(rowItem);
            }
        } else {
            super.getLogger().debug(this.getClass().getName(), "No results found");
        }
        super.getLogger().debug(this.getClass().getName(), "-- listUsersAsList" + " end --");
        return results;
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.user.service.UserService#listUsersAsList(tutorial.global.model.UserDAO, int, int)
     */
    public List<UserDAO> listUsersAsList(UserDAO user, int fromRow, int rowCount) {
        super.getLogger().debug(this.getClass().getName(), "-- listUsersAsList" + " invoke --");
        int incrementCnt = 3;

        super.getLogger().debug(this.getClass().getName(), "Creating base condition values...");
        // create SQL condition params
        List<String> conditionVal = new ArrayList<String>();
        conditionVal.add(Integer.toString(user.getType()));

        super.getLogger().debug(this.getClass().getName(), "Creating base condition strings...");
        // create SQL query conditions
        String conditionStr = "";
        SearchUserDAO conditions = (SearchUserDAO) user;
        if (user.getType() == GlobalConstants.USER_TYPE_MEMBER) {
            conditionStr += "   OR user_master.user_type_id = ?)";
            conditionVal.add(Integer.toString(GlobalConstants.USER_TYPE_MEMBER_B));
            incrementCnt++;
        } else {
            conditionStr += ")";
        }
        if (!StringUtils.isEmpty(conditions.getUserId())) {
            conditionStr += "   AND user_master.user_id like ?";
            conditionVal.add("%" + conditions.getUserId() + "%");
            incrementCnt++;
        }
        if (!StringUtils.isEmpty(conditions.getAccountName())) {
            conditionStr += "   AND user_info.account_name like ?";
            conditionVal.add("%" + conditions.getAccountName() + "%");
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getRegisterDate()) &&
                !StringUtils.isEmpty(conditions.getRegisterDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.register_date, '%Y/%m/%d') BETWEEN ? AND ?";
            conditionVal.add(conditions.getRegisterDate());
            conditionVal.add(conditions.getRegisterDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getRegisterDate())) {
            conditionStr += "   AND DATE_FORMAT(user_info.register_date, '%Y/%m/%d') >= ? ";
            conditionVal.add(conditions.getRegisterDate());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getRegisterDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.register_date, '%Y/%m/%d') =< ?";
            conditionVal.add(conditions.getRegisterDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getUpdateDate()) &&
                !StringUtils.isEmpty(conditions.getUpdateDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.update_date, '%Y/%m/%d') BETWEEN ? AND ?";
            conditionVal.add(conditions.getUpdateDate());
            conditionVal.add(conditions.getUpdateDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getUpdateDate())) {
            conditionStr += "   AND DATE_FORMAT(user_info.update_date, '%Y/%m/%d') >= ?";
            conditionVal.add(conditions.getUpdateDate());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getUpdateDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.update_date, '%Y/%m/%d') <= ?";
            conditionVal.add(conditions.getUpdateDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getLastLog()) &&
                !StringUtils.isEmpty(conditions.getLastLogDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.last_log, '%Y/%m/%d') BETWEEN ? AND ?";
            conditionVal.add(conditions.getLastLog());
            conditionVal.add(conditions.getLastLogDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getLastLog())) {
            conditionStr += "   AND DATE_FORMAT(user_info.last_log, '%Y/%m/%d') >= ?";
            conditionVal.add(conditions.getLastLog());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getLastLogDateTo())) {
            conditionStr += "   AND DATE_FORMAT(user_info.last_log, '%Y/%m/%d') <= ?";
            conditionVal.add(conditions.getLastLogDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getValidity())) {
            conditionStr += "   AND user_master.status = ?";
            conditionVal.add(conditions.getValidity());
            incrementCnt++;
        }

        conditionVal.add(Integer.toString(fromRow * rowCount));
        conditionVal.add(Integer.toString(rowCount));

        super.getLogger().debug(this.getClass().getName(), "Creating base sort index");
        String sortStr = "";
        if ("userId".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_master.user_id "
                        + conditions.getSortIdx();
        } else if ("accountName".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_info.account_name "
                        + conditions.getSortIdx();
        } else if ("registerDate".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_info.register_date "
                        + conditions.getSortIdx();
        } else if ("updateDate".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_info.update_date "
                        + conditions.getSortIdx();
        } else if ("lastLog".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_info.last_log "
                        + conditions.getSortIdx();
        } else if ("validity".equals(conditions.getSortItem())) {
            sortStr += " ORDER BY "
                        + "user_master.status "
                        + conditions.getSortIdx();
        }

        String sqlStr =
            "SELECT user_master.user_id," +
            "       user_master.email," +
            "       user_info.account_name, " +
            "       user_master.status," +
            "       DATE_FORMAT(user_info.register_date, '%Y/%m/%d') as register_date," +
            "       DATE_FORMAT(user_info.update_date, '%Y/%m/%d') as update_date, " +
            "       DATE_FORMAT(user_info.last_log, '%Y/%m/%d') as last_log " +
            "  FROM user_master " +
            "  LEFT JOIN user_info " +
            "         ON user_info.user_id = user_master.user_id " +
            " WHERE (user_master.user_type_id = ?" +
            conditionStr +
            sortStr +
            " LIMIT ?, ?";
        logger.debug(this.getClass().getName(), "Generated SQL := " + sqlStr);

        super.getLogger().debug(this.getClass().getName(), "Executing query...");
        // execute query
        Map<Integer, Map<String, Object>> resultList =
            super.getConnector().doQuery(
                sqlStr,
                conditionVal.toArray(new String[incrementCnt]),
                new ParameterMapper() {
                    public void map(PreparedStatement prepStmt, String[] args) {
                        try {
                            if (args.length == 3) {
                                prepStmt.setString(1, args[0]);
                                prepStmt.setInt(2, Integer.parseInt(args[1]));
                                prepStmt.setInt(3, Integer.parseInt(args[2]));
                            } else {
                                prepStmt.setString(1, args[0]);
                                int idx=0;
                                for (idx=0; idx<args.length - 3; idx++) {
                                    prepStmt.setString(2 + idx, args[1 + idx]);
                                }
                                prepStmt.setInt(2 + idx, Integer.parseInt(args[1 + idx]));
                                prepStmt.setInt(3 + idx, Integer.parseInt(args[2 + idx]));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

        super.getLogger().debug(this.getClass().getName(), "Reverse mapping results...");
        // iterate query result then map to a UserDAO instance
        List<UserDAO> results = new ArrayList<UserDAO>();
        UserDAO rowItem = null;
        if (resultList != null) {
            for (Integer key : resultList.keySet()) {
                rowItem = new UserDAO();
                rowItem.setUserId(ConverterUtils.objToString(resultList.get(key).get("user_id")));
                rowItem.setEmail(ConverterUtils.objToString(resultList.get(key).get("email")));
                rowItem.setAccountName(ConverterUtils.objToString(resultList.get(key).get("account_name")));
                rowItem.setStatus(ConverterUtils.objToInt(resultList.get(key).get("status")));
                rowItem.setRegisterDate(ConverterUtils.objToString(resultList.get(key).get("register_date")));
                rowItem.setUpdateDate(ConverterUtils.objToString(resultList.get(key).get("update_date")));
                rowItem.setLastLog(ConverterUtils.objToString(resultList.get(key).get("last_log")));
                results.add(rowItem);
            }
        } else {
            super.getLogger().debug(this.getClass().getName(), "No results found");
        }
        super.getLogger().debug(this.getClass().getName(), "-- listUsersAsList" + " end --");
        return results;
    }

    /*
     * (non-Javadoc)
     * @see tutorial.global.user.service.UserService#count(tutorial.global.model.UserDAO)
     */
    public int count(UserDAO user) {
        super.getLogger().debug(this.getClass().getName(), "-- count" + " invoke --");

        int incrementCnt = 1;

        super.getLogger().debug(this.getClass().getName(), "Creating base condition values...");
        // create SQL condition params
        List<String> conditionVal = new ArrayList<String>();
        conditionVal.add(Integer.toString(user.getType()));

        super.getLogger().debug(this.getClass().getName(), "Creating base condition strings...");
        // create SQL query conditions
        String conditionStr = "";
        SearchUserDAO conditions = (SearchUserDAO) user;
        if (!StringUtils.isEmpty(conditions.getUserId())) {
            conditionStr += "   AND user_master.user_id like ?";
            conditionVal.add("%" + conditions.getUserId() + "%");
            incrementCnt++;
        }
        if (!StringUtils.isEmpty(conditions.getAccountName())) {
            conditionStr += "   AND user_info.account_name like ?";
            conditionVal.add("%" + conditions.getAccountName() + "%");
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getRegisterDate()) &&
                !StringUtils.isEmpty(conditions.getRegisterDateTo())) {
            conditionStr += "   AND user_info.register_date BETWEEN ADDDATE(?, -1) AND ADDDATE(?, 1)";
            conditionVal.add(conditions.getRegisterDate());
            conditionVal.add(conditions.getRegisterDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getRegisterDate())) {
            conditionStr += "   AND user_info.register_date >= ADDDATE(?, -1) ";
            conditionVal.add(conditions.getRegisterDate());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getRegisterDateTo())) {
            conditionStr += "   AND user_info.register_date =< ADDDATE(?, 1)";
            conditionVal.add(conditions.getRegisterDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getUpdateDate()) &&
                !StringUtils.isEmpty(conditions.getUpdateDateTo())) {
            conditionStr += "   AND user_info.update_date BETWEEN ADDDATE(?, -1) AND ADDDATE(?, 1)";
            conditionVal.add(conditions.getUpdateDate());
            conditionVal.add(conditions.getUpdateDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getUpdateDate())) {
            conditionStr += "   AND user_info.update_date >= ADDDATE(?, -1)";
            conditionVal.add(conditions.getUpdateDate());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getUpdateDateTo())) {
            conditionStr += "   AND user_info.update_date <= ADDDATE(?, 1)";
            conditionVal.add(conditions.getUpdateDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getLastLog()) &&
                !StringUtils.isEmpty(conditions.getLastLogDateTo())) {
            conditionStr += "   AND user_info.last_log BETWEEN ADDDATE(?, -1) AND ADDDATE(?, 1)";
            conditionVal.add(conditions.getLastLog());
            conditionVal.add(conditions.getLastLogDateTo());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getLastLog())) {
            conditionStr += "   AND user_info.last_log >= ADDDATE(?, -1)";
            conditionVal.add(conditions.getLastLog());
            incrementCnt++;
        } else if (!StringUtils.isEmpty(conditions.getLastLogDateTo())) {
            conditionStr += "   AND user_info.last_log <= ADDDATE(?, 1)";
            conditionVal.add(conditions.getLastLogDateTo());
            incrementCnt++;
        }

        if (!StringUtils.isEmpty(conditions.getValidity())) {
            conditionStr += "   AND user_master.status = ?";
            conditionVal.add(conditions.getValidity());
            incrementCnt++;
        }

        String sqlStr =
            "SELECT COUNT(*) as record_count " +
            "  FROM user_master " +
            "  LEFT JOIN user_info " +
            "         ON user_info.user_id = user_master.user_id " +
            " WHERE user_master.user_type_id = ?" +
            conditionStr;

        Map<Integer, Map<String, Object>> resultList =
            super.getConnector().doQuery(
                sqlStr,
                conditionVal.toArray(new String[incrementCnt]),
                new ParameterMapper() {
                    public void map(PreparedStatement prepStmt, String[] args) {
                        try {
                            for (int idx=0; idx<args.length; idx++) {
                                prepStmt.setString(idx + 1, args[idx]);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

        int resultCount = 0;
        if (resultList != null) {
            resultCount = Integer.parseInt(resultList.get(0).get("record_count").toString());
        } else {
            super.getLogger().debug(this.getClass().getName(), "No results found");
        }
        super.getLogger().debug(this.getClass().getName(), "-- count" + " end --");
        return resultCount;
    }

    public DBConnectorTest getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DBConnectorTest dbConnector) {
        this.dbConnector = dbConnector;
    }

}
