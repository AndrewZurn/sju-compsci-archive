package csci230radomskizurnhardy;

/**
 * A class that will be extended by Admin and User to hold data values that are
 * similar between the two classes.
 *
 * @author Andrew Zurn, Wiley Radomski, Preston Hardy
 * @version 1.0
 */
public abstract class Person {

    /**
     * first name to be associated with the person.
     */
    private String firstName;
    /**
     * last name to be associated with the person.
     */
    private String lastName;
    /**
     * user name to be associated with the person.
     */
    private String userName;
    /**
     * password to be associated with the person.
     */
    private String password;
    /**
     * type of user to be associated with the person.
     */
    private char type;
    /**
     * status of user to be associated with the person
     */
    private char status;

    /**
     * Will be used to construct the representation of the person.
     *
     * @param firstName First name of the person.
     * @param lastName Last name of the person.
     * @param userName User name of the person.
     * @param password Pass word of the person.
     * @param type Type of user that the person is.
     * @param status Whether the person is active or not
     */
    public Person(String firstName, String lastName, String userName, String password, char type, char status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    /**
     * Will return the first name of the person.
     *
     * @return first name of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Will set the first name of the person
     *
     * @param firstName the first name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Will return the last name of the person.
     *
     * @return the last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Will set the last name of the person
     *
     * @param lastName the last name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Will return the first name of the person.
     *
     * @return the user name of the person.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Will set the username of the person
     *
     * @param userName the userName of the person
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Will return the password of the person.
     *
     * @return the password of the person.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Will set the password of the person.
     *
     * @param password the password of the person.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Will return the type of user that the person is.
     *
     * @return the type of user the person is.
     */
    public char getType() {
        return type;
    }

    /**
     * Will set the type of user that the person is.
     *
     * @param type the type of user of the person.
     */
    public void setType(char type) {
        this.type = type;
    }
    /**
     * status of user to be associated with the person
     * @return the status
     */
    public char getStatus() {
        return status;
    }

    /**
     * status of user to be associated with the person
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * A method to return the current values of person in the form of a string.
     *
     * @return the values currently stored in person.
     */
    @Override
    public String toString() {
        return ("\n-Person-\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + userName + "\nPassword: "
                + password + "\nType: " + type + "\nStatus: " + status );
    }
    
    public static void main(String args[]) {
        
    }
}
