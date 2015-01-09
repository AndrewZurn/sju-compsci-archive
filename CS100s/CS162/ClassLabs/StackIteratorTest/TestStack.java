import junit.framework.*;
import java.util.*;
import stack.*;
public class TestStack extends TestCase {
  private LinkedStackIterator<Character> testS;
  public void setUp() {
    testS=new LinkedStackIterator<Character>();
  }
  
  /**
   * This method tests the iterator for a stack.
   */
  public void testIterator() {
    for(char c='A';c<'G';c++) {
      testS.push(c);
    }
    for(Character c:testS) {
      System.out.print(c);
    }
    System.out.println();
    Iterator<Character> iter=testS.iterator();
    for(char c='F';c>='A';c--) {
      assertTrue("Iterator doesn't work right.",iter.next().equals(c));
    }
  }
}