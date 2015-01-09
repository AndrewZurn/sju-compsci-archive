import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import graph.*;
/**
 * BaconGUI is the user interface to the "Kevin Bacon"
 * data. To use it, you must first run Bacon which produces
 * a LabeledGraph containing the all-pairs shortest path
 * data. This program will read that data in and, then,
 * run a GUI that allows you to choose 2 actors and produces
 * the shortest path between them.
 */
public class BaconGUI extends JFrame {
  /**
   * Here is the HashMap containing the shortest path
   * information for our movie data. It is read in in
   * the constructor and, then, used to construct the
   * menus used to find shortest path.
   */
  private LabeledGraph<String,BaconQuad> shortestPathData;
  public BaconGUI() {
	//read in the output from Bacon into shortestPathData
  }
  public static void main(String[] args) {
    new BaconGUI();
  }
}