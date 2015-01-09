
import objectdraw.*;
import java.awt.*;
/**
 * A race program between a square and an oval
 */

public class RaceStarter extends FrameWindowController{
//list variables to be used in Race program
  private FilledOval hare;
  private FilledRect turtle;
  private FilledRect grass;
  private Line start;
  private Line finish;
  private RandomIntGenerator speed;
  private Text instructions1;
  private Text instructions2;
  private FilledRect turtletrack;
  private FilledRect haretrack;

/**
 * initiate the screen   
 */
  public void begin() {
   
  //Create start and finish line
    //start=new Line( 50, 50, 50, 360, canvas);
    //finish=new Line( 325, 50, 325, 360, canvas);
    
  //Create a green grassy background
    grass=new FilledRect( 0, 0,  canvas.getWidth(), canvas.getHeight(), canvas);
    grass.setColor(new Color(0, 100, 0));
    
  //Create instructions in screen
    instructions1=new Text("Click the Mouse Repeatedly", canvas.getWidth()/4, (canvas.getHeight()/2), canvas);
    instructions2=new Text("to Race Along the Track", (canvas.getWidth()/4) + 13, (canvas.getHeight()/2 + canvas.getHeight()/16), canvas);
    
  //Create and color racing lanes
  
    turtletrack=new FilledRect (0, (canvas.getHeight() - canvas.getHeight()/3.48), canvas.getWidth(), 65, canvas);
    haretrack=new FilledRect (0, (canvas.getHeight()/2 - canvas.getHeight()/2.64), canvas.getWidth(), 65, canvas);
    turtletrack.setColor(new Color(210, 180, 140));
    haretrack.setColor(new Color(210, 180, 140));
    
  //Create lines proportional to window size
    start=new Line( (canvas.getWidth()/8), (canvas.getHeight()/8), (canvas.getWidth()/8), (canvas.getHeight()), canvas);
    finish=new Line( (canvas.getWidth() - canvas.getWidth()/8), (canvas.getHeight()/8), (canvas.getWidth() - canvas.getWidth()/8), (canvas.getHeight()), canvas);

  //Create the 'hare' and the 'turtle'
  hare=new FilledOval ( 3, (canvas.getHeight() - canvas.getHeight()/1.19), 45, 35, canvas);
  turtle=new FilledRect ( 3, (canvas.getHeight() - canvas.getHeight()/4), 45, 35, canvas);
  
  //Color 'hare' gray and 'turtle' green
  hare.setColor(Color.GRAY);
  turtle.setColor(Color.GREEN);
  
  
  //Create RandomIntGenerator
  speed=new RandomIntGenerator( 5, 10);
  }
  
  
  /**
   * Move the racers forward with each click
   */
  public void onMouseClick(Location point){
    hare.move(speed.nextValue(), 0);
    turtle.move(speed.nextValue(), 0);
    instructions1.hide();
    instructions2.hide();  
  }
  
  public void onMouseExit (Location point){
    hare.moveTo(3, (canvas.getHeight() - canvas.getHeight()/1.19));
    turtle.moveTo(3, (canvas.getHeight() - canvas.getHeight()/4));
    instructions1.show();
    instructions2.show();
  }
}