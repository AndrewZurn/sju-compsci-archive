package Graphs;
import java.util.*;

/**
 * LabeledGraphInterface is the interface for all kinds of Labeled
 * graphs - including numerically labeled graphs. Template type V
 * is the type of the vertex - often Strings, characters, or 
 * integers and Template type L is the type of the Label. V is
 * Comparable since you usually want to order the vertices in some
 * way.
 */
public interface LabeledGraphInterface<V extends Comparable<V>,L> {
  
  /**
   * public boolean isEmpty() returns true if this LabeledGraph
   * is empty.
   */
  public boolean isEmpty();
  
  /**
   * addVertex(v) attempts to add the vertex v to the LabeledGraph.
   * 
   * <p><b>precondition:</b> v is not null</p><br>
   * <p><b>postcondtion:</b> vertex v is added to the LabeledGraph if it
   *     was not already there. If it was already there, return false
   *     (since we will not add the vertex). Otherwise, return true.</p><br>
   */
  public boolean addVertex(V v) throws NullPointerException;
  
  /**
   * addEdge(v,w,l) adds the edge from v to w with edge label 
   * lbl to the graph.
   * 
   * <p><b>precondition:</b> The two vertices v and w are not null.</p><br>
   * <p><b>postcondition:</b> The edge between vertex v and vertex w with 
   *     label lbl is added to the graph. If the edge was already there,
   *     return false. If not, return true. In either case, the edge
   *     from v to w will be there and will have edge label lbl.</p><br>
   */
  public boolean addEdge(V v,V w, L label) throws NullPointerException;
  
  /**
   * getVertices() returns a Collection containing all the vertices
   * in the graph.
   */
  public Collection<V> getVertices();
  
  /**
   * getAdjacent(v) returns a Map<V,L> which contains all of the
   * vertices in the graph adjacent to v and the corresponding
   * labels for the edge connecting v to each vertex in the Map.
   */
  public Map<V,L> getAdjacent(V v);
  
  /**
   * boolean hasEdge(V first, V second) returns true if there is an
   * edge between first and second in the LabeledGraph.
   */
  public boolean hasEdge(V first, V second);
  
  /**
   * getNumVertices() returns the number of vertices in the graph.
   */
  public int getNumVertices();
  
  /**
   * getNumEdges() returns the number of edges in the graph.
   */
  public int getNumEdges();
  
  /**
   * public L getLabel(V first,V second) 
   * 
   * <p><b>precondition:</b> first and second are not null</p><br>
   * <p><b>postcondition:</b> the label for edge <first,second,label>
   *     is returned if such an edge exists. Otherwise, null
   *     is returned.</p><br>
   */
  public L getLabel(V first,V second) throws NullPointerException;
}