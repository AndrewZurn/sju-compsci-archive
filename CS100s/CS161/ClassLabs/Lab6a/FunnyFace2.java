import objectdraw.*;
import java.awt.*;

/**
 * Class to represent a Funnyface graphical object Allows a face to be 
 * made with different widths and heights
 */
public class FunnyFace2 {
    
  private static final int EYE_OFFSET = 20,   // eye location and size
    EYE_RADIUS = 8,    
    MOUTH_HEIGHT = 10; // dimensions of the mouth
  
  private int faceHeight = 60,  // dimensions of the face
    faceWidth = 60,
    mouthWidth = faceWidth/2;
    FramedOval head,     // oval for head
    leftEye,  // ovals for eyes
    rightEye,
    mouth;    // oval for mouth
    
    /**
     * Create pieces of funny face with X and Y location values
     */
    public FunnyFace2( double left, double top, DrawingCanvas canvas) {
        head = new FramedOval( left, top, faceWidth, faceHeight, canvas );
        mouth = new FramedOval( left+(faceWidth-mouthWidth)/2, 
                                top + 2*faceHeight/3,
                                mouthWidth, MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                                  EYE_RADIUS, EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+faceWidth-EYE_OFFSET-EYE_RADIUS/2, 
                                   top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    }
    
    public FunnyFace2(double left, double top, int width, int height, DrawingCanvas canvas){
      this(left, top, canvas);
      faceWidth = width;
      faceHeight = height;
    }
    /**
     * Create Funnyface with a Location parameter
     */
    public FunnyFace2(Location upperLeft, DrawingCanvas canvas) {
      this(upperLeft.getX(), upperLeft.getY(), canvas);
    }
    
    /**
     *  Move funny face by (dx,dy)
     */
    public void move(double dx, double dy) {
        head.move(dx,dy);
        leftEye.move(dx,dy);
        rightEye.move(dx,dy);
        mouth.move(dx,dy);
    }
    
    /**
     *  Determine whether pt is inside funny face
     */
    public boolean contains(Location pt) {
        return head.contains(pt);
    }
    
    /**
     *  Move funny face to (x, y)
     */
    public void moveTo( double x, double y ){
        this.move(x - head.getX(), y - head.getY());
    }
}
