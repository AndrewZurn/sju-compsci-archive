package csci230radomskizurnhardy;

/**
 *
 * @author wjradomski
 */

public class User extends Person {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private char type;
    //private UserController UserController;
    
    public User(String firstName, String lastName, String userName,
            String password, char type /*, UserController userController*/){
    super(firstName, lastName, userName, password, type);
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.type = type;
    }

//    /**
//     * @return the firstName
//     */
//    public String getFirstName() {
//        return firstName;
//    }
//
//    /**
//     * @param firstName the firstName to set
//     */
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    /**
//     * @return the lastName
//     */
//    public String getLastName() {
//        return lastName;
//    }
//
//    /**
//     * @param lastName the lastName to set
//     */
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    /**
//     * @return the userName
//     */
//    public String getUserName() {
//        return userName;
//    }
//
//    /**
//     * @param userName the userName to set
//     */
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    /**
//     * @return the password
//     */
//    public String getPassword() {
//        return password;
//    }
//
//    /**
//     * @param password the password to set
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /**
//     * @return the type
//     */
//    public char getType() {
//        return type;
//    }
//
//    /**
//     * @param type the type to set
//     */
//    public void setType(char type) {
//        this.type = type;
//    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + ", type=" + type + '}';
    }
    
    /**
     * User to run this class from the command line.
     * @param args The parameters passed to this class from stdin.
     */
    public static void main(String args[]){
        User user = new User("UserFirstName", "UserLastName", "UserUserName","password",'u');
    }
  
    
}
