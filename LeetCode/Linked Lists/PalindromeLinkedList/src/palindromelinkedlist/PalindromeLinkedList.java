/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromelinkedlist;

import java.util.Stack;

/**
 *
 * @author ginaj
 */
public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { 
            val = x; 
        }
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        int listSize = 0;
        while(curr != null) {
            listSize++;
            curr = curr.next;
        }
        
        boolean even = (listSize % 2 == 0);
        int half = listSize / 2;
        
        Stack<Integer> stack = new Stack<>();
        curr = head;
        
        for(int i = 0; i < half; i++) {
            stack.push(curr.val);
            curr = curr.next;
        }
        if(!even) {
            curr = curr.next;
        }
        
        while(!stack.empty() && curr != null) {
            int n = stack.pop();
            if(curr.val != n) {
                return false;
            }
            curr = curr.next;
        }
        
        return true;
    }
}
