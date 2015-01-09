import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * @author Zurn, Andrew
 * @version May 6, 2011
 */

public class GradeGUI extends JFrame implements ActionListener {
  private Scanner sc;
  private TreeMap<String, ArrayList<String>> treeMap;
  private ArrayList<String> arrayList;
  private JTextField searchField;
  private JButton quit, searchButton;
  private JPanel panel;
  private Container thisFrame;
  private JTextArea field;
  
  public GradeGUI(){
    try{
      sc = FileChooser.openScanner();
    }
    catch(Exception e){
      System.out.println("The File could not be found");
    }
    treeMap = new TreeMap<String, ArrayList<String>>();
    while(sc.hasNext()){
      String name = sc.nextLine();
      String classes = sc.nextLine();
      String classesArray[] = new String[8];
      classesArray = classes.split(",");
      ArrayList<String> arrayList = new ArrayList<String>();
      for(String s: classesArray){
        arrayList.add(s);
      }
      treeMap.put(name, arrayList);
    }
    
    field = new JTextArea(550,280);
    field.setEditable(false);
    field.setLineWrap(true);
    
    panel = new JPanel();
    searchField = new JTextField(30);
    quit = new JButton("quit");
    searchButton = new JButton("search");
    searchField.addActionListener(this);
    quit.addActionListener(this);
    searchButton.addActionListener(this);
    panel.add(searchField);
    panel.add(searchButton);
    panel.add(quit);
    
    thisFrame=getContentPane();
    thisFrame.add(field, BorderLayout.CENTER);
    thisFrame.add(panel, BorderLayout.SOUTH);
    setVisible(true);
    setSize(550,300);
    
    
    
    
    
    
  }
  
  public void actionPerformed(ActionEvent evt){
    Object source=evt.getSource();
    if(source == quit){
      System.exit(0);
    }
    else if(source == searchButton){
      String searchTerm = searchField.getText();
      for(String s: treeMap.keySet()){
        if(searchTerm.equals(s)){
          ArrayList<String> classList = new ArrayList<String>();
          classList = treeMap.get(s);
          field.setText(s + ": " + classList.toString() );
          break;
        }
      }
    }
  }
  
  public static void main(String [] args){
    new GradeGUI();
  }
  
}