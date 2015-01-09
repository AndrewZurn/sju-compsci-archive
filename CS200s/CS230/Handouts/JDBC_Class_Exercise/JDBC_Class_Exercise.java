import java.util.*;
import java.lang.*;
import java.io.*;
//Load JDBC API functions
import java.sql.*; 

public class JDBC_Class_Exercise{
  
  
  //Variable of type database connection
  private Connection myConnection;
  //Variables of type statement
  private Statement stmt1, stmt2;
  //Variables of type ResultSet which will contain query output
  private ResultSet rs;
  
  public JDBC_Class_Exercise(){
    try{
      Class.forName("com.mysql.jdbc.Driver");
      myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/bioDB","monty", "foo");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public void InsertNewContributors(String labName, String city, String state, String country, String contact){
    try{
      stmt1 = myConnection.createStatement();
      String queryString = "Insert Into Contributor Values('"+labName+"', '"+city+"', '" + state+ "', '" + country+ "', '" + contact+ "')";
      int result = stmt1.executeUpdate(queryString);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public void InsertNewGene(String geneName, String gFunction, String gOrganism, String gSequence, String gContributor){
    try{
      stmt1 = myConnection.createStatement();
      String queryString = "Insert Into Gene Values('"+geneName+"','"+gFunction+"', '"+gOrganism+"', '" + gSequence+ "', '" + gContributor+ "' )";
      int result = stmt1.executeUpdate(queryString);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  
  public void InsertNewProtein(String proteinName, String gene, String pFunction, String pOrganism, String pSequence,String pContributor){
    try{
      stmt1 = myConnection.createStatement();
      String queryString = "Insert Into Protein Values('"+proteinName+"','"+gene+"', '"+pFunction+"', '" + pOrganism+ "', '" + pSequence+ "', '" + pContributor+ "' )";
      int result = stmt1.executeUpdate(queryString);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public void SearchProtein(String geneName){
    try{
      stmt2 = myConnection.createStatement();
      String queryString = "Select * from Protein where Gene like '%"+geneName+"%'";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      while (rs.next())
      {
        System.out.println("ProteinName = "+rs.getString("ProteinName")+", Gene = "+rs.getString("Gene")+", PFunction = "+rs.getString("PFunction")+", PSequence = "+rs.getString("PSequence")+", PContributor = "+rs.getString("PContributor"));
      }
      System.out.println();
    }
    catch(Exception E){ 
      E.printStackTrace();
    }
  }
  
  public void SearchGeneSequence(String dna){
    try{
      stmt2 = myConnection.createStatement();
      String queryString = "Select * from Gene where GSequence like '%"+dna+"%'";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      while (rs.next())
      {
        System.out.println("GeneName = "+rs.getString("GeneName")+", GFunction = "+rs.getString("GFunction")+", GOrganism = "+rs.getString("GOrganism")+", GSequence = "+rs.getString("GSequence")+", GContributor = "+rs.getString("GContributor"));
      }
      System.out.println();
    }
    catch(Exception E){ 
      E.printStackTrace();
    }
  }
  
  public void SearchContributorCountry(String country){
    try{
      stmt2 = myConnection.createStatement();
      String queryString = "Select * from Contributor where Country like '%"+country+"%' and LabName like '.";
      //Execute the query and save resulting table/relation in the ResultSet object
      rs = stmt2.executeQuery(queryString);
      //Loop thru the ResultSet object printing each tuple twice using the two different ways of
      //accessing tuple attributes from a ResultSet
      while (rs.next())
      {
        System.out.println("GeneName = "+rs.getString("GeneName")+", GFunction = "+rs.getString("GFunction")+", GOrganism = "+rs.getString("GOrganism")+", GSequence = "+rs.getString("GSequence")+", GContributor = "+rs.getString("GContributor"));
      }
      System.out.println();
    }
    catch(Exception E){ 
      E.printStackTrace();
    }
  }
  
  
  
  public void closeDatabase(){
    try{
      rs.close();
      stmt1.close();
      stmt2.close();
      myConnection.close();
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
}
