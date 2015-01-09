import priorityqueue.*;

import junit.framework.*;

public class TestPriorityQueue extends TestCase{
  private MHPriorityQueue<String> testQ;
  
  public void setUp(){
   testQ=new MHPriorityQueue<String>();
  }
  
  public void testHightsInFirst(){
   testQ.enqueue("a");
   testQ.enqueue("b");
   testQ.enqueue("c");
   testQ.enqueue("d");
   testQ.enqueue("h");
   testQ.enqueue("f");
   //System.out.println(testQ.dequeue()+testQ.dequeue()+testQ.dequeue()+testQ.dequeue()+testQ.dequeue()+testQ.dequeue());
   assertEquals("The first dequeue should be h", testQ.dequeue(), "h");
   assertEquals("The 2nd dequeue should be f", testQ.dequeue(), "f");
   assertEquals("The 3rd dequeue should be d", testQ.dequeue(), "d");
   assertEquals("The 4th dequeue should be c", testQ.dequeue(), "c");
   assertEquals("The 5th dequeue should be b", testQ.dequeue(), "b");
   assertEquals("The 6th dequeue should be a", testQ.dequeue(), "a");
   
  }
}
