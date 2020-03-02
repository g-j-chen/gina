/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextnumber;

/**
 *
 * @author ginaj
 */
public class NextNumber {

    public static void nextNumber(int num) {
        System.out.println("Number: " + num);
        int temp = num;
        boolean trailingZero = true;
        int oneToZero = 0;
        int p = 0;
        int index = 0;
        while(temp > 0) {
            if((temp & 1) == 1) {
                oneToZero = index;
                trailingZero = false;
            }
            if((temp & 1) == 0 && !trailingZero) {
                p = index;
                break;
            }
            index++;
            temp >>= 1;
        }
        int mask = 1 << p;
        int getNext = (num | mask) & ~(1 << oneToZero);
        System.out.println("Next largest: " + getNext);
        
        temp = num;
        index = 0;
        boolean gotP = false;
        p = 0;
        oneToZero = 0;
        if((temp & 1) == 1) {
            oneToZero = (int)(Math.log(num) / Math.log(2));
            for(int i = oneToZero - 1; i >= 0; i--) {
                if((temp & 1 << i) == 0) {
                    p = i;
                    break;
                }
            }
        } else {
            while(temp > 0) {
                if((temp & 1) == 0) {
                    p = index;
                    gotP = true;
                }
                if((temp & 1) == 1 && gotP) {
                    oneToZero = index;
                    break;
                }
                index++;
                temp >>= 1;
            }
        }
        mask = 1 << p;
        int getPrev = (num | mask) & ~(1 << oneToZero);
        System.out.println("Next smallest: " + getPrev + "\n");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        nextNumber(11);
        nextNumber(404);
    }
    
}
