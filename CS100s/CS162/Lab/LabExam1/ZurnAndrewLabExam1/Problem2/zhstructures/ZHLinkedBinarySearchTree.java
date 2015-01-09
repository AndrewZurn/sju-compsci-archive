/*
 * ZHLinkedBinarySearchTree.java
 */
package zhstructures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

/**
 * Class implementing the ZHBinarySearchTree interface as a ZHBinaryTreeStructure.
 * 
 * @author J. Andrew Holey and Lynn Ziegler
 * @version October 27, 2008 revised March 11, 2011
 */
public class ZHLinkedBinarySearchTree<ElementType extends Comparable<ElementType>>
  extends ZHBinaryTreeStructure<ElementType, ZHLinkedBinarySearchTree<ElementType>>
  implements ZHBinarySearchTree<ElementType> {
  
  
  /**
   * countLeaves() returns the number of leaf "nodes" in this tree.
   * @return returns the number of leafs in the tree
   */
  public int countLeaves() {
    if(super.isEmpty()){
      return 0;
    }
    else if(leftChild.isEmpty() && rightChild.isEmpty()){
      return 1;
    }
    else{
      return (leftChild.countLeaves() + rightChild.countLeaves());
    }
    /* if the tree is empty, there are 0 leaf nodes. If the tree has 
     * both leftChild and right child empty it is a leaf node and so
     * the count should be 1. Otherwise add the number of leaf nodes 
     * in the child trees. */
    //replace the following with your code.
  }
  
  /**
   * getValue(int k) returns the k-th smallest element in the 
   * tree.
   * @param k the place of the wanted item
   * @return the value of the place wanted
   */
   public ElementType getValue(int k) {
     ArrayList<ElementType> aList = new ArrayList<ElementType>();
     ElementType kthValue;
    //for the lab exam, don't worry about k being too big or too small
    //replace the code below with your code.
     for(ElementType value: this){
       aList.add(value);
     }
     kthValue = aList.get(k-1);
    return(kthValue);
  }
  
  /**
   * Creates a new empty tree.
   */
  public ZHLinkedBinarySearchTree() {
    super();
  }
  
  public int size() {
    return(0);
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#contains(java.lang.Comparable)
   */
  @Override
  public boolean contains(ElementType element) {
    switch(this.state) {
      case EMPTY: return(false);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) return(true);
        else if(comparator<0) return(rightChild.contains(element));
        else return(leftChild.contains(element));
      }
      default: throw new IllegalStateException();
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
    switch(this.state) {
      case EMPTY: { 
        this.state=ZHComponentState.NOT_EMPTY;
        this.element=element;
        this.leftChild=new ZHLinkedBinarySearchTree<ElementType>();
        this.rightChild=new ZHLinkedBinarySearchTree<ElementType>();
        return(true);
      }
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) return(false);
        else if(comparator<0) return(rightChild.add(element));
        else return(leftChild.add(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  /* (non-Javadoc)
   * @see zhstructures.ZHBinarySearchTree#remove(java.lang.Comparable)
   */
  @Override
  public boolean remove(ElementType element) {
    switch(this.state) {
      case EMPTY: return(false);
      case NOT_EMPTY: {
        int comparator=this.element.compareTo(element);
        if(comparator==0) {
          if(leftChild.isEmpty()) {
            copyNodeToThis(rightChild);
          }
          else if(rightChild.isEmpty()) {
            copyNodeToThis(leftChild);
          }
          else { //both subtrees
            this.element=rightChild.removeAndReturnLeftmost();
          }
          return(true);
        }
        else if(comparator<0) 
          return(rightChild.remove(element));
        else //comparator>0
          return(leftChild.remove(element));
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * Removes and returns the leftmost element in this structure.
   * 
   * @return the former leftmost element in this structure
   * @throws NoSuchElementException if this structure is empty
   */
  protected ElementType removeAndReturnLeftmost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(leftChild.isEmpty()) {
          this.state=ZHComponentState.EMPTY;
          ElementType temp=this.element;
          copyNodeToThis(rightChild);
          return(temp);
        }
        else return(leftChild.removeAndReturnLeftmost());
      }
      default: throw new IllegalStateException();
    }
  }
  
  /**
   * leftMost() returns the smallest item in this tree.
   */
  public ElementType leftMost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(leftChild.isEmpty()) {
          return(this.element);
        }
        else return (leftChild.leftMost());
      }
      default: throw new IllegalStateException();
    }
  }

  /**
   * rightMost() returns the largest item in this tree.
   */
  public ElementType rightMost() {
    switch(this.state) {
      case EMPTY: { //this should never occur
        throw new NoSuchElementException();
      }
      case NOT_EMPTY: {
        if(rightChild.isEmpty()) {
          return(this.element);
        }
        else return (rightChild.rightMost());
      }
      default: throw new IllegalStateException();
    }
  }
  protected void copyNodeToThis(ZHLinkedBinarySearchTree<ElementType> otherNode) {
    this.element    = otherNode.element;
    this.leftChild  = otherNode.leftChild;
    this.rightChild = otherNode.rightChild;
    this.state      = otherNode.state;
  }
  
}
