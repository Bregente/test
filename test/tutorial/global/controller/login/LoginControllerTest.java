package tutorial.global.controller.login;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.slim3.tester.ControllerTestCase;
import org.slim3.tester.MockHttpServletRequest;
import org.slim3.tester.MockServletContext;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import tutorial.global.common.constant.GlobalConstants;
import tutorial.global.cool.login.service.LoginService;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.cool.user.service.UserService;
import tutorial.global.login.service.LoginServiceImpl;
import tutorial.global.user.service.UserServiceImpl;


public class LoginControllerTest extends ControllerTestCase {
    public static boolean isUnitTesting = false;
    private MockServletContext servletContext;
    private MockHttpServletRequest request;
    private LoginService mockLoginService;
    private UserService mockUserService;
    
    @Before
    public void set() throws Exception {
        servletContext = new MockServletContext();
        request = new MockHttpServletRequest(servletContext);
        mockLoginService = Mockito.mock(LoginServiceImpl.class);
        mockUserService = Mockito.mock(UserServiceImpl.class);
    }
    
    @Test
    public void Test01loginAccountNameRequired() throws Exception { 
        request.setParameter("accountName", "");
        request.setParameter("password", "pass");
       
        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("AccountNameExistsErrorID");
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.checkLoginFields();
        
        //Test Account Name required Error Existence
        assertThat(controller.getErrors().size(), is(1));
        assertThat(controller.getErrors().get(0), is("Account Name Required"));
        assertThat(controller.getRESULT_REDIRECT(), is(GlobalConstants.LOGIN));
        System.out.println("");
    }
    
    @Test
    public void Test02loginPasswordRequired() throws Exception { 
        request.setParameter("accountName", "mema");
        request.setParameter("password", "");

        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("AccountNameExistsErrorID");
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.checkLoginFields();
        
        //Test Password Error Existence
        assertThat(controller.getErrors().size(), is(1));
        assertThat(controller.getErrors().get(0), is("Password Required"));
        assertThat(controller.getRESULT_REDIRECT(), is(GlobalConstants.LOGIN));
        System.out.println("");
    }
    
    @Test
    public void Test03loginPasswordAndAccountNameRequired() throws Exception { 
        request.setParameter("accountName", "");
        request.setParameter("password", "");

        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("AccountNameExistsErrorID");
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.checkLoginFields();
        
        //Test Password required and Account Name required Error Existence
        assertThat(controller.getErrors().size(), is(2));
        assertThat(controller.getRESULT_REDIRECT(), is(GlobalConstants.LOGIN));
        System.out.println("");
    }
    
    @Test
    public void Test04loginAccountNameDoesNotExist() throws Exception { 
        request.setParameter("accountName", "mema");
        request.setParameter("password", "pass");

        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("AccountNameExistsErrorID");
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.checkLoginFields();
        
        //Test Account Name does not exist Error Existence
        assertThat(controller.getErrors().size(), is(1));
        assertThat(controller.getErrors().get(0), is("Account Name does not exist"));
        assertThat(controller.getRESULT_REDIRECT(), is(GlobalConstants.LOGIN));
        
        System.out.println("");
    }
    
    @Test
    public void Test05checkLoginError() throws Exception { 
        request.setParameter("accountName", "mema");
        request.setParameter("password", "pass");
        UserDAO user = new UserDAO();
        user.setErrorId("LoginIncorrectDataErrorID");
        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("");
        Mockito.when(mockLoginService.checkLogin((UserDAO)Mockito.anyObject())).thenReturn(user);
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.setLoginService(mockLoginService);
        controller.checkLoginFields();
        
        //Test checkLogin() error return value Existence
        assertThat(controller.getErrors().size(), is(1));
        assertThat(controller.getErrors().get(0), is("LoginIncorrectDataErrorID"));
        assertThat(controller.getRESULT_REDIRECT(), is(GlobalConstants.LOGIN));
        System.out.println("");
    }
    
    @Ignore
    @Test
    public void Test06LoginSuccessful() throws Exception { 
        request.setParameter("accountName", "mema");
        request.setParameter("password", "pass");
        UserDAO user = new UserDAO();
        LoginController controller = new LoginController();
        Mockito.when(mockUserService.checkExistsAccountName((UserDAO)Mockito.anyObject())).thenReturn("");
        Mockito.when(mockLoginService.checkLogin((UserDAO)Mockito.anyObject())).thenReturn(user);
        controller.setReq(request);
        controller.setMemberUserService(mockUserService);
        controller.setLoginService(mockLoginService);
        controller.checkLoginFields();
        
        //Test checkLogin() error return value Existence
        assertThat(controller.getErrors().size(), is(0));
        assertThat(controller.getRESULT_REDIRECT(), is("/login/userlist"));
        System.out.println("");
    }
    
}
