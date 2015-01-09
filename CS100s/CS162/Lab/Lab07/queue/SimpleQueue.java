package queue;
public interface SimpleQueue<T> {
  public boolean empty();
  public void enqueue(T value);
  public T peek();
  public T dequeue();
}