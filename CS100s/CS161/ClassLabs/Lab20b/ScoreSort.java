import java.util.*;
import java.io.*;

/**
 * 
 * Read a list from file and store as sorted list
 * @author Jim Schnepf
 */
public class ScoreSort {
  
  /**List of Scores for a class */
  private ArrayList<Score> scoreList;
  
  private Scanner sc;
  private PrintWriter pw;
  
  /**
   * Generate a new list of scores from a file
   * @param inFileName file to get names and scores
   * @param outFileName file to write sorted scores
   */
  public ScoreSort(String inFileName, String outFileName) {
    scoreList = new ArrayList<Score>();
    try {
      sc=new Scanner(new File(inFileName));    
    }
    catch(Exception e) {
      System.out.println("Error in scanner");
    }
    try {
      pw = new PrintWriter(outFileName);
    }
    catch (FileNotFoundException e){
      System.out.println("Error " + e.getMessage());   
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
   * sort the data using selection sort
   * */
  public void selectionSort(){
    for (int slot = 0; slot < scoreList.size(); slot++) {
      int smallestIndex = indexOfSmallest(slot);
      swap(smallestIndex,slot);
    }
  }
  
  public void nameSelectionSort(){
    for (int slot = 0; slot < scoreList.size(); slot++) {
      int smallestIndex = indexOfSmallestName(slot);
      swap(smallestIndex,slot);
    }
  }
  
  
  /* 
   * Find the index of smallest vlaue in the list from start index to end
   * @param start index to start looking
   * @return index of smallest value
   */
  public int indexOfSmallest(int start) {
    int small = start;
    for (int next = start + 1; next < scoreList.size(); next++) {
      if (scoreList.get(next).getGrade() < scoreList.get(small).getGrade()) {
        small = next;
      }
    }
    return small;
  }
  
  public int indexOfSmallestName(int start){
    int small = start;
    String smallName = scoreList.get(start).getName();
    for(int next = start + 1; next < scoreList.size(); next ++) {
      if (smallName.compareTo(scoreList.get(next).getName())>0){
        small = next;
        smallName = scoreList.get(next).getName();
      }
    }
    return small;
  }
  
  /**
   * Change position of two scores in the list
   * @param i first position
   * @param j second position
   */
  public void swap(int i, int j) {
    Score temp = scoreList.get(i);
    scoreList.set(i,scoreList.get(j));
    scoreList.set(j, temp);
  }
  
  /**
   *write the sorted list to a file
   */
  public void writeData(){
    for (int i = 0; i < scoreList.size(); i++) {
      String nextName = scoreList.get(i).getName();
      int nextGrade = scoreList.get(i).getGrade();
      pw.printf("%-10s %d\n", nextName, nextGrade);
//        pw.println(scoreList.get(i).getGrade());
    }
    pw.close();
  }
  
  /** run the program with file names for input and output files
    * @param args[0] file to read data
    * @param args[1] file to write sorted data
    */
  public static void main(String [] args) {
    ScoreSort myList =new ScoreSort(args[0],args[1]);
    myList.getData();
    myList.nameSelectionSort();
    myList.writeData();
  }
}


