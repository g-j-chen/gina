/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author ginaj
 */
public class Queue {

    /**
     * @param args the command line arguments
     */
    //Arrays will be fixed size queues, linked lists will be flexible sized queues
    
    private int front;
    private int rear;
    private int[] queue;
    private int count;
    
    public Queue(int size) {
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }
    
    public boolean isEmpty() {
        return (count == 0);
    }
    
    public boolean isFull() {
        return (count == queue.length);
    }   
    
    public void enqueue(int data) {
        if(!isFull()) {
            queue[front] = data;
            front = moveIndexForward(front); //front = (front + 1)%queue.length; same for rear
            count++;
        } else { 
            System.out.println("Queue is full");
            /*overflows:
            queue[front] = data;
            front = moveIndexForward(front);
            rear = moveIndexForward(rear);*/
        }
    }
    
    public void dequeue() {
        if(count > 0) {
            System.out.println(queue[rear]);
            rear = moveIndexForward(rear);
            count--;
        } else {
            System.out.println("Queue is empty");
        }
    }
    
    public void print() {
        for(int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }
    
    public void peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println(queue[rear]);
        }
    }
    
    private int moveIndexForward(int n) {
        n++;
        if(n == queue.length) {
            n = 0;
        }
        return n;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Queue q = new Queue(6);
        
        q.enqueue(0);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.print();
        System.out.println("");
        
        q.enqueue(6);
        q.print();
        q.peek();
    }
    
}
