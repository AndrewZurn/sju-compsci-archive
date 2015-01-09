import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This program starts with the GUI_addSlider program, removes the menu bar and,
 * instead, uses combo boxes to set the color and shape. In this case, we add a
 * whole raft of choices for color and the same choices for shape. We also add 
 * the combo boxes to the buttonPanel.
 */
public class GUI_addCombo extends FrameWindowController 
                                        implements ActionListener,ChangeListener {
  
  private JPanel buttonPanel;                               //panel and button
  private JButton quitButton,dragButton;                    //stuff from before
  private Container contentPane;                            
  
  
  /*
   * This slider stuff remains.
   */
  private JSlider sizeSlider;
  private JTextField sizeField;
  private JLabel sliderLabel,sizeTextLabel;
  
  private int size=50;
  private final int SMALL_SIZE=5;           //SMALL_SIZE and LARGE_SIZE determine the
  private final int LARGE_SIZE=200;         //size limits for the slider.
  
  private int redPart=0,greenPart=0,bluePart=0;   /* We set the red, green, and blue
                                                   * values with the combo box and, then,
                                                   * create that color.
                                                   */
  private GraphicalObject graphicalObject=GraphicalObject.SQUARE;
  private Location oldPoint;
  private boolean lineStarted=false,
          drag=false;
  private Color color=Color.BLACK;
  
  /* Here are the new items for the combo boxes. Some choices are as before.*/
  private JComboBox redChooser,greenChooser,blueChooser,shapeChooser;
  
   /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController. (The only difference is that this time
   * there is no JMenuBar and, instead, we use combo boxes.)
   */
  public void begin() {
    redChooser=new JComboBox();          //create the red intensity chooser
    redChooser.addActionListener(this);  //make this the red chooser action listener
    greenChooser=new JComboBox();        //create the green intensity chooser
    greenChooser.addActionListener(this);//make this the green intensity action listener
    blueChooser=new JComboBox();         //create the blue intensity chooser
    blueChooser.addActionListener(this); //make this the blue intensity action listener
    /*
     * The following loop adds the items to the red, green, and blue choosers. As it
     * goes through the loop it adds 0,51, 102, 153,204, and 255 as choices for each
     * of the choosers that will determine red, green, and blue intensity.
     */
    for(int i=0;i<6;i++) {
      redChooser.addItem(""+(51*i));
      greenChooser.addItem(""+(51*i));
      blueChooser.addItem(""+(51*i));
    }
    redChooser.setSelectedItem("0");    //all three choosers start with intensity 0
    greenChooser.setSelectedItem("0");  //(This corresponds to initial being color black).
    blueChooser.setSelectedItem("0");
    
    shapeChooser=new JComboBox();    //creates the shape chooser combo box and adds
    shapeChooser.addItem("Square");  //the square, circle, and line items to it.
    shapeChooser.addItem("Circle");  
    shapeChooser.addItem("Line");
    shapeChooser.setSelectedItem("Square"); //Makes the initial choice Square.
    shapeChooser.addActionListener(this);   //make this the action listener for shape chooser
    buttonPanel=new JPanel();            /* create a panel to hold the buttons, slider,
                                            labels, text field, and combo boxes.*/

    quitButton=new JButton("Quit");      
    quitButton.addActionListener(this);  
    dragButton=new JButton("Draw curve");
    dragButton.addActionListener(this);  
    
    sizeSlider=new JSlider(JSlider.HORIZONTAL,SMALL_SIZE,LARGE_SIZE,50); 
    sizeSlider.addChangeListener(this);  
    sliderLabel=new JLabel("     Choose Size:"); 
    sizeTextLabel=new JLabel("     size:");   
    sizeField=new JTextField(5);         
    sizeField.setText("50");             
    
    buttonPanel.add(quitButton);        
    buttonPanel.add(dragButton);        
    buttonPanel.add(sliderLabel);       
    buttonPanel.add(sizeSlider);        
    buttonPanel.add(sizeTextLabel);     
    buttonPanel.add(sizeField);         
    buttonPanel.add(redChooser); //add the red chooser combo box to the button panel
    buttonPanel.add(greenChooser); //add the green chooser combo box to the button panel
    buttonPanel.add(blueChooser); //add the blue chooser combo box to the button panel
    buttonPanel.add(shapeChooser); //add the shape chooser combo box to the button panel
    
    contentPane=this.getContentPane();  
    contentPane.add(buttonPanel,BorderLayout.NORTH); 
    
    contentPane.validate();         //validate the GUI components we have added.
  }
  
  /**
   * Note actionPerformed is as in the GUI_addButtonPanel program. The slider
   * is NOT controlled by actionPerformed but by stateChanged.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource();
    if(actionObject==redChooser) {
      for(int i=0;i<6;i++) {
        if(redChooser.getSelectedItem().equals(""+(51*i))) {
          redPart=i*51;
          color=new Color(redPart,greenPart,bluePart);
        }
      }
    }
    else if(actionObject==greenChooser) {
      for(int i=0;i<6;i++) {
        if(greenChooser.getSelectedItem().equals(""+(51*i))) {
          greenPart=i*51;
          color=new Color(redPart,greenPart,bluePart);
        }
      }
    }
    else if(actionObject==blueChooser) {
      for(int i=0;i<6;i++) {
        if(blueChooser.getSelectedItem().equals(""+(51*i))) {
          bluePart=i*51;
          color=new Color(redPart,greenPart,bluePart);
        }
      }
    }
    else if(actionObject==shapeChooser) {
      if(((JComboBox)actionObject).getSelectedItem().equals("Square")) {
        graphicalObject=GraphicalObject.SQUARE;
      }
      else if(((JComboBox)actionObject).getSelectedItem().equals("Circle")) {
        graphicalObject=GraphicalObject.CIRCLE;
      }
      else if(((JComboBox)actionObject).getSelectedItem().equals("Line")) {
        graphicalObject=GraphicalObject.LINE;
      }
    }
    else if(actionObject==quitButton) {
      System.exit(0);
    }
    else if(actionObject==dragButton) {
      drag=!drag;
    }
  }
  
  /**
   * stateChanged is called when the slider gets "slid".
   * If you try it you will see that the slider value
   * changes as you slide. This means that this method
   * gets called often as the sliding happens.
   */
  public void stateChanged(ChangeEvent evt) {
    Object changeObject=evt.getSource();
    if(changeObject==sizeSlider) { //If the changed object is the
      size=sizeSlider.getValue();  //slider we reset the size value
      sizeField.setText(""+size);  //and also set the size text
    }                              //field to show the new size.
  }
  
  /**
   * onMouseClick actually draws the correct object in Color color.
   */
  public void onMouseClick(Location point) {
    if(!drag) {
      switch(graphicalObject) {
        case SQUARE: 
          new FilledRect(point,size,size,canvas).setColor(color); break;
        case CIRCLE: 
          new FilledOval(point,size,size,canvas).setColor(color); break;
        case LINE:
          if(lineStarted) {
            new Line(oldPoint,point,canvas).setColor(color);
            lineStarted=false;
          }
          else {
            lineStarted=true;
            oldPoint=point;
          }
      }
    }
  }
  
  /**
   * As before, onMousePress is used to start the "drag" process
   * when we are in the drawing or drag mode.
   */
  public void onMousePress(Location point) {
    if(drag) {
      oldPoint=point;
    }
  }
  
  /**
   * onMouseDrag does the actual drawing when in drawing or drag
   * mode. This is done as in the textbook in chapter 2.
   */
  public void onMouseDrag(Location point) {
    if(drag) {
      new Line(oldPoint,point,canvas).setColor(color);
      oldPoint=point;
    }
  }
  
}
