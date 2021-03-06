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
 * @author pghardy
 */
public class DatabaseControllerTest {
    
    public DatabaseControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        DatabaseController.addUser("FN", "LN", "UN", "PW",'u');
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
     * Test of addUniversity method, of class DatabaseController.
     */
    @Test
    public void testAddUniversity() {
        System.out.println("addUniversity");
        String school = "ClickClickBoomUniversity1";
        String state = "Minnesota";
        String location = "SUBURB";
        String control = "-1";
        int numberOfStudents = 1000;
        double percentFemales = 50.0;
        double SATVerbal = 600.0;
        double SATMath = 750.0;
        double expenses = 40000.0;
        double percentFinancialAid = 90.0;
        int numberOfApplicants = 2000;
        double percentAdmitted = 80.0;
        double percentEnrolled = 50.0;
        int academicsScale = 4;
        int socialScale = 3;
        int qualityOfLifeScale = 4;
        DatabaseController.addUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
        //Now check to see if this newly created university is in the Database
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        boolean found = false;
        for(University uni: allSchools){
            if(uni.getSchool().equals(school)){
                found = true;
            }
        }
        if(!found){
            fail("School with name: " + school + " not found.");
        }
    }

    /**
     * Test of addUniversityEmphasis method, of class DatabaseController.
     */
    @Test
    public void testAddUniversityEmphasis() {
        System.out.println("addUniversityEmphasis");
        String school = "ClickClickBoomUniversity1";
        String emphasis = "MATH";
        boolean found = false;
        DatabaseController.addUniversityEmphasis(school, emphasis);
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        for(University uni: allSchools){
            if(uni.getSchool().equals(school)){
                if(uni.getEmphases().contains(emphasis)){
                    found = true;
                }
            }
        }
        if(!found){
            fail("School with name: " + school + " does not have the right emphases.");
        }
    }

    /**
     * Test of addUser method, of class DatabaseController.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String firstName = "ClickClickBoomUser3";
        String lastName = "CCBUser3";
        String username = "CCBUsername3";
        String password = "CCBPassword3";
        char type = 'u';
        boolean found = false;
        DatabaseController.addUser(firstName, lastName, username, password, type);
        ArrayList<User> allUsers = DatabaseController.getAllUsers();
        for(User user: allUsers){
            if(user.getFirstName().equals(firstName)){
                found = true;
            }
        }
        if(!found){
            fail("User with first name: " + firstName + " was not added to the database.");
        }
    }

    /**
     * Test of addUserSchool method, of class DatabaseController.
     */
    @Test
    public void testAddUserSchool() {
        System.out.println("addUserSchool");
        int id = 2;
        String school = "ClickClickBoomUniversity1";
        DatabaseController.addUserSchool(id, school);
        boolean found = false;
        TreeMap<Integer, ArrayList<String>> schoolMap = DatabaseController.getAllSavedSchools();
        for (int i = 0; i < 1000; i++) {
            if (schoolMap.get(i) != null) {
                if (schoolMap.get(i).contains(school)) {
                    found = true;
                }
            }
        }
        if(!found){
            fail("User with ID: " + id + "'s school was not added right.");
        }
        
    }

    /**
     * Test of deactivateUser method, of class DatabaseController.
     */
    @Test
    public void testDeactivateUser_int() {
        System.out.println("deactivateUser");
        int Id = 1;
        
        DatabaseController.deactivateUser(Id);
        //ArrayList<User> allUsers = DatabaseController.getAllUsers();
        boolean found = false;
        User deactUser = DatabaseController.getSpecificUser(1);
        if(new Character(deactUser.getStatus()).equals('N')){
            found = true;
        }
        if(!found){
            fail("User with ID: " + Id + " was not properly deactivated.");
        }
    }

    /**
     * Test of deactivateUser method, of class DatabaseController.
     */
    @Test
    public void testDeactivateUser_String() {
        System.out.println("deactivateUser");
        String username = "CCBUsername1";
        DatabaseController.deactivateUser(username);
        ArrayList<User> allUsers = DatabaseController.getAllUsers();
        boolean found = false;
        for(User user: allUsers){
            if(user.getUserName().equals(username)){
                if(new Character(user.getStatus()).equals('N')){
                    found = true;
                }
            }
        }
        if(!found){
            fail("User with Username: " + username + " was not properly deactivated.");
        }
    }

    /**
     * Test of editUniversity method, of class DatabaseController.
     */
    @Test
    public void testEditUniversity() {
        System.out.println("editUniversity");
        String school = "ClickClickBoomUniversity1";
        String state = "Iowa";
        String location = "SUBURB";
        String control = "-1";
        int numberOfStudents = 1000;
        double percentFemales = 50.0;
        double SATVerbal = 600.0;
        double SATMath = 750.0;
        double expenses = 40000.0;
        double percentFinancialAid = 90.0;
        int numberOfApplicants = 2000;
        double percentAdmitted = 80.0;
        double percentEnrolled = 50.0;
        int academicsScale = 4;
        int socialScale = 3;
        int qualityOfLifeScale = 4;
        DatabaseController.editUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        boolean found = false;
        for (University uni : allSchools) {
            if (uni.getSchool().equals(school)) {
                if (uni.getState().equals("Iowa")) {
                    found = true;
                }
            }
        }
        if (!found) {
            fail("School with name: " + school + " does not have the right updates.");
        }
    }

    /**
     * Test of editUniversityEmphases method, of class DatabaseController.
     */
    @Test
    public void testEditUniversityEmphases() {
        System.out.println("editUniversityEmphases");
        String school = "ClickClickBoomUniversity1";
        ArrayList<String> emphases = new ArrayList<String>();
        emphases.add("SCIENCE");
        DatabaseController.editUniversityEmphases(school, emphases);
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        boolean found = false;
        for (University uni : allSchools) {
            if (uni.getSchool().equals(school)) {
                if (uni.getEmphases().contains("SCIENCE")) {
                    found = true;
                }
            }
        }
        if (!found) {
            fail("School with name: " + school + " does not have the right updated emphases.");
        }
    }

    /**
     * Test of editUser method, of class DatabaseController.
     */
    @Test
    public void testEditUser() {
        System.out.println("editUser");
        String username = "CCBUsername1";
        String firstName = "ClickClickBoomUser1Edit";
        String lastName = "CCBUser1Edit";
        String password = "CCBPasswordEdit";
        
        DatabaseController.editUser(username, firstName, lastName, password);
        User editedUser = DatabaseController.getSpecificUser(username);
        assertTrue("First name not edited right", firstName.equals(editedUser.getFirstName()));
        assertTrue("Lirst name not edited right", lastName.equals(editedUser.getLastName()));
        assertTrue("Password not edited right", password.equals(editedUser.getPassword()));
    }

    /**
     * Test of editUserByAdmin method, of class DatabaseController.
     */
    @Test
    public void testEditUserByAdmin_6args_1() {
        DatabaseController.addUser("ClickClickBoomUser2", "CCBUser2", "CCBUsername2", "CCBPassword2", 'u');
        ArrayList<User> allUsers = DatabaseController.getAllUsers();
        System.out.println("editUserByAdmin");
        int ID = 200;
        String firstName = "ClickClickBoomUser2Edit";
        String lastName = "CCBUser2Edit";
        String password = "CCBPassword2Edit";
        char type = 'u';
        char status = 'N';
        DatabaseController.editUserByAdmin(ID, firstName, lastName, password, type, status);
        User editedUser = DatabaseController.getSpecificUser(200);
        assertTrue("First name not edited right", firstName.equals(editedUser.getFirstName()));
        assertTrue("Lirst name not edited right", lastName.equals(editedUser.getLastName()));
        assertTrue("Password not edited right", password.equals(editedUser.getPassword()));
        assertTrue("Status not edited right", new Character('N').equals(editedUser.getStatus()));
    }

    /**
     * Test of editUserByAdmin method, of class DatabaseController.
     */
    @Test
    public void testEditUserByAdmin_6args_2() {
        System.out.println("editUserByAdmin");
        String username = "CCBUsername2";
        String firstName = "ClickClickBoomUser2Edit2";
        String lastName = "CCBUser2Edit2";
        String password = "CCBPassword2Edit2";
        char type = 'u';
        char status = 'N';
        DatabaseController.editUserByAdmin(username, firstName, lastName, password, type, status);
        User editedUser = DatabaseController.getSpecificUser(200);
        assertTrue("First name not edited right", firstName.equals(editedUser.getFirstName()));
        assertTrue("Lirst name not edited right", lastName.equals(editedUser.getLastName()));
        assertTrue("Password not edited right", password.equals(editedUser.getPassword()));
        assertTrue("Status not edited right", new Character('N').equals(editedUser.getStatus()));
    }

    /**
     * Test of getAllPossibleEmphases method, of class DatabaseController.
     */
    @Test
    public void testGetAllPossibleEmphases() {
        System.out.println("getAllPossibleEmphases");
        ArrayList<String> allEmphases = DatabaseController.getAllPossibleEmphases();
       assertTrue("Returns a complete list of possible emphases", allEmphases.contains("MATH"));
       assertTrue("Returns a complete list of possible emphases", allEmphases.contains("LIBERAL-ARTS"));
    }

    /**
     * Test of getAllSavedSchools method, of class DatabaseController.
     */
    @Test
    public void testGetAllSavedSchools() {
        System.out.println("getAllSavedSchools");
        DatabaseController.addUserSchool(200, "ClickClickBoomUniversity1");
        TreeMap<Integer, ArrayList<String>> result = DatabaseController.getAllSavedSchools();
        assertTrue("Id number 200 does not have correct schools",result.get(200).contains("ClickClickBoomUniversity1"));
    }

    /**
     * Test of getAllUniversities method, of class DatabaseController.
     */
    @Test
    public void testGetAllUniversities() {
        System.out.println("getAllUniversities");
        try{
            ArrayList<University> result = DatabaseController.getAllUniversities();
        }
        catch(Exception e){
           fail("ArrayList not constructed properly");
        }
        
    }

    /**
     * Test of getAllUniversityNamesWithEmphases method, of class DatabaseController.
     */
    @Test
    public void testGetAllUniversityNamesWithEmphases() {
        System.out.println("getAllUniversityNamesWithEmphases");
        DatabaseController.addUniversityEmphasis("ClickClickBoomUniversity1", "MATH");
        TreeMap<String, ArrayList<String>> result = DatabaseController.getAllUniversityNamesWithEmphases();
        assertTrue("Emphases not received properly",result.get("ClickClickBoomUniversity1").contains("MATH"));
    }

    /**
     * Test of getAllUsers method, of class DatabaseController.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        try{
            ArrayList<User> result = DatabaseController.getAllUsers();
            if(result==null){
                fail("Result is null");
            }
        }
        catch(Exception e){
            fail("Exception thrown in \"testGetAllUsers\"");
        }       
    }

    /**
     * Test of getSpecificUser method, of class DatabaseController.
     */
    @Test
    public void testGetSpecificUser_int() {
        System.out.println("getSpecificUser");
        int Id = 200;
        User myUser = DatabaseController.getSpecificUser(Id);
        assertTrue("First Name of " + myUser.getUserName() + " not correct",myUser.getFirstName().equals("ClickClickBoomUser2Edit2"));
        assertTrue("Last Name of " + myUser.getUserName() + " not correct",myUser.getLastName().equals("CCBUser2Edit2"));
        assertTrue("UserName of " + myUser.getUserName() + " not correct",myUser.getUserName().equals("CCBUsername2"));
        assertTrue("Password of " + myUser.getUserName() + " not correct",myUser.getPassword().equals("CCBPassword2Edit2"));
    }

    /**
     * Test of getSpecificUser method, of class DatabaseController.
     */
    @Test
    public void testGetSpecificUser_String() {
        System.out.println("getSpecificUser");
        String userName = "CCBUsername2";
        User myUser = DatabaseController.getSpecificUser(userName);
        assertTrue("First Name of " + myUser.getUserName() + " not correct",myUser.getFirstName().equals("ClickClickBoomUser2Edit2"));
        assertTrue("Last Name of " + myUser.getUserName() + " not correct",myUser.getLastName().equals("CCBUser2Edit2"));
        assertTrue("UserName of " + myUser.getUserName() + " not correct",myUser.getUserName().equals("CCBUsername2"));
        assertTrue("Password of " + myUser.getUserName() + " not correct",myUser.getPassword().equals("CCBPassword2Edit2"));
    }

    /**
     * Test of removeUserSchool method, of class DatabaseController.
     */
    @Test
    public void testRemoveUserSchool() {
        System.out.println("removeUserSchool");
        int Id = 200;
        String school = "ClickClickBoomUniversity1";
        TreeMap<Integer, ArrayList<String>> result = DatabaseController.getAllSavedSchools();
        assertTrue("Id number "+Id+" does not have correct schools",result.get(Id).contains(school));
        DatabaseController.removeUserSchool(Id, school);
        result = DatabaseController.getAllSavedSchools();
        if(result.get(Id)!=null){
            assertTrue("Id number "+Id+"'s school called "+ school + " was not remove properly.",!result.get(Id).contains(school));
        }
    } 

    /**
     * Test of main method, of class DatabaseController.
     */
//    This method was used for the driver class from Phase II    
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        DatabaseController.main(args);
//    }
}
