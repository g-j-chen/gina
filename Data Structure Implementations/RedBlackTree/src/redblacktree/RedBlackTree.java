/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblacktree;

/**
 *
 * @author ginaj
 */
 

public class RedBlackTree {

    public class Node {  // Make this static
        private int data;
        private boolean isBlack;
        private Node leftChild;
        private Node rightChild;
        private Node parent;
        private boolean isLeftChild;
        
        public Node(int data) {
            this.data = data;
            this.isBlack = false;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
            this.isLeftChild = false;
        }
    }
    
    private Node root;
    
    public void insert(int data) {
        Node newNode = new Node(data);
        
        if(root == null) {
            root = newNode;
            newNode.isBlack = true;
            return;
        }
        
        insertRecursive(root, newNode);
    }
    
    private void insertRecursive(Node parent, Node newNode) {
        if(newNode.data < parent.data) {
            if(parent.leftChild == null) {
                parent.leftChild = newNode;
                newNode.parent = parent;
                newNode.isBlack = false;
                newNode.isLeftChild = true;
            } else {
                insertRecursive(parent.leftChild, newNode);
            }
        } else if(newNode.data > parent.data) {
            if(parent.rightChild == null) {
                parent.rightChild = newNode;
                newNode.parent = parent;
                newNode.isBlack = false;
                newNode.isLeftChild = false;
            } else {
                insertRecursive(parent.rightChild, newNode);
            }
        }        
        checkColour(newNode);
    }
    
    public void checkColour(Node node) {
        if(node == root) {
            return;
        }
        if(!node.isBlack && !node.parent.isBlack) {
            correctTree(node);
        }
        checkColour(node.parent);
    }
    
    public void correctTree(Node node) {
        Node aunt = null;
        if(node.parent.isLeftChild) {
            aunt = node.parent.parent.rightChild;
            if(aunt == null || aunt.isBlack) {
                rotateTree(node);
            } else {
                aunt.isBlack = true;
                aunt.parent.isBlack = false;
                node.parent.isBlack = true;
            }
        }
        if(!node.parent.isLeftChild) { //parent is right child
            aunt = node.parent.parent.leftChild;
            if(aunt == null || aunt.isBlack) {
                rotateTree(node);
            } else {
                aunt.isBlack = true;
                aunt.parent.isBlack = false;
                node.parent.isBlack = true;
            }
        }
        if(!root.isBlack) {
            root.isBlack = true;
        }
    }
    
    public void rotateTree(Node node) {
        if(node.isLeftChild) {
            if(node.parent.isLeftChild) {
                rightRotate(node.parent.parent);
                node.isBlack = false;
                node.parent.isBlack = true;
                if(node.parent.rightChild != null) {
                    node.parent.rightChild.isBlack = false;
                }
            } else { //parent is right child
                rightLeftRotate(node.parent.parent);
                node.isBlack = true;
                node.leftChild.isBlack = false;
                node.rightChild.isBlack = false;
            }
        } else { //node is right child
            if(node.parent.isLeftChild) {
                leftRightRotate(node.parent.parent);
                node.isBlack = true;
                node.leftChild.isBlack = false;
                node.rightChild.isBlack = false;
            } else { //parent is right child
                leftRotate(node.parent.parent);
                node.parent.isBlack = true;
                node.isBlack = false;
                if(node.parent.leftChild != null) {
                    node.parent.rightChild.isBlack = false;
                }
            }
        }
    }
    
    private void rightRotate(Node node) {
        Node temp = node.leftChild;
        
        node.leftChild = temp.rightChild;
        if(node.leftChild != null) {
            node.leftChild.parent = node;
            node.leftChild.isLeftChild = true;
        }
        if(node.parent == null) {
            root = temp;
            temp.isBlack = true;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if(node.isLeftChild) {
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            } else {
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
        }
        
        temp.rightChild = node;
        node.isLeftChild = false;
        node.parent = temp;
    }
    
    private void leftRotate(Node node) {
        Node temp = node.rightChild;
        
        node.rightChild = temp.leftChild;
        if(node.rightChild != null) {
            node.rightChild.parent = node;
            node.rightChild.isLeftChild = false;
        }
        if(node.parent == null) {
            root = temp;
            temp.isBlack = true;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if(node.isLeftChild) {
                temp.isLeftChild = true;
                temp.parent.leftChild = temp;
            } else {
                temp.isLeftChild = false;
                temp.parent.rightChild = temp;
            }
        }
        
        temp.leftChild = node;
        node.isLeftChild = true;
        node.parent = temp;
    }
    
    private void leftRightRotate(Node node) {
        leftRotate(node.leftChild);
        rightRotate(node);
    }
    
    private void rightLeftRotate(Node node) {
        rightRotate(node.rightChild);
        leftRotate(node);
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
    
    public int height(Node node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.leftChild), height(node.rightChild));
        }
    }
    
    public int blackNodes(Node node) {
        if(node == null) {
            return 1;
        }
        int rightBlackNodes = blackNodes(node.rightChild);
        int leftBlackNodes = blackNodes(node.leftChild);
        
        if(rightBlackNodes != leftBlackNodes) {
            System.out.println("Unbalanced black nodes");
            return -1;
        }
        if(node.isBlack) {
            leftBlackNodes++;
        }
        return leftBlackNodes;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(5);
        rbt.insert(4);
        rbt.insert(6);
        rbt.insert(7);
        rbt.insert(8);
        rbt.inOrder();
        System.out.println("");

    }
    
}
