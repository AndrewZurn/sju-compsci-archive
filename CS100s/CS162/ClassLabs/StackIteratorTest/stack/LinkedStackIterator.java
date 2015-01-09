package stack;
import java.util.*;
/**
 * LinkedStack<T> is an implementation of a SimpleStack
 * containing values of type T with linked nodes. As such,
 * it uses a Node<T> "pointer" top which points to the top
 * item in the stack.
 */
public class LinkedStackIterator<T> implements SimpleStack<T>, Iterable<T> {
  //top points to the top item in the queue.
  private Node<T> top;
  
  /**
   * We create a new LinkedStack<T> by simply setting
   * the top pointer to null.
   */
  public LinkedStackIterator() {
    top=null;
  }
  
   /**
   * empty() returns true if the Stack is empty.
   */
  public boolean empty() {
    /* For a linked stack this happens when top is null
     * and, therefore, "points at" nothing. */
    return(top==null);
  }
  
  /**
   * push(value) adds value to the top of the stack.
   * <p><b>Postcondition<b>The stack has a new item at its top.
   * </p><br>
   */
  public void push(T value) {
    top=new Node<T>(top,value);
  }
  
  /**
   * peek() returns the value at the top of the stack.
   * The stack is unchanged.
   * <p><b>Precondition: <b>The queue is not empty.
   * </p><br>
   */
  public T peek() throws EmptyStackException {
    if(empty()) throw new EmptyStackException(
                   "Attempt to peek at an empty stack.");
    return(top.getValue());
  }
  
  /**
   * pop() returns the value at the top of the stack.
   * and removes that value from the stack.
   * <p><b>Precondition: <b>The queue is not empty.</p><br>
   * <p><b>Postcondition: <b>The top item is removed and
   * the item pushed before the top item becomes the top
   * item.
   */
  public T pop() throws EmptyStackException {
    if(empty()) throw new EmptyStackException(
                   "Attempt to pop from an empty stack.");
    T temp=top.getValue();
    top=top.getNext();
    return(temp);
  }
  
  /**
   * To implement iterator() we need to create an Iterator<T>
   * for this stack.
   */
  public Iterator<T> iterator() {
    return(new LinkedStackIteratorIterator());
  }
  
  /**
   * class LinkedStackIterator allows us to iterate through the
   * stack without changing anything.
   */
  public class LinkedStackIteratorIterator implements Iterator<T>{
    private Node<T> link;
    public LinkedStackIteratorIterator() {
      link=top;
    }
    public boolean hasNext() {
      return(link!=null);
    }
    public T next() throws NoSuchElementException {
      if(link==null) throw new NoSuchElementException(
                       "Cannot continue through an empty stack.");
      T temp=link.getValue();
      link=link.getNext();
      return(temp);
    }
    public void remove() throws UnsupportedOperationException {
      throw new UnsupportedOperationException(
          "LinkedStackIteratorIterator<T> does not support remove().");
    }
  }
}