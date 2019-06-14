/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumdistances;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ginaj
 */
public class MinimumDistances {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {3, 2, 1, 2, 3};
        System.out.println(minimumDistances(a));
    }
    
    static int minimumDistances(int[] a) {
        int minDiff = a.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])) {
                map.put(a[i], i);
            } else {
                int matchingIndex = map.get(a[i]);
                if(i - matchingIndex < minDiff) {
                    minDiff = i - matchingIndex;
                }
                map.remove(a[i]);
            }
        }
        
        return minDiff != a.length ? minDiff : -1;
    }
}
