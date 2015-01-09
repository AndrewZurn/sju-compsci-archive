import javax.swing.*;
public class TestJOptionMessage extends JFrame {
  public TestJOptionMessage() {
    JOptionPane.showMessageDialog(this, "This is a\n message","Message", JOptionPane.INFORMATION_MESSAGE);
  }
  public static void main(String [] args) {
    new TestJOptionMessage();
  }
}