//package jdbc;
import java.util.*;
import java.lang.*;
import java.io.*;
//Load JDBC API functions
import java.sql.*;

/**
 * @author Andrew Zurn, IRahal
 */
public class JDBC_lab_incomplete {
  
  //Variable of type database connection
  private Connection myConnection;
  //Variable of type regular statement
  private Statement stmt;
  //Variable of type prepared statement
  private PreparedStatement preparedStmt;
  //Variable of type ResultSet which will contain query output
  private ResultSet result;
  //Variables of type MetaData
  private ResultSetMetaData rsmetadata;
  
  /**
   * COMPLETE ME: ****************************************************************************************************
   * REPLACE XXXXXX WITH THE DATABASE NAME (Company in this case), YOUR USERNAME AND YOUR PASSWORD
   */ 
  public JDBC_lab_incomplete() throws SQLException, ClassNotFoundException
  { //Load driver and link to driver manager
    Class.forName("com.mysql.jdbc.Driver");
    myConnection = DriverManager.getConnection("jdbc:mysql://devsrv.cs.csbsju.edu:3306/Company","AZurn","AZurn");
  }
  
  public void Method1(String dname) throws SQLException
  {    
    stmt = myConnection.createStatement();
    String queryString = "Select e.lname as LastName, e.fname as FirstName, d.dname as Department from employee e, department d where e.dno=d.dnumber and dname = '"+dname+"' order by dname, lname";
    result = stmt.executeQuery(queryString);
    System.out.println(queryString);
    while (result.next())
    {
      System.out.println(" Department: "+result.getString(3)+" First name: "+result.getString(2)+" Last name: "+result.getString(1));
      
    }
    result.close();
    stmt.close();
    System.out.println("************************************************************************");
  }
  
  
  /**
   * COMPLETE ME: ****************************************************************************************************
   * REPEAT METHOD 1 again only using instance variable preparedStmt (of type PreparedStatement)
   */ 
  public void Method2(String dname) throws SQLException
  {
    String queryString = "Select e.lname as LastName, e.fname as FirstName, d.dname as Department from employee e, department d where e.dno=d.dnumber and dname = ? order by dname, lname";
    preparedStmt = myConnection.prepareStatement(queryString);
    preparedStmt.clearParameters();
    preparedStmt.setString(1, dname);
    result = preparedStmt.executeQuery();
    
    System.out.println(queryString);
    
    while(result.next()){
      System.out.println(" Department: "+result.getString(3)+" First name: "+result.getString(2)+" Last name: "+result.getString(1));
    }
    
    System.out.println("************************************************************************");
    result.close();
    stmt.close();
  }
  
  /**
   * COMPLETE ME: ****************************************************************************************************
   * COMPLETE METHOD 3 TO INSERT THE SPECIFIED PARAMETERS AS A NEW TUPLE INTO DEPENDENT 
   * using instance variable stmt (of type Statement)
   * PS: you'll need to change the dependent name in order to rerun the insert successfully
   */  
  public void Method3(String essn, String depenName, char sex, String bDate, String relationship)  throws SQLException
  {
    String queryString = "Insert into dependent Values ('"+essn+"', '"+depenName+"', '"+sex+"', '"+bDate+"', '"+relationship+"')"; 
    stmt = myConnection.createStatement();
    int returns = stmt.executeUpdate(queryString);
    System.out.println("Rows affected: " + returns);
    
    System.out.println("Inserting Into dependent values ('"+essn+"', '"+depenName+"', '"+sex+"', '"+bDate+"', '"+relationship+"')");
    System.out.println("************************************************************************");
    result.close();
    stmt.close();
  }
   
  /**
   * COMPLETE ME: ****************************************************************************************************
   * COMPLETE METHOD 4 TO ABLE TO DISPLAY RESULTS OF ANY USER INPUT SELECT QUERY 
   * USING instance variable stmt (of type Statement)
   */   
  public void Method4() throws SQLException
  {
    
    Scanner sc = new Scanner (System.in);
    System.out.println("Type in an sql SELECT statement and hit enter: ");
    String query = sc.nextLine();
    String q = query.toLowerCase();
    
    stmt = myConnection.createStatement();
    result = stmt.executeQuery(query);
    ResultSetMetaData resultMetaData = result.getMetaData();
    
    for(int i = 0; i < resultMetaData.getColumnCount(); i++){
      System.out.print(resultMetaData.getColumnName(i+1) + "(" + resultMetaData.getColumnTypeName(i+1) + ")" + "\t");
    }
    
    System.out.println();
    
    while(result.next()){
      for(int i = 0; i < resultMetaData.getColumnCount(); i++){
        System.out.print(result.getString(i+1) + "\t\t" );
      }
      System.out.println();
    }
    
    stmt.close();
    System.out.println("************************************************************************"); 
  }
  
  public void closeDatabaseVariables() throws SQLException
  {
    myConnection.close(); 
  }
  
  
  public static void main(String[] args)
  {
    try
    {
      //Creates a new class object
      JDBC_lab_incomplete myJDBC = new JDBC_lab_incomplete();
      System.out.println();
      
      // Method 1 testing
      System.out.println ("\n--------METHOD 1--------\n");
      myJDBC.Method1("administration");
      myJDBC.Method1("potato");
      
      // Method 2 testing
      System.out.println ("\n--------METHOD 2--------\n");
      myJDBC.Method2("administration");
      myJDBC.Method2("potato");
      
      // Method 3 testing
      System.out.println ("\n--------METHOD 3--------\n");

      //myJDBC.Method3("987654321", "William", 'M', "2000-01-01","SON");
      
      // Method 4 testing
      System.out.println ("\n--------METHOD 4--------\n");
      myJDBC.Method4();
      
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

