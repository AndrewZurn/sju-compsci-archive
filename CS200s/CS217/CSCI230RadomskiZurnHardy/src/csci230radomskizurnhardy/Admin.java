/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230radomskizurnhardy;

/**
 *
 * @author awzurn
 */
public class Admin extends Person {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private char type;
    //private AdminController adminController;

    public Admin(String firstName, String lastName, String userName,
            String password, char type /*, AdminContoller adminController*/) {
        super(firstName, lastName, userName, password, type);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        //this.adminController = adminController;
        }

    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }
    
    /**
     * 
     * @param args 
     */
    public static void main(String args[]){
        Admin admin = new Admin("AdminFirstName", "AdminLastName", "AdminUserName","password",'a');
    }
 }  

