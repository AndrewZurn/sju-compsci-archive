import java.util.*;
import java.io.*;

/**
 * 
 * Read a list from file and use binary search
 * requires a sorted list!
 * @author Jim Schnepf
 */
public class SearchScores {
  
  /**List of Scores for a class */
  private ArrayList<Score> scoreList;
  
  private Scanner sc;
  
  /**
   * Generate a new list of scores from a file
   * @param inFileName file to get names and scores
   * 
   */
  public SearchScores(String inFileName) {
    scoreList = new ArrayList<Score>();
    try {
      sc=new Scanner(new File(inFileName));    
    }
    catch(Exception e) {
      System.out.println("Error in scanner");
    }
    
  }
  /**
   * Read data from the inFile
   */
  public void getData() {
    String nextName;
    int nextGrade;
    
    while (sc.hasNext()) {
      nextName = sc.next();
      nextGrade = sc.nextInt();
      scoreList.add(new Score(nextName, nextGrade));
    }               
    sc.close();
  }
  
  /**
   * search the data using binary search
   * 
   * @param key Name of student to find score of
   * 
   * @param int location in array of student, -1 if not found
   **/
  public int binarySearch(String key){
    int start = 0;
    int end = scoreList.size() -1;
    while (start <= end) {
      int middleIndex = (start + end)/2;
      String candidate = scoreList.get(middleIndex).getName();
      if (key.equals(candidate)){
        return middleIndex;
      } else if (key.compareTo(candidate) < 0){
        end = middleIndex -1;
      } else{ // key > ScoreList(middleIndex)
        start = middleIndex +1;
      }
    }
    return -1;
  }
  
  /**
   * Get the name from user and print a grade
   */
  public void findGrade() {
    Scanner scName = new Scanner(System.in);
    String searchName;
    System.out.println("Enter name to find grade");
    while (scName.hasNext()){
      searchName = scName.next();
      int i = binarySearch(searchName);
      if (i == -1){
        System.out.println(searchName + ": Name not found");
      }
      else {
        System.out.println(searchName + " has a grade of: " +
                           scoreList.get(i).getGrade());
      }
      System.out.println("Enter name to find grade");
    }
  }
  
  
  /** Program to find the grade of a student
    * 
    */
  public static void main(String[] args){
    SearchScores myList = new SearchScores(args[0]);
    myList.getData();
    myList.findGrade();
  }
}
