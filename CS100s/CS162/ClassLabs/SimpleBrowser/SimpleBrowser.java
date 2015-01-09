import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is an example of an extremely simple web browser built in
 * Java. Note that I start it with my home page and it can then follow
 * links (but not return to previous links).
 *
 * @author Lynn R. Ziegler
 */
class SimpleBrowser extends JFrame implements HyperlinkListener {
  /* A JEditorPane is one of the Java classes that can use
   * "hyperlinks" which are the links connecting to the world
   * wide web. */
  JEditorPane  editor;
  //We put the editor into a JScrollPane
  JScrollPane  scroll_pane;
  
  /**
   * The constructor for our browser expects to receive an initial
   * string representing a URL along with a width and a height. It
   * then creates the JFrame with the proper height and adds the
   * scrolling frame containing the editor used to display browsed
   * stuff. It needs to convert the string into an internal
   * URL before it can use it. (A URL is a Universal Resource
   * Locator.)
   */
  public SimpleBrowser(String URL, int width, int height) 
  {
    setSize(width, height);
    
    editor = new JEditorPane();
    editor.setEditable(false);
    editor.addHyperlinkListener(this);
    
    try {
      java.net.URL helpURL = new java.net.URL(URL);
      editor.setPage(helpURL);
    } catch (Exception badURL) {
      System.err.println("Couldn't read help URL: " + URL + ". ["
                           + badURL.toString() + "]");
    }

    scroll_pane = new JScrollPane(editor);
    scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll_pane.setMinimumSize(new Dimension(200, 200));
    getContentPane().add(scroll_pane);
    setVisible(true);
    setTitle("Simple Browser");
  }
  
  /**
   * hyperlinkUpdate(HyperlinkEvent e) is the method for web browsing corresponding
   * to actionPerformed for ActionEvent events. That is, it reacts to web things
   * like clicking on a link.
   */
  public void hyperlinkUpdate(HyperlinkEvent e) {
    if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
      try {
        editor.setPage(e.getURL());
      }
      catch(Exception e2) {
        e2.printStackTrace();
      }
    }
  }
  
  /**
   * My main simply starts the browser at my home page with size 800x800.
   */
  public static void main(String [] args) {
    new SimpleBrowser("http://www.users.csbsju.edu/~lziegler/",800,600);
  }
}

