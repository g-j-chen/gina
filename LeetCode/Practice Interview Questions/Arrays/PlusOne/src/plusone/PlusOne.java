/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plusone;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class PlusOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input1 = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(input1)));
        
        int[] input2 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(input2)));
        
        int[] input3 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(input3)));
    }
    
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int l = digits.length - 1;
        int n = digits[l];
        n = n + 1;
        if(n > 9) {
            carry = 1;
            n %= 10;
        }
        digits[l] = n;

        while(carry != 0 && l > 0) {
            n = digits[--l];
            n = n + carry;
            if(n > 9) {
                carry = 1;
                n %= 10;
            } else {
                carry = 0;
            }
            digits[l] = n;
        }
        
        
        if(carry != 0) {
            int[] longerDigits = new int[digits.length + 1];
            longerDigits[0] = carry;
            int i = 1;
            int j = 0;
            while(i < longerDigits.length && j < digits.length) {
                longerDigits[i] = digits[j];
                i++;
                j++;
            }
            return longerDigits;
        }
        return digits;
    }
}
