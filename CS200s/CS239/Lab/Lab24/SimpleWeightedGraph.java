import fileChooser.*;
import java.util.*;
/**
 * This is a simple weighted graph that assumes:
 *   1. Each node is labeled with a number from 0 to size-1.
 *   2. The weights are all integers.
 *   3. You want to do all-pairs shortest path on your graph.
 */
public class SimpleWeightedGraph {
  /* weight contains the adjacency matrix for the graph.
   * weight[i][j] contains the length of the edge from i to
   * j if there is one, and the value infinity if there is
   * not an edge from i to j. (infinity is a value computed
   * as twice the total length of edges increased to a number
   * of the form 99..9 */
  private int [][] weight;
  /* After running shortestPath, shortest[i][j][0] will contain
   * the length of the shortest path from vertex i to vertex j
   * and shortest[i][j][1] will contain the number of the last
   * vertex passed through to get there. */
  private int [][][] shortest;
  //size is the number of vertices, running 0, ..., size-1
  private int size;
  //infinity is a number big enough to serve as infinity for this graph.
  private int infinity;
  
  /**
   * We need to be able to create a Graph with nothing in it.
   * Later we will fill it with readGraph();
   */
  public SimpleWeightedGraph() {
    size=0;
  }
  
  /**
   * We need to be able to create a Graph of a certain size.
   * Later we will add edges with addEdge(v1,v2,weight);
   */
  public SimpleWeightedGraph(int size) {
    weight=new int[size][size];
    shortest=new int[size][size][2];
    this.size=size;
  }
  
  /**
   * readGraph() reads in a graph from a file of edges where
   * each edge is stored in the file as triples of ints where
   * the triples are v1 (the first vertex), v2 (the second vertex), 
   * and wt (the weight of the edge).
   */
  public void readGraph() {
    Scanner sc=FileChooser.openScanner();
    ArrayList<Integer> v1=new ArrayList<Integer>();
    ArrayList<Integer> v2=new ArrayList<Integer>();
    ArrayList<Integer> wt=new ArrayList<Integer>();
    int max=0;
    int temp;
    infinity=0;
    while(sc.hasNextInt()) {
      temp=sc.nextInt();
      if(temp>max) max=temp;
      v1.add(temp);
      temp=sc.nextInt();
      if(temp>max) max=temp;
      v2.add(temp);
      temp=sc.nextInt();
      infinity=infinity+temp;
      wt.add(temp);
    }
    size=max+1;
    temp=9;
    while(infinity>temp) {
      temp=10*temp+9;
    }
    infinity=100*temp+99;
    weight=new int[size][size];
    shortest=new int[size][size][2];
    for(int i=0;i<size;i++) {
      for(int j=0;j<size;j++) {
        weight[i][j]=infinity;
        shortest[i][j][0]=infinity;
        shortest[i][j][1]=i;
      }
    }
    int j,k;
    for(int i=0;i<v1.size();i++) {
      j=v1.get(i);
      k=v2.get(i);
      weight[j][k]=wt.get(i);
      shortest[j][k][0]=weight[j][k];
      weight[k][j]=weight[j][k];
      shortest[k][j][0]=weight[j][k];
    }
  }
  
  /**
   * addEdge(v1,v2,weight) adds an edge between v1 and v2
   * with weight weight to the graph.
   */
  public void addEdge(int v1,int v2,int wt) {
    weight[v1][v2]=wt;
    weight[v2][v1]=wt;
    shortest[v1][v2][0]=wt;
    shortest[v2][v1][0]=wt;
  }
  
  /**
   * toString() returns a string which shows the adjacency 
   * matrix for the graph.
   */
  public String toString() {
    String returnString="      ";
    for(int i=0;i<size;i++) {
      returnString=returnString+String.format("%6d",i);
    }
    returnString=returnString+"\n";
    for(int i=0;i<size;i++) {
      returnString=returnString+String.format("%6d",i);
      for(int j=0;j<size;j++) {
        returnString=returnString+String.format("%6d",weight[i][j]);
      }
      returnString=returnString+"\n";
    }
    return(returnString+"\n");
  }
  
  /**
   * shortest() returns a string representing the shortest
   * path matrix for the graph.
   */
  public String shortest() {
    shortestPath();
    String returnString="\n      ";
    for(int i=0;i<size;i++) {
      returnString=returnString+String.format("%5d    ",i);
    }
    returnString=returnString+"\n";
    for(int i=0;i<size;i++) {
      returnString=returnString+String.format("%3d   ",i);
      for(int j=0;j<size;j++) {
        if(i==j) returnString=returnString+String.format(" infinity");
        else returnString=returnString+String.format("[%3d,%3d]",
                     shortest[i][j][0],shortest[i][j][1]);
      }
      returnString=returnString+"\n";
    }
    return(returnString);
  }
    
  /**
   * shortestPath() changes shortest to a 3-d array containing
   * the weight of the shortest path from i to j in 
   * shortest[i][j][0] and the first vertext it went through in 
   * following that path in shortest[i][j][1].
   */
  public void shortestPath() {
    for(int k=0;k<size;k++) {
      for(int i=0;i<size;i++) {
        for(int j=0;j<size;j++) {
          int temp=shortest[i][k][0]+shortest[k][j][0];
          if(temp<shortest[i][j][0]) {
            shortest[i][j][0]=temp;
            shortest[i][j][1]=k;
          }
        }
      }
    }
    for(int i=0;i<size;i++) {
      shortest[i][i][0]=infinity;
      shortest[i][i][1]=i;
    }
  }
  
  public void printPath(int v1, int v2){
    /* After running shortestPath, shortest[i][j][0] will contain
   * the length of the shortest path from vertex i to vertex j
   * and shortest[i][j][1] will contain the number of the last
   * vertex passed through to get there. */
    Stack<Integer> stack = new Stack<Integer>();
    String path = "";
    int i = v1;
    int j = v2;
    while( i != j){
      stack.push( shortest[i][j][1] );
      j--;
    }
    while(!stack.empty()){
      path = path.concat(" <" + stack.pop() + ">");
    }
    path = path.concat(" <" + v2 + ">");
    System.out.println("The Vertex: <"+v1+"> is connected to Vertex: <"+v2+"> with a length of: "+shortest[v1][v2][0]+
                       " through the verticies of"+path+ ".");
  }
  
  /**
   * This main is just included to test the class. Feel free
   * to modify it and use it for your lab 24.
   */
  public static void main(String [] args) {
    SimpleWeightedGraph temp=new SimpleWeightedGraph();
    temp.readGraph();
    System.out.println(temp);
    System.out.println(temp.shortest());
    temp.printPath( 0, 4);
  }
}
    