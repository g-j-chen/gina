/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class BubbleSort {
    //O(n^2)
    /**
     * @param args the command line arguments
     */
    
    private void bubbleSort(int[] array) {
        int n = array.length;
        for(int i = 0; i < n; i++) { //i is number of passes
            boolean exit = true;
            for(int j = 0; j < (n - i - 1); j++) { //as don't need to loop through the sorted section
                int c = j + 1; //c is comparison element index
                if(array[c] < array[j]) {
                    int temp = array[j];
                    array[j] = array[c];
                    array[c] = temp;
                    exit = false;
                }
                
            }
            if(exit) { //if already sorted, break out of loop to avoid excess passes
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8, 45, 2, 16, 1, 20, 6};
        BubbleSort bs = new BubbleSort();
        System.out.println(Arrays.toString(array));
        bs.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
