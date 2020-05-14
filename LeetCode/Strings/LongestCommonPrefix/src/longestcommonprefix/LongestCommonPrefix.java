/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonprefix;

/**
 *
 * @author ginaj
 */
public class LongestCommonPrefix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] array = new String[] {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(array));
        
        String[] array2 = new String[] {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(array2));
    }
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
