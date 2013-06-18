package tutorial.global.controller.login;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

import tutorial.global.common.base.Logger;
import tutorial.global.common.constant.GlobalConstants;
import tutorial.global.model.UserInfoSessionBean;
import tutorial.global.common.util.AppCtxUtil;
import tutorial.global.common.util.ConsoleLogger;
import tutorial.global.cool.login.service.LoginService;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.model.UserForm;
import tutorial.global.meta.UserFormMeta;

public class AdminLoginController extends Controller{

    public Navigation run() throws Exception {
        return forward (adminLogin());
    }
    
    private Logger logger = new ConsoleLogger();
    private com.google.appengine.api.users.UserService userService;
    
    public String adminLogin() {
        String RESULT_REDIRECT;
        logger.debug(this.getClass().getName(), "in admin controller");
        UserForm memberUserForm = new UserForm();
        UserFormMeta meta = UserFormMeta.get();
        BeanUtil.copy(meta, memberUserForm); //copy form jsp
       
        UserInfoSessionBean userInfo = new UserInfoSessionBean();
        this.userService = UserServiceFactory.getUserService();
        User user = this.userService.getCurrentUser();
        UserDAO userDAO = new UserDAO();

        if (user != null) {
           userDAO.setEmail(user.getEmail());           
           LoginService loginService = (LoginService)AppCtxUtil.getBean(this.servletContext, "loginServiceImpl");
                   
           userDAO = loginService.checkLoginOnEmail(userDAO);
         
           if (userDAO.getErrorId() != null) { 
               RESULT_REDIRECT = GlobalConstants.LOGIN;
           } else {
               userInfo.setUserId(userDAO.getUserId());
               userInfo.setEmail(userDAO.getEmail());
               if (userDAO.getType() == GlobalConstants.USER_TYPE_SYS_AD) {
                   userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_SYS_AD); 
                   RESULT_REDIRECT = GlobalConstants.USER_LIST;
               } else {
                   userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_ADMIN);
                   RESULT_REDIRECT = GlobalConstants.USER_LIST;
               }
              // this.sessionMap.put(GlobalConstants.SESSION_KEY_LOGIN_USER, userInfo);
               request.setAttribute("UserInfoSessionBean", userInfo);
           }
        } else {
            RESULT_REDIRECT = GlobalConstants.LOGIN;
        }
        request.setAttribute("UserForm", memberUserForm);
        logger.debug(this.getClass().getName(), "out to "+RESULT_REDIRECT+" model: "+userInfo.getEmail());

        return RESULT_REDIRECT;
    }
 
    
}
