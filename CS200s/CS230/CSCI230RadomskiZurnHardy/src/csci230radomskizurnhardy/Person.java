package csci230radomskizurnhardy;

/**
 *
 * @author wjradomski
 */



public abstract class Person {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private char type;
    
    public Person(String firstName, String lastName, String userName, String password, char type){
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.type = type;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + getFirstName() + ", lastName=" + getLastName() + ", userName=" + getUserName() + ", password=" + getPassword() + ", type=" + getType() + '}';
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
      
    
}
