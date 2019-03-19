/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class Quicksort {
//recursive algorithm
//Worst case: O(n2), average case: O(nlog n)
    /**
     * @param array 
     */   
    
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        int j = low;
        while(j < high) {
            if(array[j] < pivot) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                i++;
            }
            j++;
        }
        
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        
        return i;

    }
    
    private void quicksort(int[] array, int low, int high) {
        if(low < high) {        
            int partitionIndex = partition(array, low, high);

            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);       
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {5, 9, 7, 10, 2, 3, 1};
        System.out.println(Arrays.toString(array));
        Quicksort qs = new Quicksort();
        qs.quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    
}
