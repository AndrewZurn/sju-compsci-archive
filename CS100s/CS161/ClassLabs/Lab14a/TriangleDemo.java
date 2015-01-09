import objectdraw.*;
import java.awt.*;

// creates a Triangle on the canvas
public class TriangleDemo extends FrameWindowController {
    
    private Triangle t;
    
    // location of last mouse press
    private Location lastPos;
    private Location vertices[] = new Location[3];
    private boolean triangleMade = false;
    private int count = 0;
    
    // draw the Triangle
    public void begin() {}
        /*t = new Triangle( new Location( 100,100),
                          new Location( 50, 200),
                          new Location( 250, 100),
                          canvas);
        
    
    
    // remember the last press point
    public void onMousePress(Location pt) {
        lastPos = pt;
    }
    
    // move the Triangle with the mouse
    public void onMouseDrag(Location pt) {
        t.move( pt.getX()-lastPos.getX(),
                pt.getY()-lastPos.getY());
        lastPos = pt;
    }
    
    // print the vertices to the console
    public void onMouseRelease(Location pt) {
        Location[] pts = t.getVertices();
        for( int i = 0; i < pts.length; i++ ){
            System.out.println( pts[i] );
        }
    }
    */
    public void onMouseClicK(Location pt){
      if(!triangleMade){
        vertices[count] = pt;
        count++;
        if(count == 3 ){
          triangleMade = true;
    t = new Triangle (vertices[0], vertices[1], vertices[2], canvas);
        }
      }
    }
    
    
    //public void onMouseEnter(Location pt){
      //t.show();
    //}
    
}
