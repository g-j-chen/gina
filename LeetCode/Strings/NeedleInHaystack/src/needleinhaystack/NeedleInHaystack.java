/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package needleinhaystack;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class NeedleInHaystack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(fasterStrStr("mississippi", "issip"));
        
    }
    
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) {
            return 0;
        }
        if(needle.length() > haystack.length()) {
            return -1;
        }
        
        ArrayList<Integer>[] letters = new ArrayList[26];
        
        for(int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            int pos = (int) c - 'a';
            if(letters[pos] == null) {
                letters[pos] = new ArrayList<>();
            }
            letters[pos].add(i);
        }
        
        int n = (int) needle.charAt(0) - 'a';
        
        if(letters[n] != null) {
            for(int i : letters[n]) {
                if(i + needle.length() > haystack.length()) {
                    return -1;
                }
                int tempIndex = i;
                int j;
                for(j = 0; j < needle.length(); j++) {
                    if(needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    }
                }
                if(j == needle.length()) {
                    return tempIndex;
                }
            }
        }
        return -1;
    }
    
    //faster method and less memory use. Then I realised I can just use haystack.indexOf(needle).....
    public static int fasterStrStr(String haystack, String needle) {
        if(needle.isEmpty()) {
            return 0;
        }
        for(int i = 0; i < haystack.length() - needle.length(); i++) {
            String s = haystack.substring(i, i + needle.length());
            if(s.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
