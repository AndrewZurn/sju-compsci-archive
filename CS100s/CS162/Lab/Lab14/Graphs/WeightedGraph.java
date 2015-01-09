package Graphs;
import java.util.*;

public class WeightedGraph extends LabeledGraph<String,Integer>{
  
  public TreeMap<String,TreeMap<String,Pair<Integer,String>>> shortestPath() {
    TreeMap<String,TreeMap<String,Pair<Integer,String>>> min=
      new TreeMap<String,TreeMap<String,Pair<Integer,String>>> ();
    Collection<String> vertices=getVertices();

    Map<String,Integer> adjacent;
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
    int current,firstHalf,secondHalf;
    for(String k:vertices) {
      for(String i:vertices) {
        for(String j:vertices) {
          if(!(i.equals(j) || i.equals(k) || j.equals(k))){
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
  
  
  public ArrayList<String> depthFirstTraversal(){
    ArrayList<String> returnList = new ArrayList<String>();
    TreeMap<String, Boolean> mapList = new TreeMap<String, Boolean>();
    TreeSet<String> vertices = new TreeSet<String>();
    for(String s: getVertices()){
      vertices.add(s);
    }
    for(String s: vertices){
      mapList.put(s, false);
    }
    while( !vertices.isEmpty() ){
     returnList = dFS( vertices.iterator().next(), vertices, returnList, mapList ); 
    }
    return returnList;
  }
  
   public ArrayList<String> dFS(String s, TreeSet<String> vertices, ArrayList<String> returnList, TreeMap<String, Boolean> mapList){
      mapList.remove(s);
      mapList.put(s, true);
      returnList.add(s);
      vertices.remove(s);
      TreeMap<String, Integer> adjacentMap = (TreeMap<String, Integer>) getAdjacent(s);
      for(String st: adjacentMap.keySet()){
        if( mapList.get(st) == false ){
          dFS(st, vertices, returnList, mapList);
        }
      }
    return returnList;
  }
   

  
  
  public ArrayList<String> breadthFirstTraversal(){
    LinkedList<String> queue = new LinkedList<String>();
    ArrayList<String> returnList = new ArrayList<String>();
    TreeMap<String, Boolean> mapList = new TreeMap<String, Boolean>();
    TreeSet<String> set = new TreeSet<String>();
    for(String s: getVertices()){
      set.add(s);
    }
    for(String s: set){
      mapList.put(s, false);
    }
    while( !set.isEmpty()){
      String vertex = set.first();
      set.remove(vertex);
      queue.add(vertex);
      mapList.remove(vertex);
      mapList.put(vertex, true);
      while( !queue.isEmpty() ){
        String returned = (String) queue.remove();
        TreeMap<String, Integer> adjacentMap = (TreeMap<String, Integer>) getAdjacent(returned);
        for( String s: adjacentMap.keySet() ){
          if( mapList.get(s) == false ){
            queue.add(s);
            mapList.remove(s);
            mapList.put(s, true);
            set.remove(s);
          }
        }
        returnList.add(returned);
      }
    }
    return returnList;
  }
  
  public boolean hasPath(String vertex1, String vertex2){
    TreeMap<String,TreeMap<String,Pair<Integer,String>>> pathMap = shortestPath();
    if(getLabel(vertex1, vertex2) != null && getLabel(vertex1, vertex2) < Math.pow(2,30)){
      return true;
    }
    else {
      return false;
    }   
  }
  
  
  public static void main(String [] args){
    new WeightedGraph();
  }
}