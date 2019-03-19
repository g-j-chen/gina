
public class BoundedCounter {
    // copy here the class BoundedCounter from last weeks assignment 78 
    private int value = 0;
    private int upperLimit;
    
    public BoundedCounter(int upperLimit) {
        this.upperLimit = upperLimit;
    }
    
    public void next() {
        if (this.value < this.upperLimit) {
            this.value++;
        } else if (this.value == this.upperLimit) {
            this.value = 0;
        }
    }
    
    @Override
    public String toString() {
        if (this.value < 10) {
            return "0" + this.value;
        }
        return "" + this.value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int givenValue) {
        if (givenValue >= 0 && givenValue <= this.upperLimit) {
            this.value = givenValue;
        }
    }
}
