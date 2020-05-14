/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package increasingtripletsubsequence;

/**
 *
 * @author ginaj
 */
public class IncreasingTripletSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = new int[] {2, 5, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
    }
    
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < first) {
                first = nums[i];
            } else if(nums[i] > first && nums[i] < second) {
                second = nums[i];
            } else if(nums[i] > second) {
                return true;
            }
        }
        return false;
    }
    
}
