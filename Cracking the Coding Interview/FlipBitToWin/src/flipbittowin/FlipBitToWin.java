/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flipbittowin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class FlipBitToWin {

    public static int flipBit(int num) {
        if(num == 0) {
            return 1;
        }
        
        List<Integer> list = new ArrayList<>();
        int binaryLength = (int)(Math.log(num) / Math.log(2) + 1);
        int index = 0;
        while(num > 0) {
            if((num & 1) == 0) {
                list.add(index);
            }
            num >>>= 1;
            index++;
        }
        
        int listSize = list.size();
        int max = 0;
        int count = 0;
        int start = 0;
        
        for(int i = 0; i < listSize; i++) {
            int currIndex = list.get(i);
            int nextIndex = 0;
            if(currIndex == list.get(listSize - 1)) {
                nextIndex = binaryLength;
            } else {
                nextIndex = list.get(i + 1);
            }
            count = nextIndex - start;
            max = Math.max(count, max);
            start = currIndex + 1;
        }
        return max;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(flipBit(1775));
        System.out.println(flipBit(1767));
        System.out.println(flipBit(16111));
        System.out.println(flipBit(15887));
    }
    
}
