
import objectdraw.*;
import java.awt.*;

/**
 *  plays a classic version of single player pong
 */
public class Pong extends FrameWindowController{
  
  private static final int
    // Dimensions of the court
    courtLeft = 50,
    courtTop = 50,
    courtHeight = 300,
    courtWidth = 250,
    
    // Dimensions of the paddle
    paddleWidth = 195,
    paddleHeight = 20;
  
  private FilledRect paddle; // the paddle
  private MovingBall theBall;
  
  private FramedRect boundary; // the boundary of the playing area.
  
  private Text theScore;
  private int score = 0;
  
  public void begin()
  {
    // make the playing area
    boundary = new FramedRect(courtLeft,courtTop,
                              courtWidth, courtHeight,
                              canvas);
    theScore = new Text("Score: ", 10, 10, canvas);
    // make the paddle
    paddle =
      new FilledRect(courtLeft + (courtWidth-paddleWidth)/2,
                     courtTop + courtHeight - paddleHeight -1,
                     paddleWidth, paddleHeight,
                     canvas);
    //theBall = new MovingBall(canvas, paddle, boundary, this);
  }
  
  /**
   * Start the ball moving on mouse click
   */
  public void onMouseClick(Location point)
  {
    // make a new ball when the player clicks
theBall = new MovingBall(canvas, paddle, boundary, this);
    //theBall.start();
    
  }
  
  /** 
   * move the paddle with the mouse but stay on the court
   */
  public void onMouseMove(Location point)
  {
    if ( point.getX() < courtLeft )
    {
      // place paddle at left edge of the court
      paddle.moveTo( courtLeft,
                    courtTop + courtHeight - paddleHeight -1);
    }
    else if ( point.getX() > courtLeft + courtWidth - paddleWidth)
    {
      // place paddle at right edge of the court
      paddle.moveTo( courtLeft + courtWidth - paddleWidth,
                    courtTop + courtHeight - paddleHeight -1);
    }
    else
    {
      // keep the edge of the paddle lined up with the mouse
      paddle.moveTo( point.getX(),
                    courtTop + courtHeight - paddleHeight -1);
    }
  }
  
/**
 * change the score of the game
 */
  public void addToScore(){
    score++;
    theScore.setText("Score: " + score);
  }
  
}
