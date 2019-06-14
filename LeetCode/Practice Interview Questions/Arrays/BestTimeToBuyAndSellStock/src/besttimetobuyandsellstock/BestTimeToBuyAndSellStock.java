/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package besttimetobuyandsellstock;

/**
 *
 * @author ginaj
 */
public class BestTimeToBuyAndSellStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(input1));
        
        int[] input2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(input2));
        
        int[] input3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(input3));
    }
    
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 0) {
            return 0;
        }
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            } else {
                
            }
        }
        return profit;
    }
    
}
