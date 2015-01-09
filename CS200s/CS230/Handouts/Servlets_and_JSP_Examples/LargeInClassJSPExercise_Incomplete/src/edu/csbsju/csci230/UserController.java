/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.csci230;

/**
 *
 * @author irahal
 */
public class UserController {

    private User  currentUser;
    private boolean loggedIn=false;

    /** 
     * returns 0 for successful login
     * returns -1 if username is not valid
     * returns -2 if password is not valid
     * returns -3 if database access was not successful
     */
    public int login(String username, String password) {
        try{
            String[][] userRecord = UserDBLibrary.getSpecificUser(username);
            if (userRecord==null){
                return -1;
            }
            else if (!userRecord[0][2].equals(password)){
                return -2;
            }
            else{
                this.setCurrentUser(new User(userRecord[0][0],userRecord[0][1],userRecord[0][2],Integer.parseInt(userRecord[0][3]),userRecord[0][4],userRecord[0][5]));
                this.setLoggedIn(true);
                return 0;
            }
        }
        catch(Exception e){
            return -3;
        }   
    }
  
     public void logout(){
        this.setLoggedIn(true);
     }
    
    /**
     * @return the loggedIn
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * @param loggedIn the loggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public void addUser(User user){
        try{
            UserDBLibrary.addUser(user.getFullName(), user.getUsername(), user.getPassword(), user.getAge(),user.getCity(),user.getState());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void editUser(User user){
        try{
            UserDBLibrary.editUser(user.getUsername(), user.getFullName(), user.getPassword(), user.getAge(),user.getCity(),user.getState());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteUser(User user){
        try{
            UserDBLibrary.deleteUser(user.getUsername());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    
    public String[][] getAllUsers(){
        try{
            return UserDBLibrary.getAllUsers();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String[][] getSpecificUser(String username){
        try{
            return UserDBLibrary.getSpecificUser(username);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
