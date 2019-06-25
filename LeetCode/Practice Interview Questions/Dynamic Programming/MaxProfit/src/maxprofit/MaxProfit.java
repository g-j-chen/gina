/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxprofit;

/**
 *
 * @author ginaj
 */
public class MaxProfit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] prices1 = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));
        
        int[] prices2 = new int[] {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }
    
    public static int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int profit = 0;
        
        int i = 0;
        int j = 1;
        while(j < prices.length) {
            if(prices[i] >= prices[j]) {
                i = j;
            } else {
                profit = Math.max(profit, (prices[j] - prices[i]));
            }
            j++;
        }
        return profit;
    }
}
