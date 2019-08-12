/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitinsertion;

/**
 *
 * @author ginaj
 */
public class BitInsertion {

    public static String bitInsertion(int n, int m, int i, int j) {
        for(int k = i; k <= j; k++) {
            n = clearBit(n, k);
        }
        m <<= i;
        n = n | m;
        return Integer.toBinaryString(n);
    }
    
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Integer.toBinaryString(1072));
        System.out.println(Integer.toBinaryString(19));
        System.out.println(bitInsertion(1072, 19, 2, 6));
        
        System.out.println(Integer.toBinaryString(2047));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(bitInsertion(2047, 16, 2, 6));
    }
    
}
