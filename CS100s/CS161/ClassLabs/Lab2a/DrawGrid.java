import objectdraw.*;
import java.awt.*;

/**A program that uses the translate method to draw a
*grid of thick black lines on the canvas
*/
public class DrawGrid extends FrameWindowController{

    // The corners of the next two rectangles to draw
    private Location verticalCorner, horizontalCorner;

    // Set Locations to position first pair of lines at upper
    // left corner of the canvas
    public void begin() {
        horizontalCorner = new Location(0, 0);
        verticalCorner = new Location(0, 0);
    }

    // Draw a pair of lines and move Locations so that the next
    // pair of lines will appear further down and to the right
    public void onMouseClick(Location point) {
        new FilledRect(verticalCorner, 5, 200, canvas);
        new FilledRect(horizontalCorner, 200, 5, canvas);

        verticalCorner.translate(10, 0);
        horizontalCorner.translate(0, 10);
    }
}