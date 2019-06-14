/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class HeapSort {
    //O(nlogn)
    /**
     * @param array
     */
    
    private void heapSort(int[] array) {
        int n = array.length;
        maxHeap(array);
        for(int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    
    private void maxHeap(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int p = (i - 1) / 2;
            while(array[i] > array[p]) {
               swap(array, i, p);
                i = p;
                p = (p - 1) / 2;
            }    
        }
    }
    
    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int lc = (i * 2) + 1;
        int rc = (i * 2) + 2;
        if(lc < n && array[lc] > array[largest]) {
            largest = lc;
        }
        if(rc < n && array[rc] > array[largest]) {
            largest = rc;
        }
        
        if(largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8, 45, 2, 16, 1, 20, 6, 11, 28};
                
        System.out.println(Arrays.toString(array));
        HeapSort hs = new HeapSort();
        hs.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
