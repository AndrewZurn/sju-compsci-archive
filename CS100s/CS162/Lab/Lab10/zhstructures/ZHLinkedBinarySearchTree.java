/*
 * ZHLinkedBinarySearchTree.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing the ZHBinarySearchTree interface as a ZHBinaryTreeStructure.
 * 
 * @author J. Andrew Holey and <your name here>
 * @version October 27, 2008
 */
public class ZHLinkedBinarySearchTree<ElementType extends Comparable<ElementType>>
  extends ZHBinaryTreeStructure<ElementType, ZHLinkedBinarySearchTree<ElementType>>
  implements ZHBinarySearchTree<ElementType> {
  
  /**
   * Creates a new isEmpty tree.
   */
  public ZHLinkedBinarySearchTree() {
    super();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#contains(java.lang.Comparable)
   */
  @Override
  public boolean contains(ElementType element) {
    if (isEmpty()) {
      return false; 
    }
    else { //(!isEmpty())
      int comparator = this.element.compareTo(element);
      if (comparator == 0) {
        return true;
      }
      else if (comparator < 0) {
        return rightChild.contains(element);
      }
      else { //(comparator < 0)
        return leftChild.contains(element);
      }
    }
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#iterator()
   */
  @Override
  public Iterator<ElementType> iterator() {
    return this.inorderIterator();
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#add(java.lang.Comparable)
   */
  @Override
  public boolean add(ElementType element) {
    if (isEmpty()){
      this.element = element;
      this.leftChild = new ZHLinkedBinarySearchTree<ElementType>();
      this.rightChild = new ZHLinkedBinarySearchTree<ElementType>();
      this.state = ZHComponentState.NOT_EMPTY;
      return true;
    }
    else {
      int comparator = this.element.compareTo(element);
      if (comparator == 0) {
        return false;
      }
      else if (comparator < 0) {
        return rightChild.add(element);
      }
      else { //(comparator > 0)
        return leftChild.add(element);
      }
    }
  }
  
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#remove(java.lang.Comparable)
   */
  @Override
  public boolean remove(ElementType element) throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException ("Nothing to remove"); 
    }
    else { // (!isEmpty()) 
      int comparator = this.element.compareTo(element);
      if (comparator == 0) {
        if (this.leftChild.isEmpty()){
          this.copyNodeToThis(this.rightChild);
          return true;
        }
        else if (this.rightChild.isEmpty()) {
          this.copyNodeToThis(this.leftChild);
          return true;
        }
        else { // (!this.rightChild.isEmpty() && !this.leftChild.isEmpty()) 
          this.element = this.rightChild.removeAndReturnLeftmost();
          return true;
        }
      }
      else if (comparator < 0) {
        return rightChild.remove(element);
      }
      else { // (comparator < 0) 
        return leftChild.remove(element);
      }
    }
  }
  
  /**
   * Removes and returns the leftmost element in this structure.
   * 
   * @return the former leftmost element in this structure
   * @throws NoSuchElementException if this structure is isEmpty
   */
  protected ElementType removeAndReturnLeftmost() {
    ElementType temp = this.rightChild.leftMost();
    this.element = temp;
    this.rightChild.remove(temp);
    return temp;
  }
  
  protected void copyNodeToThis(ZHLinkedBinarySearchTree<ElementType> otherNode) {
    this.element    = otherNode.element;
    this.leftChild  = otherNode.leftChild;
    this.rightChild = otherNode.rightChild;
    this.state      = otherNode.state;
  }
  
  protected ElementType leftMost () {
    if(isEmpty()) {
      return this.element;
    }
    else { // (!isEmpty()) 
      return this.leftChild.leftMost();
    }
  }
  
  protected ElementType rightMost () {
    if(isEmpty()) {
      return this.element;
    }
    else { // (!isEmpty()) 
      return this.rightChild.rightMost();
    }
  }
  
}
