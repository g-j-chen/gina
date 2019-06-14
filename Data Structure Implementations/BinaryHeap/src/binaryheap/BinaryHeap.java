/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryheap;
import java.util.NoSuchElementException;

/**
 *
 * @author ginaj
 */
public class BinaryHeap {

    /**
     * @param array
     */
    
    private int[] array;
    private int heapSize;
    
    public BinaryHeap(int arraySize) {
        this.array = new int[arraySize];
        this.heapSize = 0;
    }
    
    public int getMin() {
        return array[0];
    }
    
    public boolean isEmpty() {
        return heapSize == 0;
    }
    
    public boolean isFull() {
        return heapSize == array.length;
    }
    
    public void insert(int i) {
        if(isFull()) {
            throw new NoSuchElementException();
        }
        if(heapSize == 0) {
            array[heapSize] = i;
            heapSize++;
            return;
        }
        array[heapSize] = i;
        heapSize++;
        heapifyUp(heapSize - 1);
    }
    
    public int extractMin() {
        int min = getMin();
        swap(0, heapSize - 1);
        heapSize--;
        heapifyDown();
        return min;
    }
    
    public boolean hasLeftChild(int parentIndex) {
        return ((parentIndex * 2) + 1) < heapSize;
    }
    
    public boolean hasRightChild(int parentIndex) {
        return ((parentIndex * 2) + 2) < heapSize;
    }
    
    public int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }
    
    public void heapifyDown() {
        int p = 0;
        while(hasLeftChild(p)) {
            int lc = (p * 2) + 1;
            int rc = (p * 2) + 2;
            int smallerChild = lc;
            if(hasRightChild(p) && array[lc] > array[rc]) {
                smallerChild = rc;                
            }
            swap(p, smallerChild);
            p = smallerChild;   
        }
    }
    
    public void heapifyUp(int childIndex) {
        int temp = array[childIndex];
        while(childIndex > 0 && temp < array[parentIndex(childIndex)]) {
            swap(childIndex, parentIndex(childIndex));
            childIndex = parentIndex(childIndex);
        }
    }
    
    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    public void print() {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //int[] array = {6, 20, 3, 24, 9, 17, 2, 10, 15, 1};
        BinaryHeap bh = new BinaryHeap(5);
        bh.insert(6);
        bh.insert(20);
        bh.insert(3);
        bh.insert(24);
        bh.insert(9);
        bh.print();
        System.out.println("");
        
        
    }
    
}
