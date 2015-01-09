import objectdraw.*;
import java.awt.*;

// Class to draw a nice brick wall
public class BetterWall extends FrameWindowController {
    
    // level and dimensions of the wall
    private static final double WALL_Y = 250;
    private static final double WALL_LEFT = 20;
    private static final double WALL_RIGHT = 470;
    
    // number of rows and columns in the wall
    private static final int WALL_HEIGHT = 7;
    private static final int WALL_WIDTH = 10;
    
    // dimensions of a brick
    private static final double BRICK_HEIGHT = 15 ;
    private static final double BRICK_WIDTH = 45;
    
    public void begin() {
        
        // initial x and y positions for drawing a brick
        double brickX = WALL_LEFT;
        double brickY = WALL_Y;
        
        int level = 0; // number of levels drawn so far
        int bricksInLevel = 0; // number of bricks drawn in the current level
        
        while ( level < WALL_HEIGHT ) {
            if (level % 2 != 0) {
                // draw two half-bricks
                new FilledRect(WALL_LEFT, brickY,
                               BRICK_WIDTH/2, BRICK_HEIGHT, canvas);
                new FramedRect(WALL_LEFT, brickY,
                               BRICK_WIDTH/2, BRICK_HEIGHT, canvas).setColor(Color.yellow);
                new FilledRect(WALL_RIGHT-BRICK_WIDTH/2, brickY,
                               BRICK_WIDTH/2, BRICK_HEIGHT, canvas);
                new FramedRect(WALL_RIGHT-BRICK_WIDTH/2, brickY,
                               BRICK_WIDTH/2, BRICK_HEIGHT, canvas).setColor(Color.yellow);
                brickX = WALL_LEFT + BRICK_WIDTH/2;
                bricksInLevel = 1; // already placed two half-bricks
            } else {
                brickX = WALL_LEFT;
                bricksInLevel = 0;
            }
            while (bricksInLevel < WALL_WIDTH ) {
                new FilledRect(brickX, brickY, BRICK_WIDTH,
                               BRICK_HEIGHT, canvas);
                new FramedRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT,
                               canvas).setColor(Color.yellow);
                brickX = brickX + BRICK_WIDTH;
                bricksInLevel++;
            }
            brickY = brickY - BRICK_HEIGHT;
            level++;
        }
    }   
}       
