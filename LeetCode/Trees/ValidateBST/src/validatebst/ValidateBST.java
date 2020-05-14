/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatebst;

/**
 *
 * @author ginaj
 */
public class ValidateBST {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       
       TreeNode(int x) { 
           val = x; 
       }
  }
    
    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        
        if(root == null) {
            return true;
        }
        return validBST(root, min, max);
    }
    
    
    private boolean validBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        long rootVal = (long) root.val;
        if(rootVal <= min || rootVal >= max) {
            return false;
        }
        return validBST(root.left, min, rootVal) && validBST(root.right, rootVal, max);
    }
}
