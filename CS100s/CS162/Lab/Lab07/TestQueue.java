import junit.framework.*;
import queue.*;
public class TestQueue extends TestCase {
  private LinkedQueue<String> testQ;
  public void setUp() {
    testQ=new LinkedQueue<String>();
  }
  
  public void testInitialState() {
    //test what the originally created queue is like.
    //test the behaviors of peek() and dequeue() on that
    //  initially created queue.
  }
  public void testFirstInFirstOut() {
    //Check to be sure that if you enqueue something, then a
    // bunch of other stuff then the first thing you enqueued
    // is what peek() and dequeue() will return and, after
    // you dequeue the first thing the second thing will be
    // what you enqueued second.
  }
  public void testInOrder() {
    //test that if you enqueue a bunch of stuff, then when
    //  you dequeue stuff it comes out in the same order in
    //  which you enqueued it.
  }
}