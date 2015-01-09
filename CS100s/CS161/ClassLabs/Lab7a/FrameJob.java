import objectdraw.*;
import java.awt.*;

/** class to display a PictureFrame.
  * 
  */
public class FrameJob extends FrameWindowController {
  
  private static final int FACE_LEFT = 30, // location of PictureFrame
    FACE_TOP = 30;
  private static final Location FACE_POINT = new Location(FACE_LEFT, FACE_TOP);
  
  private PictureFrame woodFrame;
  private PictureFrame2 secondFrame;
  private PictureFrame3 thirdFrame;
  private RandomIntGenerator randomColor = new RandomIntGenerator(0, 255);
  private Color myColor;
  
  public void begin() {
    woodFrame = new PictureFrame(FACE_LEFT, FACE_TOP, canvas);
  }
//    secondFrame = new PictureFrame2(FACE_LEFT,FACE_TOP + 250, canvas);
//      thirdFrame = new PictureFrame3(FACE_LEFT + 300, FACE_TOP, canvas);
  
  public void onMouseClick (Location point){
    Color myColor;
    woodFrame.move(25, 25);
    myColor = new Color(randomColor.nextValue(), randomColor.nextValue(), randomColor.nextValue());
    woodFrame.setColor(myColor);
  }
  
  public void onMouseExit (Location point){
    woodFrame.moveTo(FACE_POINT);
  }
}  

