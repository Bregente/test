package tutorial.global.cool.login.service;

import tutorial.global.cool.model.UserDAO;

public interface LoginService {
    public UserDAO checkLogin(UserDAO memberUserDAO);
    public UserDAO checkLoginOnEmail(UserDAO userDAO);
}
