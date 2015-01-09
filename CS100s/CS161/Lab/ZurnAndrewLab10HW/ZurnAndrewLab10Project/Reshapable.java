import objectdraw.*;
import java.awt.*;

public interface Reshapable{
  //allows the user to set the width of the object
  public void setWidth(double dx);
  
  //allows the user to set the height of the object
  public void setHeight(double dy);
  
  public void setEndPoints(double x1, double y1, double x2, double y2);
}