/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csbsju.csci230;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author irahal
 */
public class UserDBLibrary {
   
    private static Connection openDBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu/CS230JSP", "monty", "foo");
            return conn;
        } catch (ClassNotFoundException cnfe) {
            return null;
        }
    }

 
    private static String[][] wrapper(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        int rows = 1;
        while (rs.next()) {
            rows++;
        }
        String[][] result = new String[rows][cols];
        rs.beforeFirst();
        int currRow = 0;
        while (rs.next()) {
            for (int currCol = 0; currCol < cols; currCol++) {
                result[currRow][currCol] = rs.getString(currCol + 1);
            }
            currRow++;
        }
        return result;
    }

   
    private static void display(String[][] table) {
        if(table!=null){
            for (int row = 0; row < table.length; row++) {
                for (int col = 0; col < table[0].length; col++) {
                    System.out.print(table[row][col] + "\t");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Nothing to display");
        }
    }

    private static String[][] issueDBURead(String queryString) throws SQLException {
        String[][] result;
        Connection conn = UserDBLibrary.openDBConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        if (!rs.next()) {
            return null;
        } else {
            result = UserDBLibrary.wrapper(rs);
            rs.close();
            stmt.close();
            conn.close();
            return result;
        }
    }


    private static void issueDBUpdate(String queryString) throws SQLException {
        Connection conn = UserDBLibrary.openDBConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(queryString);
        stmt.close();
        conn.close();
    }

   /** Every row contains the following (and in the given order):
    *       FULLNAME 	String,
    *       USERNAME 	String  (MUST BE UNIQUE)
    *       PASSWORD 	String,
    *       AGE 	int,
    *       CITY	String, and
    *       STATE 	String
    */
    public static String[][] getAllUsers() throws SQLException {
        return UserDBLibrary.issueDBURead("Select * from USERS Order by USERNAME");
    }


    public static String[][] getSpecificUser(String username) throws SQLException {
        return UserDBLibrary.issueDBURead("Select * from USERS where USERNAME='" + username + "'");
    }

    public static void addUser(String fullname, String username, String password, int age, String city, String state) throws SQLException {
       String query = "Insert Into USERS Values('" + fullname + "','"
                + username + "','"
                + password + "',"
                + age + ",'"
                + city + "','"
                + state+ "')";
                UserDBLibrary.issueDBUpdate(query);
    }

    public static void editUser(String username, String fullname, String password, int age, String city, String state) throws SQLException {
        String query = "Update USERS set FULLNAME = '" + fullname + "',"
                    + " PASSWORD = '" + password + "',"
                    + " AGE = " + age + ","
                    + " CITY = '" + city + "',"
                    + " STATE = '" + state + "'"
                    + " where USERNAME='" + username + "'";
                UserDBLibrary.issueDBUpdate(query);
    }
    
    public static void deleteUser(String username) throws SQLException {
        String query = "Delete from USERS where USERNAME='" + username + "'";
        UserDBLibrary.issueDBUpdate(query);
    }
   public static void main (String[] args){
       try{
        System.out.println("USERS currently enrolled:");
        UserDBLibrary.display(UserDBLibrary.getAllUsers());
        System.out.println();
        System.out.println();
        System.out.println("Enrolling a new user:");
        UserDBLibrary.addUser("Bill Ding","bill","ding",42,"Aspen","CO");
        System.out.println("Enrolling a the same user:");
        //USERMGMT.addUser("Bill Ding","bill","ding",42,"Aspen","CO");
        System.out.println();
        System.out.println();
        System.out.println("Get new user:");
        UserDBLibrary.display(UserDBLibrary.getSpecificUser("bill"));
        System.out.println();
        System.out.println();
        System.out.println("USERS currently enrolled:");
        UserDBLibrary.display(UserDBLibrary.getAllUsers());
        System.out.println();
        System.out.println();
        System.out.println("Editing a user:");
        UserDBLibrary.editUser("bill","Billy Dingo","dingo",46,"Fargo","ND");
        System.out.println("USERS currently enrolled:");
        UserDBLibrary.display(UserDBLibrary.getAllUsers());
        System.out.println();
        System.out.println();
        System.out.println("Delete a user:");
        UserDBLibrary.deleteUser("bill");
        System.out.println("USERS currently enrolled:");
        UserDBLibrary.display(UserDBLibrary.getAllUsers());
        System.out.println();
        System.out.println();        
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
   }
}
