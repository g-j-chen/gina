/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addtwonumbers;

/**
 *
 * @author ginaj
 */
public class AddTwoNumbers {

    /**
     */
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerHead = new ListNode(0);
        ListNode curr = answerHead;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) {
                p = p.next;
            }
            if(q != null) {
                q = q.next;
            }            
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
                                                                                                         
            
        return answerHead.next;
    }
    
}
