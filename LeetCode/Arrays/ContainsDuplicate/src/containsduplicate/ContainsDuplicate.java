/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containsduplicate;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class ContainsDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(input1));
        
        int[] input2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(input2));
        
        int[] input3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(input3));
    }
    
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) {
            return false;
        }
        
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
