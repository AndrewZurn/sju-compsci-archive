import objectdraw.*;
import java.awt.*;

/**
 * 
 * Zurn, Andrew   Xu, Runbo   Ray, Kyle    BBall4Two Program
 *
 * program for two players to play basketball.
 * In this version the ball is not allowed to leave the window.
 */ 
public class BoundedBBall4Two extends FrameWindowController{
  
  /**
   * Location of the display
   */ 
  private static final int DISPLAY_X = 150;
  private static final int DISPLAY_Y = 200;
  private static final int DISPLAYSIZE = 16; // in points
  
  /**
   * Location and dimensions of the hoop
   */
  private static final int HOOPTOP = 50;
  private static final int HOOPLEFT = 160;
  private static final int HOOPWIDTH = 80;
  private static final int HOOPHEIGHT = 35;
  /**
   * Initial locations and dimensions of the balls
   */
  private static final int BALLX = 110;
  private static final int BALLY = 300;
  private static final int BALLSIZE = 40;
  private static final int BALLSPACING = 160;
  
  /**
   * Distance between balls and score displays
   */ 
  private static final int SCOREDOWNSET = BALLSIZE + 25;
  
  /**
   * the Text objects which display the scores
   */ 
  private Text leftDisplay, rightDisplay;
  
  /**
   * the oval that represent the hoop
   */ 
  private FramedOval hoop;
  
  /**
   * the two balls
   */ 
  private BBall leftBall, rightBall;
  
  /**
   * the ball currently being dragged
   */ 
  private BBall ballInPlay;
  
  /**
   * whether any ball is currently in play
   */ 
  private boolean carryingBall;
  
  /**
   * the scores for each player
   */ 
  private int leftScore = 0,   rightScore = 0;
  
  /**
   * the last previous known location of the mouse
   */ 
  private Location lastMouse;
  
  /**
   * initialize the counter and the text message
   */ 
  public void begin(){
    
    hoop = new FramedOval( HOOPLEFT, HOOPTOP, HOOPWIDTH, HOOPHEIGHT, canvas);
    
    leftBall = new BBall( BALLX, BALLY, BALLSIZE, canvas);
    rightBall = new BBall( BALLX + BALLSPACING, BALLY, BALLSIZE, canvas);
    
    leftDisplay = new Text("HOME 0", BALLX + BALLSIZE/2,BALLY + SCOREDOWNSET,  canvas);
    rightDisplay = new Text("VISITORS 0", BALLX + + BALLSPACING + BALLSIZE/2,BALLY + SCOREDOWNSET,   canvas);
    
    leftDisplay.setFontSize(DISPLAYSIZE);
    leftDisplay.move( - leftDisplay.getWidth()/2,0);
    rightDisplay.setFontSize(DISPLAYSIZE);
    rightDisplay.move( - rightDisplay.getWidth()/2,0);
  }
  
  /**
   * Note where mouse is depressed, whether a ball is being carried and if so,
   * which ball--set ballInPlay to = whatever ball is selected
   */ 
  public void onMousePress(Location point){  
    if (leftBall.contains(point)){
      carryingBall = true;
      ballInPlay = leftBall;
    }
    else if (rightBall.contains(point)){
      carryingBall = true;
      ballInPlay = rightBall;
    }
    
    lastMouse = point;
    // Complete code to figure out what ball contains the mouse and store this ball in ballInPlay
    // in such a case, set carryingBall to true to inform other methods that a ball has been 
    // selected by user for dragging (i.e. the user clicked inside one of the balls and not outside)
  }
  
  /**
   * Move the ball as the mouse is dragged
   */ 
  public void onMouseDrag(Location point){
    // If carryingBall has not been set to true in onMousePress then the user would not have been dragging
    // any of the balls and thus no movement needs to occur on the canvas
    // Notice that since ballInPlay is equal to either leftBall or rightBall then moving ballInPlay results 
    // in moving either leftBall or rightBall on the canvas (remember, equality assignment on objects is different 
    // than equality assignment on primitive data types)
    if (carryingBall) { 
      ballInPlay.move( point.getX() - lastMouse.getX(),point.getY() - lastMouse.getY() );
      lastMouse = point;
    }
  }
  
  /**
   * check to see if either player scored and update score accordingly
   */ 
  public void onMouseRelease(Location point){
    // Complete code below to update the score of the scoring ball by one
    // this assumes that carryingBall is true first
    if (carryingBall && hoop.contains(point)){
      if (leftBall.contains(lastMouse)){
        leftScore = leftScore + 2;
        leftDisplay.setText("Your score is " + leftScore );
      }
      if (rightBall.contains(lastMouse)){
        rightScore = rightScore + 2;
        rightDisplay.setText("Your score is " + rightScore );
      }
    }
    
    leftBall.reset();
    rightBall.reset();
    
    
  }
  
  
  
  
  
  
  
  /**
   * check to see if either player scored and updaete score accordingly
   */ 
  public void onMouseExit(Location point){
    // Complete code below to reset the ball which exited the canvas back to its initial spot
    // simply clearing the canvas won't do it because this will remove the scores as well
    // Don't forget to set carryingBall back to false
    if (carryingBall){
      if(leftBall.contains(lastMouse)){
        leftBall.reset();
      }
      if(rightBall.contains(lastMouse)){
        rightBall.reset();
      }
      carryingBall = false;
    }  
  }
}
