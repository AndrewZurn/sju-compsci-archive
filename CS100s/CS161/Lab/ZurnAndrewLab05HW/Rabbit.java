import objectdraw.*;
import java.awt.*;

public class Rabbit {
  
  private FilledOval body, head, ear1, ear2, leg1, leg2, leg3, leg4;
  
  
  private double xPos, yPos;
  
  
  public Rabbit ( double x, double y, DrawingCanvas canvas){
    xPos=x;
    yPos=y;
    buildRabbit(canvas);
  }
  
  public Rabbit ( Location p, DrawingCanvas canvas){
    xPos=p.getX();
    yPos=p.getY();
    buildRabbit(canvas);
  }
  
  private void buildRabbit(DrawingCanvas canvas){
    body = new FilledOval (xPos - 4, yPos + 5, 22, 12, canvas);
    head=new FilledOval(xPos+15,yPos+7,8,8,canvas);
    leg1=new FilledOval(xPos+1,yPos,6,6,canvas);
    leg2=new FilledOval(xPos+1,yPos+15,6,6,canvas);
    leg3=new FilledOval(xPos+11,yPos+1,6,6,canvas);
    leg4=new FilledOval(xPos+11,yPos+15,6,6,canvas);
    ear1=new FilledOval(xPos+21, yPos+11, 10, 4, canvas);
    ear2=new FilledOval(xPos+21, yPos+7, 10, 4, canvas);
  }
   
    public void move(double x, double y) {
    xPos=xPos+x;
    yPos=yPos+y;
    leg1.move(x,y);
    leg2.move(x,y);
    leg3.move(x,y);
    leg4.move(x,y);
    body.move(x,y);
    head.move(x,y);
    ear1.move(x,y);
    ear2.move(x,y);
    }
    
    public void setColor(Color color){
    leg1.setColor(color);
    leg2.setColor(color);
    leg3.setColor(color);
    leg4.setColor(color);
    body.setColor(color);
    head.setColor(color);
    ear1.setColor(color);
    ear2.setColor(color);
    }
    
    public double getX() {
    return this.xPos;
  }
    
    public double getY() {
    return this.yPos;
  }
}

    
    