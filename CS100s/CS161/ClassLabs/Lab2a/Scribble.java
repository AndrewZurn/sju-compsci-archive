import objectdraw.*;
import java.awt.*;

/**
 * This program allows its user to draw simple lines on the screen
 * using the mouse as if it were a pencil.
 */
 
public class Scribble extends FrameWindowController {

    Location previousPosition;   // Last known position of mouse

    // When the mouse button is depressed, note its location
    public void onMousePress( Location pressPoint) {
        previousPosition = pressPoint;
    }   

    // Connect current and previous mouse positions with a line
    public void onMouseDrag( Location currentPosition) {
        new Line( previousPosition, currentPosition, canvas);
        previousPosition = currentPosition;
    }

}
