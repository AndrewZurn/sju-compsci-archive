import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import acm.program.*;
import acm.graphics.*;

/**
 * This is a sample program showing you how to use GUI Buttons
 * 
 * @author Lynn R. Ziegler
 */
public class TryButtons extends GraphicsProgram{
  
  //We declare the button components
  private JButton colorButton,currentShapeButton,sizeButton;
  
  //We also have some other variables we need in our program
  private double size=50;
  private Color color=Color.RED;
  private String currentShape="Square";
  
  /**
   * We arrange init() so it adds mouse and action listeners, and GUI components.
   * Note each GUI component needs to be created, add appropriate listener, and,
   * then, get added to the screen.
   */
  public void init() {
    addMouseListeners();
    addActionListeners();
    //add the color JButton.
    colorButton=new JButton("Change Color");
    colorButton.addActionListener(this);
    add(colorButton,BorderLayout.SOUTH);
    //add the currentShape button
    currentShapeButton=new JButton("Change Shape");
    currentShapeButton.addActionListener(this);
    add(currentShapeButton,BorderLayout.EAST);
    //add the size button
    sizeButton=new JButton("Change Size");
    sizeButton.addActionListener(this);
    add(sizeButton,BorderLayout.NORTH);
  }
  
  /**
   * our run() does nothing except set the size.
   * */
  public void run() {
    setSize(1000,600);
  }
  
  /**
   * actionPerformed reacts to any of the standard components to determine what
   * action to take. The ActionEvent e contains the "source" of the action so we
   * use that to determine which action to do.
   */
  public void actionPerformed(ActionEvent actionEvent) {
    Object o=actionEvent.getSource();
    /* If the object was the color button, we use the JColorChooser to pick the
     * appropriate color.
     */
    if(o.equals(colorButton)) {
      if(color.equals(Color.RED)) {
        color=color.GREEN;
      }
      else if(color.equals(Color.GREEN)) {
        color=color.BLUE;
      }
      else {
        color=color.RED;
      }
    }
    //If the object was the currentShape button we change currentShape
    else if(o.equals(currentShapeButton)) {
      if(currentShape.equals("Square")) {
        currentShape="Circle";
      }
      else if(currentShape.equals("Circle")) {
        currentShape="Turtle";
      }
      else {
        currentShape="Square";
      }
    }
    //If the object was the size button we increase the size 20%
    else if(o.equals(sizeButton)) {
      size=size*1.2;
    }
  }
  
  /**
   * mouseClicked draws either a square or a circle (depending on the result
   * of the currentShapeChooser) either filled or not filled (depending on the filled
   * JCheckBox) in the color chosen by the colorButton at the location of the
   * click of the mouse.
   */
  public void mouseClicked(MouseEvent e) {
    if(currentShape.equals("Square")) {
      GRect gr=new GRect(e.getX(),e.getY(),size,size);
      gr.setColor(color);
      gr.setFilled(true);
      gr.setFillColor(color);
      add(gr);
    }
    else if(currentShape.equals("Circle")) {
      GOval go=new GOval(e.getX(),e.getY(),size,size);
      go.setColor(color);
      go.setFilled(true);
      go.setFillColor(color);
      add(go);
    }
    else {
      MyTurtle turtle=new MyTurtle(e.getX(),e.getY(),size);
      turtle.setColor(color);
      add(turtle);
    }
  }
  
  /**
   * As usual, we use main to ease launching of the program.
   */
  public static void main(String [] args) {
    new TryButtons().start();
  }
}