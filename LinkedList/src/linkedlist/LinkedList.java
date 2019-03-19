/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class LinkedList {

    /**
     */
    
    Node firstNode;
    
    public static class Node {
        public int data;
        public Node nextNode;
        
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }
    
    public void push(int newData) { //pushs to front of list
        Node newNode = new Node(newData);
        newNode.nextNode = firstNode;
        firstNode = newNode;
    }
    
    public void insertAfterNode(int newData, Node afterNode) { //inserts after a given node
        if(afterNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.nextNode = afterNode.nextNode;
        afterNode.nextNode = newNode;
    }
    
    public void insertAfterIndex(int newData, int index) {
        Node newNode = new Node(newData);
        Node n = firstNode;
        for(int i = 0; i < index; i++) {
            n = n.nextNode;
        }
        Node temp = n.nextNode;
        n.nextNode = newNode;
        newNode.nextNode = temp;
    }
    
    public void add(int newData) { //adds to end of list
        Node newNode = new Node(newData);
        if(firstNode == null) {
            firstNode = newNode;
            return;
        }
        Node n = firstNode;
        while(n.nextNode != null) {
            n = n.nextNode;
        }
        n.nextNode = newNode;
    }
    
    public void delete(int data) { //delete a node that contains this data
        Node n = firstNode;
        Node prev = null;
        if(n != null && n.data == data) {
            firstNode = n.nextNode;
            return;
        }
        while(n != null && n.data != data) {
            prev = n;
            n = n.nextNode;
        }
        if(n == null) {
            return;
        }
        if(n.data == data) {
            prev.nextNode = n.nextNode;
        }
    }
    
    public void deleteAtPosition(int position) {
        int p = 0;
        Node n = firstNode;
        Node temp = null;
        if(position == 0) {
            firstNode = n.nextNode;
            return;
        }
        while(n != null && position != p) {
            temp = n;
            n = n.nextNode;
            p++;
        }
        if(position == p) {
            temp.nextNode = n.nextNode;
        }
    }
    
    public void deleteList() {
        firstNode = null;
    }
    
    public int findLength() {
        Node n = firstNode;
        int length = 0;
        while(n != null) {
            length++;
            n = n.nextNode;
        }
        return length;
    }
    
    public boolean findData(int data) {
        boolean found = false;
        Node n = firstNode;
        while(n != null) {
            if(n.data == data) {
                found = true;
                break;
            } else {
                n = n.nextNode;
            }
        }
        return found;
    }
    
    public int getNode(int index) {
        int nodeData = 0;
        int position = 0;
        Node n = firstNode;
        while(n != null) {
            if(position == index) {
                nodeData = n.data;
                break;
            } else {
                n = n.nextNode;
                position++;
            }
        }
        return nodeData;
    }
    
    public int getNthFromEnd(int index) {
        Node n = firstNode;
        for(int i = 0; i < findLength() - index; i++) {
            n = n.nextNode;
        }
        return n.data;
    }
    
    public boolean detectLoop() {
        boolean loop = false;
        ArrayList<Node> t = new ArrayList<>();
        Node n = firstNode;
        while(n != null) {
            if(!t.contains(n)) {
                t.add(n);
                n = n.nextNode;
            } else {
                loop = true;
                break;
            }
        }
        return loop;
    }
    
    public void printList() {
        Node n = firstNode;
        while(n != null) {
            System.out.println(n.data);
            n = n.nextNode;
        }
    }
    
    public int printMiddle() {
        Node n = firstNode;
        int middle = findLength() / 2;
        for(int i = 0; i < middle; i++) {
            n = n.nextNode;
        }
        return n.data;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList ll = new LinkedList();
        ll.firstNode = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node last = new Node(8);
        ll.firstNode.nextNode = second;
        second.nextNode = third;
        third.nextNode = fourth;
        fourth.nextNode = last;
        

        ll.push(0);
        ll.printList();
        System.out.println("");
        
        ll.delete(4);
        ll.printList();
        
    }
    
}
