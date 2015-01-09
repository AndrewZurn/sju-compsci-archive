import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * The testGUI class consists of a variety of GUI components to show how you might incorporate their use 
 * in a class
 */
public class TestGUI extends JFrame implements ActionListener, ChangeListener {
  
  private JButton button1, button2;  // two buttons
  private JSlider slider1;
  private JComboBox box1;
  private JTextArea area1;
  private JPanel panel1, panel2;
  private JTextField textLine;
  private JLabel label1;
    
  
  public TestGUI () {
    button1 = new JButton("Push Me");  // a button that sets the amount high
    button2 = new JButton("Don't Push!"); // a buttonthat sets the amount to zero
    button1.addActionListener(this); // need to add this as the listener of events for the buttons
    button2.addActionListener(this);
    
//set the slider vertical to go from 0-100 with the value initially set to 50    
    slider1 = new JSlider(JSlider.VERTICAL, 0, 100, 50); 
    slider1.addChangeListener(this);

// create a JCombo Box and add menu items to it
    box1 = new JComboBox(); 
    box1.addItem("10");
    box1.addItem("20");
    box1.addItem("30");
    box1.addItem("40");
    box1.addActionListener(this);
    
    label1 = new JLabel("MySlider");  //label forthe slider
    
    // create a panel and add components to the panel
    panel1 = new JPanel();
    panel1.add(button1);
    panel1.add(button2);
    panel1.add(box1);
    
    // create a second panel andadd components to it
    panel2 = new JPanel();
    panel2.add(label1);
    panel2.add(slider1);
    
    //create a text field 
    textLine = new JTextField("");
    

    
//   with a JFrame, getting a contentPane is not necessary; we can just add directly with a JFrame method
    // and it will add them to the contentPane
    add(panel1, BorderLayout.NORTH);
    add(panel2, BorderLayout.WEST);
    add(textLine, BorderLayout.SOUTH);
    validate();
    setSize(400,400); // to set the size of the Window to a fixed set of pixels

    setVisible(true); // window won't show up until we setVisible to true!
  }
  
  /**
   * action Performed is required by ComboBoxes and Buttons to say what occur if an event happens that affects these
   */
  public void actionPerformed(ActionEvent evt) {
  
    if(evt.getSource() == box1) {
      if (box1.getSelectedItem().equals("10")){
              textLine.setText("100");
      }
      else if (box1.getSelectedItem().equals("20")){
              textLine.setText("20");
      
    }
       else if (box1.getSelectedItem().equals("30")){
              textLine.setText("30");
      
    }
       else //if (box1.getSelectedItem().equals("40"){
              textLine.setText("40");
      
    }
    else if (evt.getSource() == button1) {
      textLine.setText("100");
    }
    else {
      textLine.setText("0!!!");
    }
    
  }
  
  /**
   * stateChanged is required by JSLiders
   */
  public void stateChanged(ChangeEvent evt){
    textLine.setText("" + slider1.getValue());
  
  }
}
  
             
    
  