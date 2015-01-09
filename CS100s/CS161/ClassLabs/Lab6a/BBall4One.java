import objectdraw.*;

/**
 *  This program allows the user to drag a fancy BBall around the screen.
 * Points are awarded when the ball is placed in the basket.
 */
public class BBall4One extends FrameWindowController{
  
  // Location of the display
  private static final int DISPLAY_Y = 200;
  private static final int DISPLAYSIZE = 16; // in points
  
  // Location and dimensions of the hoop
  private static final int HOOPTOP = 50;
  private static final int HOOPWIDTH = 80;
  private static final int HOOPHEIGHT = 35;
  
  // Initial location and dimensions of the ball
  private static final int BALLY = 300;
  private static final int BALLSIZE = 40;
  
  // the Text object which displays the count
  private Text display;
  
  // the oval that represent the hoop
  private FramedOval hoop;
  
  // the other oval (that represents the ball)
  private BBall ball;
  
  // whether or not player grabbed the ball with the mouse
  private boolean carryingBall;
  
  // the number of points
  private int score;
  
  // the last previous known location of the mouse
  private Location lastMouse;
  
  
  /**
   *  initialize the counter and the text message
   */
  public void begin() {
    score = 0;
    display = new Text("Your score is 0", 0, DISPLAY_Y, canvas);
    display.setFontSize(DISPLAYSIZE);
    display.move((canvas.getWidth() - display.getWidth())/2, 0);
    
    hoop = new FramedOval( (canvas.getWidth() - HOOPWIDTH)/2, HOOPTOP, 
                          HOOPWIDTH, HOOPHEIGHT, canvas);
    
    ball = new BBall( (canvas.getWidth() - BALLSIZE)/2, BALLY, 
                     BALLSIZE, canvas);
    
  }
  
  /**
   *  Note where mouse is depressed
   */
  public void onMousePress(Location point)
  {
    carryingBall = ball.contains(point);
    lastMouse = point;
  }
  
  /**
   *  Move the ball
   */
  public void onMouseDrag(Location point)
  {
    if ( carryingBall )
    {
      ball.move( point.getX() - lastMouse.getX(),
                point.getY() - lastMouse.getY()
                  );
      lastMouse = point;
    }
  }
  
  /**
   *  increment the counter and update the text
   */
  public void onMouseRelease(Location point) {
    if ( carryingBall && hoop.contains(point) ) {
      score = score + 2;
      display.setText("Your score is " + score );
    }
    
    ball.reset();
  }
}
