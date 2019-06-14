/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

/**
 *
 * @author ginaj
 */

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    int data;
    int key;
    Node prev;
    Node next;
    
    public Node(int key, int data) {
        this.key = key; 
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class LruCache {

    /**
     * @param args the command line arguments
     */
    
    private HashMap<Integer, Node> map;
    private LinkedList<Integer> list;
    private Node head;
    private Node end;
    private int capacity;
    
    public LruCache(int capacity) {
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
        this.head = null;
        this.end = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            setHead(n);
            return n.data;
        }
        return -1;
    }
    
    private void setHead(Node n) {
        n.next = head;
        n.prev = null;
        
        if(head != null) {
            head.prev = n;
        }
        
        head = n;
        
        if(end == null) {
            end = head;
        }
    }
    
    public void set(int key, int data) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.data = data;
            removeNode(n);
            setHead(n);
        } else {
            Node newNode = new Node(key, data);
            if(map.size() >= capacity) {
                map.remove(end.key);
                removeNode(end);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            map.put(key, newNode);
        }
    }
    
    private void removeNode(Node n) {
        if(n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        
        if(n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }
    
    public void print() {
        Node n = head;
        while(n != null) {
            System.out.println("Key: " + n.key + " Data: " + n.data);
            n = n.next;
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        LruCache lru = new LruCache(5);
        lru.set(1, 1);
        lru.set(2, 2);
        lru.set(3, 3);
        lru.set(4, 4);
        lru.set(5, 5);
        lru.set(6, 6);
        lru.set(1, 1);
        lru.print();
        System.out.println("");
        lru.set(1, 4);
        lru.print();
    }
    
}
