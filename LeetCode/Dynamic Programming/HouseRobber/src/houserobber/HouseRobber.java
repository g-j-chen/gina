/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package houserobber;

/**
 *
 * @author ginaj
 */
public class HouseRobber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] rob1 = new int[] {1, 2, 3, 1};
        System.out.println(rob(rob1));
        
        int[] rob2 = new int[] {2, 7, 9, 3, 1};
        System.out.println(rob(rob2));
        
        int[] rob3 = new int[] {2, 1, 1, 2};
        System.out.println(rob(rob3));
    }
    
    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int sum = 0;
        int temp1 = nums[0];
        int temp2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int tempSum1 = temp1 + nums[i];
            int tempSum2 = temp2;
            sum = Math.max(tempSum1, tempSum2);
            temp1 = temp2;
            temp2 = sum;
        }
        return sum;
    }
}
