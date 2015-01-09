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
public class GUI_addSlider extends FrameWindowController 
             implements ActionListener,ChangeListener {
  
  private JPanel buttonPanel;                               //panel and button
  private JButton quitButton,dragButton;                    //stuff from before
  private Container contentPane;                            
  private JMenuBar myMenuBar;                               // menu stuff from before
  private JMenu colorMenu,shapeMenu,greenMenu;
  private JMenuItem redItem,blueItem,greenLight,greenMedium,greenDark,square,circle,line;
  /*
   * Here is the new stuff - a slider to choose the size of graphical objects plus labels
   * to tell the user what is what plus a text field to show the size selected.
   */
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
    myMenuBar=new JMenuBar();  //creates the menu bar for the top
    setJMenuBar(myMenuBar);    //makes myMenuBar the top menu bar
    
    colorMenu=new JMenu("Color"); //create a menu for changing colors

    redItem=new JMenuItem("Red");    //create an item to handle the Red color
    colorMenu.add(redItem);          //add it to the Color Menu
    redItem.addActionListener(this); /*Make this class an ActionListener to react to this
                                      * menu item being clicked. */
    greenMenu=new JMenu("Green Menu"); //Create a submenu for green items.
    colorMenu.add(greenMenu);          //add the Green submenu to the Color Menu
    greenLight=new JMenuItem("Light Green"); //a Light Green Item
    greenLight.addActionListener(this);      //add this as the Light Green action listener
    greenMenu.add(greenLight);               //add the Light Green Item to the green menu
    greenMedium=new JMenuItem("Medium Green"); //Create a medium green item
    greenMedium.addActionListener(this);       //add this as the Medium Green action listener
    greenMenu.add(greenMedium);                //add Medium Green to the green menu
    greenDark=new JMenuItem("Dark Green"); //a bright green item
    greenDark.addActionListener(this);       //add this as the Bright Green action listener
    greenMenu.add(greenDark);                //add Bright Green to the green menu

    blueItem=new JMenuItem("Blue");      //create a Blue Item
    blueItem.addActionListener(this);    //add this as the Blue action listener
    colorMenu.add(blueItem);             //add the Blue Item to the color menu
    myMenuBar.add(colorMenu);            //add the Color Menu to the Menu Bar
    
    shapeMenu=new JMenu("Shape");        //create a shape menu
    square=new JMenuItem("Square");      //create a square item
    square.addActionListener(this);      //add this as the square action listener
    shapeMenu.add(square);               //add the square to the shape menu
    circle=new JMenuItem("Circle");      //create a circle item
    circle.addActionListener(this);      //add this as the circle action listener
    shapeMenu.add(circle);               //add the circle to the shape menu
    line=new JMenuItem("Line");          //add the "none" object to the shape menu
    line.addActionListener(this);        //add this as the "none" action listener
    shapeMenu.add(line);                 //add none to the shape menu
    myMenuBar.add(shapeMenu);            //add the shape menu to the menu bar
    
    buttonPanel=new JPanel();            /* create a panel to hold the buttons, slider,
                                            labels, and text field.*/

    quitButton=new JButton("Quit");      //create a quit button
    quitButton.addActionListener(this);  //make this its action listener
    dragButton=new JButton("Draw curve");//create a drag button
    dragButton.addActionListener(this);  //make this its action listener
    
    //Here is the stuff for the slider.
    sizeSlider=new JSlider(JSlider.HORIZONTAL,SMALL_SIZE,LARGE_SIZE,50); /*create the size
                 * slider with a range from SMALL_SIZE to LARGE_SIZE and initial value 50*/
    sizeSlider.addChangeListener(this);  //make this its change listener
    sliderLabel=new JLabel("     Choose Size:"); //create a label for the slider
    sizeTextLabel=new JLabel("     size:");   //create a label for the text field
    sizeField=new JTextField(5);         //create the text field for displaying size
    sizeField.setText("50");             //set the text field to initial value 50
    
    buttonPanel.add(quitButton);        // add the quitbutton, 
    buttonPanel.add(dragButton);        // drage button,
    buttonPanel.add(sliderLabel);       // slider label,
    buttonPanel.add(sizeSlider);        // size slider,
    buttonPanel.add(sizeTextLabel);     // size text field label,
    buttonPanel.add(sizeField);         // and size field to the buttonPanel.
    
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
    if(actionObject==redItem) {
      color=Color.RED;
    }
    else if(actionObject==blueItem) {    // and, also, for all the menu items
      color=Color.BLUE;
    }
    else if(actionObject==greenLight) {
      color=new Color(0,255,0);
    }
    else if(actionObject==greenMedium) {
      color=new Color(0,205,0);
    }
    else if(actionObject==greenDark) {
      color=new Color(0,155,0);
    }
    else if(actionObject==square) {
      graphicalObject=GraphicalObject.SQUARE;
    }
    else if(actionObject==circle) {
      graphicalObject=GraphicalObject.CIRCLE;
    }
    else if(actionObject==line) {
      graphicalObject=GraphicalObject.LINE;
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
