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
  
  private int count = 0;
  
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
  }//ompPair<KeyType,ValueType>(key)
  
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
  
  public int size(){
    Iterator it = this.iterator();
    while(it.hasNext()){
      count++;
      it.next();
    }
    return (count);
  }
  
  /**
   * get(element) returns the version of this element that is actually
   * in the tree. It is almost identical to contains except that it 
   * returns null if the element is not in the tree and the actual 
   * element currently in the tree if the element matches one in the 
   * tree. This is useful for a tree map structure since the comparison
   * is done by a subpart of element and the other parts may differ.
   */
  public ElementType get(ElementType element) {
    switch(this.state) {
      case EMPTY: return(null);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0){ 
          return(this.element);
        }
        else if(comparator<0) {
          return(rightChild.get(element));
        }
        else {
          return(leftChild.get(element));
        }
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * put(element) is almost identical to add except that if a put 
   * is done and the element is already in the tree it is replaced. 
   * Instead of returning true or false, it returns the actual 
   * element that was added or the replaced value if a replacement
   * occurs.
   */
  public ElementType put(ElementType element) {
    switch(this.state) {
      case EMPTY: { 
        this.element = element;
        this.leftChild = new ZHLinkedBinarySearchTree<ElementType>();
        this.rightChild = new ZHLinkedBinarySearchTree<ElementType>();
        this.state = ZHComponentState.NOT_EMPTY;
        return null;
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) {
          /* Be sure to save the element currently in this tree
           * and, then, replace it with element. Finally, return
           * that element you have saved. */
          ElementType temp = this.element;
          this.element = element;
          this.leftChild = new ZHLinkedBinarySearchTree<ElementType>();
          this.rightChild = new ZHLinkedBinarySearchTree<ElementType>();
          return(temp);
        }
        /* The only changes from add in the other two cases are
         * that add is replaced with put. */
        else if(comparator<0){ 
          return(rightChild.put(element));
        }
        else{
          return(leftChild.put(element));
        }
      }
      default: throw new IllegalStateException();
    }
  }
  
}
