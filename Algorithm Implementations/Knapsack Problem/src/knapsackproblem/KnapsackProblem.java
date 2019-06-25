/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author ginaj
 */
public class KnapsackProblem {
    //Implementing a 0-1 algorithm for the Knapsack Problem
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] value = new int[] {0, 100, 20, 60, 40};
        int[] weight = new int[] {0, 3, 2, 4, 1};
        System.out.println(knapsack(value, weight, 5));
    }
    
    public static int knapsack(int[] value, int[] weight, int capacity) {
        int[][] mem = new int[value.length + 1][capacity + 1];
        return recKnapsack(value, weight, value.length - 1, capacity, mem);
    }
    
    private static int recKnapsack(int[] value, int[] weight, int n, int capacity, int[][] mem) {
        if(mem[n][capacity] != 0) {
            return mem[n][capacity];
        }
        
        int result = 0;
        if(n == 0 || capacity == 0) {
            result = 0;
        } else if(weight[n] > capacity) {
            result = recKnapsack(value, weight, n - 1, capacity, mem);
        } else {
            int temp1 = recKnapsack(value, weight, n - 1, capacity, mem);
            int temp2 = value[n] + recKnapsack(value, weight, n - 1, capacity - weight[n], mem);
            result = Math.max(temp1, temp2);
        }
        mem[n][capacity] = result;
        return result;
    }
}
