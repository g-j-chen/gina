/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedarraytotree;

/**
 *
 * @author ginaj
 */
public class SortedArrayToTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) { 
            val = x;
        }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        
        return convertToTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode convertToTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int middle = (start + end + 1) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = convertToTree(nums, start, middle - 1);
        node.right = convertToTree(nums, middle + 1, end);
        
        return node;
    }
}
