package csci230radomskizurnhardy;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author wjradomski
 */
public class UserControllerTest extends TestCase{
    
    public UserControllerTest() {
    }



    /**
     * Test of addUserSchool method, of class UserController.
     * Basic test which adds a school to a User's list of saved Schools then 
     * confirms the school is added.
     * Input: Auburn university, ID - 2
     * Output: Boolean - true, if user is found to have saved school.
     */
    
    public void testAddUserSchool() {
        System.out.println("addUserSchool");
        int id = 2;
        String school = "AUBURN";
        UserController.addUserSchool(id, school);
        boolean tested = false;
        ArrayList<String> savedSchools2 = UserController.getAllSavedSchools(id);

        for(int i = 0; i<savedSchools2.size(); i++){
            if(savedSchools2.get(i).equals(school)){
            tested = true;
            break;
           }  
        }
        System.out.println("School successfully added to UsersSavedSchools");
         assertTrue(tested);  

    
    }

    /**
     * Test of removeUserSchool method, of class UserController.
     * Basic test that removes a school from a User's saved Schools then
     * confirms the school is removed. 
     * Input: Auburn university, ID - 2
     * Output: Boolean - true, if university was removed from user's list.
     */
    
    public void testRemoveUserSchool() {
        System.out.println("removeUserSchool");
        int id = 2;
        String school = "Auburn";
        boolean  tested = true; 
        UserController.removeUserSchool(id, school);
        ArrayList<String> savedSchools = UserController.getAllSavedSchools(id);
        for(int i = 0; i<savedSchools.size(); i++){
            if(savedSchools.get(i).equals(school)){
                tested = false;
                break;
            }
            else{
               
            }
       } 
        System.out.println("School successfully removed from UsersSavedSchools");
          assertTrue(tested);  
        

    

    }

    /**
     * Test of getAllSavedSchools method, of class UserController.
     * Basic test returns a list of Saved Schools of a given user and compares to the
     * expected saved school list.
     * Input: A user's id
     * Output: an ArrayList of the User's Saved Schools
     */
    
    public void testGetAllSavedSchools() {
        System.out.println("getAllSavedSchools");
        int id = 2;
        String school = "AUBURN";
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add(school);
        ArrayList<String> expResult1 = UserController.getAllSavedSchools(id);
        for(int i = 0; i<expResult1.size(); i++){
            expResult.add(expResult1.get(i));
        }
        UserController.addUserSchool(id, school);
        
        ArrayList<String> result = UserController.getAllSavedSchools(id);
        boolean checker = false;
        for(int i = 0; i<result.size(); i++){
            System.out.println(expResult.get(i) + result.get(i));
            if(expResult.get(i).equals(result.get(i))){
                checker = true;
            }
            else{
                checker = false;
            }
       }
        System.out.println("List of Saved schools given");
        assertTrue(checker);
        UserController.removeUserSchool(id, school);
    }

    /**
     * Test of editUser method, of class UserController. 
     * Basic test which edits a user's firstname lastname and password then confirms
     * the changes made are correct.
     * Input: firstname - Click, lastname - Click, password - BOOM
     * Output: firstname - Click, lastname - Click, password - BOOM Tests - Passed
     */
    
    public void testEditUser() {
        System.out.println("editUser");
        String username = "juser";
        String firstName = "Click";
        String lastName = "Click";
        String password = "BOOM";
        UserController.editUser(username, firstName, lastName, password);
        System.out.println("");
        assertTrue(firstName.equals(AdminController.getSpecificUser(username).getFirstName()));
        assertTrue(lastName.equals(AdminController.getSpecificUser(username).getLastName()));
        assertTrue(password.equals(AdminController.getSpecificUser(username).getPassword()));
        firstName = "Johnny";
        lastName = "John";
        password = "user";
        UserController.editUser(username, firstName, lastName, password);
    }

    /**
     * Test of login method, of class UserController. 
     * Black box test of login.
     * Case 1: Input: correct username and correct password
     *         Output: login returns true
     * Case 2: Input: correct username and incorrect password
     *         Output: login returns false
     * Case 3: Input: invalid username and correct password
     *         Output: login returns false
     * Case 4: invalid username and invalid password
     *         Output: login returns false
     */
   
    
    public void testLogin() {
        System.out.println("login Method");
        String username = "juser";
        String username1 = "blah";
        String password = "user";
        String password1 = "user1";
        
        System.out.println("The following message corresponds to: correct username, correct password");
        boolean result = UserController.login(username, password);
        assertTrue(result);
        
        System.out.println("The following message corresponds to: correct username, incorrect password");
        boolean result1 = UserController.login(username, password1);
        assertTrue(!result1);
        
        System.out.println("The following message corresponds to: invalid username, valid password");
        boolean result2 = UserController.login(username1, password);
        assertTrue(!result2);
        
        System.out.println("The following message corresponds to: invalid username, invalid password");
        boolean result3 = UserController.login(username1, password1);
        assertTrue(!result3);
        
    }
}