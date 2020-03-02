/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isbst;

/**
 *
 * @author ginaj
 */
public class IsBST {

    class Node {
        Integer value;
        Node left;
        Node right;
        
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    
    boolean isBST() {
	int min = Integer.MIN_VALUE;
	int max = Integer.MAX_VALUE;
	return isBSTrecursive(root, min, max);
    }

    boolean isBSTrecursive(Node n, int min, int max) {
        if(n == null) {
                return true;
        }
        if(n.value <= min || n.value > max) {
            return false;
        }
        return (isBSTrecursive(n.left, min, n.value) &&
        isBSTrecursive(n.right, n.value, max));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
