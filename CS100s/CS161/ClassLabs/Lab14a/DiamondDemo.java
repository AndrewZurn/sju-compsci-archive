import objectdraw.*;
import java.awt.*;

// creates a Diamond on the canvas
public class DiamondDemo extends FrameWindowController {
    
    private Diamond d;
    
    // location of last mouse press
    private Location lastPos;
    
    // draw the Diamond
    public void begin() {
        d = new Diamond( new Location( 12,200),
                          new Location( 50, 100),
                          canvas);
        
    }
    
    // remember the last press point
    public void onMousePress(Location pt) {
      lastPos = pt;
    }
    
    // move the Triangle with the mouse
    public void onMouseDrag(Location pt) {
        d.move( pt.getX()-lastPos.getX(),
                pt.getY()-lastPos.getY());
        lastPos = pt;
    }
    
    // print the vertices to the console
    public void onMouseRelease(Location pt) {
      Location[] pts = d.getVertices();
        for( int i = 0; i < pts.length; i++ ){
          System.out.println( pts[i] );
        }
    }
    
}
