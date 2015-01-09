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
 * @author pghardy
 */
public class SearchControllerTest {
    
    public SearchControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        //USE THESE 10 SCHOOLS TO SEARCH AGAINST TO MAKE SURE
        //THE CORRECT ONES SHOW UP AND THE WRONG ONES DO NOT
        //DO NOT EDIT THESE UNIVERSITIES, THEY ARE ALREADY 
        //IN THE DATABASE AND ARE USED ELSEWHERE, Preston
        //These 10 schools are already in the Database
        //since they are used in FiveRecSchoolsControllerTest
//        DatabaseController.addUniversity("ClickClickBoomSchoolA","CCBState1", "-1",    "Private", 1000,  30, 400, 400, 40000, 55, 2000,  60, 75, 5, 3, 5);
//        DatabaseController.addUniversity("ClickClickBoomSchoolB","CCBState1", "-1",    "Public",  2000,  35, 400, 400, 40000, 65, 4000,  60, 75, 4, 3, 2);
//        DatabaseController.addUniversity("ClickClickBoomSchoolC","CCBState1", "-1",    "Private", 3000,  40, 450, 400, 40000, 75, 6000,  60, 75, 5, 3, 1);
//        DatabaseController.addUniversity("ClickClickBoomSchoolD","CCBState1", "Urban", "Public",  4000,  45, 450, 400, 40000, 85, 8000,  60, 75, 4, 3, 3);
//        DatabaseController.addUniversity("ClickClickBoomSchoolE","CCBState1", "Urban", "Private", 5000,  50, 500, 400, 50000, 95, 10000, 60, 75, 3, 3, 5);
//        DatabaseController.addUniversity("ClickClickBoomSchoolF","CCBState2", "Rural", "Public",  6000,  55, 500, 400, 50000, 95, 12000, 60, 75, 1, 2, 4);
//        DatabaseController.addUniversity("ClickClickBoomSchoolG","CCBState2", "Rural", "Public",  7000,  60, 550, 400, 50000, 85, 14000, 60, 75, 2, 5, 3);
//        DatabaseController.addUniversity("ClickClickBoomSchoolH","CCBState2", "-1",    "Public",  8000,  65, 250, 400, 50000, 75, 16000, 60, 75, 3, 1, 1);
//        DatabaseController.addUniversity("ClickClickBoomSchoolI","CCBState2", "-1",    "Public",  9000,  70, 250, 400, 50000, 65, 18000, 60, 75, 4, 2, 2);
//        DatabaseController.addUniversity("ClickClickBoomSchoolJ","CCBState2", "-1",    "Public",  10000, 75, 250, 400, 50000, 55, 20000, 60, 75, 5, 3, 5);
//        AdminController.addUniversityEmphasis("ClickClickBoomSchoolA", "Computer Science");
//        AdminController.addUniversityEmphasis("ClickClickBoomSchoolA", "Math");
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
       //problem here was SUBURBAN vs. URBAN
       assertTrue("Search Location", truth);
    }
    
     /**
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
        Double highSATVerbal = 450.0;
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
     * Test of search method, of class SearchController.
     */
    
    @Test
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
     * Test of search method, of class SearchController.
     */
    @Test
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
        Integer lowAcademicScale = 4;
        Integer highAcademicScale = 6;
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
       if(uni.getAcademicsScale() == 4 || uni.getAcademicsScale() == 5 || uni.getAcademicsScale() == 6){
           truth = true;
       }
       assertTrue("Search Academic Scale", truth);
    }
    
    /**
     * Test of search method, of class SearchController.
     */
    @Test
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
        Integer lowSocialScale = 4;
        Integer highSocialScale = 6;
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
       if(uni.getSocialScale() == 4 || uni.getSocialScale() == 5 || uni.getSocialScale() == 6){
           truth = true;
       }
       assertTrue("Search Social Scale", truth);
    }
    
     /**
     * Test of search method, of class SearchController.
     */
    @Test
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
        Integer lowQualityScale = 4;
        Integer highQualityScale = 6;
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
       if(uni.getQualityOfLifeScale() == 4 || uni.getQualityOfLifeScale() == 5 || uni.getQualityOfLifeScale() == 6 ){
           truth = true;
       }
       assertTrue("Search Quality Scale", truth);
    }
    
     /**
     * Test of search method, of class SearchController.
     */
    @Test
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
       System.out.println(uni);
       ArrayList<String> returnEmphases = uni.getEmphases();
       String return1 = returnEmphases.get(0);
       String return2 = returnEmphases.get(1);
       if( return1.toLowerCase().indexOf("computer science") == 0 &&
               return2.toLowerCase().indexOf("math") == 0 ){
           truth = true;
       }
       assertTrue("Search Emphases" + return1 + ", " + return2, truth);
    }
    
    @Test
    public void test_SearchCombo1(){
        System.out.println("testSearchCombo1");
        String wantedSchool = null;
        String wantedState = "CCBState1";
        String wantedLocation = null;
        String wantedControl = null;
        Integer lowWantedNumber = 1999;
        Integer highWantedNumber = 2001;
        Double lowPercentFemales = 34.0;
        Double highPercentFemales = 35.0;
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
       if( uni.getSchool().equals("ClickClickBoomSchoolB")){
           truth = true;
       }
       assertTrue("Search Combo 1", truth);
    }
    
    public void test_SearchCombo2(){
        System.out.println("testSearchCombo1");
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
        ArrayList<University> search = SearchController.search(wantedSchool, wantedState, wantedLocation, wantedControl, lowWantedNumber,
                                                highWantedNumber, lowPercentFemales, highPercentFemales, lowSATVerbal, highSATVerbal,
                                                lowSATMath, highSATMath, lowExpenses, highExpenses, lowFinAid, highFinAid,
                                                lowNumApplicants, highNumApplicants, lowAdmitted, highAdmitted, lowEnrolled, highEnrolled,
                                                lowAcademicScale, highAcademicScale, lowSocialScale, highSocialScale, lowQualityScale,
                                                highQualityScale, empList);
       boolean truth = false;
       University uni = search.get(0);
       if( uni.getSchool().equals("ClickClickBoomSchoolB")){
           truth = true;
       }
       assertTrue("Search Combo 1", truth);
    }
    
    public void test_SearchCombo3(){
        System.out.println("testSearchCombo1");
    }
    
    public void test_SearchCombo4(){
        System.out.println("testSearchCombo1");
    }
    
    public void test_SearchCombo5(){
        System.out.println("testSearchCombo1");
    }
    
    
    /**
     * Test of main method, of class SearchController.
     */
    //    This method was used for the driver class from Phase II    
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        SearchController.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
