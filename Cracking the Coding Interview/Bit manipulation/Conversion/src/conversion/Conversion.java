/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

/**
 *
 * @author ginaj
 */
public class Conversion {

    public static int conversion(int num1, int num2) {
        
        int n = num1 ^ num2;
        int count = 0;
        /*for(int i = n; i > 0; i >>>= 1) {
            if((i & 1) == 1) {
                count++;
            }
        }*/
        
        for(int j = n; j > 0; j &= (j - 1)) {
            count++;
        }
        
        return count;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(conversion(29, 15));
        System.out.println(conversion(21, 10));
        System.out.println(conversion(20, 18));
    }
    
}
