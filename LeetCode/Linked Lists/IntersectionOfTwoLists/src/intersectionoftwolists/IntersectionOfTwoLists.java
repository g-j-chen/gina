/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersectionoftwolists;

import java.util.HashSet;

/**
 *
 * @author ginaj
 */
public class IntersectionOfTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }
    
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while(curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        
        ListNode answer = null;
        curr = headB;
        while(curr != null) {
            if(set.contains(curr)) {
                answer = curr;
                break;
            }
            curr = curr.next;
        }
        return answer;
    }
    
    public static ListNode betterSpaceSolution(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        int len1 = 0;
        ListNode currB = headB;
        int len2 = 0;
        
        while(currA != null) {
            len1++;
            currA = currA.next;
        }
        while(currB != null) {
            len2++;
            currB = currB.next;
        }
        
        int diff = Math.abs(len1 - len2);
        currA = headA;
        currB = headB;
        
        if(len1 > len2) {
            while(diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else {
            while(diff > 0) {
                currB = currB.next;
                diff--;
            }
        }
        
        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
