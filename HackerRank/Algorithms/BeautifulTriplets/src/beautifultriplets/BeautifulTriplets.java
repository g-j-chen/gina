/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautifultriplets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class BeautifulTriplets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1, 2, 4, 5, 7, 8, 10};
        System.out.println(beautifulTriplets(3, array));
    }
    
    static int beautifulTriplets(int d, int[] arr) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(list.contains(list.get(i) + d) && list.contains(list.get(i) + 2 * d)) {
                answer++;
            }
        }
        
        return answer;
    }
}
