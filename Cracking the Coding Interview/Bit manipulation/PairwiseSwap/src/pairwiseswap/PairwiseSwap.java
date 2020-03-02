/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairwiseswap;

/**
 *
 * @author ginaj
 */
public class PairwiseSwap {

    public static String pairwiseSwap(int num) {
        System.out.println(Integer.toBinaryString(num));
        int answer = ((num & 0x55555555) << 1) | ((num & 0xaaaaaaaa) >>> 1);
        return Integer.toBinaryString(answer);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(pairwiseSwap(866));
        
    }
    
}
