import objectdraw.*;
import java.awt.*;

/** 
 * The TopHatFace extends the FunnyFace to include a top hat on the face.
 */

public class TopHatFace extends FunnyFace {
  
// Dimensions of the Hat
  private static final int BRIM_HEIGHT=10;
  private static final int STOVEPIPE_INSET = 10;
  private static final int STOVEPIPE_HEIGHT = 40;
  
  // the hat brim and stovepipe top
  private FilledOval brim;
  private FilledRect stovepipe;
   
  
  public TopHatFace( double left, double top, DrawingCanvas canvas){
  
    super(left, top, canvas);//call superclass constructor
    brim = new FilledOval(left, top-(BRIM_HEIGHT/2), FACE_WIDTH, BRIM_HEIGHT, canvas);
    stovepipe = new FilledRect(left + STOVEPIPE_INSET, top - STOVEPIPE_HEIGHT, 
                               FACE_WIDTH - (2*STOVEPIPE_INSET), STOVEPIPE_HEIGHT, canvas);
  }
  

  public boolean contains(Location pt) {
    return (super.contains(pt) || brim.contains(pt) || stovepipe.contains(pt));
  }
  
  public void move(double dx, double dy){
    super.move(dx, dy);
    brim.move(dx, dy);
    stovepipe.move(dx, dy);
  }
    
}

      
