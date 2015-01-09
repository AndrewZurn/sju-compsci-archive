public class GLineSegment implements GLineSegmentInterface{
  
  //point1 and point2 are the endpoints of the GLineSegment.
  private GPoint point1,point2;
  /**
   * <b>precondition:</b> The parameter x is nonnegative
   * </p><br>
   * slope() returns the slope of the GLineSegment
   * @return Double Returns the slope of the GLineSegment.
   * @throws Throws a VerticalLineRuntimeException if the line is vertical.
   */
  public Double slope() throws VerticalLineRuntimeException {
    if(this.isVertical()) 
      throw new VerticalLineRuntimeException(
               "You can't compute the slope of a vertical line.");
    else 
      return((point2.getSecond()-point1.getSecond())/
             (point2.getFirst()-point1.getFirst()));
  }
  
  /**
   * isVertical() returns true if this GLineSegment is vertical.
   * @return String Returns true if this is a vertical line segment.
   */
  public boolean isVertical() {
    return(point1.getFirst()==point2.getFirst());
  }
  
  /** intersects(lineSegment) returns true if lineSegment and this
    * GLineSegment intersect.
    * @param lineSegment lineSegment is another GLineSegment
    * @return boolean Returns true if and only if this GLineSegment and
    * lineSegment intersect.
    */
  public boolean intersects(GLineSegment lineSegment) {
    if(this.equals(lineSegment)) return(true);
    else if(this.slope()==lineSegment.slope()) return(false);
    else {
      //complicated stuff here.
      return(false);
    }
  }
  
  /**
   * public boolean equals(lineSegment) returns true if the two lines are
   * equal to each other.
   * @param lineSegment The other line segment we are comparing with this.
   * @return boolean Returns true if and only if this GLineSegment and
   * lineSegment are the same.
   */
  public boolean equals(Object lineSegment) {
    try {
      GLineSegment temp=(GLineSegment) lineSegment;
      return((  (this.point1.equals(temp.getFirstPoint())) &&
                (this.point2.equals(temp.getSecondPoint()))  ) ||
             (  (this.point1.equals(temp.getSecondPoint())) &&
                (this.point2.equals(temp.getFirstPoint()))  ));  
    }
    catch(Exception e) {
      return(false);
    }
  }
  
  /**
   * getFirstPoint() returns the first end point of the class.
   * @return GPoint Returns the first end point of the GLineSwgment.
   */
  public GPoint getFirstPoint() {
    return(point1);
  }
  
  /**
   * getSecondPoint() returns the second end point of the class.
   * @return GPoint Returns the second end point of the GLineSwgment.
   */
  public GPoint getSecondPoint(){
    return(point2);
  }
  
  /**
   * toString returns a description of the GLineSegment in the form
   * [<firstX,firstY>,<secondX,secondY>] where <firstX,firstY> and
   * <secondX,secondY> are the endpoints of the GLineSegment.
   * @return String The two points that are endpoints of the GLineSegment.
   */
  public String toString() {
    return("["+point1+","+point2+"]");
  }
}
  