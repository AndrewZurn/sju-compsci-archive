package zhstructures;

import java.util.Iterator;
import java.io.*;

/**
 * A collection in the Ziegler/Holey collection hierarchy that contains
 * no duplicate elements.
 * As implied by its name, this interface models the mathematical set
 * abstraction.
 * Unlike the Java Set interface, this version directly supports set
 * intersection, difference and union methods, and these methods generate
 * a new set without modifying either operand.
 * 
 * @author J. Andrew Holey
 * @version January 27, 2009
 */
public class ZHTreeSet<ElementType extends Comparable<ElementType>> 
  extends ZHLinkedBinarySearchTree<ElementType> implements ZHSet<ElementType> {
  
  /**
   * Returns a new set that is the intersection of this set and
   * otherSet.
   * That is, it returns a set that contains exactly those element
   * contained both in this set and otherSet.
   * It corresponds to the retainAll() method in the Java Set
   * specification, but creates a new set without modifying either
   * of its operands rather than modifying this set.
   * 
   * @param otherSet the set to be intersected with this set
   * @return a new set that is the intersection of this set and
   *         otherSet
   */
  public ZHSet<ElementType> intersection(ZHSet<ElementType> otherSet) {
    ZHTreeSet<ElementType> temp = new ZHTreeSet<ElementType>();
    for(ElementType value: this){
      if(otherSet.contains(value)){
        temp.add(value);
      }
    }
    return(temp);
  }
  
  /**
   * Returns a new set that is the asymmetric difference of this set
   * and otherSet.
   * That is, it returns a set that contains the elements of this set
   * that are not contained in otherSet.
   * It corresponds to the removeAll() method in the Java Set
   * specification, but creates a new set without modifying either of
   * its operands rather than modifying this set.
   * 
   * @param otherSet the set to be subtracted from this set
   * @return a new set that is the asymmetric difference of this set
   *         and otherSet
   */
  public ZHSet<ElementType> difference(ZHSet<ElementType> otherSet) {
    ZHTreeSet<ElementType> temp = new ZHTreeSet<ElementType>();
    for(ElementType value: this){
      if(!otherSet.contains(value)){
        temp.add(value);
      }
    }
    return(temp);
  }
  
  public int size() {
    int temp = super.size();
    return(temp);
  }
  
  /**
   * Returns a new set that is the symmetric difference of this set
   * and otherSet.
   * That is, it returns a set that contains the elements of this set
   * that are not contained in otherSet and the elements of otherSet
   * that are not in this set.
   * 
   * @param otherSet the set to be subtracted from this set
   * @return a new set that is the asymmetric difference of this set
   *         and otherSet
   */
  public ZHSet<ElementType> symmetricDifference(ZHSet<ElementType> otherSet) {
    ZHTreeSet<ElementType> temp = new ZHTreeSet<ElementType>();
    ZHTreeSet<ElementType> temp1 = new ZHTreeSet<ElementType>();
    for(ElementType value: this){
      if(!otherSet.contains(value)){
        temp1.add(value);
      }
    }
    for(ElementType value: otherSet){
      if(!temp1.contains(value)){
        temp.add(value);
      }
    }
    return(temp);
  }
  
  /**
   * Returns a new set that is the union of this set and otherSet.
   * That is, it returns a set that contains all elements contained
   * in this set, otherSet or both.
   * It corresponds to the addAll() method in the Java Set
   * specification, but creates a new set without modifying either of
   * its operands rather modifying this set.
   * 
   * @param otherSet the set to form the union with this set
   * @return a new set that is the union of this set and otherSet
   */
  public ZHSet<ElementType> union(ZHSet<ElementType> otherSet) {
    ZHTreeSet<ElementType> temp = new ZHTreeSet<ElementType>();
    for(ElementType value: this){
      temp.add(value);
    }
    for(ElementType value: otherSet){
      temp.add(value);
    }
    return(temp);
  }
  
  /**
   * Returns true if the specified potential subset is a subset of
   * this set.
   * It is equivalent to the containsAll() method in the Java Set
   * specification.
   * 
   * @param potentialSubset the set to check whether it is a subset
   *        of this set or not
   * @return true if the specified potential subset is a subset of
   *         this set
   */
  public boolean subset(ZHSet<ElementType> potentialSubset) {
    for(ElementType value: potentialSubset){
      if(!this.contains(value)){
        return false;
      }
    }
    return(true);
  }
  
  public void dumpIt() {
    for(ElementType value:this) {
      System.out.print("|"+value);
    }
    System.out.println();
  }
}
