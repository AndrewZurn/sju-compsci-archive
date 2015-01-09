import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This program starts with the GUI program that adds the top menu bar
 * and buttons and also adds a slider and a text box for showing the
 * slider value to the button panel.
 */
public class GUI_addRadioButtons extends FrameWindowController 
                                        implements ActionListener,ChangeListener {
  
  private JPanel buttonPanel;                               //panel and button
  private JButton quitButton,dragButton,colorButton;        //stuff from before + colorButton
  private Container contentPane;                            
  
  private ButtonGroup shapeButtons;
  private JRadioButton squareButton,circleButton,lineButton;
  private JSlider sizeSlider;
  private JTextField sizeField;
  private JLabel sliderLabel,sizeTextLabel;
  
  private int size=50;
  private final int SMALL_SIZE=5;           //SMALL_SIZE and LARGE_SIZE determine the
  private final int LARGE_SIZE=200;         //size limits for the slider.
  
  private Color color=Color.RED;            //old stuff from the previous class
  private GraphicalObject graphicalObject=GraphicalObject.SQUARE;
  private Location oldPoint;
  private boolean lineStarted=false,
          drag=false;
  
    /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController.
   */
  public void begin() {
       
    squareButton=new JRadioButton("Square");      
    squareButton.addActionListener(this);      
    circleButton=new JRadioButton("Circle");      
    circleButton.addActionListener(this);      
    lineButton=new JRadioButton("Line");      
    lineButton.addActionListener(this);      
    
    buttonPanel=new JPanel();
    buttonPanel.add(squareButton);
    buttonPanel.add(circleButton);
    buttonPanel.add(lineButton);
    quitButton=new JButton("Quit");      
    quitButton.addActionListener(this);  
    dragButton=new JButton("Draw curve");
    dragButton.addActionListener(this);  
    colorButton=new JButton("Choose color"); //create colorButton and add this for action
    colorButton.addActionListener(this);
    
    
    sizeSlider=new JSlider(JSlider.HORIZONTAL,SMALL_SIZE,LARGE_SIZE,50); 
    sizeSlider.addChangeListener(this);  
    sliderLabel=new JLabel("     Choose Size:"); 
    sizeTextLabel=new JLabel("     size:");   
    sizeField=new JTextField(5);         
    sizeField.setText("50");             
    
    buttonPanel.add(quitButton);        
    buttonPanel.add(dragButton);    
    buttonPanel.add(colorButton);
    buttonPanel.add(sliderLabel);      
    buttonPanel.add(sizeSlider);        
    buttonPanel.add(sizeTextLabel);     
    buttonPanel.add(sizeField);         
    
    contentPane=this.getContentPane();  // get the ContentPane() for this class
    contentPane.add(buttonPanel,BorderLayout.NORTH); //add the button panel on top
    
    contentPane.validate();         //validate the GUI components we have added.
  }
  
  /**
   * Note actionPerformed is as in the GUI_addButtonPanel program. The slider
   * is NOT controlled by actionPerformed but by stateChanged.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource();
   if(actionObject==squareButton) {
      graphicalObject=GraphicalObject.SQUARE;
    }
    else if(actionObject==circleButton) {
      graphicalObject=GraphicalObject.CIRCLE;
    }
    else if(actionObject==lineButton) {
      graphicalObject=GraphicalObject.LINE;
    }
    else if(actionObject==quitButton) {
      System.exit(0);
    }
    else if(actionObject==dragButton) {
      drag=!drag;
    }
    else if(actionObject==colorButton) {
      color = JColorChooser.showDialog(
                     this,
                     "Choose Shape Color",
                     color);
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
