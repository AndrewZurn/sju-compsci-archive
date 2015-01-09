 import java.util.*;
 /**
  * A DEQueue (Double Ended Queue) is a structure that enables you
  * to enqueue and dequeue from either end. This means that you can,
  * effectively, act like a queue in either direction or, if you like,
  * act like a stack by enqueueing on one end and dequeuing on the
  * same end.
  */
 public interface DEQueue<T> {
   
   /**
    * empty() returns true if there is nothing in the DEQueue.
    */
   public boolean empty();
   
   /**
    * enqueue(value) adds something at the "back" of the queue.
    */
   public void enqueue(T value);
   
   /**
    * enqueueBack(value) adds something to the "front" of the queue.
    */
   public void enqueueBack(T value);
   
   /**
    * dequeue() removes the item at the "front" of the queue and
    * returns that value.
    */
   public T dequeue();
   
   /**
    * dequeueBack() removes theitem at the "back" of the queue and
    * returns that value.
    */
   public T dequeueBack();
   
   /**
    * first() returns the first item in the queue. This is the
    * item added first by enqueue and ends up being the "last"
    * thing in the queue after other stuff is added.
    */
   public T first();
   
   /**
    * last() returns the last item in the queue. This is the item
    * added first by enqueueBack and ends up being the "first"
    * thing in the queue after other stuff is added.
    */
   public T last();
 }