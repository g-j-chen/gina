/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intersectionoftwoarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ginaj
 */
public class IntersectionOfTwoArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, };
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
    }
    
    public static int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        if(l1 < l2) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums2) {
            if(map.containsKey(n)) {
                int count = map.get(n);
                map.put(n, ++count);
            } else {
                map.put(n, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int m : nums1) {
            if(map.containsKey(m)) {
                list.add(m);
                if(map.get(m) == 1) {
                    map.remove(m);
                } else {
                    int count = map.get(m);
                    map.put(m, --count);
                }
            }
        } 
        int[] intersection = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            intersection[i] = list.get(i);
        }
        return intersection;
    }

}
