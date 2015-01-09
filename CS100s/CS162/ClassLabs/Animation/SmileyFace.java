import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;

/**
 * This class extends Animator and creates a ball that continues to bounce
 * around the graphics area of GraphicsProgram gp forever.
 * 
 * @author Lynn R. Ziegler
 */
public class SmileyFace extends GCompound {
  private GOval face,leftEye,rightEye;
  private GArc smile;
  private double currentSize=100;
  public SmileyFace(double x, double y, double size) {
    face=new GOval(0,0,100,100);
    face.setFilled(true);
    face.setColor(Color.YELLOW);
    add(face);
    leftEye=new GOval(25,20,10,10);
    leftEye.setFilled(true);
    add(leftEye);
    rightEye=new GOval(65,20,10,10);
    rightEye.setFilled(true);
    add(rightEye);
    smile=new GArc(30,50,40,20,180,180);
    smile.setFilled(true);
    add(smile);
    setSize(size);
    setLocation(x,y);
  }
  public void setSize(double size) {
    scale(size/currentSize);
    currentSize=size;
  }
}