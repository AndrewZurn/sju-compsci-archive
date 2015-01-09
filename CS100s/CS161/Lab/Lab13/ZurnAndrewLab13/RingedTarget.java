import objectdraw.*;
import java.awt.*;

//Zurn, Andrew   RingedTarget

public class RingedTarget implements TargetInterface{
  private FramedOval rings;
  private TargetInterface rest;
  
  public RingedTarget(Location pt, double radius, DrawingCanvas canvas){
    rings = new FramedOval(pt.getX() - radius, pt.getY() - radius, radius*2, radius*2, canvas);
    radius = radius - GAP_DISTANCE;
    if ( radius >= MIN_OUTER){
      rest = new RingedTarget(pt, radius, canvas);
    }
    else { 
      rest = new BullsEye(pt,radius,canvas);
    }
  }
  
  public void move(double x, double y){
    rings.move(x, y);
    rest.move(x, y);
  }
  
  public void moveTo(double x, double y){
  }
  
  public boolean contains(Location pt){
    return rings.contains(pt);
  }
}