import objectdraw.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *  This program converts a line of text to pig latin.
 *  The rules are:
 *  1. if a word has no vowels, it stays the same
 *  2. if a word starts with a vowel, add "way" to the end
 *  3. if a word's first vowel is at position i, move the first i-1 
 characters to the end, and append "ay".
 */
public class PigLatin extends FrameController implements ActionListener {
  
  private JTextField original, translated;
  
  public void begin() {
    original = new JTextField(50);
    translated = new JTextField(50);
    original.addActionListener(this);
    Container content = getContentPane();
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(4, 1));
    p.add(new JLabel("Original:"));
    p.add(original);
    p.add(new JLabel("Pig Latin:"));
    p.add(translated);
    content.add(p, BorderLayout.NORTH);
    validate();
  }
  
  /**
   * return true if c is a vowel
   */
  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
  
  /**
   * return the index of the first vowel in a word, or -1.
   */
  private int indexOfFirstVowel(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * Display the pig latin text in the translated Filed   
   */
  
  public void actionPerformed(ActionEvent event) {
    translated.setText(convertLine(original.getText()));
  }
  
  
  /**
   *  convert a line of text, preserving punctuation
   */
  public String convertLine(String line) {
    // all you need to do is complete this method...and they say 161 isn't easy!!!
    String input = original.getText();
    String ending="";
    String result="";
    String[] words = input.split(("\\s"));
    for (int i = 0; i < words.length; i++) {
      if ( indexOfFirstVowel(words[i]) == 0){
        result = result +words[i] + "way ";
      }
      else if ( indexOfFirstVowel(words[i]) == -1){
        result = result + words[i] + " ";
      }
      else{
        ending = words[i].substring(0, indexOfFirstVowel(words[i]) );
        result = result + words[i].substring(indexOfFirstVowel(words[i]),words[i].length()) + ending + "ay ";
      }
    }
    translated.setText(result);
    return result;
  }
  
}
