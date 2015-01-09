package priorityqueue;
public interface PriorityQueueInterface<T extends Comparable<T>> {
  public boolean empty();
  public void enqueue(T value);
  public T peek();
  public T dequeue();
}