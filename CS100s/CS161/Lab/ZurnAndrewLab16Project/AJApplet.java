import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class AJApplet extends JApplet implements ActionListener {
  public JButton hello,goodby;
  public JTextField greeting;
  public JPanel buttonPanel;
  
  /**
   * First method to be exectued in an Applet
   */
  public void init() {
    hello=new JButton("Hello");
    hello.addActionListener(this);
    goodby=new JButton("Goodbye");
    goodby.addActionListener(this);
    greeting=new JTextField(20);
    buttonPanel=new JPanel();
    setLayout(new BorderLayout());
    buttonPanel.add(hello);
    buttonPanel.add(goodby);
    buttonPanel.add(greeting);
    add(buttonPanel,BorderLayout.CENTER);
  }
  
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    if(source==hello) {
      greeting.setText("Hello, World!");
    }
    else if(source==goodby) {
      greeting.setText("Farewell, cruel world.");
    }
  }
}