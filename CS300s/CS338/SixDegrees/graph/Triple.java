package graph;
import java.io.*;
/**
 * class Triple<U,V,W> contains a triple of objects 
 *     <first,second,third>
 * where first is of type U, second is of type V, and third
 * is of type W.
 */
public class Triple<U,V,W> implements Serializable{
  //first, second, and third are the data items
  U first;
  V second;
  W third;
  
  //nullTriple is true if this triple contains null values
  boolean nullTriple;
  
  /**
   * The default constructor creates a Triple containing null
   * values.
   */
  public Triple() {
    first=null;
    second=null;
    third=null;
    nullTriple=true;
  }
  
  /**
   * This constructor constructs the triple <first,second,third>.
   */
  public Triple(U first,V second, W third) {
    this.first=first;
    this.second=second;
    this.third=third;
    nullTriple=(first==null) && (second==null) && (third==null);
  }
  
  /**
   * isNull() returns true if this is a null triple - i.e., if
   * all of the values are null.
   */
  public boolean isNull() {
    return(nullTriple);
  }
  
  /**
   * setFirst(U first) sets the value of first.
   */
  public void setFirst(U first) {
    this.first=first;
    nullTriple=(first==null) && (second==null) && (third==null);
  }  
  
  /**
   * setSecond(V second) sets the value of second.
   */
  public void setSecond(V second) {
    this.second=second;
    nullTriple=(first==null) && (second==null) && (third==null);
  } 
  /**
   * setThird(W third) sets the value of third.
   */
  public void setThird(W third) {
    this.third=third;
    nullTriple=(first==null) && (second==null) && (third==null);
  }
  
  /**
   * getFirst() returns the value of first.
   */
  public U getFirst() {
    return(first);
  }
  
  /**
   * getSecond() returns the value of second.
   */
  public V getSecond() {
    return(second);
  }
  
  /**
   * getThird() returns the value of third.
   */
  public W getThird() {
    return(third);
  }
}