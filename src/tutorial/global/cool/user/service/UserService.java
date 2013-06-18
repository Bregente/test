/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
package tutorial.global.cool.user.service;

import java.util.List;

import tutorial.global.cool.model.UserDAO;

/**
 * ãƒ¦ãƒ¼ã‚¶è¿½åŠ??å¤‰æ›´ãƒ»å‰Šé™¤ã�®ãƒ??ã‚¿ãƒ™ã?ã‚¹æ©Ÿè?ã€?
 * @author robert.lao
 */

public interface UserService {

    public boolean checkExists(UserDAO user);
    public String deleteUser(UserDAO user);
    public String deleteUser(List<UserDAO> userList);
    public UserDAO listUsers(UserDAO user);

    public String checkExistsAccountName(UserDAO memberUserDAO);
    public String checkExistsAccountNameOther(UserDAO memberUserDAO);
    public String checkExistsEmail(UserDAO memberUserDAO);
    public String checkExistsEmailOther(UserDAO memberUserDAO);
    public UserDAO add(UserDAO memberUserDAO);
    public String queryGetNewID();
    public String update(UserDAO userDao, String loggedUserId);

    public List<UserDAO> listUsersAsList(UserDAO user);
    public List<UserDAO> listUsersAsList(UserDAO user, int fromRow, int rowCount);

    public int count(UserDAO user);
}
