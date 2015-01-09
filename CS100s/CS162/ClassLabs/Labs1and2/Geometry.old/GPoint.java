public class GPoint {
  
  //first and second contain the first and second items in the pair <first,second>
  private Double first,second;
  
  /**
   * The only constructor requires that you pass it a firs and second value.
   */
  public GPoint(Double first, Double second) {
    this.first=first;
    this.second=second;
  }
  
  /**
   * getFirst() returns the first value in the ordered pair.
   * @return SecifiedType The first value in the ordered pair.
   */
  public Double getFirst() {
    return(first);
  }
  
  /**
   * getSecond() returns the second value in the ordered pair.
   * @return SecifiedType The second value in the ordered pair.
   */
  public Double getSecond() {
    return(second);
  }
  
  /**
   * distanceFromOrigin returns the distance of this GPoint
   * from the origin.
   * @return Double The distance from the origin of this point.
   */
  public Double distanceFromOrigin() {
    return(Math.sqrt(first*first+second*second));
  }

  /**
   * equals(point) returns true if this and point are the same point.
   * @param point The point we are comparing for equality.
   * @return boolean Returns true if this and point are the same point.
   */
  public boolean equals(Object point) {
    try{
      GPoint temp=(GPoint) point;
      return((first==temp.getFirst()) && (second==temp.getSecond()));
    }
    catch(Exception e) {
      return(false);
    }
  }
  
  /**
   * toString() returns a String showing the OrderedPair in the
   * form <first,second>.
   * @return String The String <first,second> is returned.
   */
  public String toString() {
    return("<"+first+","+second+">");
  }
}