import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import acm.gui.*;

/**
 * HexCalculator is a class that is designed to create a working
 * hexadecimal integer calculator capable of doing the four standard
 * functions (add, subtract, multiply, and divide) while allowing the
 * user to enter values using the mouse to click on buttons. It includes
 * a BS key for removing the last character entered, a CE key for
 * remving the current value, a CA key for clearing everything, and an
 * E key for "entering" a value. The calculator works using reverse
 * polish notation like HP calculators.
 * 
 * @author Lynn Ziegler
 */
public class HexCalculator extends JFrame implements ActionListener {
  //controls is the list of buttons we create for all the functions
  private ArrayList<JButton> controls;
  //computedValue is the text field containing the result entered or
  // the result calculated at any time (in hexadecimal).
  private JTextField computedValue;
  //value contains the numeric value stored in computedValue
  private long value=0;
  /* numberPanel holds the hexadecimal digit buttons 0-9a-f,
   * operatorPanel holds the operators (+,-,*,/) and
   * controlPanel contains the BS, CE, CA, and E buttons. */
  private JPanel numberPanel,operatorPanel,controlPanel;
  private boolean replaceString=true;
  private Stack<Long> numberStack;
  
  /* This is NOT one of the book programs. It is, instead, a JFrame
   * so we use the usual constructor notation. This constructor
   * adds all of the buttons and the text field to the GUI. */
  public HexCalculator() {
    //create the three JPanels to hold the distinct parts of the calculator
    numberPanel=new JPanel();
    operatorPanel=new JPanel();
    controlPanel=new JPanel();
    //create the array list that will hold all the buttons
    controls=new ArrayList<JButton>();
    /* set the layout managers fro each panel. numberPanel needs a 4x4 array
     * for the digits 0-9a-f. operatorPanel needs 4 slots (a 4x1 array) for
     * the operators (+,-,*,/). controlPanel needs 4 slots (a 4x1 array)
     * for BS, CE, CA, E. Note that we add a horizontalgap of 30 to operatorPanel
     * in order to separate the three panels. */
    numberPanel.setLayout(new TableLayout(4,4));
    operatorPanel.setLayout(new TableLayout(4,1,30,0));
    controlPanel.setLayout(new TableLayout(4,1));
    //create the text field which will show the calculated results, initially 0.
    computedValue=new JTextField();
    computedValue.setText("0");
    computedValue.setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,40));
    //allign the text field to the right the way a calculator does.
    computedValue.setHorizontalAlignment(JTextField.RIGHT);
    /* add the computedValue to the top, the numberPanel to the WEST, the
     * operatorPanel to the center, and the controlPanel to the EAST. */
    add(computedValue,BorderLayout.NORTH);
    add(numberPanel,BorderLayout.WEST);
    add(operatorPanel,BorderLayout.CENTER);
    add(controlPanel,BorderLayout.EAST);
    //create the numeric buttons and add them to the numberPanel.
    for(int i=0;i<=9;i++) {
        controls.add(new JButton(""+i));
        numberPanel.add(controls.get(i));
    }
    //create the a-f buttons and add them to the numberpanel.
    char c='a';
    for(int i=10;i<=15;i++) {
      controls.add(new JButton(""+c));
      c++;
      numberPanel.add(controls.get(i));
    }
    //add the four operator buttons to the array.
    controls.add(new JButton("+")); 
    controls.add(new JButton("-"));
    controls.add(new JButton("*"));
    controls.add(new JButton("/"));
    //now add them to the operatorPanel.
    for(int i=16;i<=19;i++) {
      operatorPanel.add(controls.get(i));
    }
    //add the four control buttons to the controlPanel.
    controls.add(new JButton("BS"));
    controls.add(new JButton("CE"));
    controls.add(new JButton("CA"));
    controls.add(new JButton("E"));
    //now add them to the operator panel.
    for(int i=20;i<=23;i++) {
      controlPanel.add(controls.get(i));
    }
    /* add action listener for all of the buttons in array controls and,
     * also, set the font to a larger value. */
    for(int i=0;i<24;i++) {
      controls.get(i).addActionListener(this);
      controls.get(i).setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,40));
    }
    numberStack=new Stack<Long>();
    for(long i=0;i<10;i++) {
      numberStack.push(0L);
    }
    //this is necessary to make the calculator appear.
    setVisible(true);
    //this "compactifies" the calculator nicely.
    pack();
  }
  
  /**
   * Depending on the operator button pushed, performOperation will do
   * the numeric operations for the calculator combining the last value
   * entered with the current value appearing in the text field
   * computedValue. */
  public long performOperation(String s) {
for(Long l:numberStack) System.out.print("|"+l);
    System.out.println();
    //Long.parseLong converts the hexadecimal string in computedValue
    // into a number.
    value=Long.parseLong(computedValue.getText(),16);
    //numberStack contains the values previously "entered" in reverse
    //order of entry. pop() removes the last one and returns it.
    long oldValue=numberStack.pop();
    //the switch statement is a special kind of if statement. It makes
    // sure the proper operation is performed.
    switch(s.charAt(0)) {
      case '+': return(oldValue+value);
      case '-': return(oldValue-value);
      case '*': return(oldValue*value);
      case '/': return(oldValue/value);
      default: return(0); //this should never happen.
    }
  }

  /**
   * In this program, actionPerformed simply reacts to all of those buttons.
   */
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    //If the button was a hexadecimal digit button, simply add that digit to
    // the text field by computing the new value.
    for(int i=0;i<16;i++) {
      if(source==controls.get(i)) {
        //if replaceString is true, we first reset the current value to 0.
        //this happens, for example, after an operation.
        if(replaceString) {
          value=0;
          replaceString=false;
        }
        //In any case, we recalculate the value using the value of this key.
        value=value*16+i;
        //we then set the displayed value to show this new value.
        computedValue.setText(Long.toHexString(value));
      }
    }
    /* This loop handles the operations by calling performOperations to get
     * the computed value, pushes that value onto the stack, and makes the
     * display show that value. */
    for(int i=16;i<20;i++) {
      if(source==controls.get(i)) { 
        value=performOperation(controls.get(i).getText());
        //numberStack.push(value);
        computedValue.setText(Long.toHexString(value));
        replaceString=true;
      }
    }
    //Here we handle the back space key.
    if(source==controls.get(20)) { // BS
      String hexNumber=computedValue.getText();
      if(hexNumber.length()>1) {
        hexNumber=hexNumber.substring(0,hexNumber.length()-1);
        computedValue.setText(hexNumber);
        value=Long.valueOf(hexNumber,16);
      }
      else {
        value=0;
        computedValue.setText("0");
        replaceString=true;
      }
    }
    //Here we handle the CE
    else if(source==controls.get(21)) { //CE
      computedValue.setText("0");
      value=0;
      replaceString=true;
    }
    //Here we handle the CA - clear the stack and the value.
    else if(source==controls.get(22)) {  //CA
      computedValue.setText("0");
      value=0;
      replaceString=true;
      while(!numberStack.isEmpty()) {
        numberStack.pop();
      }
      for(int i=0;i<10;i++) {
        numberStack.push(0L);
      }
    }
    /* E for enter pushes the current value onto the stack and
     * prepares for the entry of the next value. */
    else if(source==controls.get(23)) {  //E
      value=Long.parseLong(computedValue.getText(),16);
      numberStack.push(value);
 for(Long l:numberStack) System.out.print("|"+l);
 System.out.println();
      replaceString=true;
    }
  }
  
  /**
   * As always, main simply launches the class. Note we don't need a run()
   * method in this GUI.
   */
  public static void main(String [] args) {
    new HexCalculator();
  }
}
          