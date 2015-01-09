package csci230radomskizurnhardy;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author wjradomski
 */
public class UniversityTest extends TestCase{
    private University university;
    public UniversityTest() {
    }

    
    @Override
    protected void setUp() throws Exception {
        university = new University("", "", "", "", 0, 0., 0., 0., 0., 0., 0, 0., 0., 0, 0,0 );
    }



    /**
     * Test of setSchool method, of class University.
     * Basic test of setting and getting a school name.
     * Input: "testSchool"
     * Output: "testSchool" set to name of University
     */
   
    public void testSetSchool() {
        System.out.println("setSchool and getSchool");
        String school = "testSchool";
        university.setSchool(school);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(school, university.getSchool());
    }


    /**
     * Test of setState and getState method, of class University.
     * Basic Test of setting and getting the state of a University.
     * Input: MN"
     * Output: "MN" set state for a University
     */
    
    public void testSetState() {
        System.out.println("setState and getState");
        String state = "MN";
        university.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(state, university.getState());
    }

    /**
     * Test of setLocation method, of class University.
     * Basic Test of setting and getting a location of a University.
     * Input: "rural"
     * Output: "rural" set location for a University
     */
    
    public void testSetLocation() {
        System.out.println("setLocation and getLocation");
        String location = "rural";
        university.setLocation(location);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(location, university.getLocation());
    }


    /**
     * Test of setControl and getControl method, of class University.
     * Basic Test of setting and getting the control of a University. 
     * Input: "private"
     * Output: "private" set control for a University
     */
    
    public void testSetControl() {
        System.out.println("setControl and getControl");
        String control = "private";
        university.setControl(control);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(control, university.getControl());
    }



    /**
     * Test of setNumberOfStudents and getNumberOfStudents method, of class University.
     * Basic Test of setting and getting the number of students at a University.
     * Input: 100
     * Output: A university with a set number of students 100
     */
    
   public void testSetNumberOfStudents() {
        System.out.println("setNumberOfStudents and getNumberOfStudents");
        int students = 100;
        university.setNumberOfStudents(students);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(students, university.getNumberOfStudents());
    }


    /**
     * Test of setPercentFemales and getPercentFemales method, of class University.
     * Basic Test of setting and getting the percent females at a University.
     * Input: 50.0
     * Output: A university with a set percent female 50.0
     */
   
    public void testSetPercentFemales() {
        System.out.println("setPercentFemales and getPercentFemales");
        double percentFemales = 50.0;
        university.setPercentFemales(percentFemales);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(percentFemales, university.getPercentFemales(), .00001);
    }


    /**
     * Test of setSATVerbal and getSATVerbal method, of class University.
     * Basic Test of Setting and getting the SATVerbal of a University.
     * Input: 1.0
     * Output: A university with a set SATVerbal 1.0
     */
    
    public void testSetSATVerbal() {
        System.out.println("setSATVerbal and getSATVerbal");
        double SATVerbal = 1.0;
        university.setSATVerbal(SATVerbal);
        assertEquals(SATVerbal, university.getSATVerbal(), .00001);
    }


    /**
     * Test of setSATMath and getSATMath method, of class University.
     * Basic Test of setting and getting the SATMath of a University.
     * Input: 1.0
     * Output: A university with a set SATMath 1.0
     */
    
    public void testSetSATMath() {
        System.out.println("setSATMath and getSATMath");
        double SATMath = 1.0;
        university.setSATMath(SATMath);
        assertEquals(SATMath, university.getSATMath(), .00001);
    }


    /**
     * Test of setExpenses and getExpenses method, of class University.
     * Basic Test of Setting and Getting the expenses of a University.
     * Input: 1.0
     * Output: A university with a set expenses 1.0
     */
    
    public void testSetExpenses() {
        System.out.println("set/getExpenses");
        double expenses = 1.0;
        university.setExpenses(expenses);
        assertEquals(expenses, university.getExpenses(), .00001);
    }

    /**
     * Test of setPercentFinancialAid and getPercentFinancialAid method, of class University.
     * Basic Test of setting and getting percent financial aid offered by a University.
     * Input: 1.0
     * Output: A university with a set Percent Financial aid 1.0
     */
    
    public void testSetPercentFinancialAid() {
        System.out.println("set/getPercentFinancialAid");
        double percentFinancialAid = 1.0;
        university.setPercentFinancialAid(percentFinancialAid);
        assertEquals(percentFinancialAid, university.getPercentFinancialAid(), .00001);
    }


    /**
     * Test of setNumberOfApplicants and getNumberOfAppicants method, of class University.
     * Basic test of setting and getting the number of applicants a University has.
     * Input: 1
     * Output: A university with a set number of applicants 1
     */
    
    public void testSetNumberOfApplicants() {
        System.out.println("set/getNumberOfApplicants");
        int numberOfApplicants = 1;
        university.setNumberOfApplicants(numberOfApplicants);
        assertEquals(numberOfApplicants, university.getNumberOfApplicants());
    }



    /**
     * Test of setPercentAdmitted method, of class University.
     * Basic test of setting and getting percent admitted to a University
     * Input: 1.0
     * Output: A university with a set percent admitted 1.0
     */
    
    public void testSetPercentAdmitted() {
        System.out.println("set/getPercentAdmitted");
        double percentAdmitted = 1.0;
        university.setPercentAdmitted(percentAdmitted);
        assertEquals(percentAdmitted, university.getPercentAdmitted(), .00001);
    }


    /**
     * Test of setPercentEnrolled method, of class University.
     * Basic Test of setting and getting percent enrolled at a university
     * Input: 1.0
     * Output: A university with a set percent enrolled 1.0
     */
   
    public void testSetPercentEnrolled() {
        System.out.println("set/getPercentEnrolled");
        double percentEnrolled = 1.0;
        university.setPercentEnrolled(percentEnrolled);
        assertEquals(percentEnrolled, university.getPercentEnrolled(), .00001);
    }


    /**
     * Test of setAcademicsScale method, of class University.
     * Basic test of setting and getting academic scale at a University.
     * Input: 1
     * Output: A University with a set Academic Scale 1
     */
    
    public void testSetAcademicsScale() {
        System.out.println("set/getAcademicsScale");
        int academicsScale = 1;
        university.setAcademicsScale(academicsScale);
        assertEquals(academicsScale, university.getAcademicsScale());
    }


    /**
     * Test of setSocialScale method, of class University.
     * Basic test of setting and getting the social scale of a university.
     * Input: 1
     * Output: A university with a set Social Scale 1
     */
    
    public void testSetSocialScale() {
        System.out.println("set/getSocialScale");
        int socialScale = 1;
        university.setSocialScale(socialScale);
        assertEquals(socialScale, university.getSocialScale());
    }



    /**
     * Test of setQualityOfLifeScale method, of class University.
     * Basic test of setting and getting quality of life scale at a university.
     * Input: 1
     * Output: A University with a set Quality of Life scale 1
     */
   
    public void testSetQualityOfLifeScale() {
        System.out.println("set/getQualityOfLifeScale");
        int qualityOfLifeScale = 1;
        university.setQualityOfLifeScale(qualityOfLifeScale);
        assertEquals(qualityOfLifeScale, university.getQualityOfLifeScale());
    }



    /**
     * Test of setEmphases method, of class University.
     * Basic test of setting and getting emphases of a University
     * Input: A ArrayList of Emphases
     * Output: A university with set emphases
     */
    public void testSetEmphases() {
        System.out.println("set/getEmphases");
        ArrayList<String> emphases = new ArrayList<String>();
        emphases.add("Computer Science");
        emphases.add("Math");
        university.setEmphases(emphases);
        assertEquals(emphases, university.getEmphases());
    }
    
}