/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validpalindrome;

/**
 *
 * @author ginaj
 */
public class ValidPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "").replaceAll("\\s", "");
        int j = s.length() - 1;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
}
