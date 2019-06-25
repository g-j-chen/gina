/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climbingstairs;

/**
 *
 * @author ginaj
 */
public class ClimbingStairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(climbStairs(10));
    }
    
    public static int climbStairs(int n) {
        int[] array = new int[n + 1];
        return recClimbStairs(n, array);
    }
    
    private static int recClimbStairs(int n, int[] array) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        
        if(array[n] != 0) {
            return array[n];
        }
        int result = recClimbStairs(n - 1, array) + recClimbStairs(n - 2, array);
        array[n] = result;
        
        return result;
    }
}
