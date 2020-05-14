/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpalindromicsubstring;

/**
 *
 * @author ginaj
 */
public class LongestPalindromicSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "ab";
        String s2 = "abb";
        String s3 = "babad";
        System.out.println(longestPalindrome(s3));
        
    }
    
    public static String longestPalindrome(String s) {
        if(s == null || s.equals("")) {
            return s;
        }
        
        char[] sArray = new char[2 * s.length() + 1];
        int index = 0;
        sArray[index++] = '#';
        for(int i = 0; i < s.length(); i++) {
            sArray[index++] = s.charAt(i);
            sArray[index++] = '#';
        }
        
        int[] pArray = new int[sArray.length];
        
        int centerLine = 0;
        int right = 0;
        int maxLength = 0;
        int maxIndex = 0;
        
        for(int i = 1; i < sArray.length - 1; i++) {
            int mirrorIndex = centerLine * 2 - i;
            
            if(i < right) {
                pArray[i] = Math.min(right - i, pArray[mirrorIndex]);
            }
            
            while(i - pArray[i] >= 0 && i + pArray[i] < pArray.length && sArray[i - pArray[i]] == sArray[i + pArray[i]]) {
                pArray[i]++;
            }
            
            if(i + pArray[i] > right) {
                centerLine = i;
                right = centerLine + pArray[i];
            }
            
            if(maxLength < pArray[i]) {
                maxLength = pArray[i];
                maxIndex = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = maxIndex - pArray[maxIndex] + 1; i <= maxIndex + pArray[maxIndex] - 1; i++) {
            if(sArray[i] != '#') {
                sb.append(sArray[i]);
            }
        }
        return sb.toString();
    }
}
