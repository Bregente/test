package tutorial.global.controller.service;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tutorial.global.common.db.DBConnectorTest;
import tutorial.global.controller.base.BaseTest;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.login.service.LoginServiceImpl;

public class LoginServiceImplTest extends BaseTest {
    private UserDAO memberUserDAO;
    private DBConnectorTest connector;
    
    @Before
    public void set(){
        isUnitTesting = true;
        memberUserDAO = new UserDAO();
        connector = mock(DBConnectorTest.class);
    }
    
    @Test
    public void Test01checkLoginNullConnection() throws Exception{
        memberUserDAO.setAccountName("mema");
        memberUserDAO.setPassword("pass");
        Connection con = null;
        when(connector.getConnection()).thenReturn(con);
        LoginServiceImpl controller = new LoginServiceImpl();
        controller.setDbConnector(connector);
        String lastLogBefore = getLastLog(memberUserDAO);
        memberUserDAO = controller.checkLogin(memberUserDAO);
        String lastLogAfter = getLastLog(memberUserDAO);
        
        assertThat(memberUserDAO.getErrorId(), is("GeneralExceptionErrorID"));
        assertThat(lastLogAfter.equals(lastLogBefore), is(true));
    }
    
    @Test
    public void Test02checkLoginIncorrectData() throws Exception{
        memberUserDAO.setAccountName("mem");
        memberUserDAO.setPassword("pas");
        Connection con = new DBConnectorTest().getConnection();
        when(connector.getConnection()).thenReturn(con);
        LoginServiceImpl controller = new LoginServiceImpl();
        controller.setDbConnector(connector);
        String lastLogBefore = getLastLog(memberUserDAO);
        memberUserDAO = controller.checkLogin(memberUserDAO);
        String lastLogAfter = getLastLog(memberUserDAO);
        
        assertThat(memberUserDAO.getErrorId(), is("LoginIncorrectDataErrorID"));
        assertThat(lastLogAfter.equals(lastLogBefore), is(true));
        
    }
    
    @Test
    public void Test03checkLoginSuccessful() throws Exception{
        memberUserDAO.setAccountName("mema");
        memberUserDAO.setPassword("pass");
        Connection con = new DBConnectorTest().getConnection();
        when(connector.getConnection()).thenReturn(con);
        LoginServiceImpl controller = new LoginServiceImpl();
        controller.setDbConnector(connector);
        String lastLogBefore = getLastLog(memberUserDAO);
        memberUserDAO = controller.checkLogin(memberUserDAO);
        String lastLogAfter = getLastLog(memberUserDAO);
        
        assertThat(lastLogAfter.compareTo(lastLogBefore) > 0, is(true));
        
    }
    
    private String getLastLog(UserDAO memberUserDAO) throws Exception{
        String lastLog = "";
        Connection con = new DBConnectorTest().getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select i.last_log from user_info i " 
                + "inner join user_master m on i.user_id = m.user_id where account_name=? and user_pass= ? and status=1 and (user_type_id = 2 or user_type_id=3)");
        ps.setString(1, memberUserDAO.getAccountName());
        ps.setString(2, memberUserDAO.getPassword());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lastLog = rs.getString(1);
        }
        
        return lastLog;
    }
}
