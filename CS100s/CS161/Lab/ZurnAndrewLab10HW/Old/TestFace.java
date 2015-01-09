import objectdraw.*;
import java.awt.*;

public class TestFace extends FrameWindowController{
  
  private static final int FACE_X = 30;
  private static final int FACE_Y = 30;
  private double faceWidth = 50;
  private double faceHeight = 50;
  private Reshapeable reshapeable;
  
  private FunnyFace face;
  private double newWidth, newHeight;
  
  public void begin(){
    reshapeable = new FunnyFace(FACE_X, FACE_Y, FACE_WIDTH, FACE_HEIGHT);
  }
  
  public void onMouseClick(Location point){
    newWidth = PopUpInput.getDouble("Input the new Width of the Face");
    newHeight = PopUpInput.getDouble("Input the new Height of the Face");
    reshapeable.setWidth(newWidth);
    reshapeable.setHeight(newHeight);
  }
}



