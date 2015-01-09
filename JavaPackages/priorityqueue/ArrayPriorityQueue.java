package priorityqueue;
import java.util.*;
public class ArrayPriorityQueue<T extends Comparable>
  implements PriorityQueueInterface<T> {
  private ArrayList<T> orderedItems;
  private int count;
  public ArrayPriorityQueue() {
    //create the ArrayList and initialize count.
    count=0;
    orderedItems=new ArrayList<T>();
  }
  public boolean empty() {
    if(orderItems.get(0) == null){
     return true; 
    }
    else{
    //change the return to what indicates an empty ArrayPriorityQueue
    return false;
    }
  }
  
  
  public void enqueue(T value) {
    //add value to its proper place by priority
    if(orderedItems.get(0) == null){
      orderedItems.add(value);
    }
    else{//!empty
    temp = value;
    for(int i = 0; i<orderedItems.size(); i++){
      if(val
  }
  
  
  public T dequeue() {
    orderedItems.get(0);
    T temp=orderedItems.remove(0);
    count--;
    //dequeue should return the value in the front and remove
    // that value from the queue. The return(null) is wrong.
    return(temp);
  }
  
  
  
  
  public T peek() {
    if(orderItems.get(0) == null){
      throw new EmptyQueueException("The Queue is Empty");
    }
    else{
    //peek should return the value in the front.
    // The return(null) is wrong.
    return(orderedItems.get(0));
    }
  }
}