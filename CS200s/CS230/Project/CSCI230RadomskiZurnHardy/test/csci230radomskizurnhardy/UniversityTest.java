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
 * @author wjradomski
 */
public class UniversityTest {
    private University university;
    public UniversityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        university = new University("", "", "", "", 0, 0., 0., 0., 0., 0., 0, 0., 0., 0, 0,0 );
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setSchool method, of class University.
     */
    @Test
    public void testSetSchool() {
        System.out.println("setSchool and getSchool");
        String school = "testSchool";
        university.setSchool(school);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(school, university.getSchool());
    }


    /**
     * Test of setState and getState method, of class University.
     */
    @Test
    public void testSetState() {
        System.out.println("setState and getState");
        String state = "MN";
        university.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(state, university.getState());
    }

    /**
     * Test of setLocation method, of class University.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation and getLocation");
        String location = "rural";
        university.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(location, university.getLocation());
    }


    /**
     * Test of setControl and getControl method, of class University.
     */
    @Test
    public void testSetControl() {
        System.out.println("setControl and getControl");
        String control = "private";
        university.setControl(control);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(control, university.getControl());
    }



    /**
     * Test of setNumberOfStudents and getNumberOfStudents method, of class University.
     */
    @Test
    public void testSetNumberOfStudents() {
        System.out.println("setNumberOfStudents and getNumberOfStudents");
        int students = 100;
        university.setNumberOfStudents(students);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(students, university.getNumberOfStudents());
    }


    /**
     * Test of setPercentFemales and getPercentFemales method, of class University.
     */
    @Test
    public void testSetPercentFemales() {
        System.out.println("setPercentFemales and getPercentFemales");
        double percentFemales = 50.0;
        university.setPercentFemales(percentFemales);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(percentFemales, university.getPercentFemales(), .00001);
    }


    /**
     * Test of setSATVerbal and getSATVerbal method, of class University.
     */
    @Test
    public void testSetSATVerbal() {
        System.out.println("setSATVerbal and getSATVerbal");
        double SATVerbal = 1.0;
        university.setSATVerbal(SATVerbal);
        assertEquals(SATVerbal, university.getSATVerbal(), .00001);
    }


    /**
     * Test of setSATMath and getSATMath method, of class University.
     */
    @Test
    public void testSetSATMath() {
        System.out.println("setSATMath and getSATMath");
        double SATMath = 1.0;
        university.setSATMath(SATMath);
        assertEquals(SATMath, university.getSATMath(), .00001);
    }


    /**
     * Test of setExpenses and getExpenses method, of class University.
     */
    @Test
    public void testSetExpenses() {
        System.out.println("set/getExpenses");
        double expenses = 1.0;
        university.setExpenses(expenses);
        assertEquals(expenses, university.getExpenses(), .00001);
    }

    /**
     * Test of setPercentFinancialAid and getPercentFinancialAid method, of class University.
     */
    @Test
    public void testSetPercentFinancialAid() {
        System.out.println("set/getPercentFinancialAid");
        double percentFinancialAid = 1.0;
        university.setPercentFinancialAid(percentFinancialAid);
        assertEquals(percentFinancialAid, university.getPercentFinancialAid(), .00001);
    }


    /**
     * Test of setNumberOfApplicants and getNumberOfAppicants method, of class University.
     */
    @Test
    public void testSetNumberOfApplicants() {
        System.out.println("set/getNumberOfApplicants");
        int numberOfApplicants = 1;
        university.setNumberOfApplicants(numberOfApplicants);
        assertEquals(numberOfApplicants, university.getNumberOfApplicants());
    }



    /**
     * Test of setPercentAdmitted method, of class University.
     */
    @Test
    public void testSetPercentAdmitted() {
        System.out.println("set/getPercentAdmitted");
        double percentAdmitted = 1.0;
        university.setPercentAdmitted(percentAdmitted);
        assertEquals(percentAdmitted, university.getPercentAdmitted(), .00001);
    }


    /**
     * Test of setPercentEnrolled method, of class University.
     */
    @Test
    public void testSetPercentEnrolled() {
        System.out.println("set/getPercentEnrolled");
        double percentEnrolled = 1.0;
        university.setPercentEnrolled(percentEnrolled);
        assertEquals(percentEnrolled, university.getPercentEnrolled(), .00001);
    }


    /**
     * Test of setAcademicsScale method, of class University.
     */
    @Test
    public void testSetAcademicsScale() {
        System.out.println("set/getAcademicsScale");
        int academicsScale = 1;
        university.setAcademicsScale(academicsScale);
        assertEquals(academicsScale, university.getAcademicsScale());
    }


    /**
     * Test of setSocialScale method, of class University.
     */
    @Test
    public void testSetSocialScale() {
        System.out.println("set/getSocialScale");
        int socialScale = 1;
        university.setSocialScale(socialScale);
        assertEquals(socialScale, university.getSocialScale());
    }



    /**
     * Test of setQualityOfLifeScale method, of class University.
     */
    @Test
    public void testSetQualityOfLifeScale() {
        System.out.println("set/getQualityOfLifeScale");
        int qualityOfLifeScale = 1;
        university.setQualityOfLifeScale(qualityOfLifeScale);
        assertEquals(qualityOfLifeScale, university.getQualityOfLifeScale());
    }



    /**
     * Test of setEmphases method, of class University.
     */
    @Test
    public void testSetEmphases() {
        System.out.println("set/getEmphases");
        ArrayList<String> emphases = null;
        university.setEmphases(emphases);
        assertEquals(emphases, university.getEmphases());
    }
}