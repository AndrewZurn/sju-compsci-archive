import java.awt.*;
import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;
import acm.program.*;

public class TestBouncingSmiley extends GraphicsProgram {
  private BouncingSmiley face;
  public void init() {
    addMouseListeners();
  }
  public void mouseClicked(MouseEvent e) {
    face=new BouncingSmiley(e.getX(),e.getY(),40+80*Math.random(),
                            -10+20*Math.random(),-10+20*Math.random(), this);
    face.start();
  }
  public static void main(String [] args) {
    new TestBouncingSmiley().start();
  }
}