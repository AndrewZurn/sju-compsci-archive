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
  //Variables of type statement
  private Statement stmt1, stmt2;
  //Variables of type ResultSet which will contain query output
  private ResultSet rs;
  
  public JDBC(){   
    try{
      //Load driver and link to driver manager
      Class.forName("com.mysql.jdbc.Driver");
      //Create a connection to the specified database ("jdbc:mysql://HOSTNAME:PORT/DATABASE","USERNAME","PASSWORD")
      myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/college","monty", "foo");
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
  
  
  public void InsertStudentTable(String ID, String name, String dept){
    try{
      //Create a statement using the connection object
      stmt1 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Insert Into Student Values('"+ID+"', '"+name+"' , '" + dept+ "')";
      System.out.println(queryString);
     //Execute the SQL statement
      int result = stmt1.executeUpdate(queryString);
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  
  public void QueryStudentTable(String name){
    try{
      //Create a statement using the connection object
      stmt2 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Select * from Student where Name like '%"+name+"%'";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      System.out.println(queryString);
      while (rs.next())
      {
        System.out.println("Name = "+rs.getString("Name")+", ID = "+rs.getString("ID")+", Dept = "+rs.getString("Major"));
      }
      System.out.println();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  
  public void closeDatabaseVariables(){
    try{
      //Close all database variables (ResultSet, Statment, and Connection)
      rs.close();
      stmt1.close();
      stmt2.close();
      myConnection.close();
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    try{
      //Creates a new class object
      JDBC myJDBC = new JDBC();
      myJDBC.InsertStudentTable("99999","The Boss", "CHEM");
      myJDBC.QueryStudentTable("e");
      myJDBC.closeDatabaseVariables();
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
}

