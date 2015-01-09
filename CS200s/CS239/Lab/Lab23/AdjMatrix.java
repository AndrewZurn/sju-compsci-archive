import java.util.*;
import fileChooser.*;

public class AdjMatrix{
  private TreeMap<Integer, TreeMap<Integer, Integer>> treeMap;
  private TreeMap<Integer, Integer> treeMap1;
  private int infinity = -1;
  
  public AdjMatrix(){
    treeMap = new TreeMap<Integer, TreeMap<Integer, Integer>>();
    treeMap1 = new TreeMap<Integer, Integer>();
    Scanner sc=FileChooser.openScanner();
    Integer tempVertex = 0;
    Integer vertex0 = sc.nextInt();
    Integer vertex1 = sc.nextInt();
    Integer weight = sc.nextInt();
    treeMap1.put(vertex1, weight);
    
    while(sc.hasNext()){
      tempVertex = sc.nextInt();
      if(vertex0 == tempVertex){
        vertex1 = sc.nextInt();
        weight = sc.nextInt();
        treeMap1.put(vertex1, weight);
      }
      else{
        treeMap.put(vertex0, treeMap1);
        treeMap1 = new TreeMap<Integer, Integer>();
        vertex0 = tempVertex;
        vertex1 = sc.nextInt();
        weight = sc.nextInt();
        treeMap1.put(vertex1, weight);
      }
      treeMap.put(vertex0, treeMap1);
    }
    
    ArrayList<String> adjacencyList = new ArrayList<String>();
    for(Integer key: treeMap.keySet()){
      String listString = ("<" + key + "> --> ");
      for(Integer key1: treeMap.get(key).keySet()){
        listString = listString.concat("<" + key1 + ", " + treeMap.get(key).get(key1) + "> ");
      }
      adjacencyList.add( listString );
    }
    
    System.out.println("Adjacency List:");
    for(String s: adjacencyList){
      System.out.println(s);
    }
    System.out.println();
    System.out.println("Adjacency Matrix:");
    
    ArrayList<String> adjMatrix = new ArrayList<String>();
    String adjString = "< 0> ";
    for(int i = 1; i<=treeMap.size(); i++){
      adjString = adjString.concat("< "+ i +"> ");
    }
    adjMatrix.add(adjString);
    adjString = "";
    for(Integer k: treeMap.keySet()){
      adjString = adjString.concat("< "+ k +"> ");
      for(int j = 1; j<=treeMap.size(); j++){
        if( treeMap.get(k).containsKey(j) ){
          adjString = adjString.concat("< " + treeMap.get(k).get(j) + "> ");
        }
        else{
          adjString = adjString.concat("<" + infinity + "> ");
        }
      }
      adjMatrix.add(adjString);
      adjString = "";
    }
    
    for(String s1: adjMatrix){
      System.out.println(s1);
    }
    System.out.println("   *Infinity/No Connection is denoted with a -1*");
    
  }
  
  
  
  public static void main(String[] args){
    new AdjMatrix();
  }
}
