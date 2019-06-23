/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergetwolists;


/**
 *
 * @author ginaj
 */
public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) { 
            val = x; 
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode answerHead = new ListNode(0);
        ListNode current = answerHead;        
        
        while(l1 != null || l2 != null) {
            if((l1 != null && l2 != null && l1.val <= l2.val) || (l1 != null && l2 == null)) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            current = current.next;

        }
        
        return answerHead.next;
    }
}
