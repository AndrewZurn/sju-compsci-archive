import objectdraw.*;
import java.awt.*;

public class FunnyFace{
  
  private static final int FACE_HEIGHT = 60, FACE_WIDTH=60,
    
                           EYE_OFFSET = 20, EYE_RADIUS = 8,
    
                           MOUTH_HEIGHT = 10, MOUTH_WIDTH = FACE_WIDTH/2;
  
  private FramedOval head, leftEye, rightEye, mouth;
  
  public FunnyFace ( double left, double top, DrawingCanvas canvas ){
    
    double mouthLeft, mouthTop, eyeTop;
    
    mouthLeft = left+(FACE_WIDTH - FACE_WIDTH)/2;
    mouthTop = top+2*FACE_HEIGHT/3;
    eyeTop = top+EYE_OFFSET;
    
    head = new FramedOval ( left, top, FACE_WIDTH, FACE_HEIGHT, canvas);
    
    mouth = new FramedOval ( left+(FACE_WIDTH - MOUTH_WIDTH/2), top+2*FACE_HEIGHT/3, MOUTH_WIDTH, MOUTH_HEIGHT, canvas);
    
    leftEye = new FramedOval (left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    
    rightEye = new FramedOval (left+FACE_WIDTH - EYE_OFFSET - EYE_RADIUS/2, top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    
  }
  
  public void move (double dx, double dy){
    head.move( dx, dy);
    leftEye.move( dx, dy);
    rightEye.move( dx, dy);
    mouth.move( dx, dy);
  }
  
  public boolean contains(Location pt){
    return head.contains(pt);
  }
}