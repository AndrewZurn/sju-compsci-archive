package csci230radomskizurnhardy;

/**
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.0
 */


public class User extends Person {
/**
 * First Name of a User
 */
    private String firstName;
    /**
     * Last name of a User
     */
    private String lastName;
    /**
     * username of a User
     */
    private String userName;
    /**
     * password of a User
     */
    private String password;
    /**
     * type of a Person, in case of a user must be 'u'
     */
    private char type;
    /**
     * status of user to be associated with the person
     */
    private char status;
    /**
     * Constructor for User
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param type 
     * @param status status of user to be associated with the User
     */

    public User(String firstName, String lastName, String userName,
        String password, char type, char status){
        super(firstName, lastName, userName, password, type, status);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    /**
     * A method to return the current values of user in the form of a string.
     *
     * @return the values currently stored in user.
     */
    @Override
    public String toString() {
        return ("\n-User-\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + userName + "\nPassword: "
                + password + "\nType: " + type + "\nStatus: " + status );
    }

    /**
     * User to run this class from the command line.
     *
     * @param args The parameters passed to this class from stdin.
     */
    public static void main(String args[]) {
        User user = new User("UserFirstName", "UserLastName", "UserUserName", "password", 'u', 'y');
        System.out.println(user.toString());
        user.setFirstName("NewUserFirstName");
        System.out.println("The new First Name for user is: " + user.getFirstName());
        user.setLastName("NewUserLastName");
        System.out.println("The new Last Name for user is: " + user.getLastName());
        user.setUserName("NewUserUserName");
        System.out.println("The new User Name for user is: " + user.getUserName());
        user.setPassword("NewUserPassword");
        System.out.println("The new Password for user is: " + user.getPassword());
        user.setType('u');
        System.out.println("The new type of user for user is: " + user.getType());
        user.setType('n');
        System.out.println("The new type of user for user is: " + user.getStatus());
    }
}
