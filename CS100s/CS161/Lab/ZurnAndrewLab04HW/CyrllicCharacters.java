import objectdraw.*;
import java.awt.*;

/**
 * GreekCharacters is a simple program to show how unicode characters can
 * be used to display non-Roman alphabetic characters.
 */
public class CyrllicCharacters extends FrameWindowController {
  /**
   * c is a character variable containing the unicode code for the Greek capital alpha
   */ 
  private char c='\u0400';
  /**
   * greekLetters is a text string to show the Greek letters
   */ 
  Text cyrillicLetters;
  
  /**
   * begin(), as usual, is the initializing program for our class. In this
   * case, it displays a message with instructions to click to see Greek letters
   * as well as a string with the message "Here are the upper-case Greek letters"
   * followed by that Greek upper-case alpha.
   */
  public void begin(){
    new Text("Click to see Cyrillic characters.",100,0,canvas);
    cyrillicLetters=new Text("Here are the Cyrillic characters:"+c,0,40,canvas);
  }
  
  /**
   * In this program, onMouseClick has the effect that every time you click it
   * it prints the next Greek letter until you have displayed all of the upper
   * and lower case Greek letters.
   */
  public void onMouseClick(Location point) {
    if(c<'\uA980') { //We stop displaying after the lower-case Greek letter
      //omega which has unicode code '\u03C9'.
      c++;           //Increment c to get the next letter.
      cyrillicLetters.setText(cyrillicLetters.getText()+"\n"+c);
      /*if(c=='\u03A9') { //Once we have displayed the upper-case Greek letter
       //omega, we start with the lower-case Greek letters.
       c='\u03B1';     //'\u03B1' is the lower-case Greek letter alpha.
       cyrillicLetters=new Text("Here are the lower-case greek characters: "+c,0,80,canvas);
       }
       */         //As there is no lower case to the Cyrillic language, there is no need for this line of code.
    }
  }
}
