/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package womencodesprint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ginaj
 */
public class Q3 {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
       
        
        System.out.println(visuallyBalancedSections(list));
    }
    
    public static int visuallyBalancedSections(List<Integer> colors) {
        int n = 0;
        for(int i = 0; i < colors.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < colors.size(); j++) {
                if(!set.contains(colors.get(j))) {
                    set.add(colors.get(j));
                } else {
                    set.remove(colors.get(j));
                }
                if(set.size() == 1 || set.isEmpty()) {
                    n++;
                }
            }
        }
        return n;
    }
}
