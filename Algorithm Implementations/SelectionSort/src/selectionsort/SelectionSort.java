/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class SelectionSort {
    //O(n^2)
    /**
     * @param args the command line arguments
     */
    
    private void selectionSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++) { //i is counter for smallest number index
            for(int j = (i + 1); j < n; j++) { //j is counter for comparison index
                if(array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SelectionSort ss = new SelectionSort();
        int[] array = {8, 45, 2, 16, 1, 20, 6};
        System.out.println(Arrays.toString(array));
        ss.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
