package zhstructures;
public class ZHCompPair<Key extends Comparable<Key>,Value> 
      implements Comparable<ZHCompPair<Key,Value>> {
  private Key key;
  private Value value;
  
  public ZHCompPair(Key key) {
    this.key=key;
    this.value=null;
  }
  
  public ZHCompPair(Key key, Value value) {
    this.key=key;
    this.value=value;
  }
  
  public Key getKey() {
    return(this.key);
  }
  
  public Value getValue() {
    return(this.value);
  }
  
  public void setValue(Value value) {
    this.value=value;
  }
  
  public int compareTo(ZHCompPair<Key,Value> pair) {
    return(this.getKey().compareTo(pair.getKey()));
  }
  
  /**
  @Override public boolean equals(Object other)
  */
  public boolean equals(ZHCompPair<Key,Value> pair) {
    return(this.compareTo(pair)==0);
  }
  
}
