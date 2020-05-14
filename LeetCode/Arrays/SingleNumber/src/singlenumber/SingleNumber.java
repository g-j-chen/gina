/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlenumber;

/**
 *
 * @author ginaj
 */
//Given a non-empty array of integers, every element appears twice except for one.
//Requirement: algorithm should have linear runtime complexity and without using extra memory.
public class SingleNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {2, 2, 1};
        System.out.println(singleNumber(input1));
        
        int[] input2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(input2));
    }
    
    public static int singleNumber(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
            answer ^= nums[i];
        }
        return answer;
    }
}
