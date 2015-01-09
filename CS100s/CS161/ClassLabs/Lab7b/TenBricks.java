import objectdraw.*;
import java.awt.*;

// Draws ten bricks
public class TenBricks extends FrameWindowController {
    
    // position and radius of the moon
    private static final int MOON_INSET = 50;
    private static final int MOON_SIZE = 70;
    
    // dimensions of a brick
    private static final double BRICK_HEIGHT = 15 ;
    private static final double BRICK_WIDTH = 30;
    
    // level and spacing of bricks
    private static final double BRICK_TOP = 285;
    private static final double BRICK_SPACING = 3;

    // maximum number of bricks to draw
    private static final int BRICKS_TOTAL = 10;
    
    public void begin() {
        // draw the moon
        new FilledOval(MOON_INSET,MOON_INSET,MOON_SIZE,MOON_SIZE,canvas);
        
        // draw bricks along the bottom of the canvas
        double brickPosition = 0;  // x coordinate of the next brick
        double brickCount = BRICKS_TOTAL; // number of bricks drawn so far
        while ( brickCount > 0 ) {
            new FilledRect(brickPosition, BRICK_TOP,
                           BRICK_WIDTH, BRICK_HEIGHT,canvas);
            brickPosition = brickPosition + BRICK_WIDTH + BRICK_SPACING;
            brickCount--;
        }
    }
}
