/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class Radix {
    //linear time
    /**
     * @param args the command line arguments
     */
    final int RADIX = 10;
    
    private void radixSort(int[] inputArray) {
        ArrayList<Integer> bucketsArray[] = new ArrayList[RADIX];
        for(int i = 0; i < bucketsArray.length; i++) {
            bucketsArray[i] = new ArrayList<>();
        }
        
        int biggestNumber = inputArray[0];
        for(int j = 1; j < inputArray.length; j++) {
            if(inputArray[j] > biggestNumber) {
                biggestNumber = inputArray[j];
            }
        }
        int count = 0;
        while(biggestNumber != 0) {
            biggestNumber /= 10;
            count++;
        }
        
        int maxNumberDigits = count;
        
        int placeValue = 1;
        for(int pass = 0; pass < maxNumberDigits; pass++) {
            for(int k = 0; k < inputArray.length; k++) {
                int temp = inputArray[k] / placeValue;
                int remainder = temp % RADIX;
                bucketsArray[remainder].add(inputArray[k]);
            }
            int m = 0;
            for(int bucketNumber = 0; bucketNumber < RADIX; bucketNumber++) {
                for(Integer n : bucketsArray[bucketNumber]) {
                    inputArray[m] = n;
                    m++;
                }
                bucketsArray[bucketNumber].clear();
            }
            placeValue *= RADIX;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8, 45, 20, 160, 1, 2000};
        System.out.println(Arrays.toString(array));
        Radix rad = new Radix();
        rad.radixSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}
