import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import RecordCollection.*;

public class AddArtistGUI extends JFrame implements ActionListener {
  
  private JLabel name, genre, number, goLabel, add;
  private JTextField nameText, genreText, numberText;
  private JButton go, addAnother;
  private JPanel centerPanel;
  private String artistName, artistGenre, tempArtTracks;
  private ArrayList<Integer> tracksList;
  private Artist artist;
  
  public AddArtistGUI () {
    
    centerPanel = new JPanel();
   
    name = new JLabel ("Artist");
    genre = new JLabel ("Genre");
    number = new JLabel ("Song Numbers(Seperate With a Space)");
    goLabel = new JLabel ("Press Go When Last Artist Entered");
    add = new JLabel ("Add This Artist");
    
    nameText = new JTextField("");
    genreText = new JTextField("");
    numberText = new JTextField("");
    
    go = new JButton ("GO!");
    go.addActionListener(this);
    addAnother = new JButton ("Add");
    addAnother.addActionListener(this);
    
    centerPanel.add(name);
    centerPanel.add(nameText);
    centerPanel.add(genre);
    centerPanel.add(genreText);
    centerPanel.add(number);
    centerPanel.add(numberText);
    centerPanel.add(add);
    centerPanel.add(addAnother);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(5,2));
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(570, 125);
    
  }
  
  public String getArtistName(){
    return artistName;
  }

  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    if(source == addAnother){
      artistName = nameText.getText();
      artistGenre = genreText.getText();
      tempArtTracks = numberText.getText();
      tracksList = new ArrayList<Integer>();
      Scanner sc = new Scanner(tempArtTracks);
      while(sc.hasNext()){
        tracksList.add(Integer.parseInt(sc.next()));
      }
      nameText.setText("");
      genreText.setText("");
      numberText.setText("");
    }
    else {
      artist = new Artist(artistName, artistGenre, tracksList);
      setVisible(false);
    }
  }
  
  public Artist returnArtist(){
    return artist;
  }
  
  public static void main(String [] args){
    new AddArtistGUI();
  }
  
}