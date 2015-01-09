import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RecordGUI extends JFrame  implements ActionListener {
 private Container thisFrame;
 private JPanel panel;
 private JComboBox comboBox;
 private JTextField inputField;
 private JTextArea field;
 private JButton button0, button1, button2, button3, button4, systemExit;
 private JMenuBar myMenuBar;
 private JMenu letterMenu;
 private JMenuItem [] items;
  
  
  public RecordGUI() {
    
    items=new JMenuItem[26];
    myMenuBar=new JMenuBar();
    setJMenuBar(myMenuBar);
    
     char c='A';
    for(int i=0;i<26;i++) {
      items[i]=new JMenuItem(""+c);
      items[i].addActionListener(this);
      letterMenu.add(items[i]);
      c++;
    }
    
    comboBox = new JComboBox();
    comboBox.addItem("Record/Album");
    comboBox.addItem("Track");
    comboBox.addItem("Artist");
    
    field = new JTextArea(40,30);
    
    button0 = new JButton("Button0");
    button1 = new JButton("Button1");
    button2 = new JButton("Button2");
    button3 = new JButton("Button3");
    button4 = new JButton("Button4");
    systemExit = new JButton("Quit");
    
    inputField = new JTextField("User Input Area");
    
    panel = new JPanel();
    panel.add(comboBox);
    panel.add(inputField);
    panel.add(button0);
    panel.add(button1);
    panel.add(button2);
    panel.add(button3);
    panel.add(button4);
    panel.add(systemExit);
    
    thisFrame=getContentPane();
    thisFrame.add(field,BorderLayout.WEST);
    thisFrame.add(panel,BorderLayout.SOUTH);
    setVisible(true);
    pack();
  }
  
  public void actionPerformed(ActionEvent evt) {}
  
  public static void main(String [] args){
    new RecordGUI();
  }
}
    
    