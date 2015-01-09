import RecordCollection.*;
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EditPeopleGUI extends JFrame implements ActionListener {
  
  private JPanel centerPanel;
  private JTextField nameField, typeField, songField;
  private JLabel name, type, song, goLabel;
  private JButton go;
  private MusicPeople people;
  
  
  public EditPeopleGUI (MusicPeople m) {
    
    people = m;
    
    centerPanel = new JPanel ();
    
    nameField = new JTextField (m.getName());
    typeField = new JTextField (m.getType());
    songField = new JTextField (m.getSongTitle());
    
    name = new JLabel ("Name");
    type = new JLabel ("Type");
    song = new JLabel ("Song");
    goLabel = new JLabel ("Press Go When Finished");
    
    go = new JButton ("GO!");
    go.addActionListener(this);
    
    centerPanel.add(name);
    centerPanel.add(nameField);
    centerPanel.add(type);
    centerPanel.add(typeField);
    centerPanel.add(song);
    centerPanel.add(songField);
    centerPanel.add(goLabel);
    centerPanel.add(go);
    centerPanel.setLayout(new GridLayout(4,2));
    
    Container thisFrame = getContentPane();
    thisFrame.add(centerPanel, BorderLayout.CENTER);
    setVisible(true);
    setSize(400, 100);
  }
  
  
  public void actionPerformed (ActionEvent evt) {
    people.changeName(nameField.getText());
    people.changeType(typeField.getText());
    people.changeSongTitle(songField.getText());
    setVisible(false);
  }
  
  public static void main(MusicPeople [] args){
    new EditPeopleGUI(args [0]);
  }
  
  
  
}