import objectdraw.*;
import java.awt.*;

public class FallingBallController extends FrameWindowController {
    
    private static final Location INSTR_LOCATION = new Location(100,25); 
    
    public void begin() {       
        // display instructions
        new Text("Click to make a falling ball...", INSTR_LOCATION, canvas);
    }
    
    public void onMouseClick(Location point) {
        // make a new ball when the player clicks
        new FallingBall(point, canvas);
    }
}       
