import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_1 extends FrameWindowController implements ActionListener,FocusListener {
  Container thisFrame;
  JButton squareButton,quitButton,circleButton,drawButton;
  JPanel buttonPanel;
  JTextField xBox,yBox;
  JMenuBar myMenuBar;                               // some menus and some menu items
  JMenu colorMenu,sizeMenu,greenMenu;
  JMenuItem redItem,blueItem,greenLight,greenMedium,greenBright,size50,size100,size150;
  Color graphicalObjectColor=Color.BLACK;
  double size=50,xPos=0,yPos=0;
  
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
    greenBright=new JMenuItem("Bright Green"); //a bright green item
    greenBright.addActionListener(this);       //add this as the Bright Green action listener
    greenMenu.add(greenBright);                //add Bright Green to the green menu

    blueItem=new JMenuItem("Blue");      //create a Blue Item
    blueItem.addActionListener(this);    //add this as the Blue action listener
    colorMenu.add(blueItem);             //add the Blue Item to the color menu
    myMenuBar.add(colorMenu);            //add the Color Menu to the Menu Bar
    
    sizeMenu=new JMenu("Size");          //create a size menu
    
    size50=new JMenuItem("size 50");     //create size 50 item
    size50.addActionListener(this);      //add this as its action listener
    sizeMenu.add(size50);                //add size 50 item to the size menu
    size100=new JMenuItem("size 100");   //create size 100 item
    size100.addActionListener(this);     //add this as the size 100 action listener
    sizeMenu.add(size100);               //add size 100 item to the size menu
    size150=new JMenuItem("size150");    //create a size 150 item
    size150.addActionListener(this);     //add this as the size 150 action listener
    sizeMenu.add(size150);               //add size 150 to the size menu
    
    myMenuBar.add(sizeMenu);             //add the size menu to the menu bar
    
    buttonPanel=new JPanel();            /* create buttonPanel as a Panel - a GUI device for
                                          * holding other GUI thingies */
    quitButton=new JButton("quit");      // create a quit button
    quitButton.addActionListener(this);  // add this as the quit button action listener
    buttonPanel.add(quitButton);         // add the quit button to the button panel
    
    squareButton=new JButton("Square");   // create a button for drawing a square
    squareButton.addActionListener(this); // add this as the square button action listener
    buttonPanel.add(squareButton);        // add the square button to the button panel
    
    circleButton=new JButton("Circle");   // create a button for drawing a circle
    circleButton.addActionListener(this); // add this as the circle button action listener
    buttonPanel.add(circleButton);        // add the circle button to the button panel
    
    xBox=new JTextField("0",10);          // create a text field for holding the x co-ordinate
    xBox.addFocusListener(this);          // make it so lost focus will set the X value
    buttonPanel.add(new JLabel(" X:"));   // add a "X" label to the button panel
    buttonPanel.add(xBox);                // add the x box to the button panel
    
    yBox=new JTextField("0",10);          // create a text field for holding the y co-ordinate
    yBox.addFocusListener(this);          // make it so lost focus will set the Y value
    buttonPanel.add(new JLabel(" y:"));   // add a "Y" label to the button panel
    buttonPanel.add(yBox);                // add the y box to the button panel
    
    thisFrame=getContentPane();           // the Container thisFrame is used for adding stuff
    thisFrame.add(buttonPanel,BorderLayout.NORTH); //add the button panel
    
    thisFrame.validate();     //validate the GUI components we have added
  }
  
  /**
   * actionPerformed reacts to actions associated with GUI components - usually
   * clicks.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource(); /* evt has a method getSource() returns the
                                          * GUI component the action occurred on. */
    if(actionObject==squareButton) {  //What we do when the squareButton is clicked
      new FilledRect(xPos,yPos,size,size,canvas).setColor(graphicalObjectColor);
    }
    else if(actionObject==circleButton) { //ditto for the Circle Button
      new FilledOval(100+xPos,yPos,size,size,canvas).setColor(graphicalObjectColor);
    }
    else if(actionObject==quitButton) {  //ditto for the quitButton
      System.exit(0);
    }
    else if(actionObject==blueItem) {    // and, also, for all the menu items
      graphicalObjectColor=Color.BLUE;
    }
    else if(actionObject==redItem) {
      graphicalObjectColor=Color.RED;
    }
    else if(actionObject==greenLight) {
      graphicalObjectColor=new Color(0,255,0);
    }
    else if(actionObject==greenMedium) {
      graphicalObjectColor=new Color(0,205,0);
    }
    else if(actionObject==greenBright) {
      graphicalObjectColor=new Color(0,155,0);
    }
    else if(actionObject==size50) {
      size=50;
    }
    else if(actionObject==size100) {
      size=100;
    }
    else if(actionObject==size150) {
      size=150;
    }
  }
  public void focusLost(FocusEvent e) { /* Whenever you leave the xBox and yBox, the
                                         * focus is lost for that box and this method
                                         * is called and the xPos and yPos are set. */
    xPos=Double.parseDouble(xBox.getText());
    yPos=Double.parseDouble(yBox.getText());
  }
  public void focusGained(FocusEvent e) {
  }
}