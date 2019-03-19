/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> items;
    
    public Box(int maxCapacity) {
        this.maximumCapacity = maxCapacity;
        this.items = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() <= this.maximumCapacity) {
            items.add(thing);
            return true;
        }
        return false;
    }
    
    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing t : items) {
            totalVolume += t.getVolume();
        }
        return totalVolume;
    }
    
}
