import objectdraw.*;
import java.awt.*;
/**
 * A race program between a rabbit and a turtle
 */

public class NewRace extends FrameWindowController{

  private static final int X_STARTLINE=28;
  private static final int Y_LINE=0;
  private static final int RABBIT_X = 5;
  private static final int RABBIT_Y = 20;
  private static final int TURTLE_X = 5;
  private static final int TURTLE_Y = 100;
  private RandomIntGenerator turtleMoves;
  private RandomIntGenerator rabbitMoves;
  private final int X_ENDLINE=300;

  private Rabbit rabbit;
  private Turtle turtle;
   private int highSpeedRabbit = PopUpInput.getInt("Please enter the highest speed for the rabbit (value between 1 and 20).");
   
  private  int lowSpeedRabbit = PopUpInput.getInt("Please enter the lowest speed for the rabbit (value between 1 and 20 but less than high speed).");
    private int highSpeedTurtle = PopUpInput.getInt("Please enter the highest speed for the turtle (value between 1 and 20).");
    private int lowSpeedTurtle = PopUpInput.getInt("Please enter the lowest speed for the turtle (value between 1 and 20 but less than high speed).");
 
  /**
   * *** The following two commented statements should be moved to the Rabbit and Turtle classes, respectively
   */ 
  //  private RandomIntGenerator rabbitMoves;
  // private RandomIntGenerator turtleMoves;


/**
 * initiate the screen   
 */
  public void begin() {
    //***move to Rabbit class
   
    
    //***move to Turtle class

     
    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE, X_ENDLINE, canvas.getHeight(), canvas);
  }
  
  /**
   * Create the racers 
   */
  public void onMouseClick(Location point){
    //The constructor methods of Rabbit and Turtle need to be updated to match the following
    rabbit = new Rabbit(RABBIT_X,RABBIT_Y, X_ENDLINE, highSpeedRabbit, lowSpeedRabbit, canvas);
    turtle = new Turtle(TURTLE_X,TURTLE_Y, X_ENDLINE, highSpeedTurtle,lowSpeedTurtle, canvas);
  
      start();
  }
  
}