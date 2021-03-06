/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

import java.util.TreeMap;
import java.util.*;
/**
 *Class UserController serves the purpose of performing the necessary functionalities for Users on CMC
 * @author wjradomski
 * @version 1.0
 * @since March 18, 2012
 */



public class UserController {
    private User user;
    private static DatabaseController DatabaseController;
    private University university;


    /**
     * Adds a school to an individual User's Array of saved schools
     * @param id User's ID number. 
     * @param school The school that was selected to be added to a User's saved schools. 
     */
    
    public void addUserSchool(int id, String school){
        DatabaseController.addUserSchool(id, school);
    }
    /**
     * Removes a school from an individual User's Array of saved schools. 
     * @param id User's ID.
     * @param school The school that was selected from his array of saved schools to be removed. 
     */
    
    public void removeUserSchool(int id, String school){
        DatabaseController.removeUserSchool(id, school);
    }
   /**
    * Takes the id of a user and returns a Array List of their saved schools.
    * @param id User's ID
    * @return Returns a Array List of all the saved schools given a user's id.
    */ 
    
    public ArrayList<String> getAllSavedSchools(int id){
        TreeMap<Integer, ArrayList<String>> savedSchools = DatabaseController.getAllSavedSchools();
        ArrayList<String> userSchools = savedSchools.get(id);
        return userSchools; 
    }
/**
 * Allows the User to edit his profile. 
 * 
 * @param id A User's ID.
 * @param firstName User's first name (or desired first name).
 * @param lastName User's last name (or desired last name).
 * @param password User's password (or desired password).
 */
   public void editUser(int id, String firstName, String lastName, String password){
         DatabaseController.editUser(id, firstName, lastName, password);
     }
   
   public static boolean login(String username, String password){
       try{
       User client = DatabaseController.getSpecificUser(username);
       if(client.getPassword().equals(password)){
           System.out.println("login succesful");          
           return true;
       }
       }
       catch(NullPointerException e){
           System.out.println("no such username exists");
       }
       System.out.println("login failed");   
       return false;
   }
   
   public static void main(String args[]){
       User user = new User("firstName", "lastName", "username", "password", 'u');
      
       
   }
    
}
