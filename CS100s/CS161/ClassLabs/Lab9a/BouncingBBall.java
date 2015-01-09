import objectdraw.*;
import java.awt.*;
import java.applet.AudioClip;

// basket ball with pretty pictures and sound
public class BouncingBBall extends FrameWindowController{
    
    // size of the display in points
    private static final int DISPLAYSIZE = 16;
    
    // Location and dimensions of the hoop
    private static final int HOOPTOP = 100;
    private static final int HOOPLEFT = 160;
    
    // Initial locations and dimensions of the balls
    private static final int BALLX = 70;
    private static final int BALLY = 420;
    private static final int BALLSPACING = 230;
    
    // Distance between balls and score displays
    private static final int SCOREDOWNSET =  55;
    
    // the Text objects which display the scores
    private Text leftDisplay, rightDisplay;
    
    // whether any ball is currently in play
    private boolean ballGrabbed;
    
    // the scores for each player
    private int leftScore = 0,
        rightScore = 0;
    
    // the last previous known location of the mouse
    private Location lastMouse;
    
    // where to send ball back to when done
    private Location ballInitPos;
    
    // ActiveObject that makes the ball dribble
    private Dribbler player;
        
    // the oval that represent the hoop
    private VisibleImage hoop;
    
    // the two balls
    private VisibleImage leftBall, rightBall;
    
    // the ball currently being dragged
    private VisibleImage ballInPlay;
    
    // create the balls, hoop and score displays
    public void begin() {
        
        
      hoop = new VisibleImage( getImage("hoop.gif"), HOOPLEFT, HOOPTOP, canvas);
      Image ballpic = getImage("bball.gif");
      
      leftBall = new VisibleImage( ballpic, BALLX, BALLY, canvas);
      rightBall = new VisibleImage( ballpic, BALLX + BALLSPACING, BALLY, canvas);
      
      leftDisplay = new Text("HOME 0",
                             BALLX + leftBall.getWidth()/2, 
                             BALLY + leftBall.getHeight() + SCOREDOWNSET,
                             canvas);
      rightDisplay = new Text("VISITORS 0",
                              BALLX + BALLSPACING + rightBall.getWidth()/2,
                              BALLY + rightBall.getHeight() + SCOREDOWNSET,
                              canvas);
      
      leftDisplay.setFontSize(DISPLAYSIZE);
      leftDisplay.move( - leftDisplay.getWidth()/2,0);
      rightDisplay.setFontSize(DISPLAYSIZE);
      rightDisplay.move( - rightDisplay.getWidth()/2,0);
    }
    
    
    // If mouse moves over a ball, start dribbling, then make
    // ball follow mouse
    public void onMouseMove( Location point )
    {
      if ( ballInPlay != null )
      {
        onMouseDrag( point );
      }
      else {
        if ( leftBall.contains( point ) )
        {
          ballInPlay = leftBall;
          ballInitPos = ballInPlay.getLocation();
        }
        else if ( rightBall.contains( point ) )
        {
          ballInPlay = rightBall;
          ballInitPos = ballInPlay.getLocation();
        }
        if ( ballInPlay != null )
        {
          ballInPlay.moveTo( point.getX() - ballInPlay.getWidth()/2,
                            point.getY());
          player = new Dribbler( ballInPlay );
        }
      }
      lastMouse = point;
    }
    
    
    // try to grab the ball and hold it
    public void onMousePress(Location point)
    {
      lastMouse = point;
      if ( ballInPlay == null ) {
        if ( leftBall.contains( point ) )
        {
          ballInPlay = leftBall;
          ballInitPos = ballInPlay.getLocation();
        }
        else if ( rightBall.contains( point ) )
        {
          ballInPlay = rightBall;
          ballInitPos = ballInPlay.getLocation();
        }
      } else {
        player.stopDribbling();
        player = null;
        ballInPlay.moveTo( point.getX() - ballInPlay.getWidth()/2,
                          point.getY() - ballInPlay.getHeight()/2);
      }
    }
    
    // Move the ball as the mouse is dragged
    public void onMouseDrag(Location point)
    {
      if ( ballInPlay != null )
      {
        ballInPlay.move( point.getX() - lastMouse.getX(),
                        point.getY() - lastMouse.getY() );
        lastMouse = point;
      }
    }
    
    // check to see if either player scored
    public void onMouseRelease(Location point) {
      if ( hoop.contains(point) ) {
        if ( ballInPlay == leftBall )
        {
          leftScore = leftScore + 2;
          leftDisplay.setText("HOME " + leftScore );
        }
        else if ( ballInPlay == rightBall )
        {
          rightScore = rightScore + 2;
          rightDisplay.setText("VISITORS " + rightScore);
        }
      }
      dropTheBall();
    }
    
    public void onMouseExit( Location point )
    {
      dropTheBall();
    }
    
    
    // Return the ball to start if it has been moved
    private void dropTheBall( )
    {
      if ( ballInPlay != null )
      {
        ballInPlay.moveTo(ballInitPos);
        ballInPlay = null;
        if ( player != null)
        {
          player.stopDribbling();
          player = null;
        }
      }
      
    }
    
}
