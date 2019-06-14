
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
public class Container {
    private int maxWeightLimit;
    private ArrayList<Suitcase> suitcases;
    private int currentWeight;
    
    public Container(int maxWeightLimit) {
        this.suitcases = new ArrayList<Suitcase>();
        this.maxWeightLimit = maxWeightLimit;
        this.currentWeight = 0;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (currentWeight + suitcase.totalWeight() <= maxWeightLimit) {
            this.suitcases.add(suitcase);
            this.currentWeight += suitcase.totalWeight();
        }
        
    }
    
    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.currentWeight + " kg)";
    }
    
    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }
}
