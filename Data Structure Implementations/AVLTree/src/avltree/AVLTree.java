/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class AVLTree {

    /**
     */
    public class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
        private Node parent;
        
        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }
        
    }
    
    private Node root;
    private int currentSize;
    
    public AVLTree() {
        this.root = null;
        this.currentSize = 0;
    } 
    
    
    public void insert(int data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
            currentSize++;
            return;
        }
        insertRecursive(root, newNode);
    }
    
    private void insertRecursive(Node parent, Node newNode) {
        if(newNode.data <= parent.data) {
            if(parent.leftChild == null) {
                parent.leftChild = newNode;
                newNode.parent = parent;
                currentSize++;           
            } else {
                insertRecursive(parent.leftChild, newNode);
            }            
        } else {
            if(parent.rightChild == null){
                parent.rightChild = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                insertRecursive(parent.rightChild, newNode);
            }
        }
        checkBalance(newNode);
    }
    
    private boolean containsNode(int data) {
        return containsNodeRecursive(root, data);
    }
    
    private boolean containsNodeRecursive(Node node, int data) {
        if(node == null) {
            return false;
        }
        if(data == node.data) {
            return true;
        }
        if(data < node.data) {
            return containsNodeRecursive(node.leftChild, data);
        }
        return containsNodeRecursive(node.rightChild, data);
    }
    
    public void delete(int data) {
        if(root == null) {
            System.out.println("The tree is empty");
        }
        if(!containsNode(data)) {
            System.out.println("Data not present in AVL tree");
        } else {
            deleteRecursive(root, data);
            currentSize--;
        }
    }
    
    private void deleteRecursive(Node node, int data) {
        if(data == node.data) {
            Node tempParent = node.parent;
            if(node.leftChild == null || node.rightChild == null) {
                Node tempNode = null;
                if(tempNode == node.leftChild) {
                    tempNode = node.rightChild;
                } else if(tempNode == node.rightChild) {
                    tempNode = node.leftChild;
                }
                
                if(tempParent != null) {
                    if(tempParent.leftChild == node) {
                        tempParent.leftChild = tempNode;
                    } else if(tempParent.rightChild == node) {
                        tempParent.rightChild = tempNode;
                    }
                }
                
                if(tempNode == null) {
                    node = null;
                } else {
                    node = tempNode;
                    tempNode.parent = tempParent;
                }
                
            } else {
                Node temp = node.rightChild;
                while(temp.leftChild != null) {
                    temp = temp.leftChild;
                }
                node.data = temp.data;

                deleteRecursive(node.rightChild, temp.data);
            }
 
        if(tempParent != null) {
            checkBalance(tempParent);
        }
        
        } else if(data < node.data) {
            deleteRecursive(node.leftChild, data);
        } else {
            deleteRecursive(node.rightChild, data);
        }
    }
    
    public void checkBalance(Node node) {
        if(Math.abs(height(node.leftChild) - height(node.rightChild)) > 1) {
            node = rebalance(node);
        }
        if(node.parent != null) {
            checkBalance(node.parent);
        }
    }
    
    private int height(Node node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.leftChild), height(node.rightChild));
        }
    }
    
    public Node rebalance(Node node) {
        int lh = height(node.leftChild);
        int rh = height(node.rightChild);
        int diff = lh - rh;
        
        if(diff > 1) { //left skewed - to rotate right
            if(height(node.leftChild.leftChild) > height(node.leftChild.rightChild)) {
                //LL skewed - 1 right rotation
                node = rightRotate(node);
            } else if(height(node.leftChild.leftChild) < height(node.leftChild.rightChild)) {
                //LR skewed - 1 left then 1 right rotation
                node = leftRightRotate(node);
            }
        } else if(diff < -1) { //right skewed - to rotate left
            if(height(node.rightChild.rightChild) > height(node.rightChild.leftChild)) {
                //RR skewed - 1 left rotation
                node = leftRotate(node);
            } else if(height(node.rightChild.rightChild) < height(node.rightChild.leftChild)) {
                //RL skewed - 1 right then 1 left rotation
                node = rightLeftRotate(node);
            }
        }
        return node;
    }
    
    private Node rightRotate(Node node) {
        Node temp = node.leftChild;
        temp.parent = node.parent;
        
        node.leftChild = temp.rightChild;
        if(node.leftChild != null) {
            node.leftChild.parent = node;
        }
        
        temp.rightChild = node;
        node.parent = temp;
                
        if(temp.parent != null) {
            if(temp.parent.leftChild == node) {
                temp.parent.leftChild = temp;
            } else if(temp.parent.rightChild == node) {
                temp.parent.rightChild = temp;
            }
        } else {
            root = temp;
        }
        
        return temp;
    }
    
    private Node leftRotate(Node node) {
        Node temp = node.rightChild;
        temp.parent = node.parent;
        
        node.rightChild = temp.leftChild;
        if(node.rightChild != null) {
            node.rightChild.parent = node;
        }
        
        temp.leftChild = node;
        node.parent = temp;
        
        if(temp.parent != null) {
            if(temp.parent.leftChild == node) {
                temp.parent.leftChild = temp;
            } else if(temp.parent.rightChild == node) {
                temp.parent.rightChild = temp;
            }
        } else {
            root = temp;
        }
                 
        return temp;
    }
    
    private Node leftRightRotate(Node node) {
        node.leftChild = leftRotate(node.leftChild);
        return rightRotate(node);
    }
    
    private Node rightLeftRotate(Node node) {
        node.rightChild = rightRotate(node.rightChild);
        return leftRotate(node);
    }
    
    public void inOrder() {
        inOrderRecursive(root);
    }
    
    private void inOrderRecursive(Node node) {
        if(node != null) {
            inOrderRecursive(node.leftChild);
            System.out.print(node.data + " ");
            inOrderRecursive(node.rightChild);
        }
    }
    
    
    public void drawTree() {
        if(root == null) {
            System.out.println("Tree is empty");
            return;
        }

        List<Node> nodesToPrint = new ArrayList<>();
        nodesToPrint.add(root);
        
        drawTreeRecursive(nodesToPrint, 1);
    }
    
    private void drawTreeRecursive(List<Node> nodes, int level) {
        if(nodes.isEmpty()) {
            return;
        }
        
        int maxLevel = height(root);
        int indent = (int) Math.pow(2, (maxLevel - level)) + 2;
        int betweenSpacing = (int) Math.pow(2, (maxLevel - level + 1)) - 1;
        

        printWhiteSpaces(indent - 1);
        
        List<Node> newNodes = new ArrayList<>();
        

        for(Node n : nodes) {
            if(n != null) {
                System.out.print(n.data);
                newNodes.add(n.leftChild);
                newNodes.add(n.rightChild);
            } else {
                System.out.print(" ");
            }
            printWhiteSpaces(betweenSpacing + maxLevel - level);
        }   
        
        System.out.println("");
        
        

        for(int j = 0; j < nodes.size(); j++) {
            printWhiteSpaces(indent - 2);
            if(nodes.get(j) == null) {
                printWhiteSpaces(2);
                continue;
            }
            if(nodes.get(j).leftChild != null) {
                System.out.print("/");
            } else {
                printWhiteSpaces(1);
            }
            int numDigits = (int) (Math.log10(nodes.get(j).data) + 1);
            printWhiteSpaces(numDigits);
            
            if(nodes.get(j).rightChild != null) {
                System.out.print("\\");
            } else {
                printWhiteSpaces(1);
            }

            printWhiteSpaces((int) (Math.pow(2, (maxLevel - level))) - level);
        }       
        
        System.out.println("");
        
        drawTreeRecursive(newNodes, level + 1);
    }
    
    private void printWhiteSpaces(int count) {
        for(int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        AVLTree at = new AVLTree();
        at.insert(43);
        at.insert(19);
        at.insert(23);
        at.insert(9);
        at.insert(21);
        at.insert(6);
        at.insert(8);
        at.insert(20);
        at.insert(63);
        at.insert(50);        
        at.insert(62);     
        at.insert(52);
        at.insert(53);
        at.insert(51);
        at.insert(22);
        
        at.drawTree();

    }
    
}
