package tutorial.global.controller.login;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import tutorial.global.common.util.AppCtxUtil;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.user.service.UserService;
import tutorial.global.model.UserInfoSessionBean;

public class CreateController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("create controller");
        UserInfoSessionBean userInfoSessionBean = (UserInfoSessionBean) request.getSession().getAttribute("userInfoSessionBean");
        //System.out.println(userInfoSessionBean.getEmail());
        
        UserDAO model = new UserDAO();
        
        //get fields from screen and copy to model
        BeanUtil.copy(new RequestMap(request), model);
        System.out.println(model.getEmail());
        System.out.println(model.getAccountName());
        System.out.println(model.getPassword());
        System.out.println(model.getType());
        
        //call service
        UserService service = (UserService)AppCtxUtil.getBean(this.servletContext, "userServiceImpl");
        
        //then add
        service.add(model);
        
        request.getSession().setAttribute("userInfoSessionBean", userInfoSessionBean);
        return redirect("/login/userlist");
    }
}
