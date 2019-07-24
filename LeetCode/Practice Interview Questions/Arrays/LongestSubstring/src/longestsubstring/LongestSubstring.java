/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ginaj
 */
public class LongestSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));
        
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0;
        Map<Character, Integer> duplicates = new HashMap<>();
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(duplicates.containsKey(s.charAt(i))) {
                j = Math.max(duplicates.get(s.charAt(i)), j);
            }
            longestSubstring = Math.max(longestSubstring, i - j + 1);
            duplicates.put(s.charAt(i), i + 1);
        }
        return longestSubstring;
    }
    
}
