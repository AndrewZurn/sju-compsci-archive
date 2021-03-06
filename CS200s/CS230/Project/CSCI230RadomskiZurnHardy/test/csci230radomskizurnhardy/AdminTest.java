/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author awzurn
 */
public class AdminTest {
    private Admin admin;
    
    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        admin = new Admin("Andrew", "Zurn", "AZurn91", "password", 'a', 'Y');
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Admin.
     */
    @Test

    public void testSetFirstName() {
        System.out.println("setFirstName");
        String expResult = "Andy";
        admin.setFirstName("Andy");
        assertEquals("The First Name Should Be Andy", expResult, admin.getFirstName());
    }
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String expResult = "NotZurn";
        admin.setLastName("NotZurn");
        assertEquals("The Last Name Should Be NotZurn", expResult, admin.getLastName());
    }
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String expResult = "Awzurn1991";
        admin.setUserName("Awzurn1991");
        assertEquals("The User Name Should Be Awzurn1991", expResult, admin.getUserName());
    }
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String expResult = "PASSWORD";
        admin.setPassword("PASSWORD");
        assertEquals("The Password Should Be PASSWORD", expResult, admin.getPassword());
    }
    @Test
    public void testSetType() {
        System.out.println("setType");
        char expResult = 'u';
        admin.setType('u');
        assertEquals("The Type Should Be u", expResult, admin.getType());
    }
    @Test
    public void testSetStatus(){
        System.out.println("setStatus");
        char expResult = 'N';
        admin.setStatus('N');
        assertEquals("The status should be N", expResult, admin.getStatus());
    }
}
