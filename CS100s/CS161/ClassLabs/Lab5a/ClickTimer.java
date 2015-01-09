import objectdraw.*;
import java.awt.*;

/*
 *  A program to measure the duration of mouse clicks.
 */
public class ClickTimer extends FrameWindowController {
  
  // location where messages should be displayed
  private final static Location TEXT_POS = new Location( 30, 50);
  private final static Location TEXT_POS_TWO = new Location( 30, 70);
  
  // When the mouse button was depressed
  private double startingTime;
  private double endTime;
  private double firstTime;
  // Used to display length of click
  private Text message;   
  private Text sinceFirstClick;
  private boolean firstClick = true;
  
  /*
   *  Create the Text to display the current count
   */
  public void begin() {
    message = new Text( "Please depress and release the mouse",
                       TEXT_POS, canvas );
    sinceFirstClick = new Text ( " ", TEXT_POS_TWO, canvas);
    
  }
  
  /*
   *  Record the time that the button is pressed
   */
  public void onMouseClick(Location point) {
    firstTime = System.currentTimeMillis();
    
    if (firstClick){
      startingTime = System.currentTimeMillis();
    }
    else{
      message.setText ("You time was " +
                       ( System.currentTimeMillis() - startingTime)/1000 + 
                       " seconds"     );
    }
    firstClick = !firstClick;
    sinceFirstClick.setText ("It has been " + (System.currentTimeMillis() + firstTime)/1000 + " seconds" );
    
    
  }
  
  
}

