import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This program starts with GUI_menu and shows how to add a panel of buttons.
 */
public class GUI_addButtonPanel extends FrameWindowController implements ActionListener {
  
  JPanel buttonPanel;                         // create a panel of buttons to
  JButton quitButton,dragButton;              // quit or go into draw mode.
  Container contentPane;                      // contentPane controls GUI placement
  JMenuBar myMenuBar;                         // Some menus and some menu items
  JMenu colorMenu,shapeMenu,greenMenu;        // from the previous version.
  JMenuItem redItem,blueItem,greenLight,greenMedium,greenDark,square,circle,line;
  
  int size=50;
  Color color=Color.RED;
  GraphicalObject graphicalObject=GraphicalObject.SQUARE;
  Location oldPoint;
  boolean lineStarted=false,
          drag=false;
  
    /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController.
   */
  public void begin() {
    myMenuBar=new JMenuBar();  //same menu bar stuff
    setJMenuBar(myMenuBar);    
    
    colorMenu=new JMenu("Color"); 

    redItem=new JMenuItem("Red");    
    colorMenu.add(redItem);          
    redItem.addActionListener(this); 
    greenMenu=new JMenu("Green Menu"); 
    colorMenu.add(greenMenu);          
    greenLight=new JMenuItem("Light Green");
    greenLight.addActionListener(this);      
    greenMenu.add(greenLight);               
    greenMedium=new JMenuItem("Medium Green"); 
    greenMedium.addActionListener(this);       
    greenMenu.add(greenMedium);                
    greenDark=new JMenuItem("Dark Green"); 
    greenDark.addActionListener(this);       
    greenMenu.add(greenDark);                

    blueItem=new JMenuItem("Blue");      
    blueItem.addActionListener(this);    
    colorMenu.add(blueItem);             
    myMenuBar.add(colorMenu);            
    
    shapeMenu=new JMenu("Shape");        
    square=new JMenuItem("Square");      
    square.addActionListener(this);      
    shapeMenu.add(square);               
    circle=new JMenuItem("Circle");      
    circle.addActionListener(this);      
    shapeMenu.add(circle);               
    line=new JMenuItem("Line");          
    line.addActionListener(this);        
    shapeMenu.add(line);                 
    myMenuBar.add(shapeMenu);            
    
    quitButton=new JButton("Quit");      //create the quit button
    quitButton.addActionListener(this);  //add this as its action listener
    dragButton=new JButton("Draw curve");//create the drag button
    dragButton.addActionListener(this);  //add this as its action listener
    buttonPanel=new JPanel();            //create a panel to hold the buttons
    buttonPanel.add(quitButton);         //add the quit button to the panel
    buttonPanel.add(dragButton);         //add the drag button to the panel
    
    contentPane=this.getContentPane();   //As usual, get the content pane and use
    contentPane.add(buttonPanel,BorderLayout.NORTH); //it to add the button panel.
    
    contentPane.validate();         //Validate the GUI components we have added.
  }
  
  /**
   * onMouseClick draws the appropriate thing in the current color at the appropriate
   * spot.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource(); //We grab the object that was involved in the event
    if(actionObject==redItem) {          //We use if statements to determine which
      color=Color.RED;                   //object was involved and, then, do the appropriate
    }                                    //action.
    else if(actionObject==blueItem) {    
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
    else if(actionObject==quitButton) { //action asociated with the quitButton
      System.exit(0);
    }
    else if(actionObject==dragButton) { //action associated with the drag button.
      drag=!drag;                       //Set drag to true if it was false - i.e.,
    }                                   //start the drawing. If drag is already 
  }                                     //true, it turns off drag mode.
  
  /**
   * onMouseClick actually draws the correct object in Color color unless we
   * are in LINE or drag mode. For LINE mode, it starts or finishes the line.
   * For drag mode, it does nothing since drag is handled by onMousePress and
   * onMouseDrag.
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
   * onMousePress is used to start the drawing action.
   */
  public void onMousePress(Location point) {
    if(drag) {
      oldPoint=point;
    }
  }
  
  /**
   * onMouseDrag does the actual drawing.
   */
  public void onMouseDrag(Location point) {
    if(drag) {
      new Line(oldPoint,point,canvas).setColor(color);
      oldPoint=point;
    }
  }
  
}
    