package csci230radomskizurnhardy;

import junit.framework.TestCase;

/**
 * This test class will run basic tests on the setters and getters associated with the Admin class.
 * The getter methods are tested within each test of the setter methods, where they are used to procure
 * a result from our Admin instance.
 * @author awzurn
 * @version 1.0
 * @since March, 2012
 */
public class AdminTest extends TestCase{
    private Admin admin;
    
    public AdminTest() {
    }

   
    @Override
    protected void setUp() throws Exception {
         admin = new Admin("Andrew", "Zurn", "AZurn91", "password", 'a', 'Y');
    }

    /**
     * Test of toString method, of class Admin.
     * 
     */
    
    /**
     * Basic test of setFirstName.
     * Input: Andy
     * Output: Andy
     */
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String expResult = "Andy";
        admin.setFirstName("Andy");
        assertEquals("The First Name Should Be Andy", expResult, admin.getFirstName());
    }
    
    /**
     * Basic test of setLastName
     * Input: NotZurn
     * Input: NotZurn
     */
    public void testSetLastName() {
        System.out.println("setLastName");
        String expResult = "NotZurn";
        admin.setLastName("NotZurn");
        assertEquals("The Last Name Should Be NotZurn", expResult, admin.getLastName());
    }
    
    /**
     * Basic test of setUserName
     * Input: Awzurn1991
     * Output: Awzurn1991
     */
    public void testSetUserName() {
        System.out.println("setUserName");
        String expResult = "Awzurn1991";
        admin.setUserName("Awzurn1991");
        assertEquals("The User Name Should Be Awzurn1991", expResult, admin.getUserName());
    }
    
    /**
     * Basic test of setPassword
     * Input: PASSWORD
     * Output: PASSWORD
     */
    public void testSetPassword() {
        System.out.println("setPassword");
        String expResult = "PASSWORD";
        admin.setPassword("PASSWORD");
        assertEquals("The Password Should Be PASSWORD", expResult, admin.getPassword());
    }
    
    /**
     * Basic test of setType
     * Input: u
     * Output: u
     */
    public void testSetType() {
        System.out.println("setType");
        char expResult = 'u';
        admin.setType('u');
        assertEquals("The Type Should Be u", expResult, admin.getType());
    }
    
    /**
     * Basic test of setStatus
     * Input: N
     * Output: N
     */
    public void testSetStatus(){
        System.out.println("setStatus");
        char expResult = 'N';
        admin.setStatus('N');
        assertEquals("The status should be N", expResult, admin.getStatus());
    }
}
