package tutorial.global.controller.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import tutorial.global.common.db.DBConnectorTest;
import tutorial.global.controller.base.BaseTest;
import tutorial.global.cool.model.UserDAO;
import tutorial.global.user.service.UserServiceImpl;


public class UserServiceImplTest extends BaseTest {
    private UserDAO memberUserDAO;
    private DBConnectorTest connector;
    
    @Before
    public void setUp(){
        isUnitTesting = true;
        memberUserDAO = new UserDAO();
        connector = mock(DBConnectorTest.class);
        memberUserDAO.setAccountName("memberAf");
        memberUserDAO.setPassword("pass");
        memberUserDAO.setEmail("memberAfmemberA@yahoo.com");
        memberUserDAO.setType(2);
        memberUserDAO.setStatus(1);
    }
    
    @Test
    public void Test01addNullConnection() throws Exception{
        Connection con = null;
        when(connector.getConnection()).thenReturn(con);
        UserServiceImpl controller = new UserServiceImpl();
        controller.setDbConnector(connector);
        memberUserDAO = controller.add(memberUserDAO);
        
        assertThat(memberUserDAO.getErrorId(), is("GeneralExceptionErrorID"));
        assertThat(isSuccessfullyAdded(memberUserDAO), is(false));
        
        System.out.println("");
    }
    
    @Test
    public void Test02addSuccessful() throws Exception{
        Connection con = new DBConnectorTest().getConnection();
        when(connector.getConnection()).thenReturn(con);
        UserServiceImpl controller = new UserServiceImpl();
        controller.setDbConnector(connector);
        memberUserDAO = controller.add(memberUserDAO);
        
        assertThat(memberUserDAO.getErrorId() == null, is(true));
        assertThat(isSuccessfullyAdded(memberUserDAO), is(true));
        
        System.out.println("");
    }
    
    @Test
    public void Test03deleteUserNullConnection() throws Exception{
        Connection con = null;
        when(connector.getConnection()).thenReturn(con);
        UserServiceImpl controller = new UserServiceImpl();
        controller.setDbConnector(connector);
        String ErrorID = controller.deleteUser(memberUserDAO);
        
        assertThat(ErrorID, is("GeneralExceptionErrorID"));
        assertThat(isSuccessfullyDeleted(memberUserDAO), is(false));
        
        System.out.println("");
    }
    
    @After
    public void tearDown(){
        
    }
    
    @Test
    public void Test04deleteUserSuccessful() throws Exception{
        Connection con = new DBConnectorTest().getConnection();
        when(connector.getConnection()).thenReturn(con);
        UserServiceImpl controller = new UserServiceImpl();
        controller.setDbConnector(connector);
        String ErrorID = controller.deleteUser(memberUserDAO);
        
        assertThat(ErrorID == null, is(true));
        assertThat(isSuccessfullyDeleted(memberUserDAO), is(true));
        
        System.out.println("");
    }
    
    
    private boolean isSuccessfullyAdded(UserDAO memberUserDao) throws Exception{
        boolean isAdded = false;
        
        Connection con = new DBConnectorTest().getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select i.last_log from user_info i " 
                + "inner join user_master m on i.user_id = m.user_id where account_name=? and user_pass= md5(?) "
                + "and m.email = ? and m.user_type_id = ? and m.status = ?");
        ps.setString(1, memberUserDAO.getAccountName());
        ps.setString(2, memberUserDAO.getPassword());
        ps.setString(3, memberUserDAO.getEmail());
        ps.setInt(4, memberUserDAO.getType());
        ps.setInt(5, memberUserDAO.getStatus());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            isAdded = true;
        }
        return isAdded;
    }
    
    private boolean isSuccessfullyDeleted(UserDAO memUserDAO) throws Exception{
        boolean isDeleted = false;
        
        Connection con = new DBConnectorTest().getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("select m.status from user_master m " 
                + "where m.email = ? and m.user_type_id = ?");
        ps.setString(1, memUserDAO.getEmail());
        ps.setInt(2, memUserDAO.getType());

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if(rs.getInt(1) == 0){
                isDeleted = true;
            }
        }
        return isDeleted;
    }
}
