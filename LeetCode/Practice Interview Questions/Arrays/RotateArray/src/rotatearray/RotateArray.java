/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotatearray;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */

//Rotate array in place
public class RotateArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        rotate(input, 3);
        System.out.println(Arrays.toString(input));
    }
    
    public static void rotate(int[] nums, int k) {
        while(k > 0) {
            int temp = nums[nums.length - 1];
            for(int i = nums.length - 1; i >= 0; i--) {
                if(i == 0) {
                    nums[i] = temp;
                } else {
                    nums[i] = nums[i - 1];
                }
            }
            k--;
            
        }
    }
}
