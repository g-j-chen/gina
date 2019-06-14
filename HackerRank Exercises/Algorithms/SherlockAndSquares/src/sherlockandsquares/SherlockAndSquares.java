/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sherlockandsquares;

/**
 *
 * @author ginaj
 */
public class SherlockAndSquares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(squares(3, 9));
        System.out.println(squares(17, 24));
    }
    
     static int squares(int a, int b) {
        int answer = 0;
        int lower = (int) Math.sqrt(a);
        int upper = (int) Math.sqrt(b);
        for(int i = lower; i <= upper; i++) {
            if(Math.pow(i, 2) >= a && Math.pow(i, 2) <= b) {
                answer++;
            }
        }
        return answer;
    }
    
}
