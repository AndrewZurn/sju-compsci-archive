import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// creates a graphical interface that allows the user to enter and retrieve
// events from a calendar
public class CalendarController5 extends FrameController implements ActionListener{
    
    private static final int YEAR = 2004;
    
    private JTextField month;              // which month
    private JTextField day;                // which event
    private JTextField description;        // what's happening
    
    private JButton addEvent;              // add event to specified month, day
    private JButton getEvent;              // get event for specified month, day
    
    private YearlyCalendar2 theCalendar;    // stores the daily events
    
    // display the graphical components
    public void begin() {
        
        Container contentPane = getContentPane();
        
        Container inputPanel = new JPanel();
        
        JPanel monthPanel = new JPanel( );
        JLabel monthLable = new JLabel("Month:");
        month = new JTextField(3);
        monthPanel.add(monthLable);
        monthPanel.add(month);
        
        JPanel dayPanel = new JPanel( );
        JLabel dayLable = new JLabel("Day:");
        day = new JTextField(3);
        dayPanel.add(dayLable);
        dayPanel.add(day);
        
        inputPanel.add(monthPanel);
        inputPanel.add(dayPanel);
        
        JPanel descPanel = new JPanel( );
        JLabel descLabel = new JLabel("Description:");
        description = new JTextField(30);
        descPanel.add(descLabel);
        descPanel.add(description);
        
        JPanel buttonPanel = new JPanel();
        addEvent = new JButton("Enter Event");
        addEvent.addActionListener(this);
        buttonPanel.add(addEvent);
        
        getEvent = new JButton("Get Event");
        getEvent.addActionListener(this);
        buttonPanel.add(getEvent);
        
        contentPane.add( inputPanel, BorderLayout.NORTH );
        contentPane.add( descPanel, BorderLayout.CENTER );
        contentPane.add( buttonPanel, BorderLayout.SOUTH );
        
        validate();
        
        theCalendar = new YearlyCalendar2(YEAR);
        
        
    }
    
    // enter or retrieve an event
    public void actionPerformed( ActionEvent evt ){
        if(evt.getSource() == addEvent){
            try {
                theCalendar.setEvent(
                        month.getText() ,
                        day.getText() ,
                        description.getText()
                );
            } catch ( NumberFormatException e ) {
                System.out.println(
                        "Date entered is invalid. " +
                        "Enter numeric values for the month and day."
                        );
            }
        }
        else{
            try {
                description.setText(theCalendar.getEvent(
                                                month.getText() ,
                                                day.getText()
                                                ));
            } catch ( NumberFormatException e ) {
                System.out.println(
                        "Date entered is invalid. " +
                        "Enter numeric values for the month and day."
                        );
            }
        }
    }
    
    
    
}
