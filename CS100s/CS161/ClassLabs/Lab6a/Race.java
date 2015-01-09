import objectdraw.*;
import java.awt.*;
/**
 * A race program between a square and an oval
 */

public class Race extends FrameWindowController{
/**
 * FilledRect object that represents the rabbit in the race
 */
  private Rabbit rabbit;
/**
 * Turtle object that represents the turtle in the race
 */
  private Turtle turtle;
/**
 * X value for the start line 
 */
  private static final int STARTLINE=28;
/**
 * X value for the finish line 
 */
  private static final int ENDLINE=300;

/**
 * initiate the screen   
 */
  public void begin() {
    new Line(STARTLINE, 0, STARTLINE, canvas.getHeight(), canvas);
    new Line(ENDLINE, 0,ENDLINE, canvas.getHeight(), canvas);
    
    rabbit = new Rabbit(5,20, 25, 25, canvas);
    rabbit.setColor(Color.GRAY);
    turtle = new Turtle(5,100, canvas);
    turtle.setColor(Color.GREEN);
    new Turtle(50,200,canvas).setColor(Color.GREEN);
    new Turtle(80,200,canvas).setColor(Color.GREEN);
    new Turtle(110,200,canvas).setColor(Color.GREEN);
    new Turtle(140,200,canvas).setColor(Color.GREEN);
    new Turtle(50,230,canvas).setColor(Color.GREEN);
    new Turtle(80,230,canvas).setColor(Color.GREEN);
    new Turtle(110,230,canvas).setColor(Color.GREEN);
    new Turtle(140,230,canvas).setColor(Color.GREEN);
  }
  
  /**
   * Move the racers forward with each click
   */
  public void onMouseClick(Location point){
    if(((rabbit.getX()+25)<ENDLINE) && ((turtle.getX()+25)<ENDLINE)) {
      rabbit.move(Math.random()*15, 0);
      turtle.move(Math.random()*15, 0);
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