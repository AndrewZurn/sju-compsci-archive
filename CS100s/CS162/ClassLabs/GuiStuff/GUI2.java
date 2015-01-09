import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2 extends JFrame implements ActionListener {
  private JButton quitButton;
  private JComboBox aComboBox;
  private JTextField data;
  
  public GUI2() {
    quitButton=new JButton("quit");
    quitButton.addActionListener(this);
    aComboBox=new JComboBox();
    for(int i=0;i<6;i++) {
      aComboBox.addItem(""+i);
    }
    aComboBox.addActionListener(this);
    aComboBox.addItem("Huh");
    data=new JTextField("Hi!",15);
    data.addActionListener(this);
    Container contentPane=getContentPane();
    contentPane.setLayout(new FlowLayout());
    contentPane.add(quitButton);
    contentPane.add(aComboBox);
    contentPane.add(data);
    setSize(350,80);
    
    
  }
  public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
    if(source==quitButton) {
      System.exit(0);
    }
    else if(source==aComboBox) {
      String temp=(String)aComboBox.getSelectedItem();
      data.setText(""+temp);
    }
    else if(source==data) {
      aComboBox.addItem(data.getText());
    }
  }
  public static void main(String [] args) {
    GUI2 temp=new GUI2();
    temp.setVisible(true);
  }
}