/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author ginaj
 */
public class BulkTank {
    
    private double capacity;
    private double volume;
    
    public BulkTank() {
        this.capacity = 2000.0;
        this.volume = 0.0;
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0.0;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if(amount > howMuchFreeSpace()) {
            volume = capacity;
        } else {
            volume += amount;
        }
    }
    
    public double getFromTank(double amount) {
        if(amount > volume) {
            double amountTaken = volume;
            volume = 0.0;
            return amountTaken;
        } else {
            volume -= amount;
            return volume;
        }
    }
    
    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
