/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicates;

/**
 *
 * @author ginaj
 */

//Remove duplicates in place. 

public class RemoveDuplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
    
    public static int removeDuplicates(int[] nums) {
        int uniqueLength = 1;
        int i = 0;
        int j = 1;
        
        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else if(nums[j] > nums[i]) {
                swap(nums, ++i, j);
                j++;
                uniqueLength++;
            }
        }
        return uniqueLength;
    }
    
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
 
}
