import objectdraw.*;
import java.awt.*;

//Zurn, Andrew   Face Shaping Program

public class FaceShapes extends FrameWindowController{
  
  private static final double FUNNY_FACE_X = 50;
  private static final double FACE_Y = 75;
  private static final double STRAIGHT_FACE_X = 175;
  private static final double FUNNY_BUTTON_X = 0;
  private static final double STRAIGHT_BUTTON_X = 100;
  private static final double BUTTON_Y = 0;
  private static final double BUTTON_SIZE = 30;
  private static final double INSTRU_X = 43;
  
  private Reshapable reshapeable;
  private FunnyFace funnyFace;
  private StraightFace straightFace;
  private FilledOval funnyButton, straightButton, setHeightButton, setWidthButton;
  private double newWidth, newHeight;
  private Text funnyText, straightText, setHeightText, setWidthText, instructions;
  
  public void begin(){
    funnyFace = new FunnyFace(FUNNY_FACE_X, FACE_Y,  canvas);
    straightFace = new StraightFace(STRAIGHT_FACE_X, FACE_Y, canvas);
    
    funnyButton = new FilledOval(FUNNY_BUTTON_X, BUTTON_Y, BUTTON_SIZE, BUTTON_SIZE, canvas);
    straightButton = new FilledOval(STRAIGHT_BUTTON_X, BUTTON_Y, BUTTON_SIZE, BUTTON_SIZE, canvas);
    setWidthButton =  new FilledOval(FUNNY_BUTTON_X, BUTTON_Y + BUTTON_SIZE,
                                     BUTTON_SIZE, BUTTON_SIZE, canvas);
    setHeightButton = new FilledOval(STRAIGHT_BUTTON_X, BUTTON_Y + BUTTON_SIZE,
                                     BUTTON_SIZE, BUTTON_SIZE, canvas);
    funnyButton.setColor(Color.BLUE);
    straightButton.setColor(Color.BLUE);
    setWidthButton.setColor(Color.RED);
    setHeightButton.setColor(Color.RED);
    setWidthButton.hide();
    setHeightButton.hide();
    
    funnyText = new Text("Funny Face", FUNNY_BUTTON_X + BUTTON_SIZE,BUTTON_SIZE, canvas);
    straightText = new Text("Straight Face", STRAIGHT_BUTTON_X + BUTTON_SIZE,BUTTON_SIZE, canvas);
    setWidthText = new Text("Set Width", FUNNY_BUTTON_X + BUTTON_SIZE,BUTTON_SIZE, canvas);
    setHeightText = new Text("Set Height", STRAIGHT_BUTTON_X + BUTTON_SIZE,BUTTON_SIZE, canvas);
    setWidthText.hide();
    setHeightText.hide();
    
    instructions = new Text("Click on the Colored Buttons to Shape the Faces",
                            INSTRU_X, canvas.getHeight() - canvas.getHeight()/4, canvas);
    
  }
  
  public void onMouseClick(Location point){
    
    if (funnyButton.contains(point)){
      funnyButton.hide();
      straightButton.hide();
      funnyText.hide();
      straightText.hide();
      straightFace.hide();
      setWidthButton.show();
      setHeightButton.show();
      setWidthText.show();
      setHeightText.show();
      reshapeable = funnyFace;
      //enter additional if statements here
    }
    
     else if (straightButton.contains(point)){
      funnyButton.hide();
      straightButton.hide();
      funnyText.hide();
      straightText.hide();
      funnyFace.hide();
      setWidthButton.show();
      setHeightButton.show();
      setWidthText.show();
      setHeightText.show();
      reshapeable = straightFace;
      //enter addition if statements here
     }
     
     if (reshapeable != null){
       if (setWidthButton.contains(point)){
         newWidth = PopUpInput.getDouble("Input the new Width of the Face");
         reshapeable.setWidth(newWidth);
         reshapeable.setEndPoints(newWidth, straightFace.getHeight(), newWidth, straightFace.getHeight());
         
         funnyFace.show();
         straightFace.show();
         funnyButton.show();
         funnyText.show();
         straightButton.show();
         straightText.show();
         
         setWidthButton.hide();
         setHeightButton.hide();
         setWidthText.hide();
         setHeightText.hide();
       }
       else if(setHeightButton.contains(point)){
         newHeight = PopUpInput.getDouble("Input the new Height of the Face");
         reshapeable.setHeight(newHeight);
         reshapeable.setEndPoints(straightFace.getWidth(), newHeight, straightFace.getWidth(), newHeight);
         
         funnyFace.show();
         straightFace.show();
         funnyButton.show();
         funnyText.show();
         straightButton.show();
         straightText.show();
         
         setWidthButton.hide();
         setHeightButton.hide();
         setWidthText.hide();
         setHeightText.hide();
       }
     }
  
  }
}


                           
    
      