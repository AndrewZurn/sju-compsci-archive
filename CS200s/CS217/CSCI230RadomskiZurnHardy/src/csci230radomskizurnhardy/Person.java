/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Person(String firstName, String lastName, String username, String password, char type){
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.type = type;
    }
      
}
