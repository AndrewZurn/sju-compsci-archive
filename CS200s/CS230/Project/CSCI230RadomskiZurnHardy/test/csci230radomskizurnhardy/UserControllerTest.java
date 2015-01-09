



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author wjradomski
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUserSchool method, of class UserController.
     */
    @Test
    public void testAddUserSchool() {
        System.out.println("addUserSchool");
        int id = 0;
        String school = "";
        UserController.addUserSchool(id, school);

    }

    /**
     * Test of removeUserSchool method, of class UserController.
     */
    @Test
    public void testRemoveUserSchool() {
        System.out.println("removeUserSchool");
        int id = 0;
        String school = "";
        UserController.removeUserSchool(id, school);

    }

    /**
     * Test of getAllSavedSchools method, of class UserController.
     */
    @Test
    public void testGetAllSavedSchools() {
        System.out.println("getAllSavedSchools");
        int id = 0;
        ArrayList expResult = null;
        ArrayList result = UserController.getAllSavedSchools(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of editUser method, of class UserController.
     */
    @Test
    public void testEditUser() {
        System.out.println("editUser");
        String username = "juser";
        String firstName = "Johnny";
        String lastName = "John";
        String password = "user";
        UserController.editUser(username, firstName, lastName, password);

    }

    /**
     * Test of login method, of class UserController.
     */
    @Test
    public void testLogin() {
        System.out.println("login Method");
        String username = "juser";
        String username1 = "blah";
        String password = "user";
        String password1 = "user1";
        System.out.println("The following message corresponds to: correct username, correct password");
        boolean result = UserController.login(username, password);
        assertTrue(result);
        
        System.out.println("The following message corresponds to: correct username, incorrect password");
        boolean result1 = UserController.login(username, password1);
        assertTrue(!result1);
        
        System.out.println("The following message corresponds to: invalid username, valid password");
        boolean result2 = UserController.login(username1, password);
        assertTrue(!result2);
        
        System.out.println("The following message corresponds to: invalid username, invalid password");
        boolean result3 = UserController.login(username1, password1);
        assertTrue(!result3);
        
    }
}