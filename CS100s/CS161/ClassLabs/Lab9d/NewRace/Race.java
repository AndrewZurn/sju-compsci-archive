import objectdraw.*;
import java.awt.*;
/**
 * A race program between a rabbit and a turtle
 */

public class Race extends FrameWindowController{
// Location of start and end line for race 
  private static final int X_STARTLINE=28;
  private static final int Y_LINE=0;
  private static final double X_ENDLINE=300;
  private static final Location ANNOUNCE_LOCATION= new Location (30, 200); 
  
// initial locations for the rabbit and turtle
  private static final int RABBIT_X = 5;
  private static final int RABBIT_Y = 20;
  private static final int TURTLE_X = 5;
  private static final int TURTLE_Y = 100;
  
  
  private Rabbit rabbit;
  private Turtle turtle;
  
  private boolean raceDone = false;
  private Text announce;
  
  
  
  /**
   * initiate the screen   
   */
  public void begin() {
    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE,X_ENDLINE, canvas.getHeight(), canvas);
    announce = new Text("Click to start the race", ANNOUNCE_LOCATION, canvas); 
    
  }
  
  /**
   * Move the racers forward with each click
   */
  public void onMouseClick(Location point){
    rabbit = new Rabbit(RABBIT_X,RABBIT_Y, X_ENDLINE,  canvas, this);
    turtle = new Turtle(TURTLE_X,TURTLE_Y, X_ENDLINE, canvas, this);
    raceDone = false;
    
  }
  
  public void raceOver(String name) {
    if (!raceDone){
      if(name.equals("Rabbit")) {
        announce.setText("Rabbit wins!");
      }
      else { //turtle wins
        announce.setText ("Turtle wins!");
      }
      raceDone = true;
    }
  }
  
  
}