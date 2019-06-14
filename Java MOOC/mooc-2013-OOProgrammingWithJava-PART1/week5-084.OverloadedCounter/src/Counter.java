/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Counter {
    
    private int value;
    private boolean check;
    
            
    public Counter(int startingValue, boolean check) {
        this.value = startingValue;
        this.check = check;
    }
    
    public Counter(int startingValue) {
        this.value = startingValue;
        this.check = false;
    }
    
    public Counter(boolean check) {
        this.check = check;
        this.value = 0;
    }
    
    public Counter() {
        this.check = false;
        this.value = 0;
    }
    
    public int value() {
        return this.value;
    }
    
    public void increase() {
        this.increase(1);
    }
    
    public void increase(int increaseAmount) {
        if (increaseAmount > 0) {
            this.value = this.value + increaseAmount;    
        }
    }
    
    public void decrease() {
        this.decrease(1);
    }
        
    
    public void decrease(int decreaseAmount) {
        if (decreaseAmount > 0) {
            if (check && this.value - decreaseAmount >= 0) {
                this.value = this.value - decreaseAmount;
            } else if (check && this.value - decreaseAmount < 0) {
                this.value = 0;
            } else if (!check) {
                this.value = this.value - decreaseAmount;
            }
        }
    }
    
}
