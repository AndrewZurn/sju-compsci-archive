package csci230radomskizurnhardy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author pghardy
 */
public class ProjectTestSuite extends TestCase {
    
    public ProjectTestSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("ProjectTestSuite2");
        suite.addTestSuite(AdminControllerTest.class);
        suite.addTestSuite(AdminTest.class);
        suite.addTestSuite(DatabaseControllerTest.class);
        suite.addTestSuite(FiveRecSchoolsControllerTest.class);
        suite.addTestSuite(PersonTest.class);
        suite.addTestSuite(SearchControllerTest.class);
        suite.addTestSuite(UniversityTest.class);
        suite.addTestSuite(UseCasesTest.class);
        suite.addTestSuite(UserControllerTest.class);
        suite.addTestSuite(UserTest.class);
        return suite;
    }
    
    
}
