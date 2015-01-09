import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class shows how to create a menu bar GUI component 
 * and use it to cause actions to occur.
 */
public class GUI_menu extends FrameWindowController implements ActionListener {
  
  JMenuBar myMenuBar;                               // the menubar
  JMenu colorMenu,shapeMenu,greenMenu;              // some menus for the menubar
  // the following are items in the three menus
  JMenuItem redItem,blueItem,greenLight,greenMedium,greenDark,square,circle,line;
  
  Color color=Color.RED;
  GraphicalObject graphicalObject=GraphicalObject.SQUARE; /* keeps track of which
                                                           * graphical object to draw*/
  Location oldPoint; // used to hold initial point in a line
  boolean lineStarted=false; /* if false, it means we click for the first point. If 
                                true, it means that the click will draw the line.*/
   /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController. For this program, the GUI components
   * are all part of the menu bar placed on top of the screen.
   */
  public void begin() {
    myMenuBar=new JMenuBar();  //creates the menu bar on top of the screen
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
    line=new JMenuItem("Line");          //add the line object to the shape menu
    line.addActionListener(this);        //add this as the line action listener
    shapeMenu.add(line);                 //add line to the shape menu
    myMenuBar.add(shapeMenu);            //add the shape menu to the menu bar
    
    getContentPane().validate();         //validate the GUI components we have added.
  }
  
  /**
   * onMouseClick draws the appropriate thing in the current color at the appropriate
   * spot.
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
  }
  
  /**
   * onMouseClick actually draws the correct object in Color color.
   */
  public void onMouseClick(Location point) {
    switch(graphicalObject) {
      case SQUARE: 
        new FilledRect(point,50,50,canvas).setColor(color); break;
      case CIRCLE: 
        new FilledOval(point,50,50,canvas).setColor(color); break;
      case LINE: 
        if(lineStarted) {
          new Line(oldPoint,point,canvas).setColor(color);
          lineStarted=false;
        }
        else {
          oldPoint=point;
          lineStarted=true;
        } break;
    }
  }
}
    