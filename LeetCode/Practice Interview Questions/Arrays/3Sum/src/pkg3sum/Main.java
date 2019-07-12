/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = new int[] {-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums));
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums == null || nums.length < 2) {
            return answer;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    answer.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while(j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;

                    while(j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return answer;
    }
}
