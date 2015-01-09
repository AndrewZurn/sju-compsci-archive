package csci230radomskizurnhardy;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pghardy
 */
public class FiveRecSchoolsControllerTest {
    
    public FiveRecSchoolsControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        DatabaseController.addUniversity("ClickClickBoomSchool1","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool2","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool3","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool4","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool5","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool6","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
//        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
//        for(University uni: allSchools){
//            System.out.println(uni.getSchool());
//        }
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
     * Test of getFiveMatches method, of class FiveRecSchoolsController.
     */
    @Test
    public void testGetFiveMatches() {
        System.out.println("getFiveMatchesSchool");
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        University searchU = null;
        FiveRecSchoolsController instance = null;
        ArrayList<University> result = null;
        for(University uni: allSchools){
            if(uni.getSchool().equals("ClickClickBoomSchool1")){
                searchU = uni;
            }
        }
        if(searchU!=null){
             instance = new FiveRecSchoolsController(searchU);
             result = instance.getFiveMatches();
             for(University uni: result){
                 System.out.println(uni.getSchool());
                 assertTrue(uni + " not found.", uni.getSchool().equals("ClickClickBoomSchoolC") ||
                                                 uni.getSchool().equals("ClickClickBoomSchoolB") ||
                                                 uni.getSchool().equals("ClickClickBoomSchoolE") ||
                                                 uni.getSchool().equals("ClickClickBoomSchoolJ") ||
                                                 uni.getSchool().equals("ClickClickBoomSchoolD"));                
             }
        }
        else{
            fail("Specified school not found.");
        }
    }

    /**
     * Test of main method, of class FiveRecSchoolsController.
     */
//    This method was used for the driver class from Phase II 
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        FiveRecSchoolsController.main(args);
//    }
}
