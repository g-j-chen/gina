/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalizearray;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ginaj
 */
public class EqualizeArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {3, 3, 2, 1, 3};
        System.out.println(equalizeArray(arr));
    }
    
    static int equalizeArray(int[] arr) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, (map.get(i) + 1));
                if(map.get(i) > max) {
                    max = map.get(i);
                }
            }
        }

        return arr.length - max;
    }
    
}
