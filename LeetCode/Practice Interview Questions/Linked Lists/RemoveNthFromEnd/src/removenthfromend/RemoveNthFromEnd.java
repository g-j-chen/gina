/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removenthfromend;

/**
 *
 * @author ginaj
 */
public class RemoveNthFromEnd {
    
    public static class ListNode {
      int val;
      ListNode next;
      
      ListNode(int x) { 
          val = x; 
      }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int nodeCount = 0;
        while(curr != null) {
            nodeCount++;
            curr = curr.next;
        }
        
        int nthFromStart = nodeCount - n;
        if(nthFromStart == 0) {
            head = head.next;
            return head;
        }
        
        curr = head;
        
        for(int i = 0; i < nthFromStart - 1; i++) {
            curr = curr.next;
        }
        
        if(curr.next != null) {
            curr.next = curr.next.next;
        } else {
            curr.next = null;
        }
        
        return head;
    }
}
