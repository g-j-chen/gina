/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appendanddelete;

/**
 *
 * @author ginaj
 */
public class AppendAndDelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println(appendAndDelete("ashley", "ash", 2));
    }
    
    static String appendAndDelete(String s, String t, int k) {
        String answer = "";
        int pos = 0;
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) == t.charAt(i)) {
                pos++;
            } else {
                break;
            }
        }
        
        if((s.length() + t.length() - 2 * pos) > k) {
            answer = "No";
        } else if((s.length() + t.length() - 2 * pos) % 2 == k % 2) {
            answer = "Yes";
        } else if(s.length() + t.length() - k < 0) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        
        return answer;
    }
    
}
