package queue;
public class EmptyQueueException extends RuntimeException {
  //put in the two constructors
  public EmptyQueueException(){
    super();
  }
  public EmptyQueueException(String message){
    super(message);
  }
}