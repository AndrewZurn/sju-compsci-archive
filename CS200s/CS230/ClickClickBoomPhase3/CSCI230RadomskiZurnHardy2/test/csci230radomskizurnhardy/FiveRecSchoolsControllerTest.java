package csci230radomskizurnhardy;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author pghardy
 */
public class FiveRecSchoolsControllerTest extends TestCase{
    
    public FiveRecSchoolsControllerTest() {
    }

    @Override
    protected void setUp() throws Exception {
        DatabaseController.addUniversity("ClickClickBoomSchool1","CCBState1", "-1",    "Private", 2000,  30, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool2","CCBState1", "-1",    "Private", 2000,  31, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool3","CCBState1", "-1",    "Private", 2000,  32, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool4","CCBState1", "-1",    "Private", 2000,  33, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool5","CCBState1", "-1",    "Private", 2000,  34, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
        DatabaseController.addUniversity("ClickClickBoomSchool6","CCBState1", "-1",    "Private", 2000,  35, 400, 400, 80000, 55, 2000,  60, 75, 5, 4, 5);
//        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
//        for(University uni: allSchools){
//            System.out.println(uni.getSchool());
//        }
    }


    /**
     * This is a basic test of getFiveMatches method, of class FiveRecSchoolsController.
     * Prior to running this test, 6 very similar schools are added to the database. One of the schools
     * is then fed through the search algorithm and we must assert that the other 5 similar schools
     * are the 5 that are returned.
     * Input: School with name "ClickClickBoomSchool1"
     * Output: the other 5 schools ranging in ClickClickBoomSchool[2-6]
     * The test fails if any one of them is not found. 
     */
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
                 assertTrue(uni + " not found.", uni.getSchool().equals("ClickClickBoomSchool2") ||
                                                 uni.getSchool().equals("ClickClickBoomSchool3") ||
                                                 uni.getSchool().equals("ClickClickBoomSchool4") ||
                                                 uni.getSchool().equals("ClickClickBoomSchool5") ||
                                                 uni.getSchool().equals("ClickClickBoomSchool6"));                
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
