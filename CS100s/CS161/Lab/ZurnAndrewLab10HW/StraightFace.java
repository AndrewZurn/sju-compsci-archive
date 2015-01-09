import objectdraw.*;
import java.awt.*;

public class StraightFace implements Movable, Reshapable {
  /**
   * dimensions of the face
   */
  private static final int FACE_HEIGHT = 60,  
    FACE_WIDTH = 60,
    /**
     * eye location and size
     */
    EYE_OFFSET = 20,   
    EYE_RADIUS = 8,
    /**
     * dimensions of the mouth                                         
     */
    MOUTH_WIDTH = FACE_WIDTH/2;
  
  private double side, high, facePt, faceWidth, faceHeight;
  
  /**
   * oval for head
   */
  private FramedOval head;     
  /**
   * lines for eyes,nose and mouth
   */
  private Line leftEye,       
    rightEye,
    nose,           
    mouth;        
  
  /**
   * Create pieces of straight face
   */ 
  public StraightFace( double left, double top, DrawingCanvas canvas) {
    head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
    mouth = new Line( left+(FACE_WIDTH-MOUTH_WIDTH)/2, top + 2*FACE_HEIGHT/3,
                     left+(FACE_WIDTH+MOUTH_WIDTH)/2, 
                     top + 2*FACE_HEIGHT/3, canvas );
    
    nose = new Line( left+FACE_WIDTH/2, top+EYE_OFFSET, 
                    left+FACE_WIDTH/2, top + FACE_HEIGHT/2, canvas );                           
    
    leftEye = new Line( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                       left+EYE_OFFSET+EYE_RADIUS/2, top+EYE_OFFSET, canvas );
    rightEye = new Line( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2,  
                        top+EYE_OFFSET, left+FACE_WIDTH-EYE_OFFSET+EYE_RADIUS/2, 
                        top+EYE_OFFSET, canvas);
    side = left;
    high = top;
    faceHeight = head.getHeight();
    faceWidth = head.getWidth();
  }
  
  /**
   * Move straight face by (dx,dy)
   */ 
  public void move(double dx, double dy) {
    head.move(dx,dy);
    leftEye.move(dx,dy);
    rightEye.move(dx,dy);
    mouth.move(dx,dy);
    nose.move(dx,dy);
  }
  
  /**
   * Move straight face to pt
   */ 
  public void moveTo(Location pt) {
    this.move(pt.getX() - head.getX(), pt.getY() - head.getY());
  }
  
  /**
   * Determine whether pt is inside straight face
   */
  public boolean contains(Location pt) {
    return head.contains(pt);
  }
  
  public void setEndPoints(double dx, double dy, double dx1, double dy1){
    head.setWidth(dx);
    head.setHeight(dy);
    faceWidth=dx;
    faceHeight = dy;
    mouth.setEndPoints((side + faceWidth/4), high + 2.0*faceHeight/3.0,
                         (side + 3.0*faceWidth/4.0), high + 2.0*faceHeight/3.0);
    nose.setEndPoints(side + faceWidth/2.0, high + faceHeight/3.0,
                      side + faceWidth/2.0,  high + faceHeight/2.0);
    leftEye.setEndPoints(side + 4.0*faceWidth/15.0, high + faceHeight/3.0,
                         side + 2.0*faceWidth/5.0, high + faceHeight/3.0);
    rightEye.setEndPoints(side + 3.0*faceWidth/5.0, high + faceHeight/3.0,
                          side + 11.0* faceWidth/15.0, high + faceHeight/3.0);
  }
  
  public void setWidth(double dx){
  }
  public void setHeight(double dy){
  }
  
  public void hide(){
    head.hide();
    mouth.hide();
    nose.hide();
    leftEye.hide();
    rightEye.hide();
  }
  
  public double getHeight(){
    return head.getHeight();
  }
  
  public double getWidth(){
    return head.getWidth();
  }
  
  public void show(){
    head.show();
    mouth.show();
    nose.show();
    leftEye.show();
    rightEye.show();
  

  }
}