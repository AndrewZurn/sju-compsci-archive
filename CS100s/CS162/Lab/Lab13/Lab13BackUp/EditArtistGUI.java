import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class EditArtistGUI extends JFrame implements ActionListener {
  
  private JLabel name, genre, number, goLabel;
  private JTextField nameText, genreText, numberText;
  private JButton go;
  private JPanel centerPanel;
  private Artist artist;
  private ArrayList<Integer> input;
  private TreeMap<String, Artist> artistMap;
  
  public EditArtistGUI (Artist a, TreeMap<String, Artist> artistMap) {
    
    this.artistMap=artistMap;
    artist = a;
    
    centerPanel = new JPanel();
    
    name = new JLabel ("Artist");
    genre = new JLabel ("Genre");
    number = new JLabel ("Song Numbers (Separate With Space)");
    goLabel = new JLabel ("Press Go When Finished");
    
    nameText = new JTextField(a.getArtist());
    genreText = new JTextField(a.getGenre());
    numberText = new JTextField("");
    input = a.getNumbers();
    for (int i = 0; i<input.size(); i++) {
    numberText.setText(numberText.getText() + input.get(i) + " ");
    }
    
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
  
  public Artist getEditedArtist (){
    return (artist);
  }
  
  public TreeMap<String, Artist> getArtistMap(){
    return (artistMap);
  }
  
  
  
  public void actionPerformed (ActionEvent evt) {
    artistMap.remove(artist.getArtist());
    artist.changeArtist (nameText.getText());
    artist.changeGenre (genreText.getText());
    ArrayList<Integer> temp = new ArrayList<Integer>();
    Scanner sc = new Scanner(numberText.getText());
    while(sc.hasNext()){
      temp.add(Integer.parseInt(sc.next()));
    }
    artist.changeNumber(temp);
    artistMap.put(artist.getArtist(), artist);
    setVisible(false);
  }
  
  
//  public static void main(Artist [] args){
//    new EditArtistGUI(args [0]);
//  }
  
  
}