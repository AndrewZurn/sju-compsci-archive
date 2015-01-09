import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import acm.gui.*;

/**
 * This is a sample program showing you how to use GUI Sliders
 * 
 * @author Lynn R. Ziegler
 */
public class SliderColor extends GraphicsProgram 
  implements ChangeListener {
  
  //We need three components, a slider, a label, and a text field.

  private JSlider redSlider,greenSlider,blueSlider;
  private JTextField redValue,greenValue,blueValue;
  private JPanel colorPanel,redPanel,greenPanel,bluePanel;
  //We have a turtle the JSliders recolor
  private MyTurtle turtle;
  
  /**
   * We arrange init() so it creates the initial box and adds the
   * slider stuff.
   */
  public void init() {
    //put the turtle on the screen
    turtle=new MyTurtle(100,100,200);
    turtle.setColor(new Color(0,200,0));
    add(turtle);
    /* redSlider, greenSlider, and blueSlider are JSliders. They are normally used to
     * allow users to pick a range of numerical values. Ours runs from 0 to 255 with
     * default 0 for red and blue and 200 for green. We also specify
     * that the slider will be oriented in the Horizontal direction. */
    redSlider=new JSlider(JSlider.HORIZONTAL,0,255,0);
    greenSlider=new JSlider(JSlider.HORIZONTAL,0,255,200);
    blueSlider=new JSlider(JSlider.HORIZONTAL,0,255,0);
    //we can (optionally) add tick marks to the JSlider.
    redSlider.setMajorTickSpacing(50);
    redSlider.setPaintTicks(true);
    greenSlider.setMajorTickSpacing(50);
    greenSlider.setPaintTicks(true);
    blueSlider.setMajorTickSpacing(50);
    blueSlider.setPaintTicks(true);
    redSlider.setPaintLabels(true);
    redSlider.addChangeListener(this);
    greenSlider.setPaintLabels(true);
    greenSlider.addChangeListener(this);
    blueSlider.setPaintLabels(true);
    blueSlider.addChangeListener(this);
    //We also add a JTextField so we can see the slider value we have chosen.
    redValue=new JTextField(5);
    redValue.setText("0");
    greenValue=new JTextField(5);
    greenValue.setText("200");
    blueValue=new JTextField(5);
    blueValue.setText("0");
    //We also add a label "above" the slider.sliderLabel=new JLabel("Size");
    //add the label, slider, and textfield in that order.
    colorPanel=new JPanel(new TableLayout(1,3));
    redPanel=new JPanel();
    greenPanel=new JPanel();
    bluePanel=new JPanel();
    redPanel.add(new JLabel("Red"));
    redPanel.add(redSlider);
    redPanel.add(redValue);
    greenPanel.add(new JLabel("    GREEN"));
    greenPanel.add(greenSlider);
    greenPanel.add(greenValue);
    bluePanel.add(new JLabel("    BLUE"));
    bluePanel.add(blueSlider);
    bluePanel.add(blueValue);
    colorPanel.add(redPanel);
    colorPanel.add(greenPanel);
    colorPanel.add(bluePanel);
    add(colorPanel,SOUTH);
  }
  
  /**
   * our run() does nothing except set the size.
   * */
  public void run() {
    setSize(1000,600);
  }
  
  /**
   * For JSlider objects we use the stateChanged method instead of
   * the actionPerformed method.
   */
  public void stateChanged(ChangeEvent e) {
    Object source=e.getSource();
    if(source==redSlider) {
      redValue.setText(""+redSlider.getValue());
    }
    else if(source==greenSlider) {
      greenValue.setText(""+greenSlider.getValue());
    }
    else if(source==blueSlider) {
      blueValue.setText(""+blueSlider.getValue());
    }
    turtle.setColor(new Color(redSlider.getValue(),
                              greenSlider.getValue(),
                              blueSlider.getValue()));
  }
  
  /**
   * As usual, we use main to ease launching of the program.
   */
  public static void main(String [] args) {
    new SliderColor().start();
  }
}