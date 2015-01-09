package SixDegrees;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SixDegrees.graph.BaconQuad;
import SixDegrees.graph.LabeledGraph;
/**
 * BaconGUI is the user interface to the "Kevin Bacon"
 * data. To use it, you must first run Bacon which produces
 * a LabeledGraph containing the all-pairs shortest path
 * data. This program will read that data in and, then,
 * run a GUI that allows you to choose 2 actors and produces
 * the shortest path between them.
 */
public class BaconGUI extends JFrame implements ActionListener, MouseListener, KeyListener{
	/**
	 * Here is the HashMap containing the shortest path
	 * information for our movie data. It is read in in
	 * the constructor and, then, used to construct the
	 * menus used to find shortest path.
	 */
	private LabeledGraph<String,BaconQuad> baconGraph, shortestBaconPath;
	private JPanel southPanel, centerPanel;
	private JScrollPane scrollPane;
	private JButton enterButton, exitButton;
	private JTextField textField;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit, about, help;

	public BaconGUI() throws FileNotFoundException, IOException, ClassNotFoundException {
		//read in the output from Bacon into shortestPathData
		ObjectInputStream inputStream = FileChooser.openObjectReader();
		baconGraph = (LabeledGraph<String, BaconQuad>) inputStream.readObject();
		//System.out.println(baconGraph.toString());
		JFrame frame = new JFrame("Baconator");

		centerPanel = new JPanel();
		textArea = new JTextArea(20, 65);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setText("Welcome to Baconater, the GUI representation of the Six Degrees of Kevin Bacon Game!\n\n\n" +
				"This program allows you to enter and Actor's or Actress's name into the text field at the bottom of the" +
				"window, where upon it then will calculate how far away the actress is within a web of actors and actresses who have" +
				"worked with Kevin Bacon\n during there careers.\n\n\nActors/Actress' that have worked directly with Kevin Bacon" +
				"in a movie will have a connection length of 1.  Actors/Actress' that have worked with someone else whom has" +
				"worked with Kevin Bacon in a movie will have a connection length of 2, and so on and so on.\n\n\nENJOY!" +
				"\n\n\n\n\n Project worked on by Andrew Zurn for CSCI 338 during the Spring 2013 Semester, under Lynn Ziegler.\n");
		scrollPane = new JScrollPane(textArea);
		centerPanel.add(scrollPane);

		southPanel = new JPanel();
		enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		textField = new JTextField("Please Enter an Actor/Actress' Name", 50);
		textField.addMouseListener(this);
		textField.addKeyListener(this);
		southPanel.add(textField);
		southPanel.add(enterButton);
		southPanel.add(exitButton);

		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		about = new JMenuItem("About");
		about.addActionListener(this);
		menu.add(about);
		help = new JMenuItem("Help");
		help.addActionListener(this);
		menu.add(help);
		quit = new JMenuItem("Quit");
		quit.addActionListener(this);
		menu.add(quit);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(centerPanel, BorderLayout.NORTH);
		frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void mouseReleased(MouseEvent e){  }
	public void mouseEntered(MouseEvent e){  }
	public void mousePressed(MouseEvent e){  }
	public void mouseExited(MouseEvent e){  }
	public void keyReleased(KeyEvent e) { }
	public void keyTyped(KeyEvent e) {}

	public void mouseClicked(MouseEvent e){
		Object source = e.getSource();
		if(source == textField){
			textField.setText("");
		}
	}

	public void keyPressed(KeyEvent e) {
		if( e.getKeyCode() == KeyEvent.VK_ENTER ){
			String name = textField.getText();
			if(name.length() > 25 || name.equals("")){
				textArea.setText("");
				textArea.setText("Please enter a valid Actor/Actress Name!");
			}
			else{
				int distance = findDistance(name);
				textArea.setText("");
				textArea.setText("You entered the name: " + name + "\n\n---Results---\n");
				textArea.append("The Distance from Kevin Bacon to " + name + " is " + distance + "!\n");
				//textArea.append("\n\nThe Path from Kevin Bacon to " + name + " runs through\n");
//				textArea.append("Kevin Bacon to " + returnList.get(1) + "\n");
//				for(int i = 2; i<returnList.size()-1; i++){
//					textArea.append(returnList.get(i) + " to " + returnList.get(i+1) + "\n");
//				}
			}
		}
	}

	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();

		if(source == exitButton){
			System.exit(0);
		}
		else if(source == quit){
			System.exit(0);
		}
		else if(source == help){
			textArea.setText("");
			textArea.setText("If you are in need assistance with this program, please contact Andrew Zurn(awzurn@csbsju.edu)");
		}
		else if(source == about){
			textArea.setText("");
			textArea.setText("Welcome to Baconater, the GUI representation of the Six Degrees of Kevin Bacon Game!\n\n\n" +
					"This program allows you to enter and Actor's or Actress's name into the text field at the bottom of the" +
					"window, where upon it then will calculate how far away the actress is within a web of actors and actresses who have" +
					"worked with Kevin Bacon\nduring there careers.\n\n\nActors/Actress' that have worked directly with Kevin Bacon" +
					"in a movie will have a connection length of 1.  Actors/Actress' that have worked with someone else whom has" +
					"worked with Kevin Bacon in a movie will have a connection length of 2, and so on and so on.\n\n\n ENJOY!" +
					"\n\n\n\n\n Project worked on by Andrew Zurn for CSCI 338 during the Spring 2013 Semester, under Lynn Ziegler.\n");
		}
		else if(source == enterButton){
			String name = textField.getText();
			if(name.length() > 25 || name.equals("")){
				textArea.setText("");
				textArea.setText("Please enter a valid Actor/Actress Name!");
			}
			else{
				int distance = findDistance(name);
				textArea.setText("");
				textArea.setText("You entered the name: " + name + "\n\n---Results---\n");
				if(distance == 1){
					textArea.append("The Distance from Kevin Bacon to " + name + " is " + distance + "!\n");
					textArea.append("\n\nKevin Bacon shares a direct connection with " + name);
				}
				else if(distance == 2){
					ArrayList<String> pathList = findPath(name, distance);
					textArea.append("The Distance from Kevin Bacon to " + name + " is " + distance + "!\n");
					textArea.append("\n\nKevin Bacon worked with " + pathList.get(0) + " who worked with " + name + ".\n");
				}
				textArea.append("The Distance from Kevin Bacon to " + name + " is " + distance + "!\n");
				//textArea.append("\n\nThe Path from Kevin Bacon to " + name + " runs through\n");
//				textArea.append("Kevin Bacon to " + returnList.get(1) + "\n");
//				for(int i = 2; i<returnList.size()-1; i++){
//					textArea.append(returnList.get(i) + " to " + returnList.get(i+1) + "\n");
//				}
			}
		}
	}
	
	/**
	 * This will find the path between Kevin Bacon and the passed parameter name.
	 * @param name The actor to find from Kevin Bacon
	 * @param distance The distance from Kevin Bacon to actor
	 * @return The list containing all the information necessary.  Index 0 - will be the distance from actor to Bacon.
	 * The following indexes will have the names between Kevin Bacon and that actor.
	 */
	public ArrayList<String> findPath(String name, int distance){
		ArrayList<String> returnList = new ArrayList<String>();
		if(distance == 2){
			for(String actor: baconGraph.getMap().get("Kevin Bacon").keySet()){
				for(String actor2: baconGraph.getMap().get(name).keySet()){
					if(actor == actor2){
						returnList.add(actor);
					}
				}
			}
		}
		
		return returnList;
	}
	
	public int findDistance(String actor){
		try{
			return baconGraph.getMap().get("Kevin Bacon").get(actor).getDistance();
		}
		catch(Exception e){
			return -1000;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		BaconGUI baconGUI = new BaconGUI();
	}

}