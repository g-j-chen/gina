/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ginaj
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        
        HashMap<String, Integer> stringMap = new HashMap<>();
        int key = 0;
        
        for(String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tString = new String(temp);
            if(!stringMap.containsKey(tString)) {
                stringMap.put(tString, key);
                key++;
                List<String> anagram = new ArrayList<>();
                anagram.add(str);
                answer.add(anagram);
            } else {
                int index = stringMap.get(tString);
                answer.get(index).add(str);
            }
        }
        return answer;
    }
    
}
