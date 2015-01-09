package SixDegrees;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

import SixDegrees.graph.BaconQuad;
import SixDegrees.graph.LabeledGraph;
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
	 * @throws Exception 
	 */
	public void run() throws Exception {
		ArrayList<String> allActors = new ArrayList<String>();
		String movie = "", name = "", actor2 = "";
		BaconQuad baconQuad;
		ArrayList<String> actorList = new ArrayList<String>();
		ObjectOutputStream outputStream;
		Scanner scanner = new Scanner(FileChooser.chooseFile());
		
		while(scanner.hasNext()){
			actorList = new ArrayList<String>();
			movie = scanner.nextLine();
			name = scanner.nextLine();
			while (!name.equals("#")){
				actorList.add(name);
				allActors.add(name);
				name = scanner.nextLine();
			}
			for(int i = 0; i<actorList.size()-1; i++){
				for(int j = i+1; j<actorList.size(); j++){
					baconQuad = new BaconQuad(actorList.get(i), actorList.get(j), movie, 1);
					baconGraph.addEdge(baconQuad.getActor(), baconQuad.getLastActor(), baconQuad);
				}
			}
		}
		//System.out.println(baconGraph.toString());
		for(String actor1: baconGraph.getVertices()){
			for(int i=0; i<allActors.size(); i++){
				actor2 = (String) allActors.get(i);
				//System.out.println(actor2);
				if(baconGraph.hasEdge(actor1, actor2) == false ){
					baconQuad = new BaconQuad(actor1, actor2, "", 1000);
					baconGraph.addEdge(baconQuad.getActor(), baconQuad.getLastActor(), baconQuad);	
				} 	
			}
		}
		//System.out.println(baconGraph.toString());
		allPairsShortestPath();
		//System.out.println(baconGraph.toString());
		outputStream = FileChooser.openObjectWriter();
		outputStream.writeObject(baconGraph);
		outputStream.close();
		scanner.close();
	}

	public void allPairsShortestPath(){
		TreeMap<String, TreeMap<String, BaconQuad>> graphMap = baconGraph.getMap();
		ArrayList<String> vertexArray = baconGraph.getVertexArray();
		int ik=0, kj=0, ij=0;
		for(int k = 0; k<graphMap.size(); k++){
			for(int i = 0; i<graphMap.size(); i++){
				for(int j = 0; j<graphMap.size(); j++){
					try{
						ik = graphMap.get(vertexArray.get(i)).get(vertexArray.get(k)).getDistance();
					}
					catch(Exception e){
						ik = 10000;
					}
					try{
						kj = graphMap.get(vertexArray.get(k)).get(vertexArray.get(j)).getDistance();
					}
					catch(Exception e){
						kj = 10000;
					}
					try{
						ij = graphMap.get(vertexArray.get(i)).get(vertexArray.get(j)).getDistance();
					}
					catch(Exception e){
						ij = 10000;
					}
					if( ik + kj < ij){
						try {
							graphMap.get(vertexArray.get(i)).get(vertexArray.get(j)).setDistance(ik + kj);
						} catch (Exception e) {
							//System.out.println("Error when processing ij @ " + i + ", " + j);
						}
					}
				}
			}
		}
		baconGraph.saveNewTree(graphMap);
	}

	/**
	 * As usual, main just starts the algorithm going.
	 * @throws Exception 
	 */
	public static void main(String [] args) throws Exception {
		new Bacon().run();
	}
}