import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * In this class we are constructing a simple calculator which will perform
 * operations on the numbers in the first and second boxes and put the answers
 * in the third. As given here, the calculator has an addition button. 
 * You are to add: -, *, /, log, exp, +/- First, +/- Second, sin, cos, tan, 
 * Clear First, Clear Second, and Clear All buttons, and make them work. All of the buttons should 
 * be put in a single button panel with a GridLayout (arrange buttons to look 
 * like an actual calculator). Also add a Quit button which stops by program by
 * executing the statement: System.exit(0);
 */
public class Calculator extends JFrame implements ActionListener,FocusListener {
  
  private JTextField firstBox,secondBox,answerBox;
  private JPanel numberPanel;
  private double first=0;
  private double second=0;
  private double answer;
  private Container contentPane;
  private JButton showValues,addValues;
  
  /**
   * The constructor must lay out all the components for the GUI, set up action
   * listeners (and things) and start the JFrame action.
   */
  public Calculator() {
    //Create the box for the first number
    firstBox=new JTextField(""+first,20);
    firstBox.addFocusListener(this);
    firstBox.setHorizontalAlignment(JTextField.RIGHT);
    //Create the box for the second number
    secondBox=new JTextField(""+second,20);
    secondBox.addFocusListener(this);
    secondBox.setHorizontalAlignment(JTextField.RIGHT);
    //Create the box for the answer
    answerBox=new JTextField("0.0",20);
    answerBox.setEditable(false);
    answerBox.setHorizontalAlignment(JTextField.RIGHT);
    /* Create a panel for the boxes and add them to it
     * along with labels and appropriate spacing */
    numberPanel=new JPanel();
    numberPanel.setLayout(new GridLayout(5,2));
    numberPanel.add(new JLabel("First"));
    numberPanel.add(firstBox);
    numberPanel.add(new JLabel("Second"));
    numberPanel.add(secondBox);
    numberPanel.add(new JLabel(""));
    numberPanel.add(new JLabel(""));
    numberPanel.add(new JLabel("Answer"));
    numberPanel.add(answerBox);
    numberPanel.add(new JLabel(""));
    //Create the content pane to add things to.
    contentPane=getContentPane();
    //Add the number panel north
    contentPane.add(numberPanel,BorderLayout.NORTH);
    //Create the Add button
    addValues=new JButton("+");
    addValues.addActionListener(this);
    /* You will eventually add this button to a
     * buttonPanel instead of the CENTER.
     */
    contentPane.add(addValues,BorderLayout.CENTER);
    contentPane.validate();
    //set the size and make the JFrame visible
    setSize(300,200);
    setVisible(true);
  }
  
  /**
   * Whenever you leave the firstBox and secondBox, the focus is lost for that box 
   * and this method is called and first and second are set to the values in
   * the JTextFields firstBox and secondBox. If you enter a bad value, the exception
   * handling handles it and pops up a box and resets the box to the previous value.
   */
  public void focusLost(FocusEvent firstEvent) { 
    Object source=firstEvent.getSource();
    if(source==firstBox) {
      try {
        first=Double.parseDouble(firstBox.getText());
      }
      catch(Exception secondEvent) {
        JOptionPane.showMessageDialog(this,"Illegal value in the first number text field.");
        firstBox.setText(""+first);
      }
    }
    else if(source==secondBox) {
      try { // a special java block to test for exceptions should they occur
        second=Double.parseDouble(secondBox.getText());
      }
      catch(Exception e) { // a special java block to deal with exceptions should they occur
        JOptionPane.showMessageDialog(this,"Illegal value in the second number text field.");
        secondBox.setText(""+second);
      }
    }      
  }
  /**
   * Even though we do not need focusGained, it must be created when you implement
   * the FocusListener interface.
   */
  public void focusGained(FocusEvent e) {
  }
  
  /**
   * The actionPerformed method handles the button actions.
   */
  public void actionPerformed(ActionEvent evt) {
    Object source=evt.getSource();
    if(source==showValues) {
      System.out.println(""+first+" "+second);
    }
    else if(source==addValues) {
      answer=first+second;
      answerBox.setText(""+answer);
    }
  }
}
