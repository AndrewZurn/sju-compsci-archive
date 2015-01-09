import objectdraw.*;
import java.awt.*;

public class BooleanTester extends FrameWindowController{
  
private Integer x = 0;
private Integer y = 8;
  
  public void onMouseClick(Location point){
    while (x < y) {
      x = x +3;
      y = y -1;
    }
    System .out .println ("the value of x is: " + x + "the value of y is: " + y);
    
  }
}
