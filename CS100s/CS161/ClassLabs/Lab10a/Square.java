import objectdraw.*;
import java.awt.*;

public class Square implements Resizeable{
  
  private FilledRect square;
  private double size;
  
  public Square(double x, double y, double length, DrawingCanvas canvas){
    square = new FilledRect (x, y, length, length , canvas);
  }
  
  public void resize(double size){
    this.size = size;
    square.setSize(size + size, size + size);
  }
  
  public boolean contains(Location point){
    return square.contains(point);
  }
}