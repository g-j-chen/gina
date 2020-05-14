/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btinordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author ginaj
 */
public class BTInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            this.val = x;
        }
    }
    
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inOrderRecursive(root, list);
        return list;
    }
    
    private static void inOrderRecursive(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inOrderRecursive(root.left, list);
        list.add(root.val);
        inOrderRecursive(root.right, list);
    }
    
    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        
        while(curr != null || !stack.empty()) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
