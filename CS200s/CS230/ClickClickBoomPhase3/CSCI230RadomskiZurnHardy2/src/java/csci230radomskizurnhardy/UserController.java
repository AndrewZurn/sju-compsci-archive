package csci230radomskizurnhardy;

import java.util.ArrayList;
import java.util.TreeMap;
/**
 *Class UserController serves the purpose of performing the necessary functionalities for Users on CMC
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.0
 * @since March 18, 2012
 */



public class UserController {
    private User user;
    private static DatabaseController DatabaseController;
    private University university;

    
    /**
     * 
     */
    
public void UserController(){
    
    
}
    /**
     * Adds a school to an individual User's Array of saved schools given the User's ID and the name of the University.
     * @param id User's ID number. 
     * @param school The school that was selected to be added to a User's saved schools. 
     */
    
    public static void addUserSchool(int id, String school){
        DatabaseController.addUserSchool(id, school);
    }
    /**
     * Removes a school from an individual User's Array of saved schools whose ID is given as a parameter. 
     * @param id User's ID.
     * @param school The school that was selected from his array of saved schools to be removed. 
     */
    
    public static void removeUserSchool(int id, String school){
        DatabaseController.removeUserSchool(id, school);
    }
    
   /**
    * Takes the id of a user and returns a Array List of their saved schools.
    * @param id User's ID
    * @return Returns a Array List of all the saved schools given a user's id.
    */ 
    public static ArrayList<String> getAllSavedSchools(int id){
        TreeMap<Integer, ArrayList<String>> savedSchools = DatabaseController.getAllSavedSchools();
        ArrayList<String> userSchools = savedSchools.get(id);
        return userSchools; 
    }
/**
 * Allows the User to edit his/her information
 * 
 * @param id A User's ID.
 * @param firstName User's first name (or desired first name).
 * @param lastName User's last name (or desired last name).
 * @param password User's password (or desired password).
 */
   public static void editUser(String username, String firstName, String lastName, String password){
         DatabaseController.editUser(username, firstName, lastName, password);
     }
   /**
    * Logs on Users in order to search schools, manage their information, and view their saved schools
    * @param username
    * @param password
    * @return Returns a boolean "true" if login is successful or "false" if either username or password is incorrect
    */
   
   public static boolean login(String username, String password){
       boolean status = false;
        try{
            User user = DatabaseController.getSpecificUser(username);
            String correctPass = user.getPassword();
            if(correctPass.equals(password)){
                System.out.println("Login Successful");
                status = true;
            }
            else{
                System.out.println("Login Unsuccessful");
                status = false;
                }
            }
        catch(NullPointerException ne){
            System.out.println("This user was not found within our database.");
        }
        return status;
    }
   /**
    * Allows the class to be run from the command line, where it demonstrates it's methods.
    * @param args 
    */
   
   public static void main(String args[]){
 //      User user = new User("firstName", "lastName", "username", "password", 'u');
       System.out.println("***Here is Use Case #1: Login***");
       System.out.println("\n\nLogin function");
       System.out.println("\n\nAttempted Login with correct username and password");
       Integer id = 1;
       User user = DatabaseController.getSpecificUser(id);
       boolean loginFun = UserController.login(user.getUserName(), user.getPassword());
       
       System.out.println("Attempted Login with a valid username and incorrect password");
       
       loginFun = UserController.login(user.getUserName(), "aaaaaaa");
       
       System.out.println("Attempted Login with a invalid username and correct password");
       
       loginFun = UserController.login("a", user.getPassword());
       
        System.out.println("\n\ngetAllSavedSchools function, for User with id = 1");
        System.out.println("***Here is Use Case #10: View Additional School Info***");
        ArrayList<String> schoolsSaved = UserController.getAllSavedSchools(id);
        for(int i = 0; i<schoolsSaved.size(); i++){
            String printed = schoolsSaved.get(i);
            System.out.println(printed);
        }
        System.out.println("***Here is Use Case #9: Save School***");
        System.out.println("\n\naddUserSchool function, adding ZURN UNIVERSITY to User with id = 1 list");
        
        String zurnsPlace = "Zurn University";
        
        UserController.addUserSchool(id, zurnsPlace);
        ArrayList<String> schoolsSaved1 = UserController.getAllSavedSchools(id);
        System.out.println("\n\nZURN UNIVERSITY added to User's saved Schools");
        for(int i = 0; i<schoolsSaved1.size(); i++){
            String printed = schoolsSaved1.get(i);
            System.out.println(printed);
        }
        
        System.out.println("\n\nremoveUserSchool function");
        
        UserController.removeUserSchool(id, zurnsPlace);
        ArrayList<String> schoolsSaved2 = UserController.getAllSavedSchools(id);
        System.out.println("\n\nZurn University Removed from User with id = 1 saved Schools");
        
        for(int i = 0; i<schoolsSaved2.size(); i++){
            String printed = schoolsSaved2.get(i);
            System.out.println(printed);
        }
        System.out.println("\n\neditUser function");
                User user1 = DatabaseController.getSpecificUser(2);
        System.out.println("" + user1.getFirstName() + ", "+ user1.getLastName() + ", "+ user1.getPassword());
        System.out.println("Change first name to Joe, last name to User1 and password to user1 for User with id = 2");
        UserController.editUser("juser", "Joe", "User1", "user1");
                User user2 = DatabaseController.getSpecificUser(2);
        System.out.println("" + user2.getFirstName() + ", "+ user2.getLastName() + ", "+ user2.getPassword());

        UserController.editUser("juser", "User", "John", "user");
   }
    
}
