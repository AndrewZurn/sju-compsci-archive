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
  private RandomIntGenerator rabbitMoves;
  private RandomIntGenerator turtleMoves; 

/**
 * initiate the screen   
 */
  public void begin() {

    int highSpeedRabbit = PopUpInput.getInt("Please enter the highest speed for the rabbit (value between 1 and 20).");
    int lowSpeedRabbit = PopUpInput.getInt("Please enter the lowest speed for the rabbit (value between 1 and 20 but less than high speed).");
    rabbitMoves = new RandomIntGenerator(lowSpeedRabbit, highSpeedRabbit);

    int highSpeedTurtle = PopUpInput.getInt("Please enter the highest speed for the turtle (value between 1 and 20).");
    int lowSpeedTurtle = PopUpInput.getInt("Please enter the lowest speed for the turtle (value between 1 and 20 but less than high speed).");
    turtleMoves= new RandomIntGenerator(lowSpeedTurtle , highSpeedTurtle);

    new Line(X_STARTLINE, Y_LINE, X_STARTLINE, canvas.getHeight(), canvas);
    new Line(X_ENDLINE, Y_LINE,X_ENDLINE, canvas.getHeight(), canvas);
    rabbit = new Rabbit(RABBIT_X,RABBIT_Y, canvas);
    turtle = new Turtle(TURTLE_X,TURTLE_Y, canvas);
 
  }
  
  /**
   * Move the racers forward with each click
   */
  public void onMouseClick(Location point){
    if(((rabbit.getX()+25)<X_ENDLINE) && ((turtle.getX()+25)<X_ENDLINE)) {
      rabbit.move(rabbitMoves.nextValue(), 0);
      turtle.move(turtleMoves.nextValue(), 0);
    }
    else if(rabbit.getX()>turtle.getX()) {
      new Text("Rabbit wins.",100,100,canvas);
      new Text("BOO, HISS",50,280,canvas);
    }
    else {
      new Text("Turtle wins.",100,100,canvas);
      new Text("HOORAY, HOORAY",50,280,canvas);
    }
    
  }
}