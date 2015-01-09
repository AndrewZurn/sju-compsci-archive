import objectdraw.*;
import java.awt.*;



/**
 *Include your name and a description of the program here.
 * Andrew Zurn, Laundry Sorter program
 */
public class LaundrySorter extends FrameWindowController{
  // place constant and variable declarations here
  private FilledRect hamper;
  private FramedRect hamperOutline;
  private FramedRect whiteTub;
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
  private static final int HAMPER_OUT_X = 91;
  private static final int HAMPER_OUT_Y = 74;
  private static final int HAMPER_OUT_WIDTH = 36;
  private static final int HAMPER_OUT_LENGTH = 36;
  private RandomIntGenerator hamperColorRepeater;
  private Integer hamperColor;
  //private Color hamperColor3;
  private boolean currentColor;
  private boolean clickedColor;

  /**
   * Initialize the display with a colored rectangle for the first article 
   * of clothing along with 3 tubs labeled "White", "Dark", and "Colored". 
   */
   public void begin(){
     
     //creates and colors the four rectangles
     hamper = new FilledRect ( HAMPER_X, HAMPER_Y, HAMPER_WIDTH, HAMPER_LENGTH, canvas);
     hamperOutline = new FramedRect ( HAMPER_OUT_X, HAMPER_OUT_Y, HAMPER_OUT_WIDTH, HAMPER_OUT_LENGTH, canvas);
     whiteTub = new FramedRect ( WHITE_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
     redTub = new FilledRect ( RED_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
     blackTub = new FilledRect ( BLACK_X, LAUNDRY_Y, LAUNDRY_WIDTH, LAUNDRY_LENGTH, canvas);
     redTub.setColor (Color.RED);
     blackTub.setColor (Color.BLACK);
     
     //create status
     status = new Text ( " ", TEXT_X, TEXT_Y, canvas);
     
     //labels the different rectangles
     whites = new Text ("WHITES", WHITE_X - 5, LAUNDRY_Y + 45, canvas);
     coloreds = new Text ("COLOREDS", RED_X - 10, LAUNDRY_Y + 45, canvas);
     blacks = new Text ("BLACKS", BLACK_X, LAUNDRY_Y + 45, canvas);
     hampers = new Text ("HAMPER", HAMPER_X - 5, HAMPER_Y + 45, canvas);
     
     
   }
   
   public void onMouseClick (Location point){
     
     //create a random integer generator to randomly generator a color for the hamper
     hamperColorRepeater = new RandomIntGenerator (1, 3);
     hamperColor = hamperColorRepeater.nextValue();
     
     if ( hamperColor == 1){
       currentColor = blackTub.getColor();
       //clickedColor = blackTub.contains ( point );
     }
     if ( hamperColor == 2){
       currentColor = whiteTub.getColor();
       //clickedColor = whiteTub.contains ( point );
     }
     if ( hamperColor == 3){
       currentColor = redTub.getColor();
       //clickedColor = redTub.contains ( point );
     }
   }
   
   
   
   
   
   
   
   
   
   
  
   
 

   
   /**
    * If the tub selected matches the color of the new laundry item, 
    * display success message and generate a new random color for hamper
    * otherwise display error message 
    */
   
   public void onMouseClick (Location point){
     
     if ( clickedColor == currentColor ){
       
       status.setText("SUCCESS");
       if (hamperColor2 == 1){
       hamper.setColor (Color.BLACK);
       }
       if (hamperColor2 == 2){
       hamper.setColor (Color.RED);
       }
       if (hamperColor2 == 3){
       hamper.setColor (Color.WHITE);
       }
      
       else if ( clickedColor == currentColor ){
         
         status.setText("SUCCESS");
       }
       if (hamperColor2 == 1){
       hamper.setColor (Color.BLACK);
       }
       if (hamperColor2 == 2){
       hamper.setColor (Color.RED);
       }
       if (hamperColor2 == 3){
       hamper.setColor (Color.WHITE);
       }
       
       else if (clickedColor == currentColor ){
         
         status.setText ("SUCCESS");
       }
       if (hamperColor2 == 1){
       hamper.setColor (Color.BLACK);
       }
       if (hamperColor2 == 2){
       hamper.setColor (Color.RED);
       }
       if (hamperColor2 == 3){
       hamper.setColor (Color.WHITE);
       }
     
     }
     
     

   }
   
   
}

   
   
     
     
     
     
     
     