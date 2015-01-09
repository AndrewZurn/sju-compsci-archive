import objectdraw.*;
import java.awt.*;

// class to draw and manipulate a collection of nested rectangles.
public class NestedRects {
    private FramedRect outerRect;    // outermost rectangle in nested rectangles
    private NestedRects rest;        // inner nested rect
    
    // Draw nested rectangles at the given x and y coordinates and 
    // with the given height and width (both of which must be non-negative)
    public NestedRects(double x, double y, double width, 
                       double height, DrawingCanvas canvas) {
        outerRect = new FramedRect( x, y, width, height, canvas );
        if ( width >= 8 && height >= 8) {
            rest = new NestedRects(x+4, y+4, width-8, 
                                   height-8, canvas);
        } else {         // nothing more to construct
            rest = null;   
        }
    }
    
    public void move(double dx, double dy){
      outerRect.move(dx, dy);
      if(rest != null){
        rest.move(dx, dy);
      }
    }
    
    // Move nested rect to (x,y)
    public void moveTo(double x, double y) {
        outerRect.moveTo(x,y);
        if (rest != null) {
            rest.moveTo(x+4, y+4);
        }
    }
    
    // Remove the nested rect from the canvas
    public void removeFromCanvas() {
        outerRect.removeFromCanvas();
        if (rest != null) {
            rest.removeFromCanvas();
        }
    }
    
    public void setColor(Color newColor) {
      outerRect.setColor(newColor);
      if (rest != null){
        rest.setColor(newColor);
      }
    }
}
