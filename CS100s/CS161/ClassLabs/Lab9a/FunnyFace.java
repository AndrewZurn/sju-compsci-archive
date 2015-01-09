import objectdraw.*;
import java.awt.*;

public class FunnyFace {
    
    private static final int FACE_HEIGHT = 60,  // dimensions of the face
                             FACE_WIDTH = 60,
        
                             EYE_OFFSET = 20,   // eye location and size
                             EYE_RADIUS = 8,
        
                             MOUTH_HEIGHT = 10, // dimensions of the mouth
                             MOUTH_WIDTH = FACE_WIDTH/2;
    
    private FramedOval head,     // oval for head
                       leftEye,  // ovals for eyes
                       rightEye,
                       mouth;    // oval for mouth
    
    // Create pieces of funny face
    public FunnyFace( double left, double top, DrawingCanvas canvas) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2, 
                                top + 2*FACE_HEIGHT/3,
                                MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                                  EYE_RADIUS, EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2, 
                                   top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    }
    
    // Move funny face by (dx,dy)
    public void move(double dx, double dy) {
        head.move(dx,dy);
        leftEye.move(dx,dy);
        rightEye.move(dx,dy);
        mouth.move(dx,dy);
    }
    
    // Determine whether pt is inside funny face
    public boolean contains(Location pt) {
        return head.contains(pt);
    }
    
    // Move funny face to (x, y)
    public void moveTo( double x, double y ){
        this.move(x - head.getX(), y - head.getY());
    }
}
