import objectdraw.*;
import java.awt.*;

public class ShapeController extends FrameWindowController {

    private static final int CANVAS_WIDTH = 400;  // Width & height of canvas
    private static final int CANVAS_HEIGHT = 400;
    
    private ShapeGenerator generator;     // generator of new shapes
    private int numRight = 0;             // number of clicks that erased shapes

    // Create a shape generator of the desired size
    public void begin () {
        generator = new ShapeGenerator (CANVAS_WIDTH / 5, CANVAS_HEIGHT / 5, 
                                        CANVAS_WIDTH, CANVAS_HEIGHT, canvas);
    }
    
    /* If user presses the mouse button on the last shape drawn, remove it 
        from the canvas.  For every third time the user removes a shape, speed up  
        the drawing of new shapes. */
    public void onMousePress (Location point) {
        DrawableInterface lastShape = generator.getLastShape ();
        if (lastShape.contains (point)) {
            numRight = numRight + 1;
            lastShape.removeFromCanvas ();
            if (numRight % 3 == 0) {  // speed up if numRight is multiple of 3 
                generator.goFaster ();
            }
        }
    }

}
