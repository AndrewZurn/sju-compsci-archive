package zhstructures;
public class ZHNode<T> {
  private ZHNode<T> next;
  private T value;
  public ZHNode(ZHNode<T> next,T value) {
    this.next=next;
    this.value=value;
  }
  public ZHNode<T> getNext() {
    return(next);
  }
  public void setNext(ZHNode<T> next) {
    this.next=next;
  }
  public T getValue() {
    return(value);
  }
}
