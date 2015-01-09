/**
 * Class allowing calculations of timing between events.
 */ 
public class Timer {
    /**
     * time when Timer started or reset
     */
    private double startTime;  

    /**
     * Create timer, initializing startTime with current time
     */ 
    public Timer() {
        startTime = System.currentTimeMillis();
    }
    
    /**
     * Return number of milliseconds since last reset
     */ 
    public double elapsedMilliseconds() {
        return System.currentTimeMillis() - startTime;
    }
    
    /**
     * Return number of seconds since last reset
     */ 
    public double elapsedSeconds() {
        return this.elapsedMilliseconds() / 1000;
    }
    
    /**
     * Return number of minutes since last reset
     */ 
    public double elapsedMinutes() {
        return this.elapsedSeconds() / 60;
    }
    
    /**
     * Return number of hours since last reset
     */ 
    public double elapsedHours() {
        return this.elapsedMinutes() / 60;
    }
    
    /**
     * Display number of hours, minutes and seconds since last reset
     */ 
    public void displayElapsedTime() {
        int time, hours, minutes, seconds;
        time = (int) elapsedMilliseconds();
        hours = time/(1000*60*60);
        time = time%(1000*60*60);
        minutes = time/(1000*60);
        time = time%(1000*60);
        seconds = time/(1000);
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
    
    /**
     * Reset startTime
     */ 
    public void reset() {
        startTime = System.currentTimeMillis();
    }
}      
