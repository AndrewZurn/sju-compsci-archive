import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 * This program shows how you can access a simple network
 * server program. Basically, a server program is a program
 * running on another machine that allows another (client)
 * program to connect to it and do some form of information
 * exchange. In this case, it is a simple one-way exchange.
 * When we connect to sunfac5.cs.csbsju.edu on port 8189,
 * a string containing the name of an animal is sent to this
 * client. The port then closes and, then, does nothing else.
 * We connect by opening a "socket" to the port, feeding that
 * socket through a BufferedReader, and, then, using readLine
 * to read the string the server sent.
 */
class Client extends JFrame implements ActionListener {
  
  /**
   * Being Java, we of course use some GUI components to
   * do the interface to the program. quitButton is to
   * stop the program. clientButton makes the "socket" 
   * connection and gets the time, clientField is where
   * the returned time is displayed.
   */
  private JButton quitButton,clientButton;
  private JTextField clientField;
  
  public Client() {
    setTitle("Double numbers");
    setSize(1000,150);
    clientField=new JTextField(18);
    clientField.setFont(new java.awt.Font("Dialog",0,30));
    quitButton=new JButton("Quit");
    quitButton.addActionListener(this);
    quitButton.setFont(new java.awt.Font("Dialog",0,30));
    clientButton=new JButton("Get Info");
    clientButton.addActionListener(this);
    clientButton.setFont(new java.awt.Font("Dialog",0,30));
    Container pane=getContentPane();
    pane.add(quitButton,"West");
    pane.add(clientButton,"Center");
    pane.add(clientField,"East"); 
  }
  
  private void Quit()
  {
    System.exit(0);
  }
  
  /**
   * DisplayTime is the method executed when the Time
   * Button is clicked. It creates a socket connected
   * to the appropriate machine and port, wraps a
   * BufferedReader around the port, uses 
   */
  public void actionPerformed(ActionEvent e) {   
    Object source=e.getSource();
    if(source==clientButton) {
      try {
        Socket s=new Socket("linfac5.cs.csbsju.edu",8189);
        BufferedReader socketReader=new BufferedReader(
                new InputStreamReader(s.getInputStream()));
        String clientString=socketReader.readLine();
        clientField.setText(clientString);
        socketReader.close();
      }
      catch(Exception e2) {
        System.out.println("ERROR using socket"+e2);
        System.exit(0);
      }
    }
    else if(source==quitButton) {
      System.exit(0);
    }
  }
  
  public static void main(String[] args)
  {
    Client ClientTest=new Client();
    ClientTest.setVisible(true);
  }
} 
