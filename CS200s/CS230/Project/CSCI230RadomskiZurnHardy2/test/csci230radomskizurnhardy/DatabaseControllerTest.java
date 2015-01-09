package csci230radomskizurnhardy;

import java.util.ArrayList;
import java.util.TreeMap;
import junit.framework.TestCase;

/**
 * This test class contains basic tests of the various methods used within the
 * DatabaseController class. As most of the methods in DatabaseController refer
 * to a method used in the actual Database, the tests preformed are basic tests,
 * i.e. a university is added to the database, and the test searches through the
 * database to see if the university is existent.
 *
 * @author pghardy
 */
public class DatabaseControllerTest extends TestCase {

    public DatabaseControllerTest() {
    }

    @Override
    protected void setUp() throws Exception {
        //DatabaseController.addUser("FN", "LN", "UN", "PW",'u');
    }

    /**
     * Basic test of addUniversity. This a rather simple test, as the function
     * case diagram merely needs to add the University to the database. To
     * determine if the function works properly, we will simple find the
     * university within the list of universities in the database. Input: new
     * University Output: Boolean - true, if school is found after the
     * addUniversity method is called.
     */
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
        for (University uni : allSchools) {
            if (uni.getSchool().equals(school)) {
                found = true;
            }
        }
        if (!found) {
            fail("School with name: " + school + " not found.");
        }
    }

    /**
     * Basic test of addUniversityEmphasis method of class DatabaseController.
     * Another rather simple test, this will add an emphasis to a given
     * university, and then determine if the emphasis was successfully added to
     * that university. Input: Add MATH to "ClickClickBoomUniversity1" Output:
     * Boolean - true, if math can be found in this school's emphases.
     */
    public void testAddUniversityEmphasis() {
        System.out.println("addUniversityEmphasis");
        String school = "ClickClickBoomUniversity1";
        String emphasis = "MATH";
        boolean found = false;
        DatabaseController.addUniversityEmphasis(school, emphasis);
        ArrayList<University> allSchools = DatabaseController.getAllUniversities();
        for (University uni : allSchools) {
            if (uni.getSchool().equals(school)) {
                if (uni.getEmphases().contains(emphasis)) {
                    found = true;
                }
            }
        }
        if (!found) {
            fail("School with name: " + school + " does not have the right emphases.");
        }
    }

    /**
     * Basic test of the addUser method of DatabseController. This will add a
     * user to the database, and then run through all the users in the database,
     * and upon finding the added user, set a boolean to true. If it does not
     * find it, the boolean will remain false. Input: new User, username
     * CCBUsername3 Output: Boolean - true, if the user CCBUsername3 is found
     * within the database.
     */
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
        for (User user : allUsers) {
            if (user.getFirstName().equals(firstName)) {
                found = true;
            }
        }
        if (!found) {
            fail("User with first name: " + firstName + " was not added to the database.");
        }
    }

    /**
     * Basic test of the addUserSchool method of DatabseController. This will
     * add a school to a user's saved school list and then check to see if that
     * user has that saved school. If it does not find it, the boolean will remain false.
     * Input: User with ID:2 and school name: "ClickClickBoomUniversity1"
     * Output: Boolean - true, if the user ID:2 has "ClickClickBoomUniversity1"
     */
    public void testAddUserSchool() {
        System.out.println("addUserSchool");
        int id = 2;
        String school = "ClickClickBoomUniversity1";
        DatabaseController.addUserSchool(id, school);
        boolean found = false;
        TreeMap<Integer, ArrayList<String>> schoolMap = DatabaseController.getAllSavedSchools();
        if (schoolMap.get(2) != null && schoolMap.get(2).contains(school)) {
            found = true;
        }
        if (!found) {
            fail("User with ID: " + id + "'s school was not added right.");
        }
    }

    /**
     * Basic test deactivateUser(int ID) method of DatabseController. The user will be
     * deactivated in the database, and then will be found in the user list
     * stored in the database, and its status will be returned. On a successful
     * changing of its status, a boolean will be set to true. If not, the
     * boolean will be false.
     * Input: deactivateUser of ID number 1
     * Output: Boolean - true, if status of user with ID number 1 is 'N'
     */
    public void testDeactivateUser_int() {
        System.out.println("deactivateUser");
        int Id = 1;

        DatabaseController.deactivateUser(Id);
        //ArrayList<User> allUsers = DatabaseController.getAllUsers();
        boolean found = false;
        User deactUser = DatabaseController.getSpecificUser(1);
        if (new Character(deactUser.getStatus()).equals('N')) {
            found = true;
        }
        if (!found) {
            fail("User with ID: " + Id + " was not properly deactivated.");
        }
    }

    /**
     * Basic test deactivateUser(String username) method of DatabseController. The user will be
     * deactivated in the database, and then will be found in the user list
     * stored in the database, and its status will be returned. On a successful
     * changing of its status, a boolean will be set to true. If not, the
     * boolean will be false.
     * Input: deactivateUser of username "CCBUsername1"
     * Output: Boolean - true, if status "CCBUsername1" is 'N'
     */
    public void testDeactivateUser_String() {
        System.out.println("deactivateUser");
        String username = "CCBUsername1";
        DatabaseController.deactivateUser(username);
        ArrayList<User> allUsers = DatabaseController.getAllUsers();
        boolean found = false;
        for (User user : allUsers) {
            if (user.getUserName().equals(username)) {
                if (new Character(user.getStatus()).equals('N')) {
                    found = true;
                }
            }
        }
        if (!found) {
            fail("User with Username: " + username + " was not properly deactivated.");
        }
    }

    /**
     * Basic test of editUniversity method of class DatabaseController.  This is a rather
     * simple test, that will edit the university, see if the university still exists within the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * In this case the STATE will be altered.
     * Input: School: "ClickClickBoomUniversity1"
     *        Edit: State: Iowa
     * Output: Boolean - true, if the above changes are found to be true.
     */
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
     * Basic test of editUniversityEmphases method of class DatabaseController.  This is a rather
     * simple test, that will edit the university's emphases, see if the emphases were added into the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * In this case, SCIENCE is added as an emphases
     * Input: School: "ClickClickBoomUniversity1" with emphases SCIENCE
     * Output: Boolean - true, if the above changes are found to be true.
     */
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
     * Basic test of editUser method of class DatabaseController.  This is a rather
     * simple test, that will add and edit a user, get the use from within the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * Input: Username: "CCBUsername1"
     *        Edit: firstName = "ClickClickBoomUser1Edit";
     *              lastName = "CCBUser1Edit";
     *              password = "CCBPasswordEdit";
     * Output: 3 Booleans - true, if the above changes are found to be true.
     */
    public void testEditUser() {
        DatabaseController.addUser("CCBUsername1", "a", "b", "c", 'u');
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
     * Basic test of editUserByAdmin_ID method of class DatabaseController.  This is a rather
     * simple test, that will add and edit a user, get the use from within the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * Input: ID:2
     *        Edit: firstName = "ClickClickBoomUser2Edit";
     *              lastName = "CCBUser2Edit";
     *              password = "CCBPassword2Edit";
     *              type = 'u';
                    status = 'N'
     * Output:  4 Booleans - true, if the above changes are found to be true.
     */
    public void testEditUserByAdmin_6args_1() {
        DatabaseController.addUser("ClickClickBoomUser2", "CCBUser2", "CCBUsername2", "CCBPassword2", 'u');
        ArrayList<User> allUsers = DatabaseController.getAllUsers();
        System.out.println("editUserByAdmin");
        int ID = 2;
        String firstName = "ClickClickBoomUser2Edit";
        String lastName = "CCBUser2Edit";
        String password = "CCBPassword2Edit";
        char type = 'u';
        char status = 'N';
        DatabaseController.editUserByAdmin(ID, firstName, lastName, password, type, status);
        User editedUser = DatabaseController.getSpecificUser(2);
        //System.out.println("AAA|" + editedUser.getFirstName());
        assertTrue("First name not edited right", firstName.equals(editedUser.getFirstName()));
        assertTrue("Lirst name not edited right", lastName.equals(editedUser.getLastName()));
        assertTrue("Password not edited right", password.equals(editedUser.getPassword()));
        assertTrue("Status not edited right", new Character('N').equals(editedUser.getStatus()));
    }

    /**
     * Basic test of editUserByAdmin_USERNAME method of class DatabaseController.  This is a rather
     * simple test, that will add and edit a user, get the use from within the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * Input: Username: "CCBUsername2";
     *        Edit: firstName = "ClickClickBoomUser2Edit2";
     *              lastName = "CCBUser2Edit2";
     *              password = "CCBPassword2Edit2";
     *              type = 'u';
                    status = 'N'
     * Output:  4 Booleans - true, if the above changes are found to be true.
     */
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
     * Basic test of getAllPossibleEmphases method of class DatabaseController.  This is a rather
     * simple test that will check to see if a few examples are contained within the list of all emphases.
     * Input: MATH and LIBERAL-ARTS
     * Output:  2 Booleans - true, if the above emphases are present
     */
    public void testGetAllPossibleEmphases() {
        System.out.println("getAllPossibleEmphases");
        ArrayList<String> allEmphases = DatabaseController.getAllPossibleEmphases();
        assertTrue("Returns a complete list of possible emphases", allEmphases.contains("MATH"));
        assertTrue("Returns a complete list of possible emphases", allEmphases.contains("LIBERAL-ARTS"));
    }

    /**
     * Basic test of getAllSavedSchools method of class DatabaseController.  This is a rather
     * simple test that will add a school to a user's saved universities. Then it will make sure
     * that school was added.
     * Input: ID:2 and "ClickClickBoomUniversity1"
     * Output:  Boolean - true, if the above saved school is present in user ID:2's list
     */
    public void testGetAllSavedSchools() {
        System.out.println("getAllSavedSchools");
        DatabaseController.addUserSchool(2, "ClickClickBoomUniversity1");
        TreeMap<Integer, ArrayList<String>> result = DatabaseController.getAllSavedSchools();
        assertTrue("Id number 2 does not have correct schools", result.get(2).contains("ClickClickBoomUniversity1"));
    }

    /**
     * Basic test of getAllUniversities method of class DatabaseController.  This is a rather
     * simple test that will check to see if the array that gets the universities is not null.
     * Input: ArrayList<University> result = DatabaseController.getAllUniversities();
     * Output:  Boolean - true, if the above array is not null
     */
    public void testGetAllUniversities() {
        System.out.println("getAllUniversities");
        try {
            ArrayList<University> result = DatabaseController.getAllUniversities();
            assertTrue("result is not null", result != null);
        } catch (Exception e) {
            fail("ArrayList not constructed properly");
        }

    }

    /**
     * Basic test of getAllUniversityNamesWithEmphases method of class DatabaseController.  This is a rather
     * simple test, that will add to a university's emphases, see if that emphasis was added into the database,
     * and then determine if the fields that were edited, were indeed edited to the desired correction.
     * In this case, MATH is added as an emphases to "ClickClickBoomUniversity1"
     * Input: School: "ClickClickBoomUniversity1" with emphases MATH
     * Output: Boolean - true, if the above changes are found to be true.
     */
    public void testGetAllUniversityNamesWithEmphases() {
        System.out.println("getAllUniversityNamesWithEmphases");
        DatabaseController.addUniversityEmphasis("ClickClickBoomUniversity1", "MATH");
        TreeMap<String, ArrayList<String>> result = DatabaseController.getAllUniversityNamesWithEmphases();
        assertTrue("Emphases not received properly", result.get("ClickClickBoomUniversity1").contains("MATH"));
    }

    /**
     * Basic test of getAllUsers method of class DatabaseController.  This is a rather
     * simple test that will check to see if the array that gets the users is not null.
     * Input: ArrayList<User> result = DatabaseController.getAllUsers();
     * Output:  Boolean - true, if the above array is not null
     */
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        try {
            ArrayList<User> result = DatabaseController.getAllUsers();
            if (result == null) {
                fail("Result is null");
            }
        } catch (Exception e) {
            fail("Exception thrown in \"testGetAllUsers\"");
        }
    }

    /**
     * Basic test of getSpecificUser_int() method of class DatabaseController.  This is a rather
     * simple test, that will edit a user(in case the entries have changed since the creation of
     * this test), get the user from within the database by the ID number,
     * and then determine if the fields that were edited, refer to the edited user.
     * Input: ID:2
     *        Edit: firstName = "ClickClickBoomUser2Edit2";
     *              lastName = "CCBUser2Edit2";
     *              password = "CCBPassword2Edit2";
     *              type = 'u';
                    status = 'N'
     * Output:  4 Booleans - true, if the above changes are found to be true.
     */
    public void testGetSpecificUser_int() {
        System.out.println("getSpecificUser");
        int Id = 2;
        String firstName = "ClickClickBoomUser2Edit2";
        String lastName = "CCBUser2Edit2";
        String password = "CCBPassword2Edit2";
        char type = 'u';
        char status = 'N';
        DatabaseController.editUserByAdmin(Id, firstName, lastName, password, type, status);
        User myUser = DatabaseController.getSpecificUser(Id);
        assertTrue("First Name of " + myUser.getUserName() + " not correct", myUser.getFirstName().equals("ClickClickBoomUser2Edit2"));
        assertTrue("Last Name of " + myUser.getUserName() + " not correct", myUser.getLastName().equals("CCBUser2Edit2"));
        assertTrue("UserName of " + myUser.getUserName() + " not correct", myUser.getUserName().equals("juser"));
        assertTrue("Password of " + myUser.getUserName() + " not correct", myUser.getPassword().equals("CCBPassword2Edit2"));
    }

    /**
     * Basic test of getSpecificUser_String() method of class DatabaseController.  This is a rather
     * simple test, that will edit a user(in case the entries have changed since the creation of
     * this test), get the user from within the database by the username,  
     * and then determine if the fields that were edited, refer to the edited user.
     * Input: "CCBUsername2";
     * Output:  4 Booleans - true, if the above changes are found to be true.
     */
    public void testGetSpecificUser_String() {
        System.out.println("getSpecificUser");
        String userName = "CCBUsername2";
        User myUser = DatabaseController.getSpecificUser(userName);
        assertTrue("First Name of " + myUser.getUserName() + " not correct", myUser.getFirstName().equals("ClickClickBoomUser2Edit2"));
        assertTrue("Last Name of " + myUser.getUserName() + " not correct", myUser.getLastName().equals("CCBUser2Edit2"));
        assertTrue("UserName of " + myUser.getUserName() + " not correct", myUser.getUserName().equals("CCBUsername2"));
        assertTrue("Password of " + myUser.getUserName() + " not correct", myUser.getPassword().equals("CCBPassword2Edit2"));
    }

    /**
     * Basic test of the removeUserSchool method of DatabseController. This will
     * remove a school from a user's saved school list and then check to see if that
     * user does not have that saved school.
     * Input: User with ID:2 and school name: "ClickClickBoomUniversity1"
     * Output: Boolean - true, if the user ID:2 does not have "ClickClickBoomUniversity1"
     */
    public void testRemoveUserSchool() {
        System.out.println("removeUserSchool");
        int Id = 2;
        String school = "ClickClickBoomUniversity1";
        DatabaseController.addUserSchool(Id, school);
        TreeMap<Integer, ArrayList<String>> result = DatabaseController.getAllSavedSchools();
        assertTrue("Id number " + Id + " does not have correct schools", result.get(Id).contains(school));
        DatabaseController.removeUserSchool(Id, school);
        result = DatabaseController.getAllSavedSchools();
        if (result.get(Id) != null) {
            assertTrue("Id number " + Id + "'s school called " + school + " was not remove properly.", !result.get(Id).contains(school));
        }
    }
    
    /**
     * Basic test of the getID method of DatabseController. This will
     * check to see that the ID number of a know user is fetched correctly,
     * Input: User with username: "nadmin"
     * Output: Boolean - true, if this username returns an ID of 1.
     */
    public void testGetID(){
        System.out.println("getID");
        String username = "nadmin";
        assertTrue("Username: nadmin has incorrect ID number.",DatabaseController.getID(username)==1);
    }
    /**
     * Test of main method, of class DatabaseController.
     */
//    This method was used for the driver class from Phase II    
//    
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        DatabaseController.main(args);
//    }
}
