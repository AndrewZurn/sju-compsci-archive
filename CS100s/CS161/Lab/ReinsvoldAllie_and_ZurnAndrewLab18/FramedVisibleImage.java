import objectdraw.*;
import java.awt.*;

public class FramedVisibleImage extends VisibleImage{
  private FilledRect rect;
  //private Image image;
  private int fWidth;
  
  public FramedVisibleImage(java.awt.Image image, double x, double y, int frameWidth, DrawingCanvas canvas){
    super(image, x+frameWidth, y+frameWidth, canvas);
    fWidth = frameWidth;
    rect = new FilledRect(x, y, super.getWidth()+frameWidth*2, super.getHeight()+frameWidth*2, canvas);
    rect.sendToBack();  
  }
  
  public double getX(){
    return super.getX()-fWidth;
  }
  
  public double getY(){
    return super.getY() - fWidth;
  }
  
  public void move(double dx, double dy){
    super.move(dx, dy);
    rect.move(dx, dy);
  }
  
  public void setColor(java.awt.Color c){
    rect.setColor(c);
  }
  
  public void hide(){
    super.hide();
    rect.hide();
  }
  
  public void show(){
    super.show();
    rect.show();
  }
  
  public void removeFromCanvas(){
    super.removeFromCanvas();
    rect.removeFromCanvas();
  }
}
    