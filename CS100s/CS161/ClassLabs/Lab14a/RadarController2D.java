import java.awt.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*;


public class RadarController2D extends FrameWindowController implements ActionListener{
 private static final int XText = 20;
 private static final int YText = 40;
   
  private RadarStats2D stats;
  private JButton totalButton,       // Buttons to control speed
    highestDayButton,
    highestHourButton,
    graphButton;
  private JTextField inputDay;
  private JLabel inputLabel;
  private Text message = new Text("Select Function with button",XText,YText, canvas);
  
  
  public void begin()
  {
    //Generate new Statistics
    stats = new RadarStats2D(canvas);
    
    //Create GUI
    JPanel southPanel = new JPanel();
    JPanel northPanel = new JPanel();
    inputLabel = new JLabel("Enter day of month");
    inputDay = new JTextField("0",5);
    
    highestDayButton = new JButton( "Highest Day" );
    highestHourButton = new JButton( "Highest Hour" );
    graphButton = new JButton( "Show graph" );
    totalButton = new JButton("Total");
    
    highestDayButton.addActionListener( this );
    highestHourButton.addActionListener( this );
    graphButton.addActionListener( this );
    totalButton.addActionListener( this );
    
    northPanel.add(inputLabel);
    northPanel.add(inputDay);
   
    southPanel.add( highestDayButton );
    southPanel.add( highestHourButton );
    southPanel.add( graphButton );
    southPanel.add( totalButton );
    Container contentPane = getContentPane();
    contentPane.add( northPanel, BorderLayout.NORTH );
    contentPane.add( southPanel, BorderLayout.SOUTH );
    contentPane.validate();
  }
  
  public void actionPerformed( ActionEvent evt ) {
    if ( evt.getSource() == highestDayButton ) {
      canvas.clear();
      message= new Text("The highest day had " + stats.getHighestDay(),XText,YText, canvas);
      
      
    } else if ( evt.getSource() == highestHourButton ) {
      canvas.clear();
      message= new Text("The highest hour had " + stats.getHighestHour(),XText,YText, canvas);
      
      
    } else if(evt.getSource() == graphButton ) {
      int day= Integer.parseInt(inputDay.getText());
      stats.vehicleReport(day);
      
      
    } else { // evt.getSource() == TotalButton
      canvas.clear();
      message= new Text("The total number of speeders is " + stats.getTotal(),XText,YText, canvas);
      
    }
  }
}