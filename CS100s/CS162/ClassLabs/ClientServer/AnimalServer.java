import java.io.*;
import java.net.*;
import java.util.*;

/**
 * AnimalServer is a server that sends a random animal name to any program
 * that connects to it through its default socket.
 */

public class AnimalServer {
  public int DEFAULT_SOCKET=8189;
  public static void main(String[] Args) {
    new AnimalServer();
  }
  public AnimalServer() {
    try
    {
      ServerSocket s=new ServerSocket(DEFAULT_SOCKET);
      /*
       * This while loop waits for a client to contact this computer
       * via the DEFAULT_SOCKET and when it does, it launches a thread
       * to talk to that client.
       */
      while(true)
      {
        Socket incoming=s.accept();
        new ThreadedAnimalHandler(incoming).start();
      }
    }
    catch(Exception e2)
    {
      System.out.println("ERROR in socket 8189 opening caused exception "+e2);
    }
  }
  
  
  /**
   * Each client gets it's own thread for communication so that there can be many
   * clients operating at the same time.
   */
  class ThreadedAnimalHandler extends Thread
  {
    String [] Animals={"An Artful Aardvaark", "A Buoyant Bunny", "A Curious Cat",
      "A Dogmatic Dog", "An Elegant Elephant", "A Foxy Fox", 
      "A Gingerly Giraffe", "A Happy Hare", "An Ignorant Iguana",
      "A Jacked-up Jackrabbit", "A Kind Kangaroo", "A Lying Lion",
      "A Mere Meercat", "A New Newt", "An Octogenerain Octupus",
      "A Pert Pelican", "A Quiet Quail", "A Rapid Rat",
      "A Sneaky Snake", "A Telegenic Toad", "A Unique Unicorn",
      "A Vulnerable Vulture", "A Wonderful Wombat", 
      "A Xenophobic Xenops", "A Yakkity Yak", "A Zestful Zebra"};
    private Socket incoming;
    private Random Rand=new Random();
    
    public ThreadedAnimalHandler(Socket i)
    {
      incoming=i;
    }
    
    public void run()
    {
      try
      {
        PrintWriter out=new PrintWriter(incoming.getOutputStream(),true);
        out.println(Animals[Rand.nextInt(26)]);
        incoming.close();
      }
      catch(Exception e)
      {
        System.out.println("ERROR in Animal Server thread raised exception "+e);
      }
    }
  }
}
