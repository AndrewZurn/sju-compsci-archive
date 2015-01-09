import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_menuBar extends FrameWindowController implements ActionListener {
  Container thisFrame;
  JMenuBar myMenuBar;                               // some menus and some menu items
  JMenu colorMenu,sizeMenu,greenMenu,quitMenu;
  JMenuItem quitItem,redItem,blueItem,greenLight,greenMedium,greenBright,size50,size100,size150;
  double size=50,xPos=0,yPos=0;
  FilledRect fr;
  
  /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController.
   */
  public void begin() {
    myMenuBar=new JMenuBar();  //creates the menu bar for the top
    setJMenuBar(myMenuBar);    //makes myMenuBar the top menu bar
    
    quitMenu=new JMenu("Quit"); //create the quitting menu
    quitItem=new JMenuItem("Quit"); //create the quit item
    quitItem.addActionListener(this); //Make the quitItem active
    quitMenu.add(quitItem);
    myMenuBar.add(quitMenu); //add the quitting menu to the menu bar
    
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
    
    fr=new FilledRect(10,10,50,50,canvas);  //create the filled rectangle
        
    thisFrame=getContentPane();           // the Container thisFrame is used for adding stuff
    
    thisFrame.validate();     //validate the GUI components we have added
  }
  
  /**
   * actionPerformed reacts to actions associated with GUI components - usually
   * clicks.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource(); /* evt has a method getSource() returns the
                                          * GUI component the action occurred on. */
    if(actionObject==quitItem) {
      System.exit(0);
    }
    else if(actionObject==blueItem) {    //actions for all the menu items
      fr.setColor(Color.BLUE);
    }
    else if(actionObject==redItem) {
      fr.setColor(Color.RED);
    }
    else if(actionObject==greenLight) {
      fr.setColor(new Color(0,255,0));
    }
    else if(actionObject==greenMedium) {
      fr.setColor(new Color(0,205,0));
    }
    else if(actionObject==greenBright) {
      fr.setColor(new Color(0,155,0));
    }
    else if(actionObject==size50) {
      fr.setSize(50,50);
    }
    else if(actionObject==size100) {
      fr.setSize(100,100);
    }
    else if(actionObject==size150) {
      fr.setSize(150,150);
    }
  }
  
  public void onMouseClick(Location p) {
    fr.moveTo(p);
  }
}