package SixDegrees.graph;
import java.util.*;
/**
 * LabeledGraphInterface is the interface for all kinds of Labeled
 * graphs - including numerically labeled graphs.
 */
public interface LabeledGraphInterface<V extends Comparable<V>,L> {
  /**
   * public boolean isEmpty() returns true if this LabeledGraph
   * is empty.
   */
  public boolean isEmpty();
  
    /**
   * addVertex(V x) attempts to add the vertex x to the LabeledGraph.
   * 
   * precondition: x is not null
   * postcondtion: vertex x is added to the LabeledGraph.
   */
  public void addVertex(V x) throws NullPointerException;
  
  /**
   * addEdge(Triple<V,V,L> edge) adds the edge to the graph. The Triple
   * edge contains the two ends of the edge and the label for the edge.
   * 
   * precondition: The Triple edge contains two non-null vertices and
   *     a label
   * postcondition: The edge represented by that triple is added to the
   *     graph.
   */
  public void addEdge(LabeledEdge<V,L> edge) throws NullPointerException;
  
  /**
   * getVertices() returns a Collection containing all the vertices.
   */
  public Collection<V> getVertices();
  
  /**
   * boolean hasEdge(V first, V second) returns true if there is an
   * edge <first,second,label> in the LabeledGraph.
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
   * precondition: first and second are not null
   * postcondition: the label attached to edge <first,second>
   *     is returned if such an edge exists. Otherwise, 
   *     null is returned.
   */
  public L getLabel(V first,V second);
}