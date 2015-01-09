import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import RecordCollection.*;

public class AddPeopleGUI extends JFrame implements ActionListener {
  
  private JPanel centerPanel;
  private JTextField nameField, typeField, songField;
  private JLabel name, type, song, goLabel, addAnother;
  private JButton go, addButton;
  private String peopleName, peopleType, peopleSong;
  private ArrayList<MusicPeople> musicPeopleList;
  
  
  public AddPeopleGUI () {
    
    centerPanel = new JPanel ();
    
    nameField = new JTextField ("");
    typeField = new JTextField ("");
    songField = new JTextField ("");
    
    name = new JLabel ("Name");
    type = new JLabel ("Type");
    song = new JLabel ("Song");
    addAnother = new JLabel ("Add This Person");
    goLabel = new JLabel ("Press Go When Last Person Added");
    
    go = new JButton ("GO!");
    addButton = new JButton("Add");
    go.addActionListener(this);
    addButton.addActionListener(this);
    
    centerPanel.add(name);
    centerPanel.add(nameField);
    centerPanel.add(type);
    centerPanel.add(typeField);
    centerPanel.add(song);
    centerPanel.add(songField);
    centerPanel.add(addAnother);
    centerPanel.add(addButton);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(5,2));
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(550, 120);
    musicPeopleList = new ArrayList<MusicPeople>();
  }
  
  
  public void actionPerformed (ActionEvent evt) {
    Object source=evt.getSource();
    if(source == addButton){
      peopleName = nameField.getText();
      peopleType = typeField.getText();
      peopleSong = songField.getText();
      musicPeopleList.add(new MusicPeople(peopleName, peopleType, peopleSong));
      nameField.setText("");
      typeField.setText("");
      songField.setText("");
    }
    else{
      setVisible(false);
    }
  }
  
  public ArrayList<MusicPeople> returnMusicPeople(){
    return musicPeopleList;
  }
  
  public static void main(String [] args){
    new AddPeopleGUI();
  }
  
  
}