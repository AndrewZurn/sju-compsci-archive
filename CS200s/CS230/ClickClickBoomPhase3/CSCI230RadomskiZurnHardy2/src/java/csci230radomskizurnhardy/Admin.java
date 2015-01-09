package csci230radomskizurnhardy;

/**
 * A class that will be used to represent an administrator within the CMC
 * system.
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
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
     * status of user to be associated with the person
     */
    private char status;

    /**
     * Will be used to construct the representation of the administrator.
     *
     * @param firstName First name of the admin.
     * @param lastName Last name of the admin.
     * @param userName User name of the admin.
     * @param password Pass word of the admin.
     * @param type Type of user that the admin is.
     * @param status Whether the person is active or not
     */
    public Admin(String firstName, String lastName, String userName,
            String password, char type, char status) {
        super(firstName, lastName, userName, password, type, status);
    }

    @Override
    /**
     * A method to return the current values of admin in the form of a string.
     *
     * @return the values currently stored in admin.
     */
    public String toString() {
        return ("\n-Admin-\nFirst Name: " + super.getFirstName() + "\nLast Name: " 
                + super.getLastName() + "\nUsername: " + super.getUserName() + "\nPassword: "
                + super.getPassword() + "\nType: " + super.getType() + "\nStatus: " + super.getStatus() );
    }

    /**
     * User to run this class from the command line.
     *
     * @param args The parameters passed to this class from stdin.
     */
    public static void main(String args[]) {
        
        Admin admin = new Admin("AdminFirstName", "AdminLastName", "AdminUserName", "password", 'a', 'y');
        System.out.println(admin.toString());
        System.out.println("~We now set all of the Admin's attributes, get them and print them out");
        admin.setFirstName("NewAdminFirstName");
        System.out.println("The new First Name for admin is: " + admin.getFirstName());
        admin.setLastName("NewAdminLastName");
        System.out.println("The new Last Name for admin is: " + admin.getLastName());
        admin.setUserName("NewAdminUserName");
        System.out.println("The new User Name for admin is: " + admin.getUserName());
        admin.setPassword("NewAdminPassword");
        System.out.println("The new Password for admin is: " + admin.getPassword());
        admin.setType('u');
        System.out.println("The new type of user for admin is: " + admin.getType());
        admin.setType('n');
        System.out.println("The new type of user for admin is: " + admin.getStatus());
    }
}
