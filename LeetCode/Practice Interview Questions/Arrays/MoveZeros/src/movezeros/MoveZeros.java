/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movezeros;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class MoveZeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {0, 1, 0, 3, 12};
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
        
        int[] input2 = {7, 4, 0, 8, 2, 0, 10};
        moveZeroes(input2);
        System.out.println(Arrays.toString(input2));
    }
    
    public static void moveZeroes(int[] nums) {
        int numZeros = 0;
        int pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numZeros++;
            } else {
                nums[pos] = nums[i];
                pos++;
            }
        }


        while(numZeros > 0 && pos < nums.length) {
            nums[pos] = 0;
            numZeros--;
            pos++;
        }
    }
}
