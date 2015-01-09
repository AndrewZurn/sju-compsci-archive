import objectdraw.*;
import java.awt.*;

public class StoppingBallController extends FrameWindowController {
    
    private static final Location INSTR_LOCATION = new Location(100,25); 
    
    private FallingBall droppedBall;  // the falling ball
    private FallingBall2 secondBall;

    public void begin() {       
        // display instructions
        new Text("Click to make a falling ball...", INSTR_LOCATION, canvas);
    }
    
    public void onMouseClick(Location point) {
        // make a new ball when the player clicks
        droppedBall = new FallingBall(point,  canvas);
        point.translate(20, 0);
        secondBall = new FallingBall2(point, droppedBall, canvas);
    }

    public void onMouseExit(Location point) {
        if (droppedBall != null && secondBall != null) {
            //droppedBall.changeDirection();
            secondBall.changeDirection();
        }
       
        }
    } 
