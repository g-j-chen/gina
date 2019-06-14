/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlists;

/**
 *
 * @author ginaj
 */
public class DoublyLinkedList {

    /**
     * @param args the command line arguments
     */
    Node firstNode;
    
    public static class Node {
        public int data;
        public Node nextNode;
        public Node prevNode;
        
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.nextNode = firstNode;
        firstNode.prevNode = newNode;
        firstNode = newNode;
    }
    
    public void add(int data) {
        Node newNode = new Node(data);
        if(firstNode == null) {
            firstNode = newNode;
        }
        Node n = firstNode;
        while(n.nextNode != null) {
            n = n.nextNode;
        }
        n.nextNode = newNode;
        newNode.prevNode = n;
    }
    
    public void insertAfterNode(int data, Node afterNode) {
        Node newNode = new Node(data);
        
        Node tempNext = afterNode.nextNode;
        
        afterNode.nextNode = newNode;
        newNode.nextNode = tempNext;
        
        newNode.prevNode = afterNode;
        tempNext.prevNode = newNode;
    }
    
    public void insertAfterIndex(int data, int index) {
        Node newNode = new Node(data);
        
        Node n = firstNode;
        for(int i = 0; i < index; i++) {
            n = n.nextNode;
        }
        Node tempNext = n.nextNode;
        
        n.nextNode = newNode;
        newNode.nextNode = tempNext;
        
        tempNext.prevNode = newNode;
        newNode.prevNode = n;
    }
    
    public void delete(int data) {
        Node n = firstNode;
        Node prev = null;
        Node next = null;
        if(n != null && n.data == data) {
            firstNode = n.nextNode;
            return;
        }
        if(!findData(data)) {
            System.out.println("The input data is not in this list");
            return;
        }
        while(n != null && n.data != data) {
            prev = n;
            next = n.nextNode.nextNode;
            n = n.nextNode;
        }

        if(n == null) {
            return;
        }
        if(n.data == data) {
            prev.nextNode = n.nextNode;
        }
    }
    
    public void deleteByNode(Node delNode) {      
        Node current = firstNode;
        if(current == null || delNode == null) {
            return;
        }
        if(current == delNode) {
            firstNode = current.nextNode;
        }
        
        Node n = findNode(delNode);

        if(n.nextNode != null) {
            n.nextNode.prevNode = n.prevNode;
        }

        if(n.prevNode != null) {
            n.prevNode.nextNode = n.nextNode;
        }
    }
    
    public void deleteByIndex(int index) {
        Node n = firstNode;
        Node prev = null;
        Node next = null;
        for(int i = 0; i < index; i++) {
            n = n.nextNode;
        }
        prev = n.prevNode;
        next = n.nextNode;
        prev.nextNode = next;
        next.prevNode = prev;
    }
    
    public Node findNode(Node n) {
        Node node = firstNode;
        while(n != null && node != n) {
            node = node.nextNode;
        }
        return node;
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
     
    public void reverse() {
        Node current = firstNode;
        Node temp = null;
        
        while(current != null) {
            temp = current.prevNode;
            current.prevNode = current.nextNode;
            current.nextNode = temp;
            current = current.prevNode;
        }
        
        if(temp != null) {
            firstNode = temp.prevNode;
        }
    }
     
    public void printList() {
        Node n = firstNode;
        while(n != null) {
            System.out.println(n.data);
            n = n.nextNode;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList dll = new DoublyLinkedList();
        Node first = new Node(1);
        dll.firstNode = first;
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node last = new Node(8);
        dll.firstNode.nextNode = second;
        second.prevNode = first;
        second.nextNode = third;
        third.prevNode = second;
        third.nextNode = fourth;
        fourth.prevNode = third;
        fourth.nextNode = last;
        last.prevNode = fourth;
        dll.insertAfterNode(5, fourth);
        dll.insertAfterIndex(6, 4);
        dll.push(0);
        

        dll.printList();
        System.out.println("");
        dll.reverse();
        dll.printList();
        
    }
    
}
