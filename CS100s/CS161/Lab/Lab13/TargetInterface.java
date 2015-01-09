import objectdraw.*;
import java.awt.*;

//Zurn, Andrew   RingedTarget

public interface TargetInterface{
  
  public static final int MIN_OUTER = 20;
  public static final int GAP_DISTANCE = 10;
  
  public void move(double x, double y);
  public void moveTo(double x, double y);
  public boolean contains(Location pt);
  
}