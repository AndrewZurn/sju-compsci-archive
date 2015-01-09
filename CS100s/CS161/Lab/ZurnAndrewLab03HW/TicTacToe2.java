import objectdraw.*;
import java.awt.*;

public class TicTacToe2 extends FrameWindowController{
  
  private Line verticalLine;
  private Line horizontalLine;
  private Location firstVertLine = ( 100, 0);
  private Location firstHortLine = ( 0, 100);
  
  public void begin(){
    firstVertLine = new Location (100, 0);
    firstHortLine = new Location (0, 100);
  }
  
  public void onMouseClick (Location point){
    verticalLine = new Line ( (firstVertLine), firstVertLine, 100, canvas.getHeight(), canvas);
    firstVertLine.translate (100, 0);
  }
}