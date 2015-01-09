import java.util.*;
import java.io.*;

/**
 * A class that will clean and sort words from a text file into three seperate files dependent 
 * on the length of the word
 * @author Andrew Zurn
 */

public class WordSorter{
  
  /** scanner to scan the original file */
  private Scanner sc;
  
  /** next word in the scanner */
  private String word;
  
  /** file writer to write to the three seperate files */
  private FileWriter largeFile, mediumFile, smallFile;
  
  /** array lists used to seperate words into before writing to file */
  private ArrayList<String> largeList = new ArrayList<String>();
  private ArrayList<String> mediumList = new ArrayList<String>();
  private ArrayList<String> smallList = new ArrayList<String>();
  
  /**
   * Constructor for a WordSorter with the file as its parameter
   * @param file the original file being sorted
   */
  public WordSorter(String file) throws FileNotFoundException, IOException {
    //scanner to read the given file
    sc = new Scanner( new FileReader(file));
    while( sc.hasNext()){                      
      word = sc.next();
      //Cleans words in file
      word = word.replaceAll("[,.:;'!-?/@()~]","");   
      //Used to place words larger then 8 characters in largeWords.txt
      if(word.length() > 8){ 
        largeList.add(word + "\n");
      }
      //Used to places word between 6 and 8 chars in mediumWord.txt
      else if(word.length() <= 8 && word.length() >= 6){   
        mediumList.add(word + "\n");
      }
      //Used to place words between 3 and 5 characters in smallWord.txt
      else if(word.length() <=5 && word.length() >= 3){
        smallList.add(word + "\n");
      }
    }
    
    try{
      //write our "large words" to largeWords.txt
      FileWriter largeFile = new FileWriter("largeWords.txt");
      largeFile.write(largeList.toString().replaceAll(", ",""));
      largeFile.close();
      //write our "medium words" to mediumWord.txt
      FileWriter mediumFile = new FileWriter("mediumWords.txt");
      mediumFile.write(mediumList.toString().replaceAll(", ",""));
      mediumFile.close();
      //write our "small words" to smallWord.txt
      FileWriter smallFile = new FileWriter("smallWords.txt");
      smallFile.write(smallList.toString().replaceAll(", ",""));
      smallFile.close();
    }
    catch(IOException io){
      System.out.println("The file could not be written in");
    }
  }
  
  
  
  
  /**
   * runs the program from the command line using a file name for input
   * @param args[0] file to read data from
   */
  public static void main (String[] args) throws FileNotFoundException, IOException{
    WordSorter wordSort = new WordSorter(args[0]);
  }
}
