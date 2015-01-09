import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI_button extends JFrame implements ActionListener {
  Container thisFrame;
  JButton quitButton,helloButton,goodbyButton;
  JTextField greeting;
  
  /**
   * begin serves as the costructor for a FrameWindowController (as always). In this
   * case it creates the GUI components, sets up their action responses, and adds the
   * components to the FrameWindowController.
   */
  public GUI_button() {
  
    quitButton=new JButton("quit");      // create a quit button
    quitButton.addActionListener(this);  // add this as the quit button action listener
    
    helloButton=new JButton("Hello");   // create a button for drawing a square
    helloButton.addActionListener(this); // add this as the square button action listener
    
    goodbyButton=new JButton("Goodby");   // create a button for drawing a circle
    goodbyButton.addActionListener(this); // add this as the circle button action listener

    greeting=new JTextField("");          // create a text field for greetings
    
    thisFrame=getContentPane();           // the Container thisFrame is used for adding stuff
    
    thisFrame.add(helloButton,BorderLayout.WEST); //add the hello button on the left
    thisFrame.add(goodbyButton,BorderLayout.CENTER); //add the goodby button in the center
    thisFrame.add(quitButton,BorderLayout.EAST); //add the quit button on the right
    thisFrame.add(greeting,BorderLayout.SOUTH); //add the text field on the bottom
    
    thisFrame.validate();     //validate the GUI components we have added
    
    setVisible(true);
    setSize(300,100);
  }
  
  /**
   * actionPerformed reacts to actions associated with GUI components - usually
   * clicks.
   */
  public void actionPerformed(ActionEvent evt) {
    Object actionObject=evt.getSource(); /* evt has a method getSource() returns the
                                          * GUI component the action occurred on. */
    if(actionObject==helloButton) {  //What we do when the squareButton is clicked
      greeting.setText("Hello, World!");
    }
    else if(actionObject==goodbyButton) { //ditto for the Circle Button
      greeting.setText("Farewell, friend.");
    }
    else if(actionObject==quitButton) {  //ditto for the quitButton
      System.exit(0);
    }
  }
}
