package csci230radomskizurnhardy;

/**
 *A class that will be used to represent an administrator within the CMC system.
 * @author awzurn
 * @version 1.0
 * @since March 11, 2012
 */
public class Admin extends Person {
    /**
     * first name to be associated with the admin.
     */
    private String firstName;
    /**
     * last name to be associated with the admin.
     */
    private String lastName;
    /**
     * user name to be associated with the admin.
     */
    private String userName;
    /**
     * password to be associated with the admin.
     */
    private String password;
    /**
     * type of user to be associated with the admin.
     */
    private char type;

    /**
     * Will be used to construct the representation of the administrator.
     * @param firstName First name of the admin.
     * @param lastName Last name of the admin.
     * @param userName User name of the admin.
     * @param password Pass word of the admin.
     * @param type  Type of user that the admin is.
     */
    public Admin(String firstName, String lastName, String userName,
            String password, char type) {
        super(firstName, lastName, userName, password, type);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        }

        
//    /**
//     * Used to get the first name of the admin.
//     * @return the firstName
//     */
//    public String getFirstName() {
//        return firstName;
//    }
//
//    /**
//     * Used to set the first name of the admin.
//     * @param firstName the firstName to set
//     */
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    /**
//     * Used to get the last name of the admin.
//     * @return the lastName
//     */
//    public String getLastName() {
//        return lastName;
//    }
//
//    /**
//     * Used to set the last name of the admin.
//     * @param lastName the lastName to set
//     */
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    /**
//     * Used to get the user name of the admin.
//     * @return the userName
//     */
//    public String getUserName() {
//        return userName;
//    }
//
//    /**
//     * Used to set the user name of the admin.
//     * @param userName the userName to set
//     */
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    /**
//     * Used to get the password of the admin.
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * Used to set the first name of the admin.
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * Used to get the user that the admin is.
//     * @return the type
//     */
//    public char getType() {
//        return type;
//    }
//
//    /**
//     * Used to set the user that the admin is.
//     * @param type the type to set
//     */
//    public void setType(char type) {
//        this.type = type;
//    }
    @Override
    public String toString() {
        return "Admin{" + "firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", type=" + type + '}';
    }
    
    
    /**
     * User to run this class from the command line.
     * @param args The parameters passed to this class from stdin.
     */
    public static void main(String args[]){
        Admin admin = new Admin("AdminFirstName", "AdminLastName", "AdminUserName","password",'a');
    }
 }  

