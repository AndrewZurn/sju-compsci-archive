import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EditArtistGUI extends JFrame implements ActionListener {
  
  private JLabel name, genre, number, goLabel;
  private JTextField nameText, genreText, numberText;
  private JButton go;
  private JPanel centerPanel;
  
  public EditArtistGUI (Artist a) {
    
    centerPanel = new JPanel();
    
    name = new JLabel ("Artist");
    genre = new JLabel ("Genre");
    number = new JLabel ("Song Numbers (Separate With Space)");
    goLabel = new JLabel ("Press Go When Finished");
    
    nameText = new JTextField(a.getArtist());
    genreText = new JTextField(a.getGenre());
    numberText = new JTextField(a.getNumOfTracks());
    
    go = new JButton ("GO!");
    go.addActionListener(this);
    
    centerPanel.add(name);
    centerPanel.add(nameText);
    centerPanel.add(genre);
    centerPanel.add(genreText);
    centerPanel.add(number);
    centerPanel.add(numberText);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(4,2));
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(550, 100);
    
  }
  
  
  
  public void actionPerformed (ActionEvent evt) {
    setVisible(false);
  }
  
  
  public static void main(Artist [] args){
    new EditArtistGUI(args [0]);
  }
  
  
}