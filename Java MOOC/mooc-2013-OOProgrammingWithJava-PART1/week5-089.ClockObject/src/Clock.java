public class Clock {
    private BoundedCounter hours = new BoundedCounter(23);
    private BoundedCounter minutes = new BoundedCounter(59);
    private BoundedCounter seconds = new BoundedCounter(59);

   
    public Clock(int hoursAtBeginning, int minutesAtBeginning, int secondsAtBeginning) {
        // the counters that represent hours, minutes and seconds are created and set to have the correct initial values
        this.hours.setValue(hoursAtBeginning);
        this.minutes.setValue(minutesAtBeginning);
        this.seconds.setValue(secondsAtBeginning);
    }
    
    public void tick() {
        // Clock advances by one second        
        this.seconds.next();
            if (this.seconds.getValue() == 0) {
                this.minutes.next();
                if (minutes.getValue() == 0) {
                    hours.next();
                }
            }
        
    }
    
    public String toString() {
        // returns the string representation
        return hours + ":" + minutes + ":" + seconds;
    }
}
