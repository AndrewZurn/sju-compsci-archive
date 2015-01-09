//package jdbc;
import java.util.*;
import java.lang.*;
import java.io.*;
//Load JDBC API functions
import java.sql.*; 

/**
 * @author irahal
 */
public class bioDBDriver {
  
public static void main(String[] args) {
    try{
      //Creates a new class object
      bioDB myJDBC = new bioDB();
      myJDBC.insertContributorTable("Rahal Labs","St Joe", "MN", "USA", "3203633663");
      myJDBC.insertGeneTable("Coolness","Being cool", "Human","ATTCTTGG","Rahal Labs");
      myJDBC.insertProteinTable("Coolness","Coolness","Being cool", "Human","ATTCTTGG","Rahal Labs");
      System.out.println("**************************************************************************");      
      myJDBC.searchProteinTable("Coolness");
      System.out.println("**************************************************************************");
      myJDBC.searchGeneTable1("TCT");
      System.out.println("**************************************************************************");
      myJDBC.searchGeneTable2("USA");
      System.out.println("**************************************************************************");
      myJDBC.closeConnection();
    }
    catch(Exception E){
      E.printStackTrace();
    }
  }
}