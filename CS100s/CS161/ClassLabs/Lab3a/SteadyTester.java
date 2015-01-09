import objectdraw.*;
import java.awt.*;

     //  A program to detect when two consecutive mouse clicks
     //  occur at exactly the same canvas coordinates
public class SteadyTester extends FrameWindowController
{
            //  where to display the word "STEADY"
    private static final Location MESSAGE_LOCATION = new Location(100, 100);
    
            //  Text of the message "STEADY"
    private Text steadyMessage;
    
             //  Last position clicked on
    private Location lastPoint = new Location( -1, -1 );


             //  Create and hide the "STEADY" message
    public void begin() 
    {
        steadyMessage = new Text("STEADY", MESSAGE_LOCATION, canvas );
        steadyMessage.hide();
     }

              //  Display "STEADY" if location of click has not changed
    public void onMouseClick( Location point )
    {
        if ( point.equals(lastPoint) ) { // Need to test that the points are the same
            steadyMessage.show();
        } else {
            steadyMessage.hide();
        }
        
        lastPoint = point;
    }
    
}
