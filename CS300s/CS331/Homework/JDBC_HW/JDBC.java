//package jdbc;
import java.util.*;
import java.lang.*;
import java.io.*;
//Load JDBC API functions
import java.sql.*;

/**
 * @author irahal
 */
public class JDBC {
  
  //Variable of type database connection
  private Connection myConnection;
  //Variable of type regular statement
  private Statement stmt;
  //Variable of type prepared statement
  private PreparedStatement preparedStmt;
  //Variable of type ResultSet which will contain query output
  private ResultSet result;
  
  public JDBC() throws SQLException, ClassNotFoundException{   
    //Load driver and link to driver manager
    Class.forName("com.mysql.jdbc.Driver");
    //Create a connection to the specified database ("jdbc:mysql://HOSTNAME:PORT/DATABASE","USERNAME","PASSWORD")
    myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/Company","monty", "foo");
    //You could use localhost rather than the actual machine URL if your code is on the same machine as the DBMS server you're connecting to
    //myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/irahal","irahal", "******");
  }
  
  public void RegQuery(int dno) throws SQLException{
    //Create a regular statement using the connection object
    stmt = myConnection.createStatement();
    //A string to hold the SQL statement
    String queryString = "Select pno,pname, Sum(hours) as hours from works_on, project where pno=pnumber and dnum="+dno+" Group By  pno,pname";
    //Execute the query and save resulting table/relation in the ResultSet object
    result = stmt.executeQuery(queryString);
    //Loop thru the ResultSet object printing each tuple twice using the two different ways of
    //accessing tuple attributes from a ResultSet
    System.out.println(queryString);
    System.out.println("REGULAR STATEMENT USING ATTRIBUTE NAMES");
    while (result.next()){
      System.out.println("Project Name:"+result.getString("pname")+ " Total Hours: " + result.getDouble("hours"));
    }
    
    result.beforeFirst();
    System.out.println("REGULAR STATEMENT USING ATTRIBUTE POSITIONS");
    while (result.next()){
      System.out.println("Project Name:"+result.getString(2)+ " Total Hours: " + result.getDouble(3));  
    }    
    System.out.println("***********************************************************************************");
    result.close();
    stmt.close();
  }
  
  public void RegUpdate(String oldLocation,String newLocation) throws SQLException{
    
    //A string to hold the SQL statement
    String queryString = "Update dept_locations set dlocation = '" +newLocation + "' where dlocation ='" + oldLocation+ "'";
    //Create a statement using the connection object...must specify an SQL string as an arguement
    stmt = myConnection.createStatement();
    int returns = stmt.executeUpdate(queryString);
    
    System.out.println(queryString);
    System.out.println("Rows affected " + returns);
    System.out.println("***********************************************************************************");
    stmt.close();
  }
  
  public void PreQuery(int dno) throws SQLException{
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString = "Select pno,pname, Sum(hours) as hours from works_on, project where pno=pnumber and dnum=? Group By  pno,pname";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dno);
    //Execute the query and save resulting table/relation in the ResultSet object
    result = preparedStmt.executeQuery();
    //Loop thru the ResultSet object printing each tuple 
    System.out.println(queryString);
    while (result.next())
    {
      System.out.println("Project Name:"+result.getString(2)+ " Total Hours: " + result.getDouble(3));
    }
    System.out.println("***********************************************************************************");
    result.close();
    preparedStmt.close();
  } 
  
  public void PreInsert(int dnumber, String location) throws SQLException{
    //A string to hold the SQL statement....Notice the use of ? in prepared statements
    String queryString = "INSERT into dept_locations values(?,?)";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dnumber);
    preparedStmt.setString(2,location);
    
    int returns = preparedStmt.executeUpdate();
    System.out.println(queryString);
    System.out.println("Rows affected " + returns);
    System.out.println("***********************************************************************************");
    preparedStmt.close();
  }
  
  public void FunctionCall(int dnumber) throws SQLException{
    //A string to hold the SQL statement....
    String queryString = "select returnNumEmployees(?) as Employee_Count";
    //Create a prepared statement using the connection object...must specify an SQL string as an arguement
    preparedStmt = myConnection.prepareStatement(queryString);
    //Clear all parameters
    preparedStmt.clearParameters();
    //Specify values for all ? in the query string
    preparedStmt.setInt(1,dnumber);
    
    result = preparedStmt.executeQuery();
    System.out.println(queryString);
    if (result.next()){    
      System.out.println("Number of employess in dept " + dnumber + " is " + result.getString("Employee_Count"));
    }
    System.out.println("***********************************************************************************");
    result.close();
    preparedStmt.close();
  }  
  
  
  public void closeDatabaseVariables () throws SQLException{
    //Close all database variables (Connection)
    myConnection.close();
  }
  
  public static void main(String[] args){
    try
    {
      //Creates a new class object
      JDBC myJDBC = new JDBC();
      myJDBC.RegQuery(5);
      myJDBC.RegUpdate("Staford","Stafford");
      myJDBC.PreQuery(5);
      //myJDBC.PreInsert(8,"St Joseph");
      myJDBC.FunctionCall(8);
      
      myJDBC.closeDatabaseVariables();
    }
    catch(SQLException E)
    {
      System.out.println("SQL problems:" + E);
    }
    catch(ClassNotFoundException E)
    {
      System.out.println("MySQL driver problems:" + E);
    }
    
    
  }
  
}

