package tutorial.global.cool.facade;

import tutorial.global.cool.model.UserDAO;

public interface LoginServiceFacade {
    
    public UserDAO checkLoginOnEmail(UserDAO userDAO);
}
