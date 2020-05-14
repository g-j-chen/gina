/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcolours;

import java.util.Arrays;

/**
 *
 * @author gina
 */
public class SortColours {

    /**
     * @param args the command line arguments
     * int array
     * 0 = red
     * 1 = white
     * 2 = blue
     * sort by ascending number
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = new int[] {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortColours(arr)));
        
    }
    
    public static int[] sortColours(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for(int i : nums) {
            switch(i) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
                default:
                    System.out.println("Number not recognized");
            }
        }
        
        int i = 0;
        while(red > 0) {
            nums[i] = 0;
            red--;
            i++;
        }
        while(white > 0) {
            nums[i] = 1;
            white--;
            i++;
        }
        while(blue > 0) {
            nums[i] = 2;
            blue--;
            i++;
        }
        
        return nums;
    }
    
    public static int[] sortColoursOnePass(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            if(nums[i] == 2) {
                swap(nums, i, j);
                j--;
            }
            if(nums[i] == 1) {
                i++;
                j--;
            }
            if(nums[i] == 0) {
                i++;
            }
        }
        return nums;
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
