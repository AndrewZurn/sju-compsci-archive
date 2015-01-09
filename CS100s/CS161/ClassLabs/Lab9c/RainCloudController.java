import objectdraw.*;
import java.awt.*;

// creates a RainCloud when the mouse is clicked
public class RainCloudController extends FrameWindowController {

    // location of program instructions
    private static final Location INSTR_LOCATION = new Location(100,25);

    // ratio of canvas filled by the collector when the program starts
    private static final double COLLECTOR_RATIO = 0.0;
    
    private FilledRect collector;  // collects falling drops
    
    public void begin() {       
        // display instructions
        new Text("Click to make a rainstorm...", INSTR_LOCATION, canvas);
        
        // construct a collector for the falling drops
        collector = new FilledRect(0, canvas.getHeight()-canvas.getHeight()*COLLECTOR_RATIO,
                                   canvas.getWidth(), canvas.getHeight() * COLLECTOR_RATIO, canvas);
    }
    
    // hide the instructions and make the RainCloud
    public void onMouseClick(Location point) {
        new RainCloud( canvas, collector );
    }
}
