import objectdraw.*;
import java.awt.*;

// Recursive structure for collection of nested rectangles
public class NestedRects implements NestedRectsIfc {
    private FramedRect outerRect;   // outermost rectangle in picture
    private NestedRectsIfc rest;    // remaining nested rectangles
    
    public NestedRects(double x, double y, double width, double height, 
                       DrawingCanvas canvas) {
        outerRect = new FramedRect(x, y, width, height, canvas);
        if (width >= 8 && height >= 8) {
            rest = new NestedRects( x + 4, y + 4, width - 8,
                                    height - 8, canvas);
        } else {       // construct a base object
            rest = new BaseRects();
        }
    }
    
    // move nested rectangles to (x,y)
    public void moveTo(double x, double y) {
        outerRect.moveTo(x, y);
        rest.moveTo(x + 4, y + 4);
    }
    
    // remove the nested rectangles from the canvas
    public void removeFromCanvas() {
        outerRect.removeFromCanvas();
        rest.removeFromCanvas();
    }
    
    public void setColor(Color newColor){
      outerRect.setColor(newColor);
      rest.setColor(newColor);
    }
}

