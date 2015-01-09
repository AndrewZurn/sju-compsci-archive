import java.util.*;
import java.io.*;
/**
 * A program to read and sum numbers from an input file
 */
public class SumFile {
  /**
   * instance variable to store file name
   */
  String fileName;
  /**
   * instance variable that will point to the file we're reading
   */
  FileReader file;
  /**
   * instance variable which we'll use to go through the file
   */
  Scanner sc;
  
  /**
   * This method will create a pointer (called file) to the file whose name is specified as a parameter (called fileName)
   * It will also set the scanner (sc) to point to the file so that we can read its contents
   */
  public SumFile(String fileName) {
    this.fileName=fileName;
    try {
      //set file to point to the fileName and set sc to read from file
      // from here on, all we need is scanner sc
      file=new FileReader(fileName);
      sc=new Scanner(file);
    }
    catch (Exception e) {
      System.out.println(e);
      System.exit(0);
    }
  }
  
  public void run() {
    //your code goes here. See previous lab for use of scanner.
    ArrayList<Integer> inList=new ArrayList<Integer>();
    int result=0;
    while(sc.hasNextInt()) {
       inList.add(sc.nextInt());
    }
    for(int i=0; i<inList.size();i++){
      result+=inList.get(i); 
    }
    System.out.println(result);
  }
}