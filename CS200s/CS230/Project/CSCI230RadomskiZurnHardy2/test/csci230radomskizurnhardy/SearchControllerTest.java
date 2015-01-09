package csci230radomskizurnhardy;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * This class will perform a variety of basic tests on the search methods used in SearchControllerTest.
 * Input and output results can be found in the description found before each test.  Each search method
 * is tested to simulate the user performing a search with only one search parameter/field being used.
 * Various other tests are performed to show the capabilities of the system in performing more advanced
 * searches, where more then one parameter is used.  Because these are all private methods within 
 * SearchController, the method "search" is used, where the corresponding method will be accessed to
 * return the results of the search.
 * @author awzurn, pghardy
 * @version 1.0
 * @since March, 2012
 */
public class SearchControllerTest extends TestCase{
    
    public SearchControllerTest() {
    }
    @Override
    protected void setUp() throws Exception {
        //USE THESE 10 SCHOOLS TO SEARCH AGAINST TO MAKE SURE
        //THE CORRECT ONES SHOW UP AND THE WRONG ONES DO NOT
        //DO NOT EDIT THESE UNIVERSITIES, THEY ARE ALREADY 
        //IN THE DATABASE AND ARE USED ELSEWHERE, Preston
        
        //DatabaseController.addUniversity("ClickClickBoomSchoolA","CCBState1", "-1",    "Private", 1000,  30, 400, 400, 40000, 55, 2000,  60, 75, 5, 3, 5);
        //DatabaseController.addUniversity("ClickClickBoomSchoolB","CCBState1", "-1",    "Public",  2000,  35, 400, 400, 40000, 65, 4000,  60, 75, 4, 3, 2);
        //DatabaseController.addUniversity("ClickClickBoomSchoolC","CCBState1", "-1",    "Private", 3000,  40, 450, 400, 40000, 75, 6000,  60, 75, 5, 3, 1);
        //DatabaseController.addUniversity("ClickClickBoomSchoolD","CCBState1", "Urban", "Public",  4000,  45, 450, 400, 40000, 85, 8000,  60, 75, 4, 3, 3);
        //DatabaseController.addUniversity("ClickClickBoomSchoolE","CCBState1", "Urban", "Private", 5000,  50, 500, 400, 50000, 95, 10000, 60, 75, 3, 3, 5);
        //DatabaseController.addUniversity("ClickClickBoomSchoolF","CCBState2", "Rural", "Public",  6000,  55, 500, 400, 50000, 95, 12000, 60, 75, 1, 2, 4);
        //DatabaseController.addUniversity("ClickClickBoomSchoolG","CCBState2", "Rural", "Public",  7000,  60, 550, 400, 50000, 85, 14000, 60, 75, 2, 5, 3);
        //DatabaseController.addUniversity("ClickClickBoomSchoolH","CCBState2", "-1",    "Public",  8000,  65, 250, 400, 50000, 75, 16000, 60, 75, 3, 1, 1);
        //DatabaseController.addUniversity("ClickClickBoomSchoolI","CCBState2", "-1",    "Public",  9000,  70, 250, 400, 50000, 65, 18000, 60, 75, 4, 2, 2);
        //DatabaseController.addUniversity("ClickClickBoomSchoolJ","CCBState2", "-1",    "Public",  10000, 75, 250, 400, 50000, 55, 20000, 60, 75, 5, 3, 5);
    }

    /**
     * Basic test of the search school method.  ClickClickBoomSchool A is search, and properly returned.
     * Input: ClickClickBoomSchoolA
     * Output: ClickClickBoomSchoolA
     */
    public void testSearch_School() {
        System.out.println("testSearch_School");
        String wantedSchool = "ClickClickBoomSchoolA";
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_School");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getSchool().toLowerCase().equals(wantedSchool.toLowerCase())){
           truth = true;
       }
       assertTrue("Search School Name", truth);
    }
    
    /**
     * Basic test of the search state method.  The first item in the returned ArrayList will hold the value
     * CCBState1 for its state.
     * Input: CCBState1
     * Output: School holding CCBState1 as its state.
     */
    public void testSearch_State() {
        System.out.println("testSearch_State");
        String wantedSchool = null;
        String wantedState = "CCBState1";
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_State");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getState().toLowerCase().equals(wantedState.toLowerCase())){
           truth = true;
       }
       assertTrue("Search State", truth);
    }
    
    /**
     * Basic test of the search location method.  The first item in the returned ArrayList will hold the value
     * Urban for its location.
     * Input: Urban
     * Output: School holding Urban as its location.
     */
    public void testSearch_Location() {
       System.out.println("testSearch_Location");
        String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = "Urban";
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_Location");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getLocation().toLowerCase().equals(wantedLocation.toLowerCase())){
           truth = true;
       }
       assertTrue("Search Location", truth);
    }
    
     /**
     * Basic test of the search control method.  The first item in the returned ArrayList will hold the value
     * Private for its control.
     * Input: Private
     * Output: School holding Private as its control.
     */
    public void testSearch_Control() {
       System.out.println("testSearch_Control");
        String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = "Private";
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_Control");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getControl().toLowerCase().equals(wantedControl.toLowerCase())){
           truth = true;
       }
       assertTrue("Search Control", truth);
    }
    
    /**
     * Basic test of the search number of students method.  
     * The first item in the returned ArrayList will hold the value 1000 number of students
     * Input: Lower - 999  Upper - 1001
     * Output: School containing 1000 students
     */
    public void testSearch_NumberOfStudents() {
       System.out.println("testSearch_NumberOfStudents");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = 999;
        Integer highWantedNumber = 1001;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_NumberOfStudents");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getNumberOfStudents() == 1000){
           truth = true;
       }
       assertTrue("Search Number Of Students", truth);
    }
    
    /**
     * Basic test of the search percentage of females method.
     * The first item in the returned ArrayList will hold the value 75.0 percent females.
     * Input: Lower - 74.0  Upper - 76.0
     * Output: School with 75 percent females. 
     */
    public void testSearch_PercentFemale() {
       System.out.println("testSearch_PercentFemale");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = 74.0;
        Double highPercentFemales = 76.0;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_PercentFemales");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getPercentFemales() == 75.0){
           truth = true;
       }
       assertTrue("Search Percentage Females", truth);
    }
    
    /**
     * Basic test of the search SATVerbal method.  
     * The first item in the returned ArrayList will hold the value 450 for its SATVerbal score.
     * Input: Lower - 449.0  Upper - 451.0
     * Output: School with 450 SAT verbal score.
     */
    public void testSearch_SATVerbal() {
       System.out.println("testSearch_SATVerbal");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = 449.0;
        Double highSATVerbal = 451.0;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_SATVerbal");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getSATVerbal() == 450.0){
           truth = true;
       }
       assertTrue("Search SAT Verbal", truth);
       
    }
    
    /**
     * Basic test of the search SATMath method.  
     * The first item in the returned ArrayList will hold the value 400 for its SATMath score.
     * Input: Lower - 399.0  Upper - 401.0
     * Output: School with 400 SAT math score.
     */
    public void testSearch_SATMath() {
       System.out.println("testSearch_SATMath");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = 399.0;
        Double highSATMath = 401.0;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_SATMath");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getSATMath() == 400.0){
           truth = true;
       }
       assertTrue("Search SAT Math", truth);
    }
    
    /**
     * Basic test of the search Expenses method.  
     * The first item in the returned ArrayList will hold the value 40000 for its expenses.
     * Input: Lower - 39999.0  Upper - 40001.0
     * Output: School with 40000 expense.
     */
    public void testSearch_Expenses() {
       System.out.println("testSearch_Expenses");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = 39999.0;
        Double highExpenses = 40001.0;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_Expenses");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getExpenses() == 40000.0){
           truth = true;
       }
       assertTrue("Search Expenses", truth);
    }
    
    /**
     * Basic test of the search percent financial aid method.  
     * The first item in the returned ArrayList will hold the value 55.0 for its percent financial aid.
     * Input: Lower - 54.9  Upper - 55.4
     * Output: School with 55.0 percent financial aid.
     */
    public void testSearch_PercentFinancialAid() {
       System.out.println("testSearch_PercentFinancialAid");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = 54.9;
        Double highFinAid = 55.1;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_FinancialAid");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getPercentFinancialAid() == 55.0){
           truth = true;
       }
       assertTrue("Search Percentage of Financial Aid", truth);
    }
    
    /**
     * Basic test of the search number of applicants method.  
     * The first item in the returned ArrayList will hold the value 16000 for its number of applicants.
     * Input: Lower - 15999  Upper - 16001
     * Output: School with 16000 number of applicants.
     */
    public void testSearch_NumberOfApplicants() {
       System.out.println("testSearch_NumberOfApplicants");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = 15999;
        Integer highNumApplicants = 16001;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_NumberOfApplicants");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getNumberOfApplicants() == 16000){
           truth = true;
       }
       assertTrue("Search Number of Applicants", truth);
    }
    
    /**
     * Basic test of the search percent admitted method.  
     * The first item in the returned ArrayList will hold the value 60 for percent admitted.
     * Input: Lower - 59.9  Upper - 60.1
     * Output: School with 60 percent admitted.
     */
    public void testSearch_PercentAdmitted() {
       System.out.println("testSearch_PercentAdmitted");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = 59.9;
        Double highAdmitted = 60.1;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_PercentAdmitted");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getPercentAdmitted() == 60.0){
           truth = true;
       }
       assertTrue("Search Percentage Admitted", truth);
    }
    
    /**
     * Basic test of the search percent enrolled method.  
     * The first item in the returned ArrayList will hold the value 75.0 for its percent enrolled.
     * Input: Lower - 74.9  Upper - 75.1
     * Output: School with 75 percent enrolled.
     */
    public void testSearch_PercentEnrolled() {
       System.out.println("testSearch_PercentEnrolled");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = 74.9;
        Double highEnrolled = 75.1;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_PercentEnrolled");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getPercentEnrolled() == 75.0){
           truth = true;
       }
       assertTrue("Search Percentage Enrolled", truth);
    }

     /**
     * Basic test of the search academics scale method.  
     * The first item in the returned ArrayList will hold the value 5 for its academic score.
     * Input: Lower - 5  Upper - 5
     * Output: School with 5 for academic score.
     */
    public void testSearch_AcademicScale() {
       System.out.println("testSearch_AcademicScale");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = 5;
        Integer highAcademicScale = 5;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_AcademicScale");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getAcademicsScale() == 5){
           truth = true;
       }
       assertTrue("Search Academic Scale", truth);
    }
    
    /**
     * Basic test of the search social scale method.  
     * The first item in the returned ArrayList will hold the value 5 for its social score.
     * Input: Lower - 5  Upper - 5
     * Output: School with 5 for social score.
     */
    public void testSearch_SocialScale() {
       System.out.println("testSearch_SocialScale");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = 5;
        Integer highSocialScale = 5;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_SocialScale");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getSocialScale() == 5){
           truth = true;
       }
       assertTrue("Search Social Scale", truth);
    }
    
     /**
     * Basic test of the search quality of live scale method.  
     * The first item in the returned ArrayList will hold the value 5 for its quality of life score.
     * Input: Lower - 5  Upper - 5
     * Output: School with 5 for quality of life score.
     */
    public void testSearch_QualityOfLifeScale() {
       System.out.println("testSearch_QualityOfLifeScale");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = 5;
        Integer highQualityScale = 5;
        ArrayList<String> empList = new ArrayList<String>();
        System.out.println("testSearch_QualityScale");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if(uni.getQualityOfLifeScale() == 5 ){
           truth = true;
       }
       assertTrue("Search Quality Scale", truth);
    }
    
     /**
     * Basic test of the search emphases method.  
     * The first item in the returned ArrayList will have Computer Science and Math as emphases.
     * Input: ArrayList<String> containing 0: Computer Science, 1: Math
     * Output: School containing emphases of Computer Science and Math
     */
    public void testSearch_Emphases() {
       System.out.println("testSearch_Emphases");
       String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        empList.add("Computer Science");
        empList.add("Math");
        System.out.println("testSearch_Emphases");
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       ArrayList<String> returnEmphases = uni.getEmphases();
       String return1 = returnEmphases.get(0);
       String return2 = returnEmphases.get(1);
       if( return1.toLowerCase().indexOf("computer science") == 0 &&
               return2.toLowerCase().indexOf("math") == 0 ){
           truth = true;
       }
       assertTrue("Search Emphases" + return1 + ", " + return2, truth);
    }
    
    /**
     * Black Box Test for a combination of search criteria.  
     * Equivalence case: Multiple search entries - State, Number of Students, Percent Females
     * Input: wantedState - CCBState1, lowWantedNumber - 3999  highWantedNumber - 4001,
     *        lowPercentFemales - 44.9  highPercentFemales - 45.1
     * Output: School in the state of CCBState1, has 4000 students, and 45 percent females.
     *         In this case, school ClickClickBoomSchoolD matches the criteria.
     */
    public void test_SearchCombo1(){
        System.out.println("testSearchCombo1 - Search with State, Number of Students, and Percent Females");
        String wantedSchool = null;
        String wantedState = "CCBState1";
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = 3999;
        Integer highWantedNumber = 4001;
        Double lowPercentFemales = 44.9;
        Double highPercentFemales = 45.1;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       System.out.println(uni);
       if( uni.getSchool().equals("ClickClickBoomSchoolD")){
           truth = true;
       }
       assertTrue("Search Combo 1", truth);
    }
    
    /**
     * Black Box Test for a combination of search criteria.  
     * Equivalence case: Multiple search entries - SAT Math, Number of Applicants, Percent Admitted
     * Input: lowSATMath - 399.0  highSATMath - 401.0, lowNumApplicants - 7999  highNumApplicants - 8001,
     *        lowAdmitted - 44.9  highAdmitted - 45.1
     * Output: School in the with SATMath score of 400, 8000 number of applicants, and 60 percent admitted.
     *         In this case, school ClickClickBoomSchoolD matches the criteria.
     */
    public void test_SearchCombo2(){
        System.out.println("testSearchCombo2 - Search with SAT Math, Num Applicants, Percent Admitted");
        String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = 399.0;
        Double highSATMath = 401.0;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = 7999;
        Integer highNumApplicants = 8001;
        Double lowAdmitted = 59.0;
        Double highAdmitted = 61.0;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if( uni.getSchool().equals("ClickClickBoomSchoolD")){
           truth = true;
       }
       assertTrue("Search Combo 2", truth);
    }
    
    /**
     * Black Box Test for a combination of search criteria.  
     * Equivalence case: Multiple search entries - State, Location, Control
     * Input: wantedState - CCBState1, wantedLocation - Suburban, wantedControl - Public
     * Output: There is no school that is located in a Suburban location.
     *         Null is returned.
     */
    public void test_SearchCombo3(){
        System.out.println("testSearchCombo3 - Search with State, Location and Control - Should be null");
        String wantedSchool = null;
        String wantedState = "CCBState1";
        String wantedLocation = "Suburban";
        String wantedControl = "Public";
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       if( search.isEmpty()){
           truth = true;
       }
       assertTrue("Search Combo 3", truth);
    }
    
    /**
     * Black Box Test for a combination of search criteria.  
     * Equivalence case: Multiple search entries - State and Location
     * Input: wantedState - CCBState1, wantedLocation - Urban
     * Output: School in the state of CCBState1, with an Urban location.
     *         In this case, schools ClickClickBoomSchoolD and ClickClickBoomSchoolE match the criteria.
     */
    public void test_SearchCombo4(){
        System.out.println("testSearchCombo4 - Search with State and Location");
        String wantedSchool = null;
        String wantedState = "CCBState1";
        String wantedLocation = "Urban";
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = null;
        Double highEnrolled = null;
        Integer lowAcademicScale = null;
        Integer highAcademicScale = null;
        Integer lowSocialScale = null;
        Integer highSocialScale = null;
        Integer lowQualityScale = null;
        Integer highQualityScale = null;
        ArrayList<String> empList = new ArrayList<String>();
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni1 = search.get(0);
       University uni2 = search.get(1);
       if( uni1.getSchool().equals("ClickClickBoomSchoolD") &&
               uni2.getSchool().equals("ClickClickBoomSchoolE")){
           truth = true;
       }
       assertTrue("Search Combo 4", truth);
    }
    
    /**
     * Black Box Test for a combination of search criteria.  
     * Equivalence case: Multiple search entries - Percent Enrolled, Academic, Social and Quality Scale
     * Input: lowEnrolled - 74.9  highEnrolled 75.1, lowAcademicScale - 5  highAcademicScale - 5
     *        lowSocialScale - 3  highSocialScale - 3, lowQualityScale - 5  highQualityScale - 5
     * Output: School in the with SATMath score of 400, 8000 number of applicants, and 60 percent admitted.
     *         In this case, school ClickClickBoomSchoolA and ClickClickBoomSchoolJ match the criteria.
     */
    public void test_SearchCombo5(){
        System.out.println("testSearchCombo5 - Search With Percent Enrolled, "
                + "Academic Scale, Social Scale, and Quality Scale");
        String wantedSchool = null;
        String wantedState = null;
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = null;
        Integer highWantedNumber = null;
        Double lowPercentFemales = null;
        Double highPercentFemales = null;
        Double lowSATVerbal = null;
        Double highSATVerbal = null;
        Double lowSATMath = null;
        Double highSATMath = null;
        Double lowExpenses = null;
        Double highExpenses = null;
        Double lowFinAid = null;
        Double highFinAid = null;
        Integer lowNumApplicants = null;
        Integer highNumApplicants = null;
        Double lowAdmitted = null;
        Double highAdmitted = null;
        Double lowEnrolled = 74.9;
        Double highEnrolled = 75.1;
        Integer lowAcademicScale = 5;
        Integer highAcademicScale = 5;
        Integer lowSocialScale = 3;
        Integer highSocialScale = 3;
        Integer lowQualityScale = 5;
        Integer highQualityScale = 5;
        ArrayList<String> empList = new ArrayList<String>();
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni1 = search.get(0);
       University uni2 = search.get(1);
       if( uni1.getSchool().equals("ClickClickBoomSchoolA") &&
               uni2.getSchool().equals("ClickClickBoomSchoolJ")){
           truth = true;
       }
       assertTrue("Search Combo 5", truth);
    }
    
}
