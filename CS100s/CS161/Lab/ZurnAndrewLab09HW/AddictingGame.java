import objectdraw.*;
import java.awt.*;


// Zurn, Andrew  AddictingGameController class
public class AddictingGame extends FrameWindowController {
  
  //other
  private Location lastPoint;
  
  
  //Locations of boxes
  private Location blueBoxOne = new Location (75, 75);
  private Location blueBoxTwo = new Location (195, 65);
  private Location blueBoxThree = new Location (70, 245);
  private Location blueBoxFour = new Location (255, 215);
  private double redBoxX = (canvas.getWidth() - 35);
  private double redBoxY = (canvas.getHeight() - 35);
  
  
  //Dimensions of boxes
  private static final int BLUE_ONE_THREE_WIDTH = 25;
  private static final int BLUE_ONE_THREE_HEIGHT = 75;
  private static final int BLUE_TWO_FOUR_WIDTH = 70;
  private static final int BLUE_TWO_FOUR_HEIGHT = 20;
  private static final int RED_WIDTH = 35;
  private static final int RED_HEIGHT = 35;
  
  //Variable names for boxes
  private BlueBox blueOne;
  private BlueBox blueTwo;
  private BlueBox blueThree;
  private BlueBox blueFour;
  private FilledRect red;
  private Timer timer;
  
  //In play area
  private FilledRect inArea;
  private static final double IN_AREA_X = 35;
  private static final double IN_AREA_Y = 35;
  private static final double IN_WIDTH = 305;
  private static final double IN_HEIGHT = 295;
  
  
  //Out play area
  private FilledRect outArea;
  private static final int OUT_AREA_X = 0;
  private static final int OUT_AREA_Y = 0;
  
  
  //Boolean(s)
  private boolean drag = false;
  private boolean newGame = true;
  private Location point;
  
  public void begin(){
    
    outArea = new FilledRect (OUT_AREA_X, OUT_AREA_Y, canvas.getWidth(), canvas.getHeight(), canvas);
    inArea = new FilledRect (IN_AREA_X, IN_AREA_Y, IN_WIDTH, IN_HEIGHT, canvas);
    inArea.setColor(Color.WHITE);
    red = new FilledRect ((canvas.getWidth()/2) - 35, (canvas.getHeight()/2) - 35, RED_WIDTH, RED_HEIGHT, canvas);
    red.setColor(Color.RED);
    
  }
  
  public void onMousePress (Location point){
    if (red.contains(point)){
      drag = true;
      lastPoint = point;
    }
    if(newGame){
      newGame = false;
      
      
      
      blueOne = new BlueBox (blueBoxOne, BLUE_ONE_THREE_WIDTH, BLUE_ONE_THREE_HEIGHT, Color.BLUE,
                             red, inArea, IN_WIDTH, IN_HEIGHT,   canvas);
      blueTwo = new BlueBox (blueBoxTwo, BLUE_TWO_FOUR_WIDTH, BLUE_TWO_FOUR_HEIGHT, Color.BLUE,
                             red, inArea, IN_WIDTH, IN_HEIGHT, canvas);
      blueThree = new BlueBox (blueBoxThree, BLUE_ONE_THREE_WIDTH, BLUE_ONE_THREE_HEIGHT, Color.BLUE,
                               red, inArea, IN_WIDTH, IN_HEIGHT, canvas);
      blueFour = new BlueBox (blueBoxFour, BLUE_TWO_FOUR_WIDTH, BLUE_TWO_FOUR_HEIGHT, Color.BLUE,
                              red, inArea, IN_WIDTH, IN_HEIGHT, canvas);
      timer = new Timer();
      start();
    }
  }
  
  public void onMouseDrag (Location point){
    
    if(drag){
      red.move(point.getX() - lastPoint.getX(), point.getY() - lastPoint.getY());
      lastPoint = point;
    }
    
    
    //When Red Box overlaps right or left edge of play area
    if((red.getX() + 35) > (inArea.getX() + IN_WIDTH) || red.getX() < inArea.getX() || 
       (red.getY() + 35) > (inArea.getY() + IN_HEIGHT)  || red.getY() < inArea.getY()){
      drag = false;
      newGame = true;
      red.moveTo((canvas.getWidth()/2) - 35, (canvas.getHeight()/2) - 35);
      blueOne.removeFromCanvas();
      blueTwo.removeFromCanvas();
      blueThree.removeFromCanvas();
      blueFour.removeFromCanvas();
      timer.displayElapsedTime();
      timer.reset();
    }
  }
  
  public void onMouseExit(Location point){
    
    drag = false;
    newGame = true;
    timer.displayElapsedTime();
    timer.reset();
    blueOne.removeFromCanvas();
    blueTwo.removeFromCanvas();
    blueThree.removeFromCanvas();
    blueFour.removeFromCanvas();
    red.moveTo((canvas.getWidth()/2) - 35, (canvas.getHeight()/2) - 35);
    
  }
  
}












