/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer;

/**
 *
 * @author ginaj
 */
public class CircularBuffer {

    /**
     * @param args the command line arguments
     */
    
    private int writer;
    private int reader;
    private int count;
    private int[] buffer;
    
    public CircularBuffer(int size) {
        this.buffer = new int[size];
        this.writer = 0;
        this.reader = 0;
        this.count = 0;
    }
    
    public void add(int data) {
        if(count < buffer.length) {
            buffer[writer] = data;
            writer = increment(writer);
            count++;
        } else {
            System.out.println("Buffer is full");
        }
    }
    
    public void read() {
        if(count > 0) {
            System.out.println(buffer[reader]);
            reader = increment(reader);
            count--;
        } else {
            System.out.println("Buffer is empty");
        }
    }
    
    public void peek() {
        if(count > 0) {
            System.out.println(buffer[reader]);
        } else {
            System.out.println("Buffer is empty");
        }
    }
    
    private int increment(int n) {
        n++;
        if(n == buffer.length) {
            n = 0;
        }
        return n;
    }
    
    public void print() {
        for(int i = 0; i < buffer.length; i++) {
            System.out.println(buffer[i]);
        }
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        CircularBuffer cb = new CircularBuffer(8);
        cb.add(0);
        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.add(4);
        cb.add(5);
        cb.add(6);
        cb.add(7);
        cb.print();
        System.out.println("");
        
        for(int i = 0; i < 5; i++) {
            cb.read();
        }
        
        cb.add(8);
        System.out.println("");
        cb.print();
        
        cb.peek();
    }
    
}
