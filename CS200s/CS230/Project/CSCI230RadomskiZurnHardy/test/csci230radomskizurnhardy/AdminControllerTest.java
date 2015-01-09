/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import java.util.ArrayList;
import java.util.TreeMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author awzurn
 */
public class AdminControllerTest {
    
    public AdminControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Black box test of addUniversity (Use Case #15).  This a rather simple test, as the function 
     * case diagram merely needs to add the University to the database.  To determine if the function 
     * works properly, we will simple find the university within the list of universities in the database.
     */
    @Test
    public void testAddUniversity() {
        System.out.println("Use Case #15: AddUniversity");
        String school = "RadomskiHardyZurnUniversityTest";
        String state = "Minnesota";
        String location = "Urban";
        String control = "State";
        int numberOfStudents = 15000;
        double percentFemales = 55.0;
        double SATVerbal = 1100.0;
        double SATMath = 1100.00;
        double expenses = 20500.0;
        double percentFinancialAid = 70.0;
        int numberOfApplicants = 7500;
        double percentAdmitted = 55.0;
        double percentEnrolled = 90.0;
        int academicsScale = 5;
        int socialScale = 5;
        int qualityOfLifeScale = 5;
        AdminController.addUniversity(school, state, location, control, numberOfStudents,
                percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants,
                percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
        University university = new University(school, state, location, control, numberOfStudents,
                percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants,
                percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
        boolean truth = false;
        ArrayList<University> uniList = AdminController.getAllUniversities();
        for(University uni: uniList){
            if(uni.getSchool().equals(school)){
            truth = true;
            }
        }
        assertTrue("Use Case #15: Add University, Status: ", truth);  
    }

    /**
     * Black box test of addUniversityEmphasis method (Use Case 15/16), of class AdminController.  Another
     * rather simple test, this will add an emphasis to a given university, and then determine if the
     * emphasis was successfully added to that university.
     */
    @Test
    public void testAddUniversityEmphasis() {
        System.out.println("addUniversityEmphasis");
        String school = "RadomskiHardyZurnUniversityTest";
        String emphasis = "Computer Science";
        AdminController.addUniversityEmphasis(school, emphasis);
        ArrayList<University> universities = AdminController.getAllUniversities();
        boolean truth = false;
        for(University uni: universities){
            if(uni.getSchool().equals(("RadomskiHardyZurnUniversityTest"))){
                if(uni.getEmphases().contains("Computer Science")){
                    truth = true;
                    break;
                }
            } 
        }
        assertTrue("Use Case 16: Add Emphasis, Status:", truth);
    }

    /**
     * A rather basic test of the addUser method of Admin Controller.  This will add a user to the database,
     * and then run through all the users in the database, and upon finding the added user, set a boolean to
     * true.  If it does not find it, the boolean will remain false.
     */
    @Test
    public void testAddUser() {
        System.out.println("Use Case #12: Add User");
        String firstName = "Andrew";
        String lastName = "Zurn";
        String username = "AZurn91";
        String password = "password";
        char type = 'u';
        boolean truth = false;
        AdminController.addUser(firstName, lastName, username, password, type);
        // TODO review the generated test code and remove the default call to fail.
        ArrayList<User> userList = DatabaseController.getAllUsers();
        for (User user : userList) {
            if(user.getUserName().equals("AZurn91")){
                truth = true;
                break;
            }
        }
        assertTrue("Use Case #12: Add User, Status: ", truth);
    }

    /**
     * A rather basic test of Use Case 14: Deactivate User.  The user will be deactivated in the database, 
     * and then will be found in the user list stored in the database, and its status will be returned.  
     * On a successful changing of its status, a boolean will be set to true.  If not, the boolean will
     * be false.
     */
    @Test
    public void testDeactivateUser_int() {
        System.out.println("Use Case #14: Deactivate User ID");
        int Id = 2;
        AdminController.deactivateUser(Id);
        ArrayList<User> userList = DatabaseController.getAllUsers();
        User user = userList.get(1);
        System.out.println(user.getFirstName());
        boolean truth = false;
        Character char1 = new Character(user.getStatus());
        System.out.println(char1);
        Character char2 = new Character('N');
        if( char1.equals(char2)){
            truth = true;
        }
        assertTrue("Use Case #14: Deactivate User, Status: ", truth);
    }

    /**
     * A rather basic test of Use Case 14: Deactivate User.  The user will be deactivated in the database, 
     * and then will be found in the user list stored in the database, and its status will be returned.  
     * On a successful changing of its status, a boolean will be set to true.  If not, the boolean will
     * be false.
     */
    @Test
    public void testDeactivateUser_String() {
        System.out.println("Use Case #14: Deactivate User String");
        String username = "luser";
        AdminController.deactivateUser(username);
        ArrayList<User> userList = DatabaseController.getAllUsers();
        User user = userList.get(2);
        System.out.println(user.getFirstName());
        boolean truth = false;
        Character char1 = new Character(user.getStatus());
        System.out.println(char1);
        if( char1.equals('N')){
            truth = true;
        }
        assertTrue("Use Case #14: Deactivate User, Status: ", truth);
    }

    /**
     * Black box test of editUniversity method (Use Case #16), of class AdminController.  This is a rather
     * simple test, that will edit the university, see if the university still exists within the database,
     * and then determine if the fields that were edit, were indeed edited to the wanted correction.
     * In this case, the STATE, NUMBER OF STUDENTS, EXPENSES, and ACADEMIC SCALE will be altered.
     */
    @Test
    public void testEditUniversity() {
        System.out.println("editUniversity");
        String school = "RadomskiHardyZurnUniversityTest";
        String state = "Iowa";
        String location = "Urban";
        String control = "State";
        int numberOfStudents = 10000;
        double percentFemales = 55.0;
        double SATVerbal = 1100.0;
        double SATMath = 1100.00;
        double expenses = 15500.0;
        double percentFinancialAid = 70.0;
        int numberOfApplicants = 7500;
        double percentAdmitted = 55.0;
        double percentEnrolled = 90.0;
        int academicsScale = 3;
        int socialScale = 5;
        int qualityOfLifeScale = 5;
        AdminController.editUniversity(school, state, location, control, numberOfStudents,
                percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants,
                percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
        ArrayList<University> universities = AdminController.getAllUniversities();
        boolean truth = false;
        for(University uni: universities){
            if(uni.getSchool().equals(("RadomskiHardyZurnUniversityTest"))){
                if(uni.getState().equals("Iowa") && uni.getNumberOfStudents() == 10000 &&
                        uni.getExpenses() == 15500.0 && uni.getAcademicsScale() == 3){
                    truth = true;
                    break;
                }
            }
        }
        assertTrue("Use Case 16: Edit University, Statuts: ", truth);
    }

    /**
     * This is a basic test, that will use a list of strings that contain emphases and edit the list stored
     * within a school with them.  The school will then be found in the database, and tested to see if its
     * emphases have been altered.  If the alteration was successful, a boolean will be set to true; if not,
     * the boolean will be set to false.
     */
    @Test
    public void testEditUniversityEmphases() {
        System.out.println("Use Case 16: Edit University");
        ArrayList<String> empList = new ArrayList<String>();
        empList.add("Science");
        empList.add("Math");
        empList.add("Computer Science");
        boolean truth = true;
        AdminController.editUniversityEmphases("RadomskiHardyZurnUniversityTest", empList);
        ArrayList<University> universityList = AdminController.getAllUniversities();
        for (University uni : universityList) {
            if (uni.getSchool().equals("RadomskiHardyZurnUniversityTest")) {
                ArrayList<String> getEmpList = uni.getEmphases();
                if(getEmpList.get(0).equals("Science") && getEmpList.get(1).equals("Math") &&
                        getEmpList.get(2).equals("Computer Science")){
                    truth = true;
                }
            }
        }
        assertTrue("Use Case 16: Edit University:Edit Emphases, Status: ", truth);
    }

    /**
     * A basic test, to see if the first name of a specific user can be changed in the system.
     * If it was changed correctly, a boolean will be set to true, if not, it will be set to false.
     */
    @Test
    public void testEditUser() {
        System.out.println("Use Case #13: Edit User");
        String username = "AZurn91";
        String firstName = "Andy";
        String lastName = "Zurn";
        String password = "password";
        AdminController.editUser(username, firstName, lastName, password);
        ArrayList<User> userList = AdminController.getAllUsers();
        boolean truth = false;
        for(User user: userList){
            if(user.getUserName().equals("AZurn91")){
                if(user.getFirstName().equals("Andy")){
                    truth = true;
                    break;
                }
            }
        }
        assertTrue("Use Case #13: Edit User, Status: ",truth);
    }

    /**
     * A basic test, to see if the first name and status of a specific user can be changed in the system.
     * If it was changed correctly, a boolean will be set to true, if not, it will be set to false.
     */
    @Test
    public void testEditUserByAdmin() {
        System.out.println("Use Case #13: Edit User:By Admin");
        String username = "AZurn91";
        String firstName = "Andrew";
        String lastName = "Zurn";
        String password = "password";
        char type = 'u';
        char status = 'N';
        AdminController.editUserByAdmin(username, firstName, lastName, password, type, status);
        ArrayList<User> userList = AdminController.getAllUsers();
        boolean truth = false;
        for(User user: userList){
            if(user.getUserName().equals("AZurn91")){
                if(user.getFirstName().equals("Andrew") && user.getStatus() == 'N'){
                    truth = true;
                    break;
                }
            }
        }
        assertTrue("Use Case #13: Edit User: By Admin, Status: ",truth);
    }

    /**
     * Test of getAllPossibleEmphases method, of class AdminController.
     */
    @Test
    public void testGetAllPossibleEmphases() {
        System.out.println("getAllPossibleEmphases");
        ArrayList<String> result = AdminController.getAllPossibleEmphases();
        boolean truth = false;
        if(!result.isEmpty()){
            truth = true;
        }
        assertTrue("Get All Possible Emphases: Status: ", truth);
    }

    /**
     * Test of getAllSavedSchools method, of class AdminController.
     */
    @Test
    public void testGetAllSavedSchools() {
        System.out.println("getAllSavedSchools");
        TreeMap<Integer, ArrayList<String>> result = AdminController.getAllSavedSchools();
        boolean truth = false;
        if(!result.isEmpty()){
            truth = true;
        }
        assertTrue("Get All Saved Schools: Status: ", truth);
    }

    /**
     * Test of getAllUniversities method, of class AdminController.
     */
    @Test
    public void testGetAllUniversities() {
        System.out.println("getAllUniversities");
        ArrayList<University> result = AdminController.getAllUniversities();
        boolean truth = false;
        if(!result.isEmpty()){
            truth = true;
        }
        assertTrue("Get All Schools: Status: ", truth);
    }

    /**
     * A simple test to determine if the database is returning something other than null for the
     * getAllUniversityNamesWithEmphases method.
     */
    @Test
    public void testGetAllUniversityNamesWithEmphases() {
        System.out.println("getAllUniversityNamesWithEmphases");
        TreeMap<String, ArrayList<String>> result = AdminController.getAllUniversityNamesWithEmphases();
        boolean truth = false;
        if(!result.isEmpty()){
            truth = true;
        }
        assertTrue("Get All University Names With Emphases, Status: ", truth);
    }

    /**
     * A simple test to determine if the database is returned something other than a empty array list.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        ArrayList<User> result = AdminController.getAllUsers();
        boolean truth = false;
        if(!result.isEmpty()){
            truth = true;
        }
        assertTrue("Get All Users, Status: ", truth);
    }

    /**
     * A simple test to see if the database will return a specific user from the user list.
     */
    @Test
    public void testGetSpecificUser_Integer() {
        System.out.println("getSpecificUser");
        Integer Id = 2;
        String expResult = "juser";
        User result = AdminController.getSpecificUser(Id);
        assertEquals(expResult, result.getUserName());
    }

    /**
     * A simple test to see if the database will return a specific user from the user list.
     */
    @Test
    public void testGetSpecificUser_String() {
        System.out.println("getSpecificUser");
        String username = "juser";
        String expResult = "juser";
        User result = AdminController.getSpecificUser(username);
        assertEquals(expResult, result.getUserName());
    }

    /**
     * A black box text of the login method.  Case 1: a good password will return a boolean that is true.
     * Case 2: a bad password will return a boolean that is false.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "AZurn91";
        String givenPassword = "password";
        boolean expResult = true;
        boolean result = AdminController.login(username, givenPassword);
        assertEquals(expResult, result);
        String wrongPassword = "PASSWORD";
        boolean expResult2 = false;
        boolean result2 = AdminController.login(username, wrongPassword);
        assertEquals(expResult2, result2);
    }

}
