public class ZHExtendedBST<T> extends LinkedBinarySearchTree<T> {
  public int countLeaves() {
    if(empty()) {
      return(0);
    }
    else if(leftChild.empty() && rightChild.empty()) return(1);
    else return(leftChild.countLeaves()+rightChild.countLeaves());
  }
}