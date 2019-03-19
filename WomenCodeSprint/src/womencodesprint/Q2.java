/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package womencodesprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ginaj
 */
public class Q2 {
    
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("yyxzz");
        names.add("zzyxx");
        names.add("zxzyy");
        names.add("zxzyy");
        names.add("zxzyy");
        names.add("xxzyy");
        names.add("wxzyy");
        names.add("vxzyy");
        names.add("uxzyy");
        names.add("txzyy");
        names.add("sxzyy");
        names.add("rxzyy");
        names.add("qxzyy");
        names.add("pxzyy");
        names.add("oxzyy");
        names.add("nxzyy");
        names.add("mxzyy");
        names.add("lxzyy");
        names.add("kxzyy");
        names.add("jxzyy");
        names.add("ixzyy");
        names.add("hxzyy");
        names.add("gxzyy");
        names.add("fxzyy");
        names.add("exzyy");
        names.add("dxzyy");
        names.add("cxzyy");
        names.add("bxzyy");
        names.add("axzyy");
        
        System.out.println(productName(names));
    }
    
    public static String productName(List<String> names) {
        List<Set<Integer>> letters = new ArrayList<>();
        List<Map<Integer, Integer>> occurence = new ArrayList<>();
        
        for(int i = 0; i < 5; i++) {
            Set<Integer> set = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < names.size(); j++) {
                int c = (int) names.get(j).charAt(i);
                set.add(c);
                if(!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    int t = map.get(c);
                    map.put(c, (t + 1));
                }
            }
            letters.add(set);
            occurence.add(map);
        }
        
        String name = "";
        
        for(int i = 0; i < 5; i++) {
            boolean flag = true;
            char c = '\0';
            for(int j = 122; j >= 97; j--) {
                if(!letters.get(i).contains(j)) {
                    flag = false;
                    c = (char) j;
                    break;
                }  
            }
            if(!flag) {
                name += c;
            } else {
                Map<Integer, Integer> sorted = new LinkedHashMap<>();
                occurence.get(i).entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
                int minValue = (int) sorted.values().toArray()[0];
                int minKey = 97;
                for(Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
                    if(entry.getValue() == minValue && entry.getKey() > minKey) {
                        minKey = entry.getKey();
                    }
                }
                name += Character.toString((char) minKey);
            }
            
        }
        
        return name;
    }
    
}
