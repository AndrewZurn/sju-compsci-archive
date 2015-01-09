/**
 * file: C__Interpreter.java
 */

import java.io.*;
import postfix.*;
import java.util.*;

/**
 * a class to interpret a file written in C-- into Java
 * @author Xu, Runbo and Zurn, Andrew
 * @version Feb 8, 2011 ver 1.0
 */
public class C__Interpreter{  
  /**
   * a scanner to read through the wanted file
   */
  private Scanner sc;
  /**
   * a temporary string used to hold a next line in the file
   */
  private String line;
  /**
   * used to calculate complex expressions 
   */
  private Postfix pf;
  /**
   * used to find and associate characters with values within the file
   */
  private TreeMap<Character,Double> values;
  
  /**
   * the constructor to interpret a file written in C-- into Java
   * @param fileName the file to be interpreted
   * @throws FileNotFoundException when the file is not found
   * @throws IOException when there is an input/output error
   */
  public C__Interpreter(String fileName) throws FileNotFoundException, IOException {
    try{
      sc=new Scanner(new FileReader(fileName));
    }
    catch (FileNotFoundException e1){
      System.out.println(e1);
    }
    values=new TreeMap<Character,Double>();
    for(char c='a';c<'z';c++) {
      values.put(c,0.0);
    }
    pf=new Postfix(values);
    while(sc.hasNextLine()){
      String initialLine = sc.nextLine();
      line="";
      for(int i=0;i<initialLine.length();i++){
        if(!initialLine.substring(i,i+1).equals(" ")){
          line=line+initialLine.substring(i,i+1);
        }
      }
      char temp = line.charAt(0);
      if(temp=='#'){
      }
      else if(temp=='P'){
        if("Print".equals(line.substring(0,5)) && line.charAt(6)<='z' && line.charAt(6)>='a'){
          System.out.println(values.get(line.charAt(6)));
        }
        else{
         System.out.println("Error! Illegal Print Method!");
        }
      }
      else if(temp=='R'){
        if("Read".equals(line.substring(0,4)) && line.charAt(5)<='z' && line.charAt(5)>='a'){
          double k=PopUpInput.getDouble("Please enter a value for "+line.substring(5,6));
         values.put(line.charAt(5), k);
        }
        else{
          System.out.println("Error! Illegal Read Method!");
        }
      }
      else if(temp=='E'){
       System.exit(0); 
      }
      else if(temp<='z' && temp>='a'){
        double tempD;
        try {
          tempD=Double.parseDouble(line.substring(2,line.length()));
           values.put(line.charAt(0), tempD);
        }
        catch(Exception e) {
          try {
            tempD=pf.evaluate(pf.infixToPostfix(line.substring(2, line.length())));
             values.put(line.charAt(0), tempD);
          }
          catch(Exception e2) {
            System.out.println(e2);
          }
        } 
    }
  } 
}
  /**
   * used to run the class outside the Java IDE
   * @param args the C-- file to be interpreted
   * @throws FileNotFoundException when the file is not found
   * @throws IOException when there is an input/output error
   */
  public static void main(String[] args)throws FileNotFoundException, IOException {
   new C__Interpreter(args[0]); 
  }
}