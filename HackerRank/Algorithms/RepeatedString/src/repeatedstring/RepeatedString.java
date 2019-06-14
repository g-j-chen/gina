/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeatedstring;

/**
 *
 * @author ginaj
 */
public class RepeatedString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "a";
        long n = 1000000000;
        
        System.out.println(repeatedString(s, n));
        
    }
    
    static long repeatedString(String s, long n) {
        long answer = 0;
        
        if(!s.contains("a")) {
            return answer;
        }
        
        long remainder = s.length() > 0 ? n % s.length() : 0;
        long remCounter = 0;
        long numReps = n / s.length();
        
        for(long i = 0; i < s.length(); i++) {
            if(i >= n) {
                break;
            }
            if(s.charAt((int) i) == 'a') {
                if(i < remainder) {
                    remCounter++;
                }
                answer++;
            }
        }
        
        return (answer * numReps) + remCounter;
    }
}
