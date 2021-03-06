import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ClientGUI extends JFrame implements ActionListener {
  
  private JPanel northPanel, southPanel, one, two, three, four;
  private JButton create, change, getOne, getAll, delete, send, clear;
  private JTextField user, recipient, number;
  private JPasswordField password, newPass;
  private JTextArea text;
  private JScrollPane scrolly;
  private JMenuBar myMenuBar;
  private JMenu fileMenu;
  private JMenuItem quitItem, clearItem;
  
  
  public ClientGUI () {
    
    northPanel = new JPanel();
    southPanel = new JPanel();
    one = new JPanel();
    two = new JPanel();
    three = new JPanel();
    four = new JPanel();
    
    text = new JTextArea(100,100);
    text.setLineWrap(true);
    scrolly = new JScrollPane(text);
    
    myMenuBar = new JMenuBar();
    setJMenuBar(myMenuBar);
    fileMenu = new JMenu("File");
    quitItem = new JMenuItem("Quit");
    quitItem.addActionListener(this);
    clearItem = new JMenuItem("Clear");
    clearItem.addActionListener(this);
    fileMenu.add(clearItem);
    fileMenu.add(quitItem);
    myMenuBar.add(fileMenu);
    
    create = new JButton("Create Account");
    create.addActionListener(this);
    user = new JTextField(20);
    password = new JPasswordField(20);
    JLabel userLabel = new JLabel("User");
    JLabel passLabel = new JLabel ("Password");
    one.add(userLabel);
    one.add(user);
    one.add(passLabel);
    one.add(password);
    one.add(create);
    
    change = new JButton("Change Password");
    change.addActionListener(this);
    newPass = new JPasswordField(20);
    JLabel newPassLabel = new JLabel("New Password");
    two.add(newPassLabel);
    two.add(newPass);
    two.add(change);
    
    getOne = new JButton("Get Message");
    getOne.addActionListener(this);
    getAll = new JButton("Get List Of Messages");
    getAll.addActionListener(this);
    delete = new JButton("Delete Message");
    delete.addActionListener(this);
    number = new JTextField(5);
    JLabel numberLabel = new JLabel("Message Number");
    three.add(getOne);
    three.add(numberLabel);
    three.add(number);
    three.add(delete);
    three.add(getAll);
    
    send = new JButton("Send a Message");
    send.addActionListener(this);
    clear = new JButton("Clear");
    clear.addActionListener(this);
    recipient = new JTextField(20);
    JLabel toLabel = new JLabel("To:");
    four.add(toLabel);
    four.add(recipient);
    four.add(send);
    four.add(clear);
    
    northPanel.add(one);
    northPanel.add(two);
    northPanel.setLayout(new GridLayout(2,1));
    
    southPanel.add(three);
    southPanel.add(four);
    southPanel.setLayout(new GridLayout(2,1));
    
    
    
    
    Container thisFrame = getContentPane();
    thisFrame.add(northPanel, BorderLayout.NORTH);
    thisFrame.add(southPanel, BorderLayout.SOUTH);
    thisFrame.add(scrolly, BorderLayout.CENTER);
    setVisible(true);
    setSize(400, 100);
    pack();
  }
  
  public void clear(){
   text.setText(""); 
  }
  
  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    
    if(source == create){
      String pwd = new String(password.getPassword());
      String created = new String("c" + user.getText() + "#" + pwd);
      clear();
      text.setText(created);
    }
    else if (source == change){
      String pwd = new String(password.getPassword());
      String pwd2 = new String(newPass.getPassword());
      String changed = new String("p" + user.getText() + "#" + pwd + "#" + pwd2);
      clear();
      text.setText(changed);
    }
    else if (source == getAll){
      String pwd = new String(password.getPassword());
      String all = new String("l" + user.getText() + "#" + pwd);
      clear();
      text.setText(all);
    }
    else if (source == getOne){
      String pwd = new String(password.getPassword());
      String single = new String("g" + user.getText() + "#" + pwd + "#" + number.getText());
      clear();
      text.setText(single);
    }
    else if (source == delete){
      String pwd = new String(password.getPassword());
      String deleted = new String("d" + user.getText() + "#" + pwd + "#" + number.getText());
      clear();
      text.setText(deleted);
    }
    else if (source == send){
      String pwd = new String(password.getPassword());
      String sent = new String("s" + user.getText() + "#" + pwd + "#" + recipient.getText() + "#@" + text.getText() + "@");
      clear();
      text.setText(sent);
    }
    else if (source == quitItem){
      System.exit(0);
    }
    else if (source == clearItem){
      clear();
    }
    else if (source == clear){
      clear();
    }
    
    
  }
  
  
  
  public static void main(String [] args){
    new ClientGUI();
  }
  
  
  
}