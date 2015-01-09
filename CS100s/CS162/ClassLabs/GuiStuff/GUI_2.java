import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_2 extends JFrame implements ActionListener {
  private Container thisFrame;
  private JTextField field;
  private JMenuBar myMenuBar;                               // some menus and some menu items
  private JMenu letterMenu;
  private JMenuItem [] items;
  
  /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController.
   */
  public GUI_2() {
    items=new JMenuItem[26];
    myMenuBar=new JMenuBar();  //creates the menu bar for the top
    setJMenuBar(myMenuBar);    //makes myMenuBar the top menu bar
    
    letterMenu=new JMenu("Letters"); //create a menu for changing colors
    char c='A';
    for(int i=0;i<26;i++) {
      items[i]=new JMenuItem(""+c);
      items[i].addActionListener(this);
      letterMenu.add(items[i]);
      c++;
    }
    
    myMenuBar.add(letterMenu);            //add the Color Menu to the Menu Bar
    field=new JTextField(5);
    thisFrame=getContentPane();           // the Container thisFrame is used for adding stuff
    thisFrame.add(field,BorderLayout.NORTH); //add the button panel
    setVisible(true);
    pack();
  }
  
  /**
   * actionPerformed reacts to actions associated with GUI components - usually
   * clicks.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource(); /* evt has a method getSource() returns the
                                          * GUI component the action occurred on. */
    for(int i=0;i<26;i++) {
      if(actionObject==items[i]) {
        field.setText(field.getText()+items[i].getText());
      }
    }
    
  }
  
  public static void main(String [] args) {
    new GUI_2();
  }
}