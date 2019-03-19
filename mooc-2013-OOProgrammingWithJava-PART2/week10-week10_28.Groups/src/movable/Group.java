/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class Group implements Movable {
    private ArrayList<Movable> list;
    
    public Group() {
        this.list = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        list.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable movable : list) {
            movable.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String s = "";
        for(Movable movable : list) {
            s += movable.toString() + "\n";
        }
        return s;
    }
}
