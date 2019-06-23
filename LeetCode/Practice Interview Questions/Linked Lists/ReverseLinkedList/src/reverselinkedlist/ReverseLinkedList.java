/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverselinkedlist;

/**
 *
 * @author ginaj
 */
public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { 
            val = x; 
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            if(next == null) {
                head = curr;
                break;
            } else {
                curr = next;
            }
        }
        return head;
    }
}
