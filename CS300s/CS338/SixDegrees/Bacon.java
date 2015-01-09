import java.util.*;
import graph.*;
/**
 * Bacon will do the following things:
 *   1. It reads in the entire set of movies and actors and, as
 *      it reads in the actors in a movie it adds all edges
 *      between those actors and the other actors in the movie
 *      to the baconGraph along with a BaconQuad of the form
 *      <secondActor,firstActor,movieName,1>
 *   2. It then adds all pairs not already in the graph giving
 *      them the quad <secondActor,firstActor,none,1000>. That
 *      is, with effectively infinity as the distance.
 *   3. It then applies the all-pairs shortest-path algorithm
 *      to get every node
 */
public class Bacon {
  /*
   * baconGraph contains the entire graph of actor,actor
   * connections along with a BaconQuad which starts out
   * containing the edges (or lack of edges indicated
   * by weight1 000) and, as the algorithm progresses,
   * replaces each BaconQuad to indicate the fact that
   * we have found a new, shorter path.
   */
  private LabeledGraph<String,BaconQuad> baconGraph;
 
  /**
   * The constructor simply creates the three big data items
   * above in preparation for Djikstra's algorithm.
   */
  public Bacon() {
    baconGraph=new LabeledGraph<String,BaconQuad>();
  }
  
  /**
   * run() does the entire all-pairs shortest path algorithm
   * on an input file. I have supplied you with two such
   * files - SmallMovie and MovieList. Use SmallMovie to
   * test your program and make sure it works.
   *
   * The SmallMovie file contains the following data:
   * 
   * Animal House
   * John Belushi
   * Tim Matheson
   * Kevin Bacon
   * #
   * The Woodsman
   * Kyra Sedgwick
   * Kevin Bacon
   * Benjamin Bratt
   * #
   * Behind the Red Door
   * Kyra Sedgwick
   * Stackard Channing
   * #
   * 
   * Note how the data is arranged. First comes the name of the
   * movie, then the names of all the actors, then the # sign
   * to indicate the end of the actor list. For each of these
   * movies, you are to do all pairs of actors from that movie
   * and if the pair is not the same actor, add the "edge"
   * <firstActor,secondActor,BaconQuad> 
   * 
   * Your run() should look something like this pseudocode:
   * 
   * 1. Open a Scanner on the file SmallMovie. (Note I have
   *    included the FileChooser class to make this easier.)
   * 2. Repeat the following until you have reached the end of
   *    the file:
   *    a. Create a new ArrayList<String> actorList
   *    b. Read the movie name.
   *    c. read the actors into the ArrayList until you have
   *       reached a #
   *    d. do a double loop on that ArrayList so you hit all
   *       pairs of actors and add those pairs of actors and
   *       the appropriate BaconQuad as edges to the baconGraph.
   * 3. System.out.println(baconGraph)
   * 
   * After you have finished 3, look closely at the output to
   * make sure the adjacency list has every edge in it.
   *
   * Then, write the entire baconGraph out to a file using an
   * ObjectFileWriter.
   *
   * Note that I have supplied you with a class called
   * FileChooser that makes it easy to open files.
   */
  public void run() {
  }
  
  /**
   * As usual, main just starts the algorithm going.
   */
  public static void main(String [] args) {
    new Bacon().run();
  }
}