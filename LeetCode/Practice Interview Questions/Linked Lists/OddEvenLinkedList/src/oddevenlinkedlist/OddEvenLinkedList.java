/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oddevenlinkedlist;

/**
 *
 * @author ginaj
 */
public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            this.val = x;
        }
    }
    
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode currEven = head.next;
        ListNode currOdd = head;
        ListNode evenHead = currEven;
        
        while(currOdd != null && currEven != null && currOdd.next != null && currEven.next != null) {
            if(currEven.next != null) {
                currOdd.next = currOdd.next.next;
                currOdd = currOdd.next;
            }
            if(currEven != null) {
                currEven.next = currEven.next.next;
                currEven = currEven.next;
            }
        }
        currOdd.next = evenHead;
        
        return head;
    }
    
}
