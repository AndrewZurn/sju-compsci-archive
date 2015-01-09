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
 * This is a sample program showing you how to use GUI components.
 * Note that it adds components to the WEST (left) of the screen.
 * You could choose to add things elsewhere (EAST, SOUTH, NORTH).
 */
public class TryGUIs extends GraphicsProgram implements ChangeListener {
  
  //We declare the various components - JButton, JComboBox, JSlider, JLabel,
  // JTextfield
  private JButton colorButton;
  private JComboBox shapeChooser;
  private JSlider sizeSlider;
  private JCheckBox filled;
  private JLabel sliderLabel;
  private JTextField sliderValue;
  
  //We also have some other variables we need in our program
  private int size=50;
  private boolean fillItIn=true;
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
    //add the color JButton. JButtons react to being pressed.
    colorButton=new JButton("Change Color");
    colorButton.addActionListener(this);
    add(colorButton,WEST);
    //add the shapeChooser JComboBox (a menu of sorts)
    shapeChooser=new JComboBox();
    shapeChooser.addItem("Square");
    shapeChooser.addItem("Circle");
    shapeChooser.addItem("Turtle");
    shapeChooser.addActionListener(this);
    add(shapeChooser,WEST);
    //add the filled JCheckBox. JCheckBoxes have either true or false values.
    filled=new JCheckBox("Filled");
    filled.setSelected(true);  
    filled.addActionListener(this);
    add(filled,WEST);
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
    labelTable.put( new Integer( 40 ), new JLabel("40") );
    labelTable.put( new Integer( 80 ), new JLabel("80") );
    labelTable.put( new Integer( 120 ), new JLabel("120") );
    labelTable.put(new Integer(160), new JLabel("160"));
    labelTable.put(new Integer(200), new JLabel("200"));
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
   * actionPerformed reacts to any of the standard components to determine what
   * action to take. The ActionEvent e contains the "source" of the action so we
   * use that to determine which action to do.
   */
  public void actionPerformed(ActionEvent e) {
    Object o=e.getSource();
    /* If the object was the color button, we use the JColorChooser to pick the
     * appropriate color.
     */
    if(o.equals(colorButton)) {
      color = JColorChooser.showDialog(
                     null,
                     "Choose Shape Color",
                     color);

      
    }
    //the JCheckBox returns true or false depending on whether it is checked
    // or not.
    else if(o.equals(filled)) {
      fillItIn=filled.isSelected();
    }
    //The JComboBox shapeChooser can return the currently selected "label".
    else if(o.equals(shapeChooser)) {
      currentShape=(String) shapeChooser.getSelectedItem();
    }
  }
  
  /**
   * mouseClicked draws either a square or a circle (depending on the result
   * of the shapeChooser) either filled or not filled (depending on the filled
   * JCheckBox) in the color chosen by the colorButton at the location of the
   * click of the mouse.
   */
  public void mouseClicked(MouseEvent e) {
    if(currentShape.equals("Square")) {
      GRect gr=new GRect(e.getX(),e.getY(),size,size);
      gr.setColor(color);
      if(fillItIn) {
        gr.setFilled(true);
        gr.setFillColor(color);
      }
      add(gr);
    }
    else if(currentShape.equals("Circle")) {
      GOval go=new GOval(e.getX(),e.getY(),size,size);
      go.setColor(color);
      if(fillItIn) {
        go.setFilled(true);
        go.setFillColor(color);
      }
      add(go);
    }
    else {
      MyTurtle turtle=new MyTurtle(e.getX(),e.getY(),size);
      turtle.setColor(color);
      add(turtle);
    }
  }
  
  /**
   * For JSlider objects we use the stateChanged method instead of
   * the actionPerformed method.
   */
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    size = (int)source.getValue();
    sliderValue.setText(""+size);
  }
  
  /**
   * As usual, we use main to ease launching of the program.
   */
  public static void main(String [] args) {
    new TryGUIs().start();
  }
}