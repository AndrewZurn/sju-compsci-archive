import junit.framework.*;
/**
 * A TestClass to test the fucntion of DEQueue.java
 * @author Zurn, Andrew
 * @version March 10, 2011
 */
public class TestDEQueue extends TestCase {
  private ListDEQueue<Double> q1;
  public void setUp() {
    q1=new ListDEQueue<Double>();
  }
  
  /**
   * Tests the regular use and function of a queue
   */
  public void testForwardQueue() {
    q1.enqueue(1.0);
    q1.enqueue(2.0);
    q1.enqueue(3.0);
    q1.enqueue(4.0);
    assertEquals("The first peek should be 1.", q1.peek(), 1.0);
    assertEquals("The first dequeue should be 1.", q1.dequeue(), 1.0);
    assertEquals("The second dequeue should be 2.", q1.dequeue(), 2.0);
    assertEquals("The third dequeue should be 3.", q1.dequeue(), 3.0);
    q1.enqueue(5.0);
    assertEquals("The fourth dequeue should be 4.", q1.dequeue(), 4.0);
    assertEquals("The fifth dequeue should be 5.", q1.dequeue(), 5.0);
  }
  
  /**
   * Test the used of the reverse function of this queue (last(), first(), enqueueBack(), dequeueBack()).
   */
  public void testReverseQueue() {
    q1.enqueue(1.0);
    q1.enqueue(2.0);
    q1.enqueue(3.0);
    q1.enqueue(4.0);
    assertEquals("The first peek should be 1.", q1.peek(), 1.0);
    q1.enqueueBack(0.0);
    assertEquals("The new first last should be 4.", q1.last(), 4.0);
    assertEquals("The first first should be 0.", q1.first(), 0.0);
    assertEquals("The item dequeued from the back of the queue should be 4.", q1.dequeueBack(), 4.0);
  }
  /**
   * Tests Exceptions such as the ones thrown in the event of an empty queue
   */
  public void testEmptyExceptions(){
    try{
      q1.first();
      fail("The queue was able to operate the first() method.");
    }
    catch(Exception e){}
    q1.enqueue(1.0);
    q1.enqueue(2.0);
    try{
      q1.dequeue();
      q1.dequeue();
      q1.dequeue();
      fail("The Class was able to be dequeued more than the amount in the queue(queue is empty)");
    }
    catch(Exception e){}
  }
  
  /**
   * Another test for some of the reverse function like last() and dequeueBack().
   */
  public void testBackStuff(){
    try{
      q1.last();
      fail("The queue was able to operate the last() method.");
    }
    catch(Exception e){}
    q1.enqueue(1.0);
    q1.enqueue(2.0);
    try{
      q1.dequeue();
      q1.dequeue();
      q1.dequeueBack();
      fail("The Class was able to be dequeued more than the amount in the queue(queue is empty)");
    }
    catch(Exception e){}
  }
  
  /**
   * Tests the initial state of the TesDEQueue
   */
  public void testInitialState(){
    assertEquals("The Queue should be empty.", q1.empty(), true);
  }
}
