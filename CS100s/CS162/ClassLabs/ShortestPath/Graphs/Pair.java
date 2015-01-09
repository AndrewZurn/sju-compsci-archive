package Graphs;
/**
 * Pair<U,V> is a simple class designed for holding a pair of items.
 * It is created with a specified pair but allows them to be changed
 * with setFirst(first) and setSecond(second) as well as allowing the
 * values to be fetched with getFirst() and getSecond().
 * @author Lynn R. Ziegler
 */
public class Pair<U,V> {
  //first and second are the two items in the pair.
  U first;
  V second;
  
  /**
   * This is a simple constructor where we pass values of first and
   * second and set the Pair's values to those values.
   */
  public Pair(U first,V second) {
    this.first=first;
    this.second=second;
  }
  
  /**
   * getFirst() returns the first of the pair of items.
   */
  public U getFirst(){
    return(first);
  }
  
  /**
   * getSecond() returns the second of the pair of items.
   */
  public V getSecond() {
    return(second);
  }
  
  /**
   * setFirst(first) changes the first element of the pair to this
   * new value first.
   */
  public void setFirst(U first) {
    this.first=first;
  }
  
  /**
   * setSecond(second) changes the second element of the pair to this
   * new value second.
   */
  public void setSecond(V second) {
    this.second=second;
  }
}