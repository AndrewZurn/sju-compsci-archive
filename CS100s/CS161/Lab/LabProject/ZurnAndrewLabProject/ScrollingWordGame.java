import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import objectdraw.*;
import java.io.*;

/**
 *Scrolling Word GUI-Game
 * @author Andrew Zurn
 */

public class ScrollingWordGame extends FrameWindowController implements ActionListener{
  
  /** variable used to refer to the game */
  private ScrollingWordGame theGame = this;
  
  /** JPanels used for various GUI components */
  private JPanel southPanel, northPanel;
  
  /** JComboBox to vary the levels in the game */
  private JComboBox level;
  
  /** JTextField used for a user's input */
  private JTextField inputArea;
  
  /** JLabel to display the score, strikes, and inputArea information */
  private JLabel scoreLabel, strikesLabel, inputLabel;
  
  /** JButton to start the game and exit the game */
  private JButton startButton, exitButton;
  
  /** int used to keep track of the score and strikes */
  private int score, strike;
  
  /** int used to lengthen the inputField area */
  private int inputFieldSize = 17;
  
  /** final doubles used to vary the speed of the words across the screen */
  private static final double slowSpeed = 1.65, mediumSpeed = 2.1, fastSpeed = 2.25;
  
  /** double used to vary the gameSpeed between the three speed options */
  private double gameSpeed = 0;
  
  /** String to pass back to BannerMover the wanted file */
  private String smallList = "smallWords.txt";
  
  /** String to pass back to BannerMover the wanted file */
  private String mediumList = "mediumWords.txt";
  
  /** String to pass back to BannerMover the wanted file */
  private String largeList = "largeWords.txt";
  
  /** String used as the initial wanted list */
  private String selectedList = "smallWords.txt";
  
  /** String used to reference the word displayed on the screen */
  private String displayedWord;
  
  /** bannerMover used to reference BannerMover */
  private BannerMover bannerMover;
  
  /** String used to reference the word entered in the inputField */
  private String ourWord;
  
  /** boolean to determine if the game has already been started */
  private boolean gameOn = true;
  
  /** boolean used to keep track of the word on screen */
  private boolean onScreen = true;
  
  /** double used to keep track of the position of the word on screen */
  private double wordPositionX;
  
  
  /**
   * Creates the GUI for the user at the initialization of the class
   */
  
  
  public void begin(){
    //Construction of the GUI
    southPanel = new JPanel();
    northPanel = new JPanel();
    
    score = 0;
    strike = 0;
    scoreLabel = new JLabel("Score: " + score);
    strikesLabel = new JLabel("Strikes: " + strike);
    inputLabel = new JLabel("Word Input");
    
    startButton = new JButton("START");
    startButton.addActionListener( this );
    exitButton = new JButton("EXIT");
    exitButton.addActionListener( this );
    
    level = new JComboBox();
    level.addItem("--");
    level.addItem("Easy");
    level.addItem("Medium");
    level.addItem("Hard");
    level.addActionListener( this );
    
    inputArea = new JTextField(inputFieldSize);
    inputArea.addActionListener( this );
    
    southPanel.add(startButton);
    southPanel.add(exitButton);
    southPanel.add(inputLabel);
    southPanel.add(inputArea);
    
    northPanel.add(level);
    northPanel.add(scoreLabel);
    northPanel.add(strikesLabel);
    
    Container contentPane = getContentPane();
    contentPane.add(southPanel, BorderLayout.SOUTH);
    contentPane.add(northPanel, BorderLayout.NORTH);
    validate();
    
    resize(450,300);
  }
  
  /**
   * determines when a GUI compenent is used
   * @param evt the GUI compenent used
   */
  public void actionPerformed(ActionEvent evt){
    try{
      //Used so a user cannot start a new game in the middle of a current game
      if (gameOn){
        //Used to select the difficulty of the game
        if (evt.getSource() == level){
          if(level.getSelectedItem() == "Easy"){
            gameSpeed = slowSpeed;
            selectedList = smallList;
          }
          else if(level.getSelectedItem() == "Medium"){
            gameSpeed = mediumSpeed;
            selectedList = mediumList;
          }
          else if(level.getSelectedItem() == "Hard"){
            gameSpeed = fastSpeed;
            selectedList = largeList;
          }
        }
        //Start the game
        else if (evt.getSource() == startButton){
          if (level.getSelectedItem() == "--" ){}
          else{
            try{
              bannerMover = new BannerMover(selectedList, gameSpeed, theGame, canvas);
            }
            catch(FileNotFoundException fo){
              System.out.println("The File could not be found");
            }
            catch(IOException io){
              System.out.println("The File could not be read");
            }
          }
        }
        //Access and compare the text in the input field to the word on screen
        else if (evt.getSource() == inputArea){
          displayedWord = bannerMover.getText();
          ourWord = inputArea.getText();
          //Used if the word is on screen and correct; will increment score if true
          if ( bannerMover.getX() <= canvas.getWidth() && ourWord.equals(displayedWord) ){
            score += 1;
            scoreLabel.setText("Score: " + score);
            inputArea.setText("");
            bannerMover.removeFromCanvas();
          }
          //Used if the word is off screen on return of the enter key or if the two words do not match
          else if( bannerMover.getX() > canvas.getWidth() || !ourWord.equals(displayedWord)){
            strike += 1;
            strikesLabel.setText("Strikes: " + strike);
            inputArea.setText("");
            bannerMover.removeFromCanvas();
          }
          try{ 
            //If strikes is equal to three, the game will not create another word
            if(strike != 3){
            bannerMover = new BannerMover(selectedList, gameSpeed, theGame, canvas);
            }
          }
          catch(FileNotFoundException fo){
            System.out.println("The File could not be found");
          }
          catch(IOException io){
            System.out.println("The Fild could not be read");
          }
          //On third strike, game is no longer running, 
          if(strike == 3){
            gameOn = false;
            new YouLoseWindow(score);
            bannerMover.stopMoving();
           //resize(125, 125);
          }
        }
      }
      //Used to exit the game
      if (evt.getSource() == exitButton){
        System.exit(0);
      }
    }
    catch(NullPointerException ne){
      System.out.println("There was an error in the action of the game \nPlease select a level of difficulty and press start");
    }
  }
  
  /**
   * Used in BannerMover to incriment strikes if the word moves off the canvas
   */
  public void incrimentStrikes(){
    strike += 1;
    strikesLabel.setText("Strikes: " + strike);
    inputArea.setText("");
    //On third strike, game is no longer running, 
    if(strike == 3){
      gameOn = false;
      new YouLoseWindow(score);
      bannerMover.stopMoving();
      resize(125, 125);
    }
    try{
      //If strikes is equal to three, the game will not create another word
      if(strike != 3){
      bannerMover = new BannerMover(selectedList, gameSpeed, theGame, canvas);
      }
    }
    catch(FileNotFoundException fo){
      System.out.println("The File could not be found");
    }
    catch(IOException io){
      System.out.println("The Fild could not be read");
    }
  }
  
  /**
   * used to run the game from the command line
   */
  public static void main (String[] args){
    new ScrollingWordGame();
  }
} 


