/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author ginaj
 */
public class BinarySearchTree {

    public class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
        
        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    
    private Node rootNode;
    
    public BinarySearchTree() {
        this.rootNode = null;
    }
    
    public void insert(int data) {
        rootNode = insertRecursive(rootNode, data);
    }
    
    private Node insertRecursive(Node current, int data) {
        if(current == null) {
            return new Node(data);
        }

        if(data < current.data) {
            current.leftChild = insertRecursive(current.leftChild, data);
        } else if(data > current.data) {
            current.rightChild = insertRecursive(current.rightChild, data);
        } else { //value already exists
            return current;
        }
        return current;
    }
    
    public void delete(int data) {
        if(rootNode == null) {
            System.out.println("Tree empty");
        } else if(containsNode(data) == false) {
            System.out.println("Data not present in tree");
        } else {
            rootNode = deleteRecursive(rootNode, data);
            System.out.println(data + " deleted from tree");
        }
    }
    
    private Node deleteRecursive(Node current, int data) {
        if(current == null) {
            return null;
        }
        if(current.data == data) {
            if(current.leftChild == null && current.rightChild == null) {
                return null;
            } else if(current.leftChild == null) {
                return current.rightChild;
            } else if(current.rightChild == null) {
                return current.leftChild;
            } else {
                Node rc = current.rightChild;
                while(rc.leftChild != null) {
                    rc = rc.leftChild;
                }
                current.data = rc.data;
                current.rightChild = deleteRecursive(current.rightChild, rc.data);
                return current;
            }
        }
        if(data < current.data) {
            return deleteRecursive(current.leftChild, data);
        }
        return deleteRecursive(current.rightChild, data);
    }
    
    public boolean containsNode(int data) {
        return containsNodeRecursive(rootNode, data);
    }
    
    private boolean containsNodeRecursive(Node current, int data) {
        if(current == null) {
            return false;
        }
        if(current.data == data) {
            return true;
        }
        if(data < current.data) {
            return containsNodeRecursive(current.leftChild, data);
        }
        return containsNodeRecursive(current.rightChild, data);
    }

    public void inOrder() {
        inOrderRecursive(rootNode);
    }
    
    private void inOrderRecursive(Node n) {
        if(n != null) {
            inOrderRecursive(n.leftChild);
            System.out.print(n.data + " ");
            inOrderRecursive(n.rightChild);
        }
    }
    
    public void preOrder() {
        preOrderRecursive(rootNode);
    }
    
    private void preOrderRecursive(Node n) {
        if(n != null) {
            System.out.print(n.data + " ");
            preOrderRecursive(n.leftChild);
            preOrderRecursive(n.rightChild);
        }
    }
    
    public void postOrder() {
        postOrderRecursive(rootNode);
    }
    
    private void postOrderRecursive(Node n) {
        if(n != null) {
            postOrderRecursive(n.leftChild);
            postOrderRecursive(n.rightChild);
            System.out.print(n.data + " ");
        }
    }
    
    public void breadthSearch() {
        if(rootNode == null) {
            return;
        }
        
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(rootNode);
        
        while(!nodes.isEmpty()) {
            Node n = nodes.remove();
            System.out.print(n.data + " ");
            
            if(n.leftChild != null) {
                nodes.add(n.leftChild);
            }
            if(n.rightChild != null) {
                nodes.add(n.rightChild);
            }
        }
        System.out.println("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(15);
        bst.insert(25);
        bst.insert(10);
        bst.insert(18);
        bst.insert(12);
        bst.insert(17);
        bst.insert(19);
        bst.insert(16);
        bst.breadthSearch();
    }
    
}
