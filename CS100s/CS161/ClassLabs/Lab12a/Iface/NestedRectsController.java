import objectdraw.*;
import java.awt.*;

// creates a set of NestedRects and allows them to be dragged or removed
// according to the action of the mouse
public class NestedRectsController extends FrameWindowController {

    // dimensions of NestedRects
    private static final double WIDTH = 200,
                                HEIGHT = 100;

    private NestedRects rects;

    // draw a new set of NestedRects where the mouse was pressed
    public void onMousePress(Location point) {
        rects = new NestedRects( point.getX(), point.getY(), 
                                 WIDTH, HEIGHT, canvas );
        rects.setColor(Color.BLUE);
    }

    // move the rects with the mouse
    public void onMouseDrag(Location point) {
        rects.moveTo(point.getX(), point.getY());
    }
    
    // remove the rects from the canvas
    public void onMouseRelease(Location point) {
//        rects.removeFromCanvas();
    }    
}
