import objectdraw.*;
import java.awt.*;



/**
 *Include your name and a description of the program here.
 * Andrew Zurn, Laundry Sorter program
 */
public class LaundrySorterFinal extends FrameWindowController{
  // place constant and variable declarations here
  private FilledRect hamper;
  private FramedRect hamperOutline;
  private FilledRect whiteTub;
  private FilledRect redTub;
  private FilledRect blackTub;
  private Text whites;
  private Text blacks;
  private Text coloreds;
  private Text hampers;
  private Text status;
  private static final int TEXT_X = 25;
  private static final int TEXT_Y = 25;
  private static final int WHITE_X = 25;
  private static final int RED_X = 90;
  private static final int BLACK_X = 155;
  private static final int LAUNDRY_Y = 145;
  private static final int LAUNDRY_WIDTH = 40;
  private static final int LAUNDRY_LENGTH = 40;
  private static final int HAMPER_X = 92;
  private static final int HAMPER_Y = 75;
  private static final int HAMPER_WIDTH = 35;
  private static final int HAMPER_LENGTH = 35;
  private RandomIntGenerator hamperColorRepeater;
  private Integer hamperColor;
  //private boolean currentColor;
  private Color clickedColor;
  private Color currentColor;
  private boolean correctColor;
  private Location lastPoint;
  private Location point;
  private boolean hamperGrabbed;
  private FilledRect background;
  private Text rightText;
  private Text wrongText;
  private int rightCount;
  private int wrongCount;
  
  /**
   * Initialize the display with a colored rectangle for the first article 
   * of clothing along with 3 tubs labeled "White", "Dark", and "Colored". 
   */
  public void begin(){
    
    //creates and colors the four rectangles
    background = new FilledRect ( 0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
    background.setColor (Color.YELLOW);
    hamper = new FilledRect ( HAMPER_X, HAMPER_Y, HAMPER_WIDTH, HAMPER_LENGTH, canvas);
    
    whiteTub = new FilledRect ( WHITE_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
    redTub = new FilledRect ( RED_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
    blackTub = new FilledRect ( BLACK_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
    redTub.setColor (Color.RED);
    whiteTub.setColor (Color.WHITE);
    rightText = new Text ( "Number of items right = 0", (canvas.getWidth() - canvas.getWidth()/1.1), (canvas.getHeight() - 100), canvas);
    wrongText = new Text ( "Number of items wrong = 0",(canvas.getWidth() - canvas.getWidth()/1.1), (canvas.getHeight() - 80), canvas);
    rightCount = 0;
    wrongCount = 0;
    
    //create status
    status = new Text ( " ", TEXT_X, TEXT_Y, canvas);
    
    //labels the different rectangles
    whites = new Text ("WHITES", WHITE_X - 5, LAUNDRY_Y + 45, canvas);
    coloreds = new Text ("COLOREDS", RED_X - 10, LAUNDRY_Y + 45, canvas);
    blacks = new Text ("BLACKS", BLACK_X, LAUNDRY_Y + 45, canvas);
    hampers = new Text ("HAMPER", HAMPER_X - 5, HAMPER_Y + 45, canvas);
    status = new Text (" ", TEXT_X, TEXT_Y, canvas);
  }
  
  
 
  
  
  
  public void onMousePress (Location point){
    lastPoint = point;
    hamperGrabbed = hamper.contains (point);
  }
  
  
  public void onMouseDrag( Location point ) {
    if ( hamperGrabbed ) {
      hamper.move( point.getX() - lastPoint.getX(),
                  point.getY() - lastPoint.getY() );
      lastPoint = point;
      
      
      correctColor = true;
      
      
      
      
      
      
      
      currentColor = hamper.getColor();
      
      
      
      
      if (correctColor){
        
        
          if (blackTub.contains (point)){
            clickedColor = blackTub.getColor();
            if (clickedColor == currentColor){
              
              correctColor = true;
            }
            else if (currentColor != clickedColor){
              clickedColor = blackTub.getColor();
              correctColor=false;
            }
          }
          
          else if (whiteTub.contains (point)){
            clickedColor = whiteTub.getColor();
            if (currentColor == clickedColor){
              correctColor = true;
            }
            else if (currentColor != clickedColor){
              clickedColor = whiteTub.getColor();
              correctColor=false;
            }
          }
          
          else if (redTub.contains (point)){
            clickedColor = redTub.getColor();
            if (currentColor == clickedColor){
              correctColor = true;
            }
            else if (currentColor != clickedColor){
              clickedColor = redTub.getColor();
              correctColor=false;
            }
          }
        }
        
        
        
      
    }
  }
  
  
  public void onMouseRelease (Location point){
    
    if (correctColor = false){
      status.setText ("ERROR");
      wrongCount = wrongCount + 1;
      wrongText.setText ("Number of items wrong = " + wrongCount + " !");
      
      
    }
    else if (correctColor = true){
      status.setText ("SUCCESS");
      rightCount = rightCount + 1;
      rightText.setText ("Number of items right = " + rightCount + " !");
    }
    
    
    hamper.moveTo( HAMPER_X, HAMPER_Y);
    
     hamperColorRepeater = new RandomIntGenerator ( 1, 3);
    hamperColor = hamperColorRepeater.nextValue();
    
    
    
    if (hamperColor == 1){
      hamper.setColor(Color.BLACK);
      currentColor = Color.BLACK;
    }
    else if (hamperColor == 2){
      hamper.setColor(Color.WHITE);
      currentColor = Color.WHITE;
    }
    else{
      hamper.setColor(Color.RED);
      currentColor = Color.RED;
    
    
    
    
    }
  }
}






