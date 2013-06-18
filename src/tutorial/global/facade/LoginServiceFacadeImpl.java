package tutorial.global.facade;

import tutorial.global.common.util.ConsoleLogger;
import tutorial.global.cool.facade.LoginServiceFacade;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.login.service.LoginService;

public class LoginServiceFacadeImpl implements LoginServiceFacade {

    private LoginService loginServiceImpl;

    private ConsoleLogger logger;
    
    private LoginServiceFacadeImpl(LoginService loginServiceImpl, ConsoleLogger logger){

        this.loginServiceImpl = loginServiceImpl;
        this.logger = logger;      
        
        System.out.println("constructor start");
        if(null != logger){
            System.out.println("constructor logger not null");
        }else{
            System.out.println("constructor logger null");
        }
        
        if(null != loginServiceImpl){
            System.out.println("constructor loginServiceImpl not null");
        }else{
            System.out.println("constructor loginServiceImpl null");
        }
        System.out.println("constructor end");
       
    }   
   
    public UserDAO checkLoginOnEmail(UserDAO userDAO){ 
       
        if(null != logger){
            System.out.println("logger not null");
        }else{
            System.out.println("logger null");
        }
        
        if(null != loginServiceImpl){
            System.out.println("loginServiceImpl not null");
        }else{
            System.out.println("loginServiceImpl null");
        }
        System.out.println("in facade");
        return loginServiceImpl.checkLoginOnEmail(userDAO);
    }  
   
}
