/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> contents;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
        int currentWeight = 0;
        
        for(Thing t : contents) {
            currentWeight += t.getWeight();
        }
        
        if(currentWeight + thing.getWeight() <= maxWeight) {
            currentWeight += thing.getWeight();
            contents.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return contents.contains(thing);
    }
    
}
