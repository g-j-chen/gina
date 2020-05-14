/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetrictree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ginaj
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) { 
            val = x;
        }
    }
    
    public boolean isSymmetricIterative(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean mirror = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            
            if(left == null && right == null) {
                mirror = true;
            } else if(left == null || right == null || left.val != right.val) {
                mirror = false;
                break;
            } else if(left != null && right != null) {
                queue.offer(left.left);
                queue.offer(right.right);
                
                queue.offer(left.right);
                queue.offer(right.left);
            }   
        }
        return mirror;
    }
    
    public boolean isSymmetricRecurse(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricRecursive(root.left, root.right);
    }
    
    private boolean isSymmetricRecursive(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) {
            return true;
        }
        
        boolean mirror = false;
        
        if(leftNode != null && rightNode != null) {
            mirror = (leftNode.val == rightNode.val)
                && isSymmetricRecursive(leftNode.left, rightNode.right)
                && isSymmetricRecursive(leftNode.right, rightNode.left);
        }
        return mirror;
    }
}
