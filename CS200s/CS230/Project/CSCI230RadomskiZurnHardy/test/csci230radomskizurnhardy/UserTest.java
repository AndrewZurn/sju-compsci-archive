/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author wjradomski
 */
public class UserTest {
    private User user;
    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        user = new User("name", "name", "name", "name", 'u', 'n');
    }
    
    @After
    public void tearDown() {
    }
     /**
     * Test of setFirstName and getFirstName methods.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName and getfirstName methods");
        String expResult = "firstName";
        user.setFirstName("firstName");
        assertEquals(expResult, user.getFirstName());
    }
         /**
     * Test of setLastName and getLastName methods.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName and getLastName methods");
        String expResult = "lastName";
        user.setLastName("lastName");
        assertEquals(expResult, user.getLastName());
    }
         /**
     * Test of setUserName and getUserName methods.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName method");
        String expResult = "userName";
        user.setUserName("userName");
        assertEquals(expResult, user.getUserName());
    }
         /**
     * Test of setPassword and getPassword methods.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword and getPassword method");
        String expResult = "password";
        user.setPassword("password");
        assertEquals(expResult, user.getPassword());
    }
    
         /**
     * Test of setType and getType methods.
     */
    @Test
    public void testSetType() {
        System.out.println("setType and getType method");
        char expResult = 'u';
        user.setType('u');
        assertEquals(expResult, user.getType());
    }
         /**
     * Test of setStatus and getStatus methods.
     */
    @Test
    public void testSetStatus(){
        System.out.println("setStatus and getStatus method");
        char expResult = 'N';
        user.setStatus('N');
        assertEquals(expResult, user.getStatus());
    }
}