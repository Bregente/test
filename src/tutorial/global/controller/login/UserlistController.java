package tutorial.global.controller.login;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import tutorial.global.common.util.AppCtxUtil;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.model.UserForm;
import tutorial.global.cool.user.service.UserService;
import tutorial.global.model.UserInfoSessionBean;

public class UserlistController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("userlist controller"); 
        //slim3's form
        UserForm memberUserForm = new UserForm();
        BeanUtil.copy(new RequestMap (request), memberUserForm);
        
        UserInfoSessionBean userInfoSessionBean = (UserInfoSessionBean) request.getSession().getAttribute("userInfoSessionBean");
        System.out.println(userInfoSessionBean.getEmail());
        
        
        UserDAO user = new UserDAO();
        user.setAccountName(memberUserForm.getAccountName());
        user.setType(memberUserForm.getType());
        
                
        System.out.println("acctname: "+user.getAccountName());
        System.out.println("type: "+user.getType());
        initTables(user);
        request.getSession().setAttribute("userForm", memberUserForm);
        request.getSession().setAttribute("userInfoSessionBean", userInfoSessionBean);
        return forward("userlist.jsp");
    }
    
  //polulate the tables
    public void initTables(UserDAO user){     
        
        UserService memberUserService = (UserService) AppCtxUtil.getBean(this.servletContext, "userServiceImpl");
        List<UserDAO> userList = memberUserService.listUsersAsList(user);
        System.out.println("size: "+userList.size());
        request.setAttribute("userList", userList);
        
    }
}
