/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class BoundedCounter {
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
