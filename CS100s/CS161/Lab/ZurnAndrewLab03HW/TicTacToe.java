import objectdraw.*;
import java.awt.*;

public class TicTacToe extends FrameWindowController{
  
  public void begin(){
    new Line ( canvas.getWidth()/3, 0, canvas.getWidth()/3, canvas.getHeight(), canvas);
    new Line ( (canvas.getWidth() - canvas.getWidth()/3), 0, (canvas.getWidth() - canvas.getWidth()/3), canvas.getHeight(), canvas);
    new Line ( 0, canvas.getHeight()/3, canvas.getWidth(), canvas.getHeight()/3, canvas);
    new Line ( 0, (canvas.getHeight() - canvas.getHeight()/3), canvas.getWidth(), (canvas.getHeight() - canvas.getHeight()/3), canvas);
  
  }
}