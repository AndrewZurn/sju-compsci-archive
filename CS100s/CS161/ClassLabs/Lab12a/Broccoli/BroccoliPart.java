import objectdraw.*;
import java.awt.*;

/**
 * BroccoliPart is an interface for parts of broccoli.
 */
public interface BroccoliPart {
  // move the broccoli part by dx in the horizontal direction and
  // dy in the vertical direction
  public void move( double dx, double dy );

  
  // whether a point is contained in the broccoli part
  public boolean contains( Location point );
}
