/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author pghardy
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({csci230radomskizurnhardy.AdminControllerTest.class, 
    csci230radomskizurnhardy.AdminTest.class, csci230radomskizurnhardy.DatabaseControllerTest.class,
    csci230radomskizurnhardy.FiveRecSchoolsControllerTest.class, 
    csci230radomskizurnhardy.SearchControllerTest.class, 
    csci230radomskizurnhardy.UniversityTest.class, csci230radomskizurnhardy.UserTest.class, 
    csci230radomskizurnhardy.UserControllerTest.class, csci230radomskizurnhardy.UseCasesTest.class})
public class ProjectTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
