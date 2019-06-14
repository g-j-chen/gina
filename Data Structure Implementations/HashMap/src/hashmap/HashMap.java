/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.LinkedList;
/**
 *
 * @author ginaj
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {
    
    public class HashNode<K, V> {
        private K key;
        private V value;
        
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<HashNode<K, V>>[] hashArray;
    private int mapSize;
    private int numElements;
    private final double loadFactor;
    
    public HashMap(int size) {
        this.hashArray = (LinkedList<HashNode<K, V>>[]) new LinkedList[size];
        this.mapSize = size;
        this.numElements = 0;
        this.loadFactor = 0.75;
        for(int i = 0; i < mapSize; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key) {
        int position = 1;
        int hash = 0;
        String s = String.valueOf(key);
        for(int i = 0; i < s.length(); i++) {
            hash += s.charAt(i) * position++;
        }
        return hash;
    }
    
    public void add(K key, V value) {
        if(reachedLoadFactor()) {
            resize(mapSize * 2);
        }
        int hashCode = hashFunction(key) % mapSize;
        HashNode<K, V> hn = new HashNode(key, value);
        hashArray[hashCode].add(hn);
        numElements++;
    }
    
    private void resize(int newSize) {
        LinkedList<HashNode<K,V>>[] newArray = (LinkedList<HashNode<K, V>>[]) new LinkedList[newSize];
        for(int i = 0; i < newSize; i++) {
            newArray[i] = new LinkedList<>();
        }
        for(int i = 0; i < mapSize; i++) {
            for(int j = 0; j < hashArray[i].size(); j++) {
                HashNode hn = hashArray[i].remove();
                int hashCode = hashFunction((K) hn.key) % newSize;
                newArray[hashCode].add(hn);
            }
        }
        hashArray = newArray;
        mapSize = newSize;
    }
    
    private boolean reachedLoadFactor() {
        return (numElements / mapSize) > loadFactor;
     }
    
    public void remove(K key) {
        int hashCode = hashFunction(key) % mapSize;
        for(HashNode hn : hashArray[hashCode]) {
            if(((Comparable<K>)key).compareTo((K) hn.key) == 0) {
                hashArray[hashCode].remove(hn);
            }
        }
        numElements--;
    }
    
    public V getValue(K key) {
        int hashCode = hashFunction(key) % mapSize;
        for(HashNode hn : hashArray[hashCode]) {
            if(((Comparable<K>)key).compareTo((K) hn.key) == 0) {
                return (V) hn.value;
            }
        }
        return null;
    }
    
    public int numElements() {
        return numElements;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap hm = new HashMap(5);
        hm.add("Gina", 1);
        hm.add("Glen", 2);
        hm.add("Morty", 3);
        
        System.out.println(hm.getValue("Gina"));
    }
    
}
