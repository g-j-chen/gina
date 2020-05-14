/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author ginaj
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(input1, 9)));
        
        int[] input2 = {1, 6, 4, 7};
        System.out.println(Arrays.toString(twoSum(input2, 10)));
    }
    
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
