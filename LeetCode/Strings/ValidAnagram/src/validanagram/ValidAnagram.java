/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validanagram;

/**
 *
 * @author ginaj
 */
public class ValidAnagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(isAnagram("anagram", "aaangrm"));
        System.out.println(isAnagram("rat", "cat"));
    }
    
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] comparison = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            comparison[pos] = (comparison[pos] + 1);
        }
        
        for(int j = 0; j < t.length(); j++) {
            int pos = t.charAt(j) - 'a';
            int n = comparison[pos];
            if(n == 0) {
                return false;
            }
            comparison[pos] = --n;
        }
        return true;
    }
}
