// Class to represent a yearly calendar of daily events
public class YearlyCalendar2 {
    
    // A two-dimensional array of event descriptions.
    // rows are months; columns are days
    private String[][] dailyEvent;
    
    private int year;     // the year
    
    // Create a calendar for the given year
    public YearlyCalendar2(int aYear) {
        year = aYear;
        
        // set up 2-dimensional array of months and days
        dailyEvent = new String[12][];
        for (int month = 0; month < 12; month++) {
            int numDays = getDays(month);
            dailyEvent[month] = new String[numDays];
        }
        
        // initialize event descriptions
        for (int month = 0; month < 12; month++) {
            for (int day = 0; day < dailyEvent[month].length; day++) {
                dailyEvent[month][day] = "No event today";
            }
        }
    }
    
    // Returns number of days in the month
    private int getDays(int monthNumber) {
        monthNumber++;          // to adjust for array indexing
        int numDays = 0;
        if (monthNumber == 9 || monthNumber == 4 || monthNumber == 6 || monthNumber == 11)      
            numDays = 30;
        else if (monthNumber == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
                numDays = 29;
            else
                numDays = 28;
        }
        else
            numDays = 31;
        return numDays;
    }
    
    // Set the event description for a given month and day
    public void setEvent( String month,
                          String day, 
                          String description) {
        dailyEvent[Integer.parseInt(month)-1][Integer.parseInt(day)-1]
                                                 = description;
    }
    
    // Returns the event associated with a given date
    public String getEvent( String month,
                            String day ) {
        return dailyEvent[Integer.parseInt(month)-1][Integer.parseInt(day)-1];
    }
}
