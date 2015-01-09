import Graphs.*;
import java.util.*;
public class TestAllPairs {
  private WeightedGraph wg=new WeightedGraph();
  public void run() {
    wg.readGraph();
    TreeMap<String,TreeMap<String,Pair<Integer,String>>> result=wg.shortestPath();
    for(String v1:result.keySet()) {
      System.out.println(v1+" shortest paths to ");
      for(String v2:result.get(v1).keySet()) {
        if(result.get(v1).get(v2).getSecond()!=null)
          System.out.println("   "+v2+" with weight "+result.get(v1).get(v2).getFirst()+
                           " through vertex "+result.get(v1).get(v2).getSecond());
        else
          System.out.println("   "+v2+" with weight "+result.get(v1).get(v2).getFirst()+
                           " through an edge");
      }
    }
  }
  public static void main(String [] args) {
    new TestAllPairs().run();
  }
}