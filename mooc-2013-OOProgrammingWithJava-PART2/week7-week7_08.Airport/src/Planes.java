
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
public class Planes {
    private final String id;
    private final int capacity;
    
    public Planes(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    

    public String getID() {
        return this.id;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public String toString() {
        return this.id + " (" + this.capacity + " ppl)";
    }
    
    
}
