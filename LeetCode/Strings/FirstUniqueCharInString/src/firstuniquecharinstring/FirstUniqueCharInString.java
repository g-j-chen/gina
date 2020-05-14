/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstuniquecharinstring;

import java.util.HashMap;

/**
 *
 * @author ginaj
 */
public class FirstUniqueCharInString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1));
        
        String s2 = "abcdefabcdef";
        System.out.println(fasterFirstUniqChar(s2));
        
    }
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, (map.get(c) + 1));
            } else {
                map.put(c, 1);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            } 
        }
        return -1;
    }
    
    public static int fasterFirstUniqChar(String s) {
        int set = 0;
        int duplicate = 0;
        for(int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            if(((1 << ascii) & set) > 0) {
                duplicate |= (1 << ascii);
            } else {
                set |= (1 << ascii);
            }
        }
        set -= duplicate;
        for(int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i) - 'a';
            if(((1 << ascii) & set) > 0) {
                return i;
            }
        }
        return -1;
    }
}
