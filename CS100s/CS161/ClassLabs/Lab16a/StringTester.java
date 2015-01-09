import objectdraw.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StringTester extends FrameController implements ActionListener {
  
  private JTextField original;
  private JTextField second;
  private JTextArea translated;
  JComboBox selector;
  
  public void begin() {
    original = new JTextField();
    second= new JTextField();
    translated = new JTextArea(4,50);
    original.addActionListener(this);
    Container content = getContentPane();
    JPanel top = new JPanel();
    top.setLayout(new GridLayout(4, 1));
    top.add(new JLabel("Original:"));
    top.add(original);
    top.add(new JLabel("Second String:"));
    top.add(second);
    JPanel middle = new JPanel();
    middle.setLayout(new GridLayout(2, 1));
    middle.add(new JLabel("Result:"));
    middle.add(translated);
    content.add(top, BorderLayout.NORTH);
    content.add(middle, BorderLayout.CENTER);
    JPanel bottom = new JPanel();
    selector = new JComboBox();
    selector.addItem("IndexOf");   // first location of second string in original 
    selector.addItem("LastIndexOf");// last location of second string in original 
    selector.addItem("Reverse");  // reverse the original string
    selector.addItem("Compare"); // compare the original with the second string
    selector.addItem("Split"); // break the original into words
    selector.addItem("n count"); // number of n's in original string
    selector.addItem("UpperCase First"); // make first letter of each word uppercase
    selector.addItem("Java count"); // number of "Java's" in original string
    selector.addItem("java count"); // number of "Java's" (case independent) in original string 
    selector.addItem("Longest word");  // Output the longest word in original
    selector.addItem("Change to Upper Case");  // Change input to all upper case letters
    bottom.add(selector);
    content.add(bottom, BorderLayout.SOUTH);
    selector.addActionListener( this );
    
    validate();
  }
  public void actionPerformed(ActionEvent event) {
    String input = original.getText();
    String secondInput = second.getText();
    if (selector.getSelectedItem().equals("IndexOf")){
      translated.setText( "The substring starts at: " + input.indexOf(secondInput));
    }
    else if (selector.getSelectedItem().equals("Change to Upper Case")){
      String result = "";
      result=input.toUpperCase();
      translated.setText(result);
    }
    else if(selector.getSelectedItem().equals("LastIndexOf")){
      translated.setText(  "The substring starts at: " + input.lastIndexOf(secondInput));
    }  
    else if(selector.getSelectedItem().equals("Reverse")){
      String reverse = "";
      for (int i = input.length(); i >0 ; i--) {
        reverse = reverse + input.substring(i-1, i);
      }
      translated.setText(reverse);
    }
    else if(selector.getSelectedItem().equals("Compare")){
      translated.setText("the comparison results in: "+ input.compareToIgnoreCase(secondInput));
    }
    else if(selector.getSelectedItem().equals("Split")){
      String result="";
      String[] words = input.split(("\\s"));
      for (int i = 0; i < words.length; i++) {
        result = result + words[i]  + "\n";
      }
      translated.setText(result);
    }
    else if(selector.getSelectedItem().equals("n count")){
      int count = 0;
      for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == 'n') {
          count++;
        }
      }
      translated.setText("the number of ns is: " + count);
    }
    else if(selector.getSelectedItem().equals("UpperCase First")){
      String result = "";
      result = input.substring(0,1).toUpperCase();
      for(int i = 1; i < input.length(); i++){
        if(input.charAt(i) == ' ' || input.charAt(i) == 0){
          result=result + input.substring(i+1,i+2).toUpperCase() + input.substring(i+2, input.length());
        }
        
      translated.setText(result);
      }
    }
    
    
    else if(selector.getSelectedItem().equals("Java count")){
      int count = 0;
      if (input.contains("Java")){
        for(int i = 0; i< input.length()-3; i++){
          if(input.charAt(i) == 'J' && input.charAt(i+1)=='a' && input.charAt(i+2) == 'v' && input.charAt(i+3) == 'a'){
            count++;
          }
        }
        translated.setText("The Number of Javas is: " + count);
      }
    }
    else if(selector.getSelectedItem().equals("java count")){
      int count = 0;
      if (input.contains("java")){
        for(int i = 0; i< input.length()-3; i++){
          if(input.charAt(i) == 'j' && input.charAt(i+1)=='a' && input.charAt(i+2) == 'v' && input.charAt(i+3) == 'a'){
            count++;
          }
        }
        translated.setText("The Number of javas is: " + count);
      }
    }
    else if(selector.getSelectedItem().equals("Longest word")){
      Scanner sc=new Scanner(input);
      ArrayList<String> inputA = new ArrayList<String>();
      while(sc.hasNext()){
        inputA.add(sc.next());
      }
      int wordLength=inputA.get(0).length();
      int location = 0;
      for(int i=0; i<inputA.size();i++){
        if(inputA.get(i).length()>wordLength){
          wordLength=inputA.get(i).length();
          location=i;
        }
      }
      translated.setText("The Longest Word is: " + inputA.get(location));
    }
    
  }
}