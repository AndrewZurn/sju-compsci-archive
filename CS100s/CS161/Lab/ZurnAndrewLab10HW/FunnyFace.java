import objectdraw.*;
import java.awt.*;

public class FunnyFace implements Movable, Reshapable {
  /**
   * dimensions of the face
   */
  private static final int FACE_HEIGHT = 60,  
    FACE_WIDTH = 60,
    /**
     *  eye location and size                         
     */
    EYE_OFFSET = 20,
    EYE_RADIUS = 8,
    /**
     * dimensions of the mouth
     */
    MOUTH_HEIGHT = 10,
    MOUTH_WIDTH = FACE_WIDTH/2;
  
  private double side,high,facePt, faceWidth, faceHeight;
  
  /**
   * oval for head, eyes and mouth
   */
  private FramedOval head,     
    leftEye, 
    rightEye,
    mouth;    
  
  /**
   * Create pieces of funny face
   */ 
  public FunnyFace( double left, double top, DrawingCanvas canvas) {
    head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
    mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2, top + 2*FACE_HEIGHT/3,MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
    leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas );
    rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    side=left;
    high=top;
    faceHeight=head.getHeight();
    faceWidth=head.getWidth();
  }
  
  /**
   * Move funny face by (dx,dy)
   */ 
  public void move(double dx, double dy) {
    head.move(dx,dy);
    leftEye.move(dx,dy);
    rightEye.move(dx,dy);
    mouth.move(dx,dy);
  }
  
  /**
   * Move funny face to pt
   */ 
  public void moveTo(Location pt) {
    this.move(pt.getX() - head.getX(), pt.getY() - head.getY());
  }
  
  /**
   * Determine whether pt is inside funny face
   */ 
  public boolean contains(Location pt) {
    return head.contains(pt);
  }  
  public void setWidth(double dx){
    head.setWidth(dx);
  
    faceWidth=dx;
     mouth.setWidth(dx/2);
     mouth.moveTo((side + dx/4), mouth.getY());
    
   
    leftEye.moveTo(side+4*faceWidth/15.0,leftEye.getY());
    rightEye.moveTo(side+3*faceWidth/5.0, rightEye.getY());
    leftEye.setWidth((2.0/15.0)*faceWidth);
    rightEye.setWidth((2.0/15.0)*faceWidth);
  }
  
  public void setHeight(double dy){
    head.setHeight(dy);
    
    faceHeight=dy;
     mouth.setHeight(dy/6.0);
    mouth.moveTo(mouth.getX(), high + 2*faceHeight/3);
       
    leftEye.moveTo(leftEye.getX(), high+faceHeight/3);
    rightEye.moveTo(rightEye.getX(), high+faceHeight/3);
    leftEye.setHeight((2.0/15.0)*faceHeight);
    rightEye.setHeight((2.0/15.0)*faceHeight);
  }
  
  public void setEndPoints(double dx, double dy, double dx1, double dy1){
  }
  
  public void hide(){
    head.hide();
    mouth.hide();
    leftEye.hide();
    rightEye.hide();
  }
  
  public void show(){
    head.show();
    mouth.show();
    leftEye.show();
    rightEye.show();
  }
}
