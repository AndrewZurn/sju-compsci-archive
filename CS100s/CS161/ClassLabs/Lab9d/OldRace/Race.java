import objectdraw.*;
import java.awt.*;
/**
 * A race program between a rabbit and a turtle
 */

public class Race extends FrameWindowController{

  private static final int X_STARTLINE=28;
  private static final int Y_LINE=0;
  private static final int RABBIT_X = 5;
  private static final int RABBIT_Y = 20;
  private static final int TURTLE_X = 5;
  private static final int TURTLE_Y = 100;
  
  
  private final int X_ENDLINE=300;

  private Rabbit rabbit;
  private Turtle turtle;
  
//  private RandomIntGenerator rabbitMoves=new RandomIntGenerator(0,14);
// private RandomIntGenerator turtleMoves=new RandomIntGenerator(5,10);


/**
 * initiate the screen   
 */
  public void begin() {
    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE, X_ENDLINE, canvas.getHeight(), canvas);

  }
  
  /**
   * Create the racers 
   */
  public void onMouseClick(Location point){
    
    rabbit = new Rabbit(RABBIT_X,RABBIT_Y, X_ENDLINE, canvas);
    turtle = new Turtle(TURTLE_X,TURTLE_Y, X_ENDLINE, canvas);
 

  }
  
}
