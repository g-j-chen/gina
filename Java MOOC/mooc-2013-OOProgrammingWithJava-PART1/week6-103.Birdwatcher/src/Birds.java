/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Birds {
    private String name;
    private String latinName;
    private int timesObserved;
    
    public Birds(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.timesObserved = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int timesObserved() {
        return this.timesObserved;
    }
    
    public void birdSighted() {
        this.timesObserved++;
    }
    
    public String toString() {
        return this.name + " (" + this.latinName + "): " + this.timesObserved + " obersevations";
    }
}
