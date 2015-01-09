import java.util.*;
import java.io.*;

public class CandidateDemo
{
  static Candidate[] candidateArray = new Candidate[5];
  
  public static void main (String[] args) throws FileNotFoundException
  {
    int index = 0;
    String name="";
    double vote = 0;
    
    Scanner inFile = new Scanner (new FileReader("hw6Input.in"));
    PrintWriter outFile = new PrintWriter("hw6Output.txt");
    
    while(inFile.hasNext())
    {
      name = inFile.next();
      vote = (double) inFile.nextInt();
      
      candidateArray[index]=new Candidate(name,vote);
      
      index++;
    }
      
    double runningTotal = 0;
    double highestVote = 0;
    String highestCandidate = "";
    
    for(int i =0; i<candidateArray.length;i++)
    {
      runningTotal = runningTotal + candidateArray[i].getVote();
      
      if(highestVote<candidateArray[i].getVote())
      {
        highestVote = candidateArray[i].getVote();
        highestCandidate = candidateArray[i].getName();
      }
    }
    
    outFile.println("Name     Votes Recieved    % of Vote");
    
    for(int i=0; i<candidateArray.length; i++)
    {
      outFile.printf("%-8s %-17.0f %-7.2f \n", candidateArray[i].getName(), candidateArray[i].getVote() , ((candidateArray[i].getVote()/runningTotal) * 100.0));
    }
      
    outFile.println("\nThe winner of the election is "+highestCandidate+".");
    
    inFile.close();
    outFile.close();
  }
}

      
  
    