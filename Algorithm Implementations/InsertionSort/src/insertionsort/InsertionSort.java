/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class InsertionSort {
    //O(n^2)
    /**
     * @param args the command line arguments
     */
    
    private void insertionSort(int[] array) {
        int n = array.length;
        for(int i = 1; i < n; i++) { //interating through unsorted array subset
            int temp = array[i];
            int blank = i;
            while(blank > 0 && array[blank - 1] > temp) {
                array[blank] = array[blank - 1];
                blank--;
            }
            array[blank] = temp;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8, 45, 2, 16, 1, 20, 6, 11, 28};
                
        System.out.println(Arrays.toString(array));
        InsertionSort is = new InsertionSort();
        is.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
