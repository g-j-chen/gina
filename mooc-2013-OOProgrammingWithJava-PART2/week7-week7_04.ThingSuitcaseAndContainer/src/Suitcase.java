
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
public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> things;
    
    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        if (totalWeight() + thing.getWeight() <= this.maxWeight) {
            this.things.add(thing);
        }
    }
    
    public String toString() {
        String statement = "";
        if (things.size() == 0) {
            statement = "empty (" + totalWeight() + " kg)";
        } else if (things.size() == 1) {
            statement = things.size() + " thing (" + totalWeight() + " kg)";
        } else if (things.size() > 1) {
            statement = things.size() + " things (" + totalWeight() + " kg)";
        }
        return statement;
    }
    
    public void printThings() {
        for (Thing thing : this.things) {
            System.out.println(thing);
        }
    }
    
    public int totalWeight() {
        int weight = 0;
        for (Thing thing : this.things) {
            weight += thing.getWeight();
        }
        return weight;
    }
    
    public Thing heaviestThing() {
        int heaviest = 0;
        int heaviestIndex = 0;
        if (things.size() == 0) {
            return null;
        }
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i).getWeight() > heaviest) {
                heaviest = things.get(i).getWeight();
                heaviestIndex = i;
            }
        }
        return things.get(heaviestIndex);        
    }
}
