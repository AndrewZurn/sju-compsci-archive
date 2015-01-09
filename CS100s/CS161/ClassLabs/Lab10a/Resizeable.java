import objectdraw.*;

public interface Resizeable {
 // change the size of an object to the new size 
  // Parameter: 
  //  xize - the new size of the object
  public void resize( double size);
  
    // Return true if the point is in the Resizeable object
    // Parameters:
    //    point - the point to test for containment
  public boolean contains(Location point);
}