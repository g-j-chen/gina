/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashset;
import hashtable.HashTable;
/**
 *
 * @author ginaj
 */
public class HashSet {
    
    private HashTable set;
    
    public HashSet(int size) {
        this.set = new HashTable(size);
    }
    
    public void add(String s) {
        if(set.contains(s)) {
            return;
        }
        set.add(s, 0);
    }
    
    public boolean contains(String s) {
        return set.contains(s);
    }
    
    public void remove(String s) {
        set.remove(s);
    }
    
    public int getSize() {
        return set.numElements;
    }
    
    public boolean isEmpty() {
        return set.numElements == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet hs = new HashSet(5);
        hs.add("Gina");
        hs.add("Glen");
        System.out.println(hs.getSize());
        hs.add("Gina");
        System.out.println(hs.getSize());

    }
    
}
