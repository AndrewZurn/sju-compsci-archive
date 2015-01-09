import objectdraw.*;
import java.awt.*;

// Class to draw a brick wall
public class Wall extends FrameWindowController {
    
    // position and dimensions of the wall
    private static final double WALL_X = 15;
    private static final double WALL_Y = 250;
    private static final int WALL_HEIGHT = 7;
    private static final int WALL_WIDTH = 15;
    
    // dimensions of a brick
    private static final double BRICK_HEIGHT = 15 ;
    private static final double BRICK_WIDTH = 45;
    
    public void begin() { 
        // initial x and y positions for drawing a brick
        double brickX = WALL_X;
        double brickY = WALL_Y;
        
        int level = 0; // number of levels drawn so far
        int bricksInLevel = 0; // number of bricks drawn in the current level
        
        while ( level < WALL_HEIGHT) {
            bricksInLevel = 0;
            brickX = WALL_X;
            // draw one row of bricks
            while (bricksInLevel < WALL_WIDTH) {
                new FilledRect(brickX, brickY, BRICK_WIDTH,
                               BRICK_HEIGHT, canvas);
                new FramedRect(brickX, brickY, BRICK_WIDTH,
                               BRICK_HEIGHT, canvas).setColor(Color.yellow);
                brickX = brickX + BRICK_WIDTH;
                bricksInLevel++;
            }
            brickY = brickY - BRICK_HEIGHT;
            level++;
        }
    }       
}
