/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.LinkedList;

/**
 *
 * @author ginaj
 */

public class HashTable {
    
    public class Node {
        private String name;
        private int value;
        
        public Node(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }
    
    private LinkedList<Node>[] keyArray;
    private int tableSize;
    public int numElements;
    private final double maxLoadFactor;
    
    public HashTable(int arraySize) {
        this.keyArray = new LinkedList[arraySize];
        this.tableSize = arraySize;
        this.numElements = 0;
        this.maxLoadFactor = 0.75;
    }
    
    private int hashFunction(String s) {
        int position = 1;
        int hash = 0;
        for(int i = 0; i < s.length(); i++) {
            hash += s.charAt(i) * position++;
        }
        return hash;
    }
    
    public void add(String name, int value) {
        if(reachedMaxLoadFactor()) {
            resize(tableSize * 2);
        }
        int hashCode = hashFunction(name);
        hashCode = hashCode % tableSize;
        Node n = new Node(name, value);
        if(keyArray[hashCode] == null) {
            LinkedList<Node> list = new LinkedList<>();
            keyArray[hashCode] = list;
            list.add(n);
        } else {
            keyArray[hashCode].add(n);
        }
        numElements++;
    }
    
    private void resize(int newSize) {
        LinkedList<Node>[] newArray = new LinkedList[newSize];
        for(int i = 0; i < tableSize; i++) {
            if(keyArray[i] != null) {
                for(int j = 0; j < keyArray[i].size(); j++) {
                    Node n = keyArray[i].remove();
                    int hashCode = hashFunction(n.name);
                    hashCode = hashCode % newSize;
                    if(newArray[hashCode] == null) {
                        LinkedList<Node> list = new LinkedList<>();
                        newArray[hashCode] = list;
                        list.add(n);
                    } else {
                        newArray[hashCode].add(n);
                    }
                }
            }
        }
        keyArray = newArray;
        tableSize = newSize;
    }
    
    public int getValue(String name) {
        int hashCode = hashFunction(name);
        hashCode = hashCode % tableSize;
        int value = -1;
        for(Node n : keyArray[hashCode]) {
            if(n.name.equals(name)) {
                value = n.value;
                System.out.println("Found value for: " + name);
            }
        }
        if(value == -1) {
            System.out.println("Value not found for entry: " + name);
        }
        return value;
    }
    
    public boolean contains(String name) {
        int hashCode = hashFunction(name);
        hashCode = hashCode % tableSize;
        
        if(keyArray[hashCode] == null) {
            return false;
        }
        
        for(Node n : keyArray[hashCode]) {
            if(n.name.equals(name)) {
                System.out.println("Found " + name);
                return true;
            }
        }
        System.out.println("Not found");
        return false;
        
    }
    
    public void remove(String name) {
        int hashCode = hashFunction(name);
        hashCode = hashCode % tableSize;
        for(Node n : keyArray[hashCode]) {
            if(n.name.equals(name)) {
                keyArray[hashCode].remove(n);
            }
        }
        numElements--;
    }
    
    private boolean reachedMaxLoadFactor() {
        return (numElements / tableSize) > maxLoadFactor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashTable ht = new HashTable(5);
        ht.add("Gina", 123456);
        ht.add("Glen", 456789);
        ht.add("Andrea", 987654);
        ht.add("Andrew", 654321);
        ht.add("Simon", 321065);
        ht.add("Adam", 951753);
        ht.add("Kate", 684153);

    }
    
}
