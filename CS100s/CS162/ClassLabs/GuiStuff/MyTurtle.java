import java.awt.*;
import acm.graphics.*;

/**
 * A race program between a square and an oval
 */

public class MyTurtle extends GCompound{
  /**
   * Our turtle needs a body, a head, a tail, 2 eyes, and 4 legs
   */
  private GOval body, head, tail, leg1, leg2, leg3, leg4, eye1, eye2;
  /**
   * We save the scale of our turtle.
   */
  double scale=100.0;
  /**
   * Our constructor recieves x and y co-ordinates and a size
   * and places a turtle of that size at those co-ordinates.
   */
  public MyTurtle(double x, double y, double size) {
    head=new GOval(70,40,30,20);
    head.setFilled(true);
    head.setFillColor(Color.GREEN);
    add(head);
    eye1=new GOval(90,45,3,3);
    eye1.setFilled(true);
    eye1.setFillColor(Color.BLACK);
    add(eye1);
    eye2=new GOval(90,52,3,3);
    eye2.setFilled(true);
    eye2.setFillColor(Color.BLACK);
    add(eye2);
    tail=new GOval(5,45,30,10);
    tail.setFilled(true);
    tail.setFillColor(Color.GREEN);
    add(tail);
    leg1=new GOval(30,5,10,30);
    leg1.setFilled(true);
    leg1.setFillColor(Color.GREEN);
    add(leg1);
    leg2=new GOval(60,5,10,30);
    leg2.setFilled(true);
    leg2.setFillColor(Color.GREEN);
    add(leg2);
    leg3=new GOval(30,65,10,30);
    leg3.setFilled(true);
    leg3.setFillColor(Color.GREEN);
    add(leg3);
    leg4=new GOval(60,65,10,30);
    leg4.setFilled(true);
    leg4.setFillColor(Color.GREEN);
    add(leg4);
    body=new GOval(20,20,60,60);
    body.setFilled(true);
    body.setFillColor(Color.GREEN);
    add(body);
    setLocation(x,y);
    scale(size/100);
    scale=size;
  }
  
  /**
   * resize(double factor) resizes the turtle to a size
   * factor times its original size (which is stored in
   * scale). Thus if factor is 2 it will be twice as big.
   */
  public void resize(double factor) {
    scale(factor/scale);
    scale=factor;
  }
  
  /**
   * setColor(color) changes the body of the turtle to this new color.
   */
  public void setColor(Color color) {
    leg1.setFillColor(color);
    leg2.setFillColor(color);
    leg3.setFillColor(color);
    leg4.setFillColor(color);
    body.setFillColor(color);
    head.setFillColor(color);
    tail.setFillColor(color);
  }
  public void setFillColor(Color color) {
    setColor(color);
  }
}