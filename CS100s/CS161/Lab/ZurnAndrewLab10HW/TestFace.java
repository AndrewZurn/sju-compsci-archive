import objectdraw.*;
import java.awt.*;

public class TestFace extends FrameWindowController{
  
  private static final double FACE_X = 100;
  private static final double FACE_Y = 100;

private Reshapable reshapeable;

private FunnyFace funnyFace;
private StraightFace straightFace;
private double newWidth, newHeight;
  
  public void begin(){
    funnyFace = new FunnyFace(FACE_X, FACE_Y,  canvas);
    straightFace = new StraightFace(FACE_X + 75, FACE_Y + 75, canvas);
  }
  
  public void onMouseClick(Location point){
    newWidth = PopUpInput.getDouble("Input the new Width of the Face");
    newHeight = PopUpInput.getDouble("Input the new Height of the Face");
    
    if(funnyFace.contains(point)){
      reshapeable = funnyFace;
      reshapeable.setWidth(newWidth);
      reshapeable.setHeight(newHeight);
    }
    
    if(straightFace.contains(point)){
      reshapeable = straightFace;
      reshapeable.setEndPoints(newWidth, newHeight, newWidth, newHeight);
    }
  }
}

                           
    
      