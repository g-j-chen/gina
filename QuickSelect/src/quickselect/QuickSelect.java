/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickselect;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class QuickSelect {

    /**
     * @param args the command line arguments
     */
    
    private int partition(int[] array, int low, int high) {
        int pivot = high;
        int i = low;
        int j = low;
        while(i < high) {
            if(array[i] < array[pivot]) {
                swap(array, i, j);
                j++;
            }
            i++;
        }
        swap(array, j, pivot);
        return j;
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    private int quickSelect(int[] array, int low, int high, int k) {
        int kIndex = k - 1;
        int partitionIndex = partition(array, low, high);
        if(partitionIndex == kIndex) {
            return array[partitionIndex];
        } else if(kIndex < partitionIndex) {
            return quickSelect(array, low, partitionIndex - 1, k);
        } else {
            return quickSelect(array, partitionIndex + 1, high, k);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8, 45, 2, 16, 1, 20, 6, 11, 28};
                
        System.out.println(Arrays.toString(array));
        QuickSelect qSelect = new QuickSelect();
        int number = qSelect.quickSelect(array, 0, array.length - 1, 9);
        System.out.println(number);
    }
    
}
