/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    // ave: O(nlogn)
    
    private void merge(int[] left, int[] right, int[] array) {
        int nLeft = left.length;
        int nRight = right.length;
        int i = 0; //element of left array
        int j = 0; //element of right array
        int k = 0; //element of original array
        
        while(i < nLeft && j < nRight) {
            if(left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < nLeft) {
            array[k] = left[i];
            i++;
            k++;
        }
        while(j < nRight) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    
    private void mergesort(int[] array) {
        int n = array.length;
        if(n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int [(n - mid)];
        
        for(int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        
        for(int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }

        mergesort(left);        
        mergesort(right);
        
        merge(left, right, array);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {50, 6, 23, 9, 1, 42, 16, 7, 5};
        System.out.println(Arrays.toString(array));
        MergeSort ms = new MergeSort();
        ms.mergesort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
