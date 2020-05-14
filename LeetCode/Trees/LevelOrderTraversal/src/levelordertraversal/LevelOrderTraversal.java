/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author ginaj
 */
public class LevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) { 
            val = x;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        
        while(!nodes.isEmpty()) {
            int limit = nodes.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < limit; i++) {
                TreeNode n = nodes.remove();
                levelList.add(n.val);
                if(n.left != null) {
                    nodes.add(n.left);
                }
                if(n.right != null) {
                    nodes.add(n.right);
                }
            }
            levelOrder.add(levelList);
        }
        
        return levelOrder;
    }
}
