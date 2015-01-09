import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * A class to randomly choose a word from a selected file
 * @author Andrew Zurn
 */
public class RandomWord{
  /** an array list used as a temporary hold for a RandomIntGenerator to choose from */
  private ArrayList<String> wordList = new ArrayList<String>();
  /** the random word choosen from the array list */
  private String nextWord;
  
  /**
   * Constructor for a RandomWord with the file as a parameter
   * @param file the name of the file selected to be randomized
   */
  public RandomWord(String file) throws FileNotFoundException, IOException{
    //Open a reader to read the file and add it to an array list while the next line does not return null
    BufferedReader fileReader = new BufferedReader (new FileReader(file));
    String currentLine = fileReader.readLine();
    while(currentLine != null){
      wordList.add(currentLine);
      currentLine = fileReader.readLine();
    }
    //Used to randomly select a word from the given array list
    RandomIntGenerator randomWord = new RandomIntGenerator(0,wordList.size());
    nextWord = wordList.get(randomWord.nextValue());
    fileReader.close();
  }
  
  /**
   * Return the random word from the array list
   * @return nextWord from the list
   */
  public String getWord(){
    return nextWord;
  }
  
  /**
   * Can be used to also run this program from the command line
   * @param args[0] file to read data from
   */
  public static void main (String[] args) throws FileNotFoundException, IOException{
    RandomWord randomWord = new RandomWord(args[0]);
  }
}