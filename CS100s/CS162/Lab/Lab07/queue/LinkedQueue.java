package queue;
public class LinkedQueue<T> implements SimpleQueue<T> {
  private Node<T> front,back;
  public LinkedQueue() {
    //do the appropriate constructor for a new, empty queue
  }
  public boolean empty() {
    return(front==null);
  }
  public void enqueue(T value) {
    //implement enqueue with the linked nodes.
  }
  public T dequeue() throws EmptyQueueException {
    /* dequeue must remove the front thing and, then,
     * return the value that was in the front node. 
     * If the queue is empty it must throw an exception. */
    return(null);
  }
  public T peek() {
    /* peek must return the value that was in the front node. 
     * If the queue is empty it must throw an exception. */
    return(null);
  }
}