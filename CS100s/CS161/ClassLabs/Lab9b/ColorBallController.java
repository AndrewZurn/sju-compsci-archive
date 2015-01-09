import objectdraw.*;
import java.awt.*;

public class ColorBallController extends FrameWindowController {
    
    private static final Location INSTR_LOCATION = new Location(100,25);
    
    private FallingBall droppedBall; // the falling ball
    
    public void begin() {       
        // display instructions
        new Text("Click to make a falling ball...", INSTR_LOCATION, canvas);
    }
    
    public void onMouseClick(Location point) {
        // make a new ball when the player clicks
        droppedBall = new FallingBall(point, canvas);
    }
    
    public void onMouseExit(Location point) {
        if (droppedBall != null) {
            droppedBall.setColor(Color.GREEN);
        }
    }
    
    public void onMouseEnter(Location point) {
        if (droppedBall != null) {
            droppedBall.setColor(Color.black);
        }
    }
}
