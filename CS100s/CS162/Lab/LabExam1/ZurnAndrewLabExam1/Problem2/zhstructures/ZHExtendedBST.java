package zhstructures;
public class ZHExtendedBST<T extends Comparable<T>> 
  extends ZHLinkedBinarySearchTree<T> {
  public int countLeaves() {
    if(isEmpty()) {
      return(0);
    }
    else if(leftChild.isEmpty() && rightChild.isEmpty()) return(1);
    else return(leftChild.countLeaves()+rightChild.countLeaves());
  }
}