package universities;

import java.util.*;
//library needed to connect to, retrieve data from, and modify data in the database
import java.sql.*;

/**
 * Class UniversityDBLibrary allows data retrievals from the database to be 
 * utilized by your CSCI230 class project. It also allows class users to insert, 
 * delete and update data. 
 * 
 * Notice that all class methods are static which implies that they should be 
 * accessed directly via the class name rather than an instance of the class; 
 * e.g., to call method getX(), the caller should issue the following Java 
 * statement: UniversityDBLibrary.getX()
 * 
 * @author irahal
 * @version 1.2
 * @since March 2, 2012
 */
public class UniversityDBLibrary {

    /**
     * A private helper method used by other methods in this class to connect 
     * to the database. 
     * This method SHOULD NOT be used outside this class.
     * 
     * @return a Connection object required by methods of this class to connect 
     * to the database
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    private static Connection openDBConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu/Universities", "monty", "foo");
            return conn;
        } catch (ClassNotFoundException cnfe) {
            return null;
        }
    }

    /**
     * A private helper method used by other methods in this class to convert 
     * data returned from the database in the form of a ResultSet object into a 
     * 2-D array of Strings. 
     * This method SHOULD NOT be used outside this class.
     * 
     * @param rs a ResultSet object containing the data returned from the 
     * database
     * @return a 2-D array of Strings containing the data in the input 
     * ResultSet object. Please note that usually not all data in the input 
     * ResultSet object is of type String. However, for convenience, everything 
     * - including number data - is converted into type String in order to be 
     * stored and returned in a single 2D array. All methods in this class that 
     * return data to your application use this method; thus, it is left up to 
     * the programmer to cast non-String data correctly (using Java methods like 
     * Integer.parseInt(String s) and Double.pareDouble(String s)). A null is 
     * returned if the input ResultSet is empty.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
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

    /**
     * A private helper method used by other methods in this class to display 
     * data returned from the database for testing purposes.
     * This method SHOULD NOT be used outside this class.
     * 
     * @param table a 2-D array of Strings containing data from the database
     */
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

    /**
     * A private helper method used by other methods in this class to retrieve 
     * data from the database by passing a properly formatted SELECT SQL query 
     * String.
     * This method SHOULD NOT be used outside this class.
     * 
     * @param queryString the input SELECT SQL query String to be used to 
     * retrieve data from the database
     * @return a 2-D array of Strings containing the data returned from database 
     * in response to the query. A null is returned if there are no matches in 
     * the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    private static String[][] issueDBURead(String queryString) throws SQLException {
        String[][] result;
        Connection conn = UniversityDBLibrary.openDBConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        if (!rs.next()) {
            return null;
        } else {
            result = UniversityDBLibrary.wrapper(rs);
            rs.close();
            stmt.close();
            conn.close();
            return result;
        }
    }

    /**
     * A private helper method used by other methods in this class to modify 
     * data in the database by passing a properly formatted INSERT, UPDATE, or 
     * DELETE SQL query String.
     * This method SHOULD NOT be used outside this class.
     * 
     * @param queryString the input INSERT, UPDATE, or DELETE SQL query String 
     * to be used to modify data in the database
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    private static void issueDBUpdate(String queryString) throws SQLException {
        Connection conn = UniversityDBLibrary.openDBConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(queryString);
        stmt.close();
        conn.close();
    }

    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * users in the database. Every array row contains a user record which, in 
     * turn, is made up of the following fields: Id int (a new unique number is 
     * assigned for every user), FirstName String, LastName String, Username 
     * String (must be unique among users), Password String, Type char (can be 
     * either 'a' for administrators or 'u' for regular users), Status char (can 
     * be either 'Y' for active accounts or 'N' inactive ones). Records in the 
     * array are sorted by user Id in ascending order.
     * 
     * For example, the following Java statement:
     *      String[][] allUsers = UniversityDBLibrary.getAllUsers() 
     * will store all system users in array allUsers. The Username and password 
     * fields for the first user would be stored in allUsers[0][3] and 
     * allUsers[0][4], respectively.
     * 
     * @return a 2-D array of Strings containing all users in the database. A 
     * null is returned if there are no users in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    public static String[][] getAllUsers() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from User Order by Id");
    }

    /**
     * When called, this method returns a 2-D array of Strings containing the 
     * record(s) of the user(s) whose Username is specified as a parameter.
     * 
     * @param username a String containing the Username of the desired user(s)
     * @return a 2-D array of Strings containing the record(s) of the user(s) 
     * whose Username is specified as a parameter. A null is returned if no such 
     * users exist in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUsers()      
     */
    public static String[][] getSpecificUser(String username) throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from User where Username='" + username + "'");
    }

    /**
     * When called, this method returns a 2-D array of Strings containing the 
     * record of the user whose Id is specified as a parameter.
     * 
     * @param Id an integer representing the Id of the desired user
     * @return a 2-D array of Strings containing the record of the user 
     * whose Id is specified as a parameter. A null is returned if no such 
     * user exists in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUsers() 
     */    
    public static String[][] getSpecificUser(int Id) throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from User where Id=" + Id);
    }

    /**
     * When called, this method creates a new user record using the information 
     * provided in the parameters. The user will be active by default and will 
     * be assigned a unique Id equal to one plus the current largest Id among 
     * all users in the database. Callers of this method must ensure that the
     * specified username is unique among all users, otherwise, an SQLException 
     * is thrown.
     * 
     * @param firstName a String containing the first name for the new user
     * @param lastName a String containing the last name for the new user
     * @param username a String containing the username for the new user which 
     * must be unique among all users
     * @param password a String containing the password for the new user
     * @param type should be either 'a' for administrators or 'u' for regular 
     * users
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block. This 
     * method also throws an SQLException if the specified username is not 
     * unique among all users.
     * @see #getAllUsers() 
     */
    public static void addUser(String firstName, String lastName, String username, String password, char type) throws SQLException {
        String query = "Insert Into User Values(null,'" + firstName + "','"
                + lastName + "','"
                + username + "','"
                + password + "','"
                + type + "','"
                + "Y')";
        UniversityDBLibrary.issueDBUpdate(query);
    }

    /**
     * When called, this method changes the status of the user, whose username 
     * is specified as a parameter, to inactive. In other words, it sets user 
     * status to 'N' instead of 'Y'. Nothing happens if an invalid username 
     * is specified.
     * 
     * @param username a String containing the username of the user whose 
     * account is being deactivated 
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #deactivateUser(int Id)
     * @see #getAllUsers() 
     */
    public static void deactivateUser(String username) throws SQLException {
        String query = "Update User set Status = 'N' where Username='" + username + "'";
        UniversityDBLibrary.issueDBUpdate(query);
    }
    /**
     * When called, this method changes the status of the user, whose Id is 
     * specified as a parameter, to inactive. In other words, it sets user 
     * status to 'N' instead of 'Y'. Nothing happens if an invalid Id is 
     * specified.
     * 
     * @param Id an integer representing the Id of the user whose account is 
     * being deactivated 
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #deactivateUser(String username)
     * @see #getAllUsers() 
     */
    public static void deactivateUser(int Id) throws SQLException {
        String query = "Update User set Status = 'N' where Id=" + Id;
        UniversityDBLibrary.issueDBUpdate(query);
    }
    /**
     * When called, this method updates the record of the user, whose username 
     * is specified as a parameter, using the information provided in the 
     * parameters. The user fields that can be modified are: first name, last 
     * name and password. This method will not modify the rest of the fields in 
     * the user's record. Nothing happens if an invalid username is specified.
     * 
     * @param username a String containing the username of the user whose 
     * account is being modified 
     * @param firstName a String containing the new first name for the user
     * @param lastName a String containing the new last name for the  user
     * @param password a String containing the new password for the user
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #getAllUsers() 
     */
    public static void editUser(String username, String firstName, String lastName, String password) throws SQLException {
        String query = "Update User set FirstName = '" + firstName + "',"
                + " LastName = '" + lastName + "',"
                + " Password = '" + password + "'"
                + " where Username='" + username + "'";
        UniversityDBLibrary.issueDBUpdate(query);
    }
    
    /**
     * When called, this method updates the record of the user,  whose Id is 
     * specified as a parameter, using the information provided in the 
     * parameters. The user fields that can be modified are: first name, last 
     * name and password. This method will not modify the rest of the fields in 
     * the user's record. Nothing happens if an invalid Id is specified.
     * 
     * @param Id an integer representing the Id of the user whose account is 
     * being modified 
     * @param firstName a String containing the new first name for the user
     * @param lastName a String containing the new last name for the  user
     * @param password a String containing the new password for the user
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #getAllUsers() 
     */
    public static void editUser(int Id, String firstName, String lastName, String password) throws SQLException {
        String query = "Update User set FirstName = '" + firstName + "',"
                + " LastName = '" + lastName + "',"
                + " Password = '" + password + "'"
                + " where Id=" + Id;
        UniversityDBLibrary.issueDBUpdate(query);
    }
        
    /**
     * When called by an administrator, this method updates the record of the 
     * user, whose username is specified as a parameter, using the information 
     * provided in the parameters. The user fields that can be modified are: 
     * first name, last name, password, type, and status. Nothing happens if an 
     * invalid username is specified.
     * 
     * @param username a String containing the username of the user whose 
     * account is being modified 
     * @param firstName a String containing the new first name for the user
     * @param lastName a String containing the new last name for the  user
     * @param password a String containing the new password for the user
     * @param type a char which should be either 'a' for administrators or 'u' 
     * for regular users       
     * @param status a char which should be either 'Y' for active accounts or 
     * 'N' for inactive accounts
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #getAllUsers() 
     */
    
    public static void editUserByAdmin(String username, String firstName, String lastName, String password, char type, char status) throws SQLException {
        String query = "Update User set FirstName = '" + firstName + "',"
                + " LastName = '" + lastName + "',"
                + " Password = '" + password + "',"
                + " Status = '" + status + "',"
                + " Type = '" + type + "'"
                + " where Username='" + username + "'";
        UniversityDBLibrary.issueDBUpdate(query);
    }
    
   /**
     * When called by an administrator, this method updates the record of the 
     * user, whose Id is specified as a parameter, using the information 
     * provided in the parameters. The user fields that can be modified are: 
     * first name, last name, password, type, and status. Nothing happens if an 
     * invalid Id is specified.
     * 
     * @param username a String containing the username of the user whose 
     * account is being modified 
     * @param firstName a String containing the new first name for the user
     * @param lastName a String containing the new last name for the  user
     * @param password a String containing the new password for the user
     * @param type a char which should be either 'a' for administrators or 'u' 
     * for regular users       
     * @param status a char which should be either 'Y' for active accounts or 
     * 'N' for inactive accounts
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block.
     * @see #getAllUsers() 
     */
    
    public static void editUserByAdmin(int Id, String firstName, String lastName, String password, char type, char status) throws SQLException {
        String query = "Update User set FirstName = '" + firstName + "',"
                + " LastName = '" + lastName + "',"
                + " Password = '" + password + "',"
                + " Status = '" + status + "',"
                + " Type = '" + type + "'"
                + " where Id=" + Id;
        UniversityDBLibrary.issueDBUpdate(query);
    }  
    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * universities in the database. Every array row contains a university 
     * record which, in turn, is made up of the following fields: School String 
     * (must be unique among universities), State String, Location String, 
     * Control String, NumberOfStudents int, PercentFemales double (between 0 
     * and 100), SATVerbal double (up to 800), SATMath double (up to 800), 
     * Expenses double, PercentFinancialAid double (between 0 and 100), 
     * NumberOfApplicants int, PercentAdmitted double (between 0 and 100), 
     * PercentEnrolled double (between 0 and 100), AcademicsScale int (between 
     * 1 and 5 where is best), SocialScale int (between 1 and 5 where is best), 
     * QualityOfLifeScale int (between 1 and 5 where is best). Records in the 
     * array are sorted by School name in ascending order.
     * 
     * For example, the following Java statement 
     *      String[][] allUnivs = UniversityDBLibrary.getAllUniversities() 
     * will store all universities in array allUnivs. The State and SATVerbal 
     * fields for the first university would be stored in allUnivs[0][1] and 
     * allUser[0][6], respectively.
     * 
     * Please note that some universities have missing field information which 
     * have been indicated by the String "-1" for String fields and the number 
     * -1 for number fields.
     * 
     * @return a 2-D array of Strings containing all universities in the 
     * database. A null is returned if there are no universities in the 
     * database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #addUniversity(java.lang.String, java.lang.String, java.lang.String, 
     *                     java.lang.String, int, double, double, double, 
     *                     double, double, int, double, double, int, int, int) 
     */    
    public static String[][] getAllUniversities() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from University Order by School");
    }
      
    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * possible university emphases that occur in the database. Every array row 
     * contains a single field storing an occurring emphasis. Duplicate emphases 
     * are eliminated. Records in the array are sorted by emphasis in ascending 
     * order.
     * 
     * @return a 2-D array of Strings containing all possible university 
     * emphases that occur in the database. A null is returned if no 
     * universities have emphases in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    public static String[][] getAllPossibleEmphases() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select distinct Area from Emphasis Order by Area");
    }
    
    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * university names along with their emphases in the database. Every array 
     * row contains a pair (university name, emphasis) both of which are 
     * Strings. Universities with multiple emphases will have their names repeat 
     * multiple times in the array each time with a different emphasis. 
     * Universities with no emphases will not be included in the output array. 
     * Records in the array are sorted first by school name and then by emphasis 
     * in ascending order.
     * 
     * @return a 2-D array of Strings containing all (university name, emphasis)
     * pairs in the database. A null is returned if no universities have 
     * emphases in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     */
    public static String[][] getAllUniversityNamesWithEmphases() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from Emphasis Order by School, Area");
    }


    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * university records along with their emphases in the database. Every array 
     * row contains a complete university record followed by an emphasis. 
     * Universities with multiple emphases will have their records repeat 
     * multiple times in the array each time with a different emphasis. 
     * Universities with no emphases will not be included in the output array. 
     * Records in the array are sorted first by school name and then by emphasis 
     * in ascending order.
     * 
     * @return a 2-D array of Strings containing all university records each 
     * followed by an emphasis. A null is returned if there are no universities
     * have emphasis in the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUniversities() 
     * @see #getAllEmphases() 
     */
    public static String[][] getAllUniversityRecordsWithEmphases() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select u.*, Area from University u,Emphasis e where u.School = e.School Order by u.School, Area");
    }

    /**
     * When called, this method returns a 2-D array of Strings containing the 
     * record of the university whose name is specified in the parameter along 
     * with the emphases of the university in the database. Every array 
     * row contains the complete university record followed by an emphasis. 
     * If the university has multiple emphases, its record will repeat 
     * multiple times in the array each time with a different emphasis. 
     * A null is returned if the university has no emphasis in the database or 
     * if an invalid university name is provided. Records in the array are 
     * sorted by emphasis in ascending order.
     * 
     * @param University a String containing the name of desired university
     * @return a 2-D array of Strings containing the record of the university 
     * whose name is specified in the parameter along with the emphases of the 
     * university in the database. A null is returned if the university has no 
     * emphasis in the database or if an invalid university name is provided as 
     * a parameter. Records in the array are sorted by emphasis in ascending 
     * order.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUniversities() 
     * @see #getAllUniversityRecordsWithEmphases() 
     */   
    
    public static String[][] getSpecificUniversityRecordWithEmphases(String University) throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from Emphasis where School  like '" + University + "' order by Area");
    }

    /**
     * When called, this method creates a new university record using the 
     * information provided in the parameters. Callers of this method must 
     * ensure that the school name is unique among all universities, otherwise, 
     * an SQLException is thrown.
     * 
     * @param school a String containing the name for the new university which 
     * must be unique among all universities
     * @param state a String containing the state in which the new university is 
     * located. Specify "-1" if the value of this field is unknown. Specify 
     * "FOREIGN" if the university is located outside the US
     * @param location a String specifying the type of area in which the new 
     * university is located. Possible values are "SUBURBAN", "URBAN" and 
     * "SMALL-CITY".  Specify "-1" if the value of this field is unknown
     * @param control a String specifying who controls the new university. 
     * Possible values are "PRIVATE", "STATE" and "CITY". Specify "-1" if the 
     * value of this field is unknown
     * @param numberOfStudents an integer representing the number of students 
     * currently enrolled in the new university
     * @param percentFemales a double out of 100 representing the percentage of 
     * females in the student population
     * @param SATVerbal a double out of 800 representing the average SAT Verbal 
     * exam score for all students currently enrolled in the new university
     * @param SATMath a double out of 800 representing the average SAT Math 
     * exam score for all students currently enrolled in the new university
     * @param expenses a double representing the annual tuition for the new 
     * university
     * @param percentFinancialAid a double out of 100 representing the 
     * percentage of students receiving any form sort of financial assistance 
     * from the new university
     * @param percentAdmitted a double out of 100 representing the percentage 
     * of applicants who are admitted annually to the new university
     * @param percentEnrolled a double out of 100 representing the percentage 
     * of admitted students who enroll in the new university
     * @param academicsScale an int between 1 and 5 (with 5 being best) 
     * indicating the quality of the academics at the new university 
     * @param socialScale an int between 1 and 5 (with 5 being best) 
     * indicating the quality of the social life at the new university 
     * @param qualityOfLifeScale an int between 1 and 5 (with 5 being best) 
     * indicating the overall quality of life at the new university 
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUniversities() 
     */
   
    public static void addUniversity(String school, String state, String location, String control, int numberOfStudents, double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) throws SQLException {
        String query = "Insert Into University Values('" + school + "','"
                + state + "','"
                + location + "','"
                + control + "',"
                + numberOfStudents + ","
                + percentFemales + ","
                + SATVerbal + ","
                + SATMath + ","
                + expenses + ","
                + percentFinancialAid + ","
                + numberOfApplicants + ","
                + percentAdmitted + ","
                + percentEnrolled + ","
                + academicsScale + ","
                + socialScale + ","
                + qualityOfLifeScale + ")";
        UniversityDBLibrary.issueDBUpdate(query);
    }
    
    /**
     * When called, this method updates the university record for the university 
     * whose name is specified as a parameter, using the information provided in 
     * the parameters. This method can update all university fields except for 
     * the emphases which are processed separately. Nothing happens if an 
     * invalid university name is specified.
     * 
     * @param school a String containing the name for the university being 
     * updated
     * @param state a String containing the updated state in which the 
     * university being updated is located. Specify "-1" if the value of this 
     * field is unknown.
     * @param location a String specifying the updated type of area in which the 
     * university being updated is located. Possible values are "SUBURBAN", 
     * "URBAN" and "SMALL-CITY".  Specify "-1" if the value of this field is 
     * unknown
     * @param control a String specifying who controls the university  being 
     * updated. Possible values are "PRIVATE", "STATE" and "CITY". Specify "-1" 
     * if the value of this field is unknown
     * @param numberOfStudents an integer representing the updated number of 
     * students currently enrolled in the university being updated
     * @param percentFemales a double out of 100 representing the updated 
     * percentage of females in the student population
     * @param SATVerbal a double out of 800 representing the updated average SAT
     * Verbal exam score for all students currently enrolled in the university 
     * being updated
     * @param SATMath a double out of 800 representing the updated average SAT
     * Math exam score for all students currently enrolled in the university 
     * being updated
     * @param expenses a double representing the updated annual tuition for the 
     * university being updated
     * @param percentFinancialAid a double out of 100 representing the updated
     * percentage of students receiving any form sort of financial assistance 
     * from the university being updated
     * @param percentAdmitted a double out of 100 representing the updated 
     * percentage of applicants who are admitted annually to the university 
     * being updated
     * @param percentEnrolled a double out of 100 representing the updated 
     * percentage of admitted students who enroll in the university being 
     * updated
     * @param academicsScale an int between 1 and 5 (with 5 being best) 
     * indicating the updated quality of the academics at the university being 
     * updated
     * @param socialScale an int between 1 and 5 (with 5 being best) 
     * indicating the updated quality of the social life at the university being 
     * updated
     * @param qualityOfLifeScale an int between 1 and 5 (with 5 being best) 
     * indicating the updated overall quality of life at the university being 
     * updated
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllUniversities() 
     */
    public static void editUniversity(String school, String state, String location, String control, int numberOfStudents, double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) throws SQLException {
        String query = "Update University set   "
                + "State               ='" + state + "'"
                + ",Location            ='" + location + "'"
                + ",Control             ='" + control + "'"
                + ",NumberOfStudents    = " + numberOfStudents
                + ",PercentFemales      = " + percentFemales
                + ",SATVerbal           = " + SATVerbal
                + ",SATMath             = " + SATMath
                + ",Expenses            = " + expenses
                + ",PercentFinancialAid = " + percentFinancialAid
                + ",NumberOfApplicants  = " + numberOfApplicants
                + ",PercentAdmitted     = " + percentAdmitted
                + ",PercentEnrolled     = " + percentEnrolled
                + ",AcademicsScale      = " + academicsScale
                + ",SocialScale         = " + socialScale
                + ",QualityOfLifeScale  = " + qualityOfLifeScale
                + " Where School = '" + school + "'";
        UniversityDBLibrary.issueDBUpdate(query);
    }

    /**
     * When called, this method adds a new emphasis area for the specified 
     * school. Nothing happens if an invalid school name is specified or if the 
     * specified emphasis already exists for the specified school
     * 
     * @param school a String containing the name of the school for which the 
     * new emphasis area is being added
     * @param emphasis a String containing the new emphasis to be added to the 
     * specified school
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllPossibleEmphases() 
     * @see #getAllUniversityNamesWithEmphases() 
     * @see #getAllUniversityRecordsWithEmphases() 
     */
    public static void addUniversityEmphasis(String school, String emphasis) throws SQLException {
        String query = "Insert Into Emphasis Values('" + school + "','" + emphasis + "')";
        UniversityDBLibrary.issueDBUpdate(query);
    }
    
    /**
     * When called, this method deletes all the old emphasis areas for the 
     * specified school from the database and replaces them with the ones 
     * specified in the ArrayList parameter. Nothing happens if an invalid 
     * school name is specified.
     * 
     * @param school a String containing the name of the school for which the 
     * emphasis areas are being added
     * @param emphases an ArrayList<String> containing the new emphases to be 
     * added to the specified school in place of the old ones
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #addUniversityEmphasis(java.lang.String, java.lang.String) 
     */    
    public static void editUniversityEmphases(String school, ArrayList<String> emphases) throws SQLException {
        String query = "delete from Emphasis where School='" + school + "'";
        UniversityDBLibrary.issueDBUpdate(query);
        for (String s : emphases) {
            UniversityDBLibrary.addUniversityEmphasis(school, s);
        }
    }

    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * user Ids along with their saved schools in the database. Every array 
     * row contains a pair (user Id, school). Users with multiple saved schools 
     * will have their Ids repeat multiple times in the array each time with a 
     * different school. Users with no saved schools will not be included in the 
     * output array. Records in the array are sorted first by user Id and then 
     * by school in ascending order.
     * 
     * @return a 2-D array of Strings containing all (user Id, school) pairs in 
     * the database. A null is returned if no users have any saved schools in 
     * the database.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #addUserSchool(int, java.lang.String)
     */
    public static String[][] getAllSavedSchools() throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select * from MySavedSchools Order by Id, School");
    }

    /**
     * When called, this method returns a 2-D array of Strings containing all 
     * the saved schools for the user whose Id is provided as a parameter. Every 
     * array row contains a single school column. A null is returned if the 
     * user has no saved schools in the database or if an invalid userId is 
     * provided. Records in the array are sorted by school name in ascending 
     * order.
     *      
     * @param Id an integer representing the Id of the user whose saved schools 
     * are sought
     * @return 2-D array of Strings containing all the saved schools for the 
     * user whose Id is provided as a parameter. Every array row contains a 
     * single school column. A null is returned if the user has no saved schools 
     * in the database or if an invalid userId is provided. Records in the array 
     * are sorted by school name in ascending order.
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllSavedSchools() 
     * @see #addUserSchool(int, java.lang.String)
     */  
    public static String[][] getSavedSchools(int Id) throws SQLException {
        return UniversityDBLibrary.issueDBURead("Select School from MySavedSchools where Id =" + Id + " Order by School");
    }

    /**
     * When called, this method saves the specified school to the  user's list 
     * of saved schools. Nothing happens if an invalid user Id is specified or 
     * if the specified school is already in user's list of saved schools
     * 
     * @param Id an int representing the user for whom the specified school is 
     * being saved
     * @param school a String containing the school to be saved to the user's 
     * list of saved schools
     * @return true if the specified shool was successfully added to the user's 
     * list of saved schools or false otherwise
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllSavedSchools() 
     * @see #getSavedSchools(int) 
     */
    public static boolean addUserSchool(int Id, String school) throws SQLException {
        String query = "select * from MySavedSchools where Id=" + Id + " and School like '" + school + "'";
        System.out.println(query);
        String[][] table = UniversityDBLibrary.issueDBURead(query);

        if (table == null || table.length == 0) {
            query = "insert into MySavedSchools values(" + Id + ",'" + school + "')";
            UniversityDBLibrary.issueDBUpdate(query);
            return true;
        }
        return false;
    }
    /**
     * When called, this method removed the specified school from the  user's 
     * list of saved schools. Nothing happens if an invalid user Id is specified 
     * or if the specified school is not already in user's list of saved schools
     * 
     * @param Id an int representing the user for whom the specified school is 
     * being removed
     * @param school a String containing the school to be removed from the 
     * user's list of saved schools
     * @throws SQLException is always thrown when this method is called 
     * requiring callers to include the call inside a try/catch block
     * @see #getAllSavedSchools() 
     * @see #getSavedSchools(int) 
     */
    public static void removeUserSchool(int Id, String school) throws SQLException {
        String query = "delete from MySavedSchools where Id=" + Id + " and School='" + school + "'";
        UniversityDBLibrary.issueDBUpdate(query);
    }

    public static void main(String[] args) {
        try {
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUsers());
            //UniversityDBLibrary.display(UniversityDBLibrary.getSpecificUser("nadmin"));
            //UniversityDBLibrary.display(UniversityDBLibrary.getSpecificUser(1));
            //UniversityDBLibrary.addUser("Imad2", "Rahal2", "Imad2", "Rahal2", 'a');
            //UniversityDBLibrary.editUser("Imad", "Rahal", "Imad", "Rahal");
            //UniversityDBLibrary.editUser(8, "Rahal0", "Imad0", "Rahal");
            //UniversityDBLibrary.editUserByAdmin("luser", "Lynn", "User", "user", 'u','N');
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUsers());
            //UniversityDBLibrary.editUserByAdmin(3, "Lynn", "User", "user", 'u','N');
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUsers());

            //UniversityDBLibrary.deactivateUser("Imad");
            //UniversityDBLibrary.deactivateUser(7);

            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUniversities());
            //UniversityDBLibrary.addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1);
            //UniversityDBLibrary.editUniversity("x","xX","xX","xX",2,2,2,2,2,2,2,2,2,2,2,2);
            //UniversityDBLibrary.addUniversityEmphasis("x", "1224");
            //UniversityDBLibrary.addUniversityEmphasis("x", "1234");
            //UniversityDBLibrary.addUniversityEmphasis("x", "1244");

            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUniversityNamesWithEmphases());
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllUniversityRecordsWithEmphases());
            //ArrayList<String> xxx = new ArrayList<String>();
            //xxx.add("1");
            //xxx.add("2");
            //xxx.add("3");
            //UniversityDBLibrary.editUniversityEmphases("x", xxx);
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllPossibleEmphases());
            //UniversityDBLibrary.display(UniversityDBLibrary.getSpecificUniversityRecordWithEmphases("AUBURN"));

            //UniversityDBLibrary.display(UniversityDBLibrary.getAllSavedSchools());

            //System.out.println(UniversityDBLibrary.addUserSchool(3,"AUBURN"));
            //System.out.println(UniversityDBLibrary.addUserSchool(3,"AUBURN"));
            //UniversityDBLibrary.display(UniversityDBLibrary.getAllSavedSchools());
            //UniversityDBLibrary.removeUserSchool(2, "AUBURN");
            UniversityDBLibrary.display(UniversityDBLibrary.getSavedSchools(2));
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}
