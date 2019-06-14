/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;
import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 *
 * @author ginaj
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    
    private LinkedList<Integer> stack;
    private int front;
    
    public Stack() {
        this.stack = new LinkedList<>();
        this.front = 0;
    }
    
    public void push(int data) {
        if(isEmpty()) {
            stack.addFirst(data);
        } else {
            stack.add(data);
        }
        front++;
    }
    
    public void pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        stack.removeLast();
        front--;
    }
    
    public boolean isEmpty() {
        return front == 0;
    }
    
    public void peek() {
        System.out.println(stack.peekLast());
    }
    
    public void print() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        stack.forEach((i) -> {
            System.out.println(i);
        });
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        Stack s = new Stack();
        s.print();
    }
    
}
