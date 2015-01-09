import objectdraw.*;
import java.awt.*;

public class Circle implements Resizeable{
  
  private FilledOval circle;
  
  public Circle(double x, double y, double diameter, DrawingCanvas canvas){
    circle = new FilledOval (x, y, diameter, diameter, canvas);
  }
  
  public void resize(double size){
    circle.setSize(size, size);
  }
  
  public boolean contains(Location point){
    return circle.contains(point);
  }
}