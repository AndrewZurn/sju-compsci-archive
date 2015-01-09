import objectdraw.*;
import java.awt.*;

public class ObjectTester extends FrameWindowController{
  private Square square;
  private Circle circle;
  
  public begin(){
    square = new Square (20, 20, 35, canvas);
    circle = new Circle (20, 20, 35, canvas);
  }
  
  public void onMouseClick(Location point)