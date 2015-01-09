package Graphs;
import java.util.*;

/**
 * A WeightedGraph is a LabeledGraph with Integer weights attached
 * to each edge. Almost everything is inherited from LabeledGraph. 
 * We have simply added a method shortestPath() which computes
 * the all-pairs shortest path algorithm and returns the resulting
 * Map of shortest paths as well as a method readGraph() which will
 * read in a graph from a file where each line contains an edge.
 * This edge consists of the names of the two vertices separated
 * by one space and the weight of that edge.
 */
public class WeightedGraph extends LabeledGraph<String,Integer>{
  
  /**
   * shortestPath() computes the shortest path between all pairs
   * of vertices in the graph. It uses an "infinity" value of 
   * the largest integer divided by 3 as an initial shortest path
   * between vertices having no edge between them.
   */
  public TreeMap<String,TreeMap<String,Pair<Integer,String>>> 
                                                      shortestPath() {
    /* min is the map that will hold the all-pairs shortest
     * path results. */
    TreeMap<String,TreeMap<String,Pair<Integer,String>>> min=
      new TreeMap<String,TreeMap<String,Pair<Integer,String>>> ();
    //vertices will be a collection containing all vertices in the graph.
    Collection<String> vertices=getVertices();
    
    /* adjacent will be used to hold the vertices adjacent to a given
     * vertex while initializing the map min. */
    Map<String,Integer> adjacent;
    
    /* This loop initializes the map so that there is a weight between
     * every pair of vertices. If there is an edge the weight of that
     * edge is used. Otherwise "infinity" (MAX_VALUE/3) is used. */
    for(String vertex:vertices) {
      min.put(vertex,new TreeMap<String,Pair<Integer,String>>());
      adjacent=getAdjacent(vertex);
      for(String vertex2:vertices) {
        if(!vertex.equals(vertex2)) {
          if(hasEdge(vertex,vertex2)) min.get(vertex).put(vertex2,
             new Pair<Integer,String>(getLabel(vertex,vertex2),null));
          else min.get(vertex).put(vertex2,
             new Pair<Integer,String>(Integer.MAX_VALUE/3,null));
        }
      }
    }
    
    /* firstHalf and secondHalf are used to hold path weights from i
     * to k and k to j. The sum of these weights is used to determine
     * if there is a shorter path from i to j via k. */
    int current,firstHalf,secondHalf;
    
    /* This is the loop that finds the shortest path between i and j
     * by trying out paths through every intermediate vertex k. */
    for(String k:vertices) {
      for(String i:vertices) {
        for(String j:vertices) {
          if(!(i.equals(j) || i.equals(k) || j.equals(k))) {
            current=min.get(i).get(j).getFirst();
            firstHalf=min.get(i).get(k).getFirst();
            secondHalf=min.get(k).get(j).getFirst();
            if(current>(firstHalf+secondHalf)){
              min.get(i).get(j).setFirst(firstHalf+secondHalf);
              min.get(i).get(j).setSecond(k);
            }
          }
        }
      }
    }
    return(min);
  }
  
  /**
   * readGraph() reads in a graph. The assumption is that the
   * graph is stored in a text file as a series of lines like
   * this example:
   *    v1 v2 7
   * where there is an edge of weight 7 between v1 and v2.
   */
  public void readGraph() {
    try {
      Scanner sc=FileChooser.openScanner();
      while(sc.hasNextLine()) {
        String v1=sc.nextLine();
        String [] pieces=v1.split(" ");
        addEdge(pieces[0],pieces[1],Integer.parseInt(pieces[2]));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}