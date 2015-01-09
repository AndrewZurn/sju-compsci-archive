package SixDegrees.graph;
import java.util.*;
import java.io.*;
/**
 * Note that the class LabeledGraph allows two kinds of labels - labeled
 * vertices and labeled edges. The basic structure of the graph is an
 * adjacency list but since we use a TreeMap it is effectively also an
 * adjacency matrix.
 */
public class LabeledGraph<V extends Comparable<V>,L> implements Serializable {
	//graphMap is where the graph is stored.
	private TreeMap<String,TreeMap<String,L>> graphMap;
	/* We put vertex labels in the vertexArray in order to keep integers
	 * as indicators of the array for use in UnionFind. */
	private ArrayList<V> vertexArray;
	/* We also need a TreeMap of vertices and their indices in the vertexArray
	 * in order to quickly find if a vertex is in the graph. */
	private TreeMap<V,Integer> vertexMap;
	//vertexCount and edgeCount keep track of how many
	// vertices and how many edges we have, respectively.
	private int vertexCount,edgeCount,vertexCounter;
	//vertexMarker is used by DFS to "mark" each vertex
	// as it is visited.

	/**
	 * This constructor creates a new empty LabeledGraph.
	 * 
	 * preconditions: none
	 * postconditions: a new empty LabeledGraph is created.e
	 */
	public LabeledGraph() {
		graphMap=new TreeMap<String,TreeMap<String,L>> ();
		vertexCount=0;
		vertexArray=new ArrayList<V>();
		vertexMap=new TreeMap<V,Integer>();
		edgeCount=0;
	}

	/**
	 * This constructor creates a new LabeledGraph from the Collection edges. 
	 */
	public LabeledGraph(Collection<LabeledEdge<V,L>> edges)
			throws NullPointerException {
		graphMap=new TreeMap<String,TreeMap<String,L>> ();
		vertexArray=new ArrayList<V>();
		vertexMap=new TreeMap<V,Integer>();
		for(LabeledEdge<V,L> y:edges) {
			addEdge(y);
		}
		edgeCount=edges.size();
	}
	
	public void saveNewTree(TreeMap<String, TreeMap<String, L>> newMap){
		graphMap = newMap;
	}
	
	public TreeMap<String, TreeMap<String, L>> getMap(){
		return graphMap;
	}

	/**
	 * public boolean isEmpty() returns true if this LabeledGraph
	 * is empty.
	 */
	public boolean isEmpty() {
		return(vertexCount==0);
	}

	/**
	 * addVertex(V x) attempts to add the vertex x to the LabeledGraph.
	 * 
	 * precondition: x is not null
	 * postcondtion: vertex x is added to the LabeledGraph unless x is
	 *                        already in the graph.
	 */
	public void addVertex(V vertex) throws NullPointerException {
		if(vertex==null) throw new NullPointerException(
				"Attempt to add a null vertex to a Labeled Graph");
		if(!graphMap.containsKey(vertex)) {
			vertexArray.add(vertex);
			vertexMap.put(vertex,vertexCount);
			graphMap.put(vertex.toString(),new TreeMap<String,L>());
			vertexCount++;
		}
	}

	/**
	 * addEdge(LabeledEdge<V,L> edge) adds the edge to the graph. The Triple
	 * edge contains the two ends of the edge and the label for the edge.
	 * 
	 * precondition: The Triple edge contains two non-null vertices and
	 *     a label
	 * postcondition: The edge represented by that triple is added to the
	 *     graph.
	 */
	public void addEdge(LabeledEdge<V,L> edge) throws NullPointerException {
		if(edge==null) throw new NullPointerException(
				"Attempt to add a null edge to a LabeledGraph");
		if(!graphMap.containsKey(edge.getFirst())) {
			addVertex(edge.getFirst());
		}
		if(!graphMap.containsKey(edge.getSecond())) {
			addVertex(edge.getSecond());
		}
		//String v1=(String)vertexMap.get(vertexArray.indexOf(edge.getFirstVertex()));
		//String v2=(String)vertexMap.get(edge.getSecond());
		graphMap.get(edge.getFirst()).put((String)edge.getSecond().toString(),edge.getThird());
		graphMap.get(edge.getSecond()).put((String)edge.getFirst().toString(),edge.getThird());
		edgeCount++;
	}

	/**
	 * addEdge(V v1,V v2,L label) adds the edge from v1 to v2 with Label
	 * label to the graph.
	 * 
	 * precondition: both vertices are non-null
	 * postcondition: The edge from vertex v1 to vertex v2 with Label
	 *     label is added to the graph.
	 */
	public void addEdge(V v1,V v2,L label) {
		addEdge(new LabeledEdge<V,L>(v1,v2,label));
	}

	/**
	 * getList(vertex) returns the TreeMap containing all vertices
	 * adjacent to vertex along with the labels associated with the
	 * edges.
	 */
	public TreeMap<V,L> getList(V vertex) {
		TreeMap<V,L> tempMap=new TreeMap<V,L>();
		Integer vInteger=vertexMap.get(vertex);
		for(String x:graphMap.get(vertex).keySet()) {
			int position = vertexArray.indexOf(vertex);
			V v=vertexArray.get(position);
			tempMap.put(v,graphMap.get(vInteger).get(x));
		}
		return(tempMap);
	}

	/**
	 * getVertices() returns a Collection containing all the vertices.
	 */
	public Set<V> getVertices() {
		return(vertexMap.keySet());
	}

	public int size(){
		return graphMap.size();
	}

	/**
	 * boolean hasEdge(V first, V second) returns true if there is an
	 * edge <first,second,label> in the LabeledGraph.
	 */
	public boolean hasEdge(V first, V second) throws Exception {
		//  if(!(vertexMap.containsKey(first) && vertexMap.containsKey(second))) {
		//   return(false);
		//  }
		//  String v1=(String) vertexMap.get(first);
		//  String v2=(String) vertexMap.get(second);
		//  return(graphMap.get(v1).containsKey(v2));
		if(graphMap.get(first).containsKey(second)){
			return true;
		}
		return false;
	}

	/**
	 * getNumVertices() returns the number of vertices in the graph.
	 */
	public int getNumVertices() {
		return(vertexCount);
	}

	/**
	 * getNumEdges() returns the number of edges in the graph.
	 */
	public int getNumEdges() {
		return(edgeCount);
	}
	
	public V getVertex(int vertexPos){
		return vertexArray.get(vertexPos);
	}

	/**
	 * public L getLabel(V first,V second) 
	 * 
	 * precondition: first and second are not null
	 * postcondition: the triple for edge <first,second,label>
	 *     is returned if such an edge exists. Otherwise, the
	 *     triple <null,null,null> is returned.
	 */
	public L getLabel(V first,V second) 
			throws Exception {
		if(!(vertexMap.containsKey(first) && vertexMap.containsKey(second))) {
			throw new Exception("Vertices "+first+" and "+second+
					" are not both in the graph.");
		}
		int v1=vertexMap.get(first);
		int v2=vertexMap.get(second);
		return(graphMap.get(v1).get(v2));
	}
	
	public ArrayList<V> getVertexArray(){
		return vertexArray;
	}

	/**
	 * printDFS() is an example of how one could create a
	 * printout of the nodes as they are visited in a Depth
	 * First Search
	 */
	/*public void printDFS() throws Exception {
  TreeSet<Integer> vertexMarker=new TreeSet<Integer>();
  for(String x:graphMap.keySet()) { //gurarantees all components reached
   if(!vertexMarker.contains(x)) { //another component
    System.out.println("Next Component");
    recursivePrintDFS(x,-1,vertexMarker);
    System.out.println();
   }
  }
 }*/

	/*
	 * recursivePrintDFS(V v,V parent) is called by
	 * printDFS() and, then, recursively goes through
	 * the current component.
	 */
	/*private void recursivePrintDFS(String v,String parent,
   TreeSet<String> vertexMarker)
     throws Exception {
  vertexMarker.add(v); //mark v
  int position = vertexArray.indexOf(v);
  int parentPosition = vertexArray.indexOf(parent);
  //print v and parent and label
  if(parent.equals(-1)) { //first node so just print that
   System.out.print("  Start Node: "+vertexArray.get(position)+" ");
   vertexCounter=0;
  }
  else { //There was an edge so show the label
   V v1=vertexArray.get(position);
   V v2=vertexArray.get(parentPosition);
   System.out.print("<"+v2+","+v1+"|"+getLabel(v2,v1)+">");
  }
  vertexCounter++; //used to prevent too many on one line
  if((vertexCounter%8)==0) //only 8 per line in this case
   System.out.println("    ");
  Set<String> adjacent=graphMap.get(v).keySet();
  for(String x:adjacent) {
   if(!vertexMarker.contains(x)) {
    recursivePrintDFS(x,v,vertexMarker);
   }
  }
 }/*

 /**
	 * toString will create a String containing all edges in
	 * the Graph.
	 */
	public String toString() {
		String returnString = "";
		for(String str: graphMap.keySet()){
			for(String str2: graphMap.get(str).keySet()){
				returnString += "Vertex1: " + str + " --- Vertex2: " + 
						str2 + " --- Label: " + graphMap.get(str).get(str2).toString() + "\n";
			}
		}
		return(returnString);
	}
}