package csci230radomskizurnhardy;

import junit.framework.TestCase;

/**
 * All the functions as defined within our use case diagram can be found in the various test classes of
 * this package.  There is a reference within a commented section under each of the use case 
 * test methods displayed below, pointing to the appropriate test method within the appropriate test class.
 * @author pghardy
 * @version 1.0
 * @since March, 2012
 */
public class UseCasesTest extends TestCase{
    
    public UseCasesTest() {
    }

    
    public void testUseCase1() {
        System.out.println("UseCase #1: Login");
        //This functionality is shown by the method:
        //      testLogin() in UserControllerTest
        
    }
    
    
    
    public void testUseCase2() {
        System.out.println("UseCase #2: Manage Profile");
        //This functionality is shown by the method:
        //      testEditUser() in UserControllerTest
    }
    
    
    public void testUseCase3() {
        System.out.println("UseCase #3: Search");
        //This functionality is shown by the class:
        //      SearchControllerTest which makes sure
        //      each test parameter is running correctly
    }
    
    
    public void testUseCase4() {
        System.out.println("UseCase #4: Manage Saved Schools");
        //This functionality is shown by the methods:
        //      testAddUserSchool() in UserControllerTest
        //      testRemoveUserSchool() in UserControllerTest
        //      testGetAllSavedSchools() in UserControllerTest
    }
    
    
    public void testUseCase5() {
        System.out.println("UseCase #5: Manage Universities");
        //This functionality is shown by the methods:
        //      testAddUniversity() in AdminControllerTest
        //      testAddUniversityEmphasis() in AdminControllerTest
        //      testEditUniversity() in AdminControllerTest
        //      testEditUniversityEmphases() in AdminControllerTest
        //      testGetAllUniversities() in AdminControllerTest
    }
    
    
    public void testUseCase6() {
        System.out.println("UseCase #6: Manage Users");
        //This functionality is shown by the methods:
        //      testAddUser() in AdminControllerTest
        //      testDeactivateUser_int() in AdminControllerTest
        //      testDeactivateUser_String() in AdminControllerTest
        //      testEditUser() in AdminControllerTest
        //      testEditUserByAdmin() in AdminControllerTest
        //      testGetSpecificUser_Integer() in AdminControllerTest
        //      testGetSpecificUser_String() in AdminControllerTest
    }
    
    
    public void testUseCase7() {
        System.out.println("UseCase #7: View Results");
        //This functionality is shown by the class:
        //      SearchControllerTest which makes
        //      the necessary Schools available to view
    }
    
    
    public void testUseCase8() {
        System.out.println("UseCase #8: View Additional School Info and Recommended Schools");
        //This functionality is shown by the class:
        //      FiveRecSearchControllerTest which
        //      takes a school and finds the five most
        //      similar ones
    }
    
    
    public void testUseCase9() {
        System.out.println("UseCase #9: Save School");
        //This functionality is shown by the method:
        //      testAddUserSchool() in UserControllerTest
    }
    
    
    public void testUseCase10() {
        System.out.println("UseCase #10: View Additional School Info");
        //This functionality is shown by the method:
        //      testGetAllSavedSchools() in UserControllerTest
    }
    
    
    public void testUseCase11() {
        System.out.println("UseCase #11: Remove School");
        //This functionality is shown by the method:
        //      testRemoveUserSchool() in UserControllerTest
    }
    
    
    public void testUseCase12() {
        System.out.println("UseCase #12: Add User");
        //This functionality is shown by the method:
        //      testAddUser() in AdminControllerTest
    }
    
    
    public void testUseCase13() {
        System.out.println("UseCase #13: Edit User");
        //This functionality is shown by the methods:
        //      testEditUser() in AdminControllerTest
        //      testEditUserByAdmin() in AdminControllerTest
    }
    
    
    public void testUseCase14() {
        System.out.println("UseCase #14: Deactivate User");
        //This functionality is shown by the methods:
        //      testDeactivateUser_int() in AdminControllerTest
        //      testDeactivateUser_String() in AdminControllerTest
    }
    
    
    public void testUseCase15() {
        System.out.println("UseCase #15: Add School");
        //This functionality is shown by the methods:
        //      testAddUniversity() in AdminControllerTest
        //      testAddUniversityEmphasis() in AdminControllerTest
    }
    
    
    public void testUseCase16() {
        System.out.println("UseCase #16: Edit School");
        //This functionality is shown by the methods:
        //      testEditUniversity() in AdminControllerTest
        //      testEditUniversityEmphases() in AdminControllerTest
    }
    
    
    public void testUseCase17() {
        System.out.println("UseCase #17: Edit User by User");
        //This functionality is shown by the methods:
        //      testEditUser() in UserControllerTest
    }
}
