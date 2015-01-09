import objectdraw.*;
import java.awt.*;


public class FiboController extends FrameWindowController{
  private double answer;
  public void onMouseClick(Location pt){
    answer = new Fibo(5.0);
    System.out.println(answer);
  }
  
}