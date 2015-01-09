public interface GLineSegmentInterface {
  /**
   * slope() returns the slope of the GLineSegment
   * @return Double Returns the slope of the GLineSegment.
   * @throws VerticalRuntimeException.
   */
  public Double slope() throws VerticalLineRuntimeException;
  
  /**
   * isVertical() returns true if this GLineSegment is vertical.
   * @return boolean Returns true if this is a vertical line segment.
   */
  public boolean isVertical();
  
  /** intersects(lineSegment) returns true if lineSegment and this
    * GLineSegment intersect.
    * @param lineSegment lineSegment is another GLineSegment
    * @return boolean Returns true if and only if this GLineSegment and
    * lineSegment intersect.
    */
  public boolean intersects(GLineSegment lineSegment);
  
  /**
   * public boolean equals(lineSegment) returns true if the two lines are
   * equal to each other.
   * @param lineSegment The other line segment we are comparing with this.
   * @return boolean Returns true if and only if this GLineSegment and
   * lineSegment are the same.
   */
  public boolean equals(Object lineSegment); 
  
  /**
   * getFirstPoint() returns the first end point of the class.
   * @return GPoint Returns the first end point of the GLineSwgment.
   */
  public GPoint getFirstPoint();
  
  /**
   * getSecondPoint() returns the second end point of the class.
   * @return GPoint Returns the second end point of the GLineSwgment.
   */
  public GPoint getSecondPoint();
  
  /**
   * toString returns a description of the GLineSegment in the form
   * [<firstX,firstY>,<secondX,secondY>] where <firstX,firstY> and
   * <secondX,secondY> are the endpoints of the GLineSegment.
   * @return String The two points that are endpoints of the GLineSegment.
   */
  public String toString();
  
  /**
   * midpoint() returns the point which is the midpoint of this
   * GLineSegment.
   * @return GPoint Returns the GPoint which is the midpoint of this GLineSegment.
   */
  public GPoint midpoint();
  
  /**
   * translation(xMovement,yMovement) moves this GLineSegment xMovement
   * in the X direction and yMovement in the Y direction.
   * @param xMovement The amount we move this GLineSegment in the X direction
   * @param yMovement The amount we move this GLineSegment in the Y direction
   */
  public void translation(Double xMovement,Double yMovement);
}

  