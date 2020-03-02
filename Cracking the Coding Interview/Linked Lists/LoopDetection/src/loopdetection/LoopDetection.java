/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopdetection;


/**
 *
 * @author ginaj
 */
public class LoopDetection {

    class Node {
        Object data;
        Node next;
        
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node getStartLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if(fast == null || fast.next == null) {
            return null;
        }
        
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
