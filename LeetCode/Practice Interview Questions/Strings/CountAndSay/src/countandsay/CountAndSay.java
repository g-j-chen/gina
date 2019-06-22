/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countandsay;

/**
 *
 * @author ginaj
 */
public class CountAndSay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }
    
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n == 2) {
            return "11";
        }
        String s = "11";
        for(int i = 0; i < n - 2; i++) {
            s = countAndSayString(s);
        }
        return s;
    }
    
    private static String countAndSayString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        
        return sb.toString();
    }
}
