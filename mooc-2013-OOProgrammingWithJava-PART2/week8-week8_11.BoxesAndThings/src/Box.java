
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Box implements ToBeStored{
    private double maxWeight;
    private int numberOfItems;
    private ArrayList<ToBeStored> stored;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.numberOfItems = 0;
        this.stored = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored tobestored) {
        if(weight() + tobestored.weight() < this.maxWeight) {
            this.stored.add(tobestored);
            this.numberOfItems++;
        }
        
        
    }
    
    public double weight() {
        double weight = 0;
        for(ToBeStored item : stored) {
            weight += item.weight();
        }
        return weight;
    }
    
    public String toString() {
        return "Box: " + this.numberOfItems + " things, total weight " + weight() + " kg";
    }
}
