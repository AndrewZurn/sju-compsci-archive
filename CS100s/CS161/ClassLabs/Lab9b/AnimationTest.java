import objectdraw.*;
import java.awt.*;

public class AnimationTest extends FrameWindowController
{
    
    private FunnyFace funFace;           // funny face 
    
    
    // Create a funnyFace
    public void begin() {
        funFace = new FunnyFace( canvas.getWidth()/2, canvas.getHeight()/10, canvas );
    }

   
    // Move funnyFace down the screen a little at a time
    public void onMouseClick(Location pt) {
      int count =0;
//      while (count <150) {
        funFace.move(0,1);
//        count ++;
//      }
    }
 
}    