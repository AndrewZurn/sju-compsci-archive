import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import zhstructures.*;

/**
 * @author Zurn, Andrew
 * @version May 6, 2011
 */

public class AgeGUI extends JFrame implements ActionListener {
  private Scanner sc;
  private JTextField searchField0, searchField1, searchField2;
  private JButton read, find, range;
  private JPanel panel;
  private Container thisFrame;
  private JTextArea field;
  private ZHLinkedBinarySearchTree<Double> ageList;
  
  public AgeGUI(){
    
    ageList = new ZHLinkedBinarySearchTree<Double>();
    
    field = new JTextArea(550,280);
    field.setEditable(false);
    field.setLineWrap(true);
    
    panel = new JPanel();
    panel.setLayout(new GridLayout(2,3));
    searchField0 = new JTextField(30);
    searchField1 = new JTextField(30);
    searchField2 = new JTextField(30);
    searchField0.addActionListener(this);
    searchField1.addActionListener(this);
    searchField2.addActionListener(this);
    read = new JButton("Read");
    find = new JButton("Find");
    range = new JButton("Range");
    read.addActionListener(this);
    find.addActionListener(this);
    range.addActionListener(this);
    panel.add(read);
    panel.add(find);
    panel.add(searchField0);
    panel.add(range);
    panel.add(searchField1);
    panel.add(searchField2);
    
    
    thisFrame=getContentPane();
    thisFrame.add(field, BorderLayout.CENTER);
    thisFrame.add(panel, BorderLayout.NORTH);
    setVisible(true);
    setSize(550,300);
    
    
  }
  
  public void actionPerformed(ActionEvent evt){
    Object source=evt.getSource();
    if(source == read){
      try{
        sc = FileChooser.openScanner();
      }
      catch(Exception e){
        System.out.println("The File could not be found");
      }
      while(sc.hasNext()){
        ageList.add(Double.parseDouble(sc.nextLine()));
      }
    }
    else if(source == find){
      Double searchAge = Double.parseDouble(searchField0.getText());
      for(Double d: ageList){
        if(searchAge.equals(d)){
          field.setText("true");
          break;
        }
        else{
          field.setText("There is no employee with this age within the records of this company.");
        }
      }   
    }
    else if(source == range){
      Double search1 = Double.parseDouble(searchField1.getText());
      Double search2 = Double.parseDouble(searchField2.getText());
      for(Double d: ageList){
        if((d > search1 && d < search2)){
          field.append(d.toString() +"\n");
        }
      }
    }
  }
  
  public static void main(String [] args){
    new AgeGUI();
  }
  
}