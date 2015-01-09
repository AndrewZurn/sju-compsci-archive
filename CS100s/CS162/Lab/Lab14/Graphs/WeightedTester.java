package Graphs;
import java.util.*;
public class WeightedTester{
  
  public WeightedTester(){
    WeightedGraph wg = new WeightedGraph();
    wg.readGraph();
    ArrayList<String> list = wg.breadthFirstTraversal();
    System.out.println(list);
    
    list = wg.depthFirstTraversal();
    System.out.println(list);
    
    System.out.println(wg.hasPath("A", "C"));
    System.out.println(wg.hasPath("A", "A"));
    System.out.println(wg.hasPath("A", "F"));
    
  }

  public static void main(String [] args){
    new WeightedTester();
  }
}