/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package womencodesprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ginaj
 */
public class Q4 {
    
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        students.add("abc");
        students.add("abd");
        students.add("dbd");
        
        System.out.println(strangelyCompatible(students));
    }
    
    public static long strangelyCompatible(List<String> students) {
        long answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String s : students) {
            if(!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int n = map.get(s);
                map.put(s, (n + 1));
            }
        }
        
        List<String> set = new ArrayList<>(map.keySet());
        
        for(int i = 0; i < set.size() - 1; i++) {
            String a = set.get(i);
            for(int j = i + 1; j < set.size(); j++) {
                String b = set.get(j);
                int diff = 0;
                for(int k = 0; k < a.length(); k++) {
                    if(a.charAt(k) != b.charAt(k)) {
                        diff++;
                        if(diff > 1) {
                            break;
                        }
                    }
                }
                if(diff == 1) {
                    answer += map.get(a) * map.get(b);
                }
            }
        }
        
        return answer;
    }
}
