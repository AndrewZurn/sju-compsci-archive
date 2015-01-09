import junit.framework.*;
import zhstructures.*;
/**
 * A Test Class to test the function of the countLeaves method of the ZHLinkedBinarySearchTree
 * @version March 10, 2011
 */
public class TestCountLeaves extends TestCase {
  ZHLinkedBinarySearchTree<Integer> tree;
  public void setUp() {
    tree=new ZHLinkedBinarySearchTree<Integer>();
  }
  /**
   * Will test the function of the countLeaves method of the ZHLinkedBinarySearchTree
   */
  public void testTree() {
    assertTrue("Tree is not empty at start.",tree.isEmpty());
    tree.add(20);
    tree.add(10);
    tree.add(30);
    tree.add(5);
    tree.add(15);
    tree.add(25);
    tree.add(35);
    tree.add(40);
    tree.add(2);
    tree.add(17);
    tree.add(40);
    assertEquals("Number of leaves wasn't 4 ",tree.countLeaves(),4);
  }
  /**
   * A method to run this class from the command line
   * @param args paramaters to be given to the class
   */
  public static void main(String [] args) {
    new TestCountLeaves().testTree();
  }
}