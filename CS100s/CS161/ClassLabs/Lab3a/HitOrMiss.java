import objectdraw.*;
import java.awt.*;
/**
 * this program will add to counter whenever square or oval are clicked on 
 */
public class HitOrMiss extends FrameWindowController {
  // location of text
  private static final int TEXT_X = 30;
  private static final int PROMPT_Y = 10;
  private static final int RESULT_Y = 30;
  
  //the text that displays the result
  private Text instructions, results;
  private Text result;
  private Text result2;
  private Text result3;

  //the rectangle and oval to be clicked
  private FilledRect square;
  private FilledOval oval;
  private static final int SQUARE_SIZE = 100;
  private static final int OVAL_SIZE = 80;
  private boolean gameOn = false;
    
  
  // counters for the clicks
  private int squareCount = 0;
  private int ovalCount = 0;
  private int misses = 0;
  private RandomIntGenerator coordinate;
  
  public void begin () {
    instructions = new Text("Click to hide square and oval", TEXT_X, PROMPT_Y, canvas);
    result = new Text( "", TEXT_X, RESULT_Y, canvas);
    result2 = new Text( "", TEXT_X, RESULT_Y +20, canvas);
    result3 = new Text( "", TEXT_X, RESULT_Y +40, canvas);
    square = new FilledRect(20,20, SQUARE_SIZE, SQUARE_SIZE, canvas);
    square.setColor(new Color(100, 35, 200));
    oval = new FilledOval(20,100,2*OVAL_SIZE,OVAL_SIZE, canvas);
    oval.setColor(new Color(200, 34, 120));
    coordinate = new RandomIntGenerator(30, canvas.getWidth() - SQUARE_SIZE);
 //   square.hide();
 //   oval.hide();
  } 

 public void onMouseClick (Location pressPoint) {
   
   
   // move object to right and increment counter if object is clicked
   // or increment missed counter; display the counts
   if (gameOn) {   
     if (square.contains(pressPoint)) {
       squareCount++;
       result.setText("Square!");
     }
     if (oval.contains(pressPoint)) {
       ovalCount++;
       result2.setText("Oval!");
       
     }
     square.show();
     oval.show();
     instructions.setText("Click to hide square and oval");
   }
   else {
     square.hide();
     oval.hide();
     square.moveTo(coordinate.nextValue(), coordinate.nextValue());
     oval.moveTo(coordinate.nextValue(), coordinate.nextValue());
     instructions.setText("Guess where the objects are and click on them");
     result.setText("");
     result2.setText("");
   }
   gameOn = !gameOn;
   
 }
 public void onMouseExit(Location point) {
   result.setText("The number of square hits is: " + squareCount);   
   result2.setText(" The number of oval hits is: " + ovalCount);
   result3.setText(" The number of misses is: " + misses);
   square.show();
   oval.show();
   
 }
   
}