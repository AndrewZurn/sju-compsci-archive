import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//Zurn, Andrew    Calculator

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
public class Calculator extends JApplet implements ActionListener,FocusListener {
  
  private JTextField firstBox,secondBox,answerBox;
  private JPanel numberPanel, functionsPanel;
  private double first=0;
  private double second=0;
  private double answer;
  private Container contentPane;
  private JButton showValues,addValues, subtractValues, multiplyValues, divideValues,
    logValues, expValues, changeFirstSign, changeSecondSign, sinValues, cosValues, tanValues,
    clearFirst, clearSecond, clearAll, blank, quitButton;
  
  /**
   * The constructor must lay out all the components for the GUI, set up action
   * listeners (and things) and start the JFrame action.
   */
  public void init() {
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
    //New functions panel
    functionsPanel = new JPanel();
    functionsPanel.setLayout(new GridLayout(4,4));
    contentPane.add(functionsPanel,BorderLayout.SOUTH);
    //Create the Add button
    addValues=new JButton("+");
    addValues.addActionListener(this);
    subtractValues=new JButton("-");
    subtractValues.addActionListener(this);
    multiplyValues=new JButton("*");
    multiplyValues.addActionListener(this);
    divideValues=new JButton("/");
    divideValues.addActionListener(this);
    logValues=new JButton("log");
    logValues.addActionListener(this);
    expValues=new JButton("exp");
    expValues.addActionListener(this);
    changeFirstSign=new JButton("+/- First");
    changeFirstSign.addActionListener(this);
    changeSecondSign=new JButton("+/- Second");
    changeSecondSign.addActionListener(this);
    sinValues=new JButton("sin");
    sinValues.addActionListener(this);
    cosValues=new JButton("cos");
    cosValues.addActionListener(this);
    tanValues=new JButton("tan");
    tanValues.addActionListener(this);
    clearFirst=new JButton("Clear First");
    clearFirst.addActionListener(this);
    clearSecond=new JButton("Clear Second");
    clearSecond.addActionListener(this);
    clearAll=new JButton("Clear All");
    clearAll.addActionListener(this);
    blank=new JButton("");
    quitButton=new JButton("Exit");
    quitButton.addActionListener(this);
    /* You will eventually add this button to a
     * buttonPanel instead of the CENTER.
     */
    functionsPanel.add(clearSecond);
    functionsPanel.add(tanValues);
    functionsPanel.add(expValues);
    functionsPanel.add(divideValues);
    functionsPanel.add(clearFirst);
    functionsPanel.add(cosValues);
    functionsPanel.add(logValues);
    functionsPanel.add(multiplyValues);
    functionsPanel.add(clearAll);
    functionsPanel.add(sinValues);
    functionsPanel.add(changeSecondSign);
    functionsPanel.add(subtractValues);
    functionsPanel.add(quitButton);
    functionsPanel.add(blank);
    functionsPanel.add(changeFirstSign);
    functionsPanel.add(addValues);
    contentPane.validate();
    //set the size and make the JFrame visible
    setSize(475,225);
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
    else if(source==subtractValues){
      answer=first-second;
      answerBox.setText(""+answer);
    }
    else if(source==divideValues){
      answer=first/second;
      answerBox.setText(""+answer);
    }
    else if(source==multiplyValues){
      answer=first*second;
      answerBox.setText(""+answer);
    }
    else if(source==changeFirstSign){
      first=-first;
      firstBox.setText(""+first);
    }
    else if(source==changeSecondSign){
      second=-second;
      secondBox.setText(""+second);
    }
    else if(source==logValues){
      first=Math.log(first);
      answerBox.setText(""+first);
    }
    else if(source==expValues){
      first=Math.exp(first);
      answerBox.setText(""+first);
    }
    else if(source==sinValues){
      first=Math.toRadians(first);
      first=Math.sin(first);
      answerBox.setText(""+first);
    }
    else if(source==cosValues){
      first=Math.toRadians(first);
      first=Math.cos(first);;
      answerBox.setText(""+first);
    }
    else if(source==tanValues){
      first=Math.toRadians(first);
      first=Math.tan(first);
      answerBox.setText(""+first);
    }
    else if(source==clearAll){
      first=0;
      firstBox.setText(""+first);
      second=0;
      secondBox.setText(""+second);
      answerBox.setText("0.0");
    }
    else if(source==clearFirst){
      first=0;
      firstBox.setText(""+first);
    }
    else if(source==clearSecond){
      second=0;
      secondBox.setText(""+second);
    }
    else if(source==quitButton){
      System.exit(0);
    }
  }
}

