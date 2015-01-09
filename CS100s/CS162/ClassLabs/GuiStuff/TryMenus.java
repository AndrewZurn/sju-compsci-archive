import java.awt.*;
import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class TryMenus extends GraphicsProgram{
  private ProgramMenuBar topMenu;
  private JMenu shapeMenu;
  private JMenuItem newFileItem,newEditItem;
  private JMenuItem square,circle,turtle;
  private JPopupMenu rightClickMenu,middleClickMenu;
  private JMenuItem red,green,blue;
  private JMenuItem increase,decrease,reset;
  
  private Color chosenColor=Color.RED;
  private String shape="circle";
  private double size=50.0;
  
  public void init() {
    addMouseListeners();
    addActionListeners();
    
    //this block sets up an additional menu item on the top menu
    topMenu=getMenuBar();
    shapeMenu=new JMenu("Shape");
    square=new JMenuItem("square");
    square.addActionListener(this);
    shapeMenu.add(square);
    circle=new JMenuItem("circle");
    circle.addActionListener(this);
    shapeMenu.add(circle);
    turtle=new JMenuItem("turtle");
    turtle.addActionListener(this);
    shapeMenu.add(turtle);
    topMenu.add(shapeMenu);
    
    //This is how we would add a new item to the regular menus
    /* first we get the first menu (the file menu) and add a new
     * item to it at the second position. */
    JMenu fMenu=getMenuBar().getMenu(0);
    newFileItem=new JMenuItem("New File Item");
    newFileItem.addActionListener(this);
    fMenu.add(newFileItem,2);
    /* next we get the second menu (the edit men) and add a new 
     * item to it at the first position. */
    JMenu eMenu=getMenuBar().getMenu(1);
    newEditItem=new JMenuItem("New Edit Item");
    newEditItem.addActionListener(this);
    eMenu.add(newEditItem,0);
    
    //this sets up a popup menu on a middle click
    middleClickMenu=new JPopupMenu();
    increase=new JMenuItem("increase size");
    increase.addActionListener(this);
    middleClickMenu.add(increase);
    decrease=new JMenuItem("decrease size");
    decrease.addActionListener(this);
    middleClickMenu.add(decrease);
    reset=new JMenuItem("reset to original size");
    reset.addActionListener(this);
    middleClickMenu.add(reset);
    
    //this sets up a popup menu on a right click
    red=new JMenuItem("red");
    red.addActionListener(this);
    green=new JMenuItem("green");
    green.addActionListener(this);
    blue=new JMenuItem("blue");
    blue.addActionListener(this);
    rightClickMenu=new JPopupMenu();
    rightClickMenu.add(red);
    rightClickMenu.add(blue);
    rightClickMenu.add(green);
  }
  public void run() {
    setSize(1000,700);
  }
  
  /**
   * As usual, our actionPerformed(e) method reacts to actions. In this
   * program all actions are menu choices (JMenuItem objects).
   */
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    //the first three are actions on the new top menu
    if(source==square) {
      shape="square";
    }
    else if (source==circle) {
      shape="circle";
    }
    else if(source==turtle) {
      shape="turtle";
    }
    //the next three are actions on the middle button popup menu
    else if(source==increase) {
      size=size*1.2;
    }
    else if(source==decrease) {
      size=size*0.8;
    }
    else if(source==reset) {
      size=50.0;
    }
    //the last three are for the right button popup menu
    else if(source==blue) {
      chosenColor=Color.BLUE;
    }
    else if(source==red) {
      chosenColor=Color.RED;
    }
    else if(source==green) {
      chosenColor=Color.GREEN;
    }
    //the following two are nonsense items we added to the file and edit menus
    else if(source==newFileItem) {
      JOptionPane.showMessageDialog(this,"We clicked the new file item");
    }
    else if(source==newEditItem) {
      JOptionPane.showMessageDialog(this,"We clicked the new edit item");
    }
  }
  
  /**
   * For the first time, our mousePressed reacts to left, middle, and right
   * button presses in different ways. The secret is e.getButton() which returns
   * 1 for the left mouse button, 2 for the middle mouse button, and 3 for the 
   * right mouse button.
   */
  public void mousePressed(MouseEvent e) {
    
    int buttonPressed=e.getButton();
    
    //If the left button is pressed we draw a shape
    if(buttonPressed==1) { //left button pressed
      if(shape.equals("square")) {
        GRect newRect=new GRect(e.getX(),e.getY(),size,size);
        newRect.setFilled(true);
        newRect.setColor(chosenColor);
        add(newRect);
      }
      else if(shape.equals("circle")) {
        GOval newOval=new GOval(e.getX(),e.getY(),size,size);
        newOval.setFilled(true);
        newOval.setColor(chosenColor);
        add(newOval);
      }
      else if(shape.equals("turtle")) {
        MyTurtle newTurtle=new MyTurtle(e.getX(),e.getY(),size);
        newTurtle.setColor(chosenColor);
        add(newTurtle);
      }
    }
    //If the middle button is pressed we pop up a size menu
    else if(buttonPressed==2) {
      middleClickMenu.show(e.getComponent(),e.getX(),e.getY());
    }
    else if(buttonPressed==3) { //right button pressed
      rightClickMenu.show(e.getComponent(),e.getX(),e.getY());
    }
  }
  
  /**
   * main, as usual, just launches this class.
   */
  public static void main(String[] args) {
    new TryMenus().start();
  }
}