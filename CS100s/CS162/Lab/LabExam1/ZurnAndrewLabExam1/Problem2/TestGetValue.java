import junit.framework.*;
import zhstructures.*;
/**
 * A Test Class to test the use of the getValue() method of the ZHLinkedBinarySearchTree
 */
public class TestGetValue extends TestCase {
  ZHLinkedBinarySearchTree<Integer> tree;
  public void setUp() {
    tree=new ZHLinkedBinarySearchTree<Integer>();
  }
  /**
   * tests the use of the getValue() method of the ZHLinkedBinarySearchTree
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
    assertTrue("Wrong 3d value ",tree.getValue(3).equals(10));
    assertTrue("Wrong 6th value ",tree.getValue(6).equals(20));
  }
  /**
   * A method to run this class from the command line
   * @param args paramaters to be given to the class
   */
  public static void main(String [] args) {
    new TestCountLeaves().testTree();
  }
}