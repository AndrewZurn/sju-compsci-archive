package csci230radomskizurnhardy;

import junit.framework.TestCase;


/**
 *
 * @author wjradomski
 */
public class UserTest extends TestCase{
    private User user;
    public UserTest() {
    }
    
    @Override
    protected void setUp() throws Exception{
        user = new User("name", "name", "name", "name", 'u', 'n');
    }
    

    public void testSetFirstName() {
        System.out.println("setFirstName and getfirstName methods");
        String expResult = "firstName";
        user.setFirstName("firstName");
        assertEquals(expResult, user.getFirstName());
    }
         /**
     * Test of setLastName and getLastName methods.
     * Basic test setting and getting a lastName of a user.
     */
   
    public void testSetLastName() {
        System.out.println("setLastName and getLastName methods");
        String expResult = "lastName";
        user.setLastName("lastName");
        assertEquals(expResult, user.getLastName());
    }
         /**
     * Test of setUserName and getUserName methods.
     * Basic Test setting and getting a username of a user.
     */
    
    public void testSetUserName() {
        System.out.println("setUserName method");
        String expResult = "userName";
        user.setUserName("userName");
        assertEquals(expResult, user.getUserName());
    }
         /**
     * Test of setPassword and getPassword methods.
     * Basic Test setting and getting a password of a user.
     */
    
    public void testSetPassword() {
        System.out.println("setPassword and getPassword method");
        String expResult = "password";
        user.setPassword("password");
        assertEquals(expResult, user.getPassword());
    }
    
         /**
     * Test of setType and getType methods.
     * Basic Test setting and getting the user type.
     */
    
    public void testSetType() {
        System.out.println("setType and getType method");
        char expResult = 'u';
        user.setType('u');
        assertEquals(expResult, user.getType());
    }
         /**
     * Test of setStatus and getStatus methods.
     * Basic test setting and getting status of a user.
     */
    
    public void testSetStatus(){
        System.out.println("setStatus and getStatus method");
        char expResult = 'N';
        user.setStatus('N');
        assertEquals(expResult, user.getStatus());
    }
}