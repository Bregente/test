package tutorial.global.controller.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial.global.common.base.Logger;
import tutorial.global.common.constant.GlobalConstants;
import tutorial.global.common.util.AppCtxUtil;
import tutorial.global.common.util.ValidationUtil;
import tutorial.global.common.util.data.ValidationData;
import tutorial.global.cool.login.service.LoginService;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.model.UserForm;
import tutorial.global.cool.user.service.UserService;
import tutorial.global.login.service.LoginServiceImpl;
import tutorial.global.model.UserInfoSessionBean;
import tutorial.global.user.service.UserServiceImpl;

/**
 * reconfigured struts2 LoginAction to use Slim3
 * @author hp.pc
 *
 */
public class LoginController extends Controller {
        
    
    private UserService memberUserService;
    private LoginService loginService;
    private HttpServletRequest req;
    private UserForm memberUserForm;
    private Errors errors;
    private String RESULT_REDIRECT;

    public String getRESULT_REDIRECT() {
        return RESULT_REDIRECT;
    }

    public void setRESULT_REDIRECT(String rESULT_REDIRECT) {
        RESULT_REDIRECT = rESULT_REDIRECT;
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }
    
    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setMemberUserService(UserService memberUserService) {
        this.memberUserService = memberUserService;
    }

    //global stuff that can be injected
    Logger logger = new tutorial.global.common.util.ConsoleLogger();
            
    @Override
    public Navigation run() throws Exception {
        req = request;
        memberUserService = new UserServiceImpl();
        loginService = new LoginServiceImpl();
        memberUserForm = new UserForm();
        String path = checkLoginFields();
        return forward (path);
    }
    
    public String checkLoginFields(){
        
        RESULT_REDIRECT = GlobalConstants.LOGIN;
        

        logger.debug(this.getClass().getName(), "-- loginValidate" + " invoked --");
      
        this.errors = new Errors();
        
        UserDAO memberUserDAO = new UserDAO(); //model
        memberUserDAO.setAccountName(req.getParameter("accountName"));
        memberUserDAO.setPassword(req.getParameter("password"));
        
        ValidationData accountNameData = new ValidationData();
        accountNameData.setFieldName("memberUserDAO.accountName");
        accountNameData.setFieldValue(memberUserDAO.getAccountName());
        accountNameData.setMaxLength(GlobalConstants.ACCOUNT_NAME_LENGTH);
        
        ValidationData passwordData = new ValidationData();
        passwordData.setFieldName("memberUserDAO.password");
        passwordData.setFieldValue(memberUserDAO.getPassword());
        passwordData.setMaxLength(GlobalConstants.PASSWORD_LENGTH);
        
        if (!ValidationUtil.validateAccountName(accountNameData)) {
                logger.debug(this.getClass().getName(),
                    "Account Name Required");
                logger.debug(this.getClass().getName(),
                    accountNameData.debugString());
                this.errors.put("accountName", "Account Name Required");
        }
        
        if(!ValidationUtil.validatePassword(passwordData)){
            logger.debug(this.getClass().getName(),
                    "Password Required");
                logger.debug(this.getClass().getName(),
                    passwordData.debugString());
                this.errors.put("password", "Password Required");
        }
        
        if(this.errors.size() == 0){
            if (GlobalConstants.ACCOUNT_NAME_EXISTS_ERROR_ID.equals(memberUserService.checkExistsAccountName(memberUserDAO))) {
                
                logger.debug(this.getClass().getName(), "Account name does not exist");
                logger.debug(this.getClass().getName(),
                    accountNameData.debugString());
                this.errors.put("accountName", "Account Name does not exist");
            }
            else if (GlobalConstants.DATABASE_ERROR_ID.equals(memberUserService.checkExistsAccountName(memberUserDAO))) {
                
                logger.debug(this.getClass().getName(), "Database Error occured");
                this.errors.put("database", "Database Error occured.");
            }else {
                UserDAO loginUserDAO = new UserDAO();
                loginUserDAO = loginService.checkLogin(memberUserDAO);

                if (loginUserDAO.getErrorId() != null) {
                    logger.debug(this.getClass().getName(), loginUserDAO.getErrorId());
                    this.errors.put("exception", loginUserDAO.getErrorId());

                } else {
                    UserInfoSessionBean userInfo = new UserInfoSessionBean();

                    if (loginUserDAO.getType() == 0) {
                        userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_SYS_AD); 
                        RESULT_REDIRECT = GlobalConstants.USER_LIST_CONTROLLER;
                    } else if (loginUserDAO.getType() == 1) {
                        userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_ADMIN);
                        RESULT_REDIRECT = GlobalConstants.USER_LIST_CONTROLLER;
                    } else if (loginUserDAO.getType() == 3) {
                        userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_MEMBER_B);
                        RESULT_REDIRECT = GlobalConstants.USER_LIST_CONTROLLER; //GlobalConstants.MESSAGE_MANAGEMENT;
                    } else {
                        userInfo.setUserType(GlobalConstants.PARAM_REQ_USER_TYPE_MEMBER);
                        RESULT_REDIRECT = GlobalConstants.USER_LIST_CONTROLLER; //GlobalConstants.MESSAGE_MANAGEMENT;
                    }

                    userInfo.setUserId(loginUserDAO.getUserId());
                    userInfo.setEmail(loginUserDAO.getEmail());
//                    this.sessionMap.put(GlobalConstants.SESSION_KEY_LOGIN_USER, userInfo);
                    req.getSession().setAttribute("userInfoSessionBean", userInfo);
                    Subject currentUser = SecurityUtils.getSubject();
                    if(!currentUser.isAuthenticated()){
                        UsernamePasswordToken token = new UsernamePasswordToken(memberUserDAO.getAccountName(), memberUserDAO.getPassword());
                        token.setRememberMe(true);
                        currentUser.login(token);
                    }
                    
                    logger.debug(this.getClass().getName(), "User [" + currentUser.getPrincipal() + "] logged in successfully.");
                }
            }
        }
        
        //setting stuff
        
        req.getSession().setAttribute("userForm", memberUserForm);
        logger.debug(this.getClass().getName(), "-- loginValidate" + " end -- sending to: "+RESULT_REDIRECT);
        //request.setAttribute("errors", arg1);
        if(RESULT_REDIRECT == GlobalConstants.USER_LIST){
            initTables(memberUserDAO);
        }
        super.errors = this.errors;
        return RESULT_REDIRECT;    
    }
    
    //polulate the tables
    public void initTables(UserDAO user){     
        
        UserService memberUserService = new UserServiceImpl();
        List<UserDAO> userList = memberUserService.listUsersAsList(user);
        System.out.println("size: "+userList.size());
        req.getSession().setAttribute("userList", userList);
        
    }

    public UserForm getMemberUserForm() {
        return memberUserForm;
    }

    public void setMemberUserForm(UserForm memberUserForm) {
        this.memberUserForm = memberUserForm;
    }

    public Errors getErrors() {
        return this.errors;
    }

    public void setErrors(Errors error) {
        this.errors = error;
    }
}
