import objectdraw.*;
import java.awt.*;

/**
 * A race program between a rabbit and a turtle
 */
public class Race extends FrameWindowController{
// Location of start and end line for race 
  private static final int X_STARTLINE=28;
  private static final int Y_LINE=0;
  private static final double X_ENDLINE=250;
  private static final Location ANNOUNCE_LOCATION= new Location (30, 20); 
  
// initial locations for the first contestant
  private static final double RACER_X = 5;
  private static final double RACER_Y = 50;
  private static final double SPACING = 50;
  
  private Rabbit rabbit;
  private Turtle turtle;
  
  private boolean raceDone = false;
  private Text announce;
  
  

/**
 * initiate the screen   
 */
  public void begin() {
    resize(300, 500);
    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE,X_ENDLINE, canvas.getHeight(), canvas);
    rabbit = new Rabbit(RACER_X, RACER_Y, X_ENDLINE, canvas, this);
    turtle = new Turtle(RACER_X, RACER_Y + SPACING, X_ENDLINE, canvas, this );
    turtle.setColor(Color.GREEN);
       
    announce = new Text("Click to start the race", ANNOUNCE_LOCATION, canvas); 
 
  }
  
  /**
   * Start the racers on a mouse click
   */
  public void onMouseClick(Location point){
    rabbit.start();
    turtle.start();
  }
  
/**
 * Declare a winner
 */
  public void raceOver(String name) {
    if (!raceDone){
         announce.setText(name + " wins!");
      }
      raceDone = true;    
  }
  
 
}