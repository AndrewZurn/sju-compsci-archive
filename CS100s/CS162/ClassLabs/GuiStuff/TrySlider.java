import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is a sample program showing you how to use GUI Sliders
 * 
 * @author Lynn R. Ziegler
 */
public class TrySlider extends GraphicsProgram 
  implements ChangeListener {
  
  //We need three components, a slider, a label, and a text field.

  private JSlider sizeSlider;
  private JLabel sliderLabel;
  private JTextField sliderValue;
  
  //We have a turtle the JSlider resizes
  private MyTurtle turtle;
  //We also have some other variables we need in our program
  private int size=50;
  
  /**
   * We arrange init() so it creates the initial box and adds the
   * slider stuff.
   */
  public void init() {
    //put the turtle on the screen
    turtle=new MyTurtle(100,100,size);
    add(turtle);
    /* sizeSlider is a JSlider. They are normally used to allow users to pick a range
     * of numerical values. Ours runs from 40 to 200 with default 50. We also specify
     * that the slider will be oriented in the VERTICAL direction. (HORIZONTAL is the
     * default orientation. */
    sizeSlider=new JSlider(JSlider.VERTICAL,40,200,50);
    //we can (optionally) add tick marks to the JSlider.
    sizeSlider.setMajorTickSpacing(40);
    sizeSlider.setPaintTicks(true);
    //This wierd construct adds labels to the JSlider if we want them.
    Hashtable<Integer,JLabel> labelTable = new Hashtable<Integer,JLabel>();
    labelTable.put( new Integer( 40 ), new JLabel("forty") );
    labelTable.put( new Integer( 80 ), new JLabel("eighty") );
    labelTable.put( new Integer( 120 ), new JLabel("one twenty") );
    labelTable.put(new Integer(160), new JLabel("one sixty"));
    labelTable.put(new Integer(200), new JLabel("two hundred"));
    sizeSlider.setLabelTable( labelTable );
    sizeSlider.setPaintLabels(true);
    sizeSlider.addChangeListener(this);
    //We also add a JTextField so we can see the slider value we have chosen.
    sliderValue=new JTextField(5);
    sliderValue.setText("50");
    //We also add a label "above" the slider.
    sliderLabel=new JLabel("Size");
    //add the label, slider, and textfield in that order.
    add(sliderLabel,WEST);
    add(sizeSlider,WEST);
    add(sliderValue,WEST);
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
    JSlider source = (JSlider)e.getSource();
    size = (int)source.getValue();
    sliderValue.setText(""+size);
    turtle.resize(size);
    add(turtle);
  }
  
  /**
   * As usual, we use main to ease launching of the program.
   */
  public static void main(String [] args) {
    new TrySlider().start();
  }
}