package tutorial.global.controller.login;

import java.util.Enumeration;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import tutorial.global.common.constant.GlobalConstants;

public class LoginRedirectController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("loginredirect");
        Enumeration e =  request.getAttributeNames();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        return forward(GlobalConstants.lOGIN_REDIRECT);
    }
}
