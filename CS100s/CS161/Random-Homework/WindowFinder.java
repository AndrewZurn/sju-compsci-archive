import objectdraw.*;

public class WindowFinder extends FrameWindowController{
  public void onMouseClick(Location point){
    System.out.println("X" + (canvas.getWidth()));
    System.out.println("Y" + (canvas.getHeight()));
  }
}