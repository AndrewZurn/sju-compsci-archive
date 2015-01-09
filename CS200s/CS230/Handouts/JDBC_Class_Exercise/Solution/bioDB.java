//package jdbc;
import java.util.*;
import java.lang.*;
import java.io.*;
//Load JDBC API functions
import java.sql.*; 

/**
 * @author irahal
 */
public class bioDB {
  
  //Variable of type database connection
  private Connection myConnection;
  //Variables of type statement
  private Statement stmt1, stmt2;
  //Variables of type ResultSet which will contain query output
  private ResultSet rs;
  
  public bioDB(){   
    try{
      //Load driver and link to driver manager
      Class.forName("com.mysql.jdbc.Driver");
      //Create a connection to the specified database ("jdbc:mysql://HOSTNAME:PORT/DATABASE","USERNAME","PASSWORD")
      myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/bioDB",
                                                 "monty", "foo");
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
  
  
  public void insertContributorTable(String labName, String city, String state, String country, String contact){
    try{
      //Create a statement using the connection object
      stmt1 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Insert Into Contributor Values('"+labName+"', '"+city+"' , '" + state+ "' , '" + country +"' , '" + contact+"')";
      System.out.println(queryString);
     //Execute the SQL statement
      int result = stmt1.executeUpdate(queryString);
      stmt1.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  
  public void insertGeneTable(String geneName, String gFunction, String gOrganism, String gSequence, String gContributor){
    try{
      //Create a statement using the connection object
      stmt1 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Insert Into Gene Values('"+geneName+"', '"+gFunction+"' , '" + gOrganism+ "' , '" + gSequence +"' , '" + gContributor+"')";
      System.out.println(queryString);
     //Execute the SQL statement
      int result = stmt1.executeUpdate(queryString);
      stmt1.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  

  public void insertProteinTable(String proteinName,String gene, String pFunction, String pOrganism, String pSequence, String pContributor){
    try{
      //Create a statement using the connection object
      stmt1 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Insert Into Protein Values('"+proteinName+"', '"+gene+"' , '" +pFunction+"' , '" + pOrganism+ "' , '" + pSequence +"' , '" + pContributor+"')";
      System.out.println(queryString);
     //Execute the SQL statement
      int result = stmt1.executeUpdate(queryString);
      stmt1.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
    
  public void searchProteinTable(String geneName){
    try{
      //Create a statement using the connection object
      stmt2 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Select * from Protein where Gene like '"+geneName+"'";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      System.out.println(queryString);
      while (rs.next())
      {
        System.out.println("proteinName = "+rs.getString("ProteinName")+", Gene = "+rs.getString("Gene")+", PFunction = "+rs.getString("PFunction") +", POrganism = "+rs.getString("POrganism")+", PSequence = "+rs.getString("PSequence")+", PContributor = "+rs.getString("PContributor"));
      }
      System.out.println();
      rs.close();
      stmt2.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  public void searchGeneTable1(String dna){
    try{
      //Create a statement using the connection object
      stmt2 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Select * from Gene where GSequence like '%"+dna+"%'";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      System.out.println(queryString);
      while (rs.next())
      {
        System.out.println("GeneName = "+rs.getString("GeneName")+", GFunction = "+rs.getString("GFunction") +", GOrganism = "+rs.getString("GOrganism")+", GSequence = "+rs.getString("GSequence")+", GContributor = "+rs.getString("GContributor"));
      }
      System.out.println();
      rs.close();
      stmt2.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  public void searchGeneTable2(String country){
    try{
      //Create a statement using the connection object
      stmt2 = myConnection.createStatement();
      //A string to hold the SQL statement
      String queryString = "Select * from Contributor,Gene where LabName=GContributor and Country ='"+country+"'";
      System.out.println(queryString);
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      
      while (rs.next())
      {
        System.out.println("GeneName = "+rs.getString("GeneName")+", GFunction = "+rs.getString("GFunction") +", GOrganism = "+rs.getString("GOrganism")+", GSequence = "+rs.getString("GSequence")+", GContributor = "+rs.getString("GContributor"));
      }
      System.out.println();
      rs.close();
      stmt2.close();
    }
    catch(Exception E){ 
      E.printStackTrace();
    } 
  }
  
  
  public void closeConnection(){
    try{
      //Close all database variables (ResultSet, Statment, and Connection)
      myConnection.close();
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
  

}

