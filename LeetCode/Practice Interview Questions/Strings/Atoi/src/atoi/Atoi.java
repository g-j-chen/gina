/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atoi;

/**
 *
 * @author ginaj
 */
public class Atoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "18446744073709551617";
        System.out.println(myAtoi(s));
        
    }
    
    public static int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        
        boolean num = false;
        boolean negative = false;
        long sum = 0;
        int plusOrMinusCount = 0;
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ' ') {
                break;
            }
            
            if(c == '+' || c == '-') {
                if(num) {
                    break;
                }
                if(c == '-') {
                    negative = true;
                }
                plusOrMinusCount++;
                if(plusOrMinusCount > 1) {
                    break;
                }
                continue;
            }
            
            if(c < 48 || c > 57) {
                break;
            }
            
            sum = sum * 10 + (c - '0');
            num = true;
            
            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        
        
        int result = (int) sum;
        
        return negative ? 0 - result : result;
    }
}
