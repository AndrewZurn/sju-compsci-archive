import objectdraw.*;
import java.awt.*;


//Zurn, Andrew   RingedTarget

public class BullsEye implements TargetInterface{
  
  private FilledOval bullsEye;
  
  
  public BullsEye(Location pt, double radius, DrawingCanvas canvas){
    bullsEye = new FilledOval(pt.getX() - radius, pt.getY() - radius,
                              radius*2, radius*2, canvas);
    bullsEye.setColor(Color.RED);
  }
  
  public void move(double x, double y){
    bullsEye.move(x, y);
  }
  
  public void moveTo(double x, double y){
  }
  
  public boolean contains(Location pt){
    return bullsEye.contains(pt);
  }
}