/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumpingonclouds;

/**
 *
 * @author ginaj
 */
public class JumpingOnClouds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] c = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c));
        
    }
    
    static int jumpingOnClouds(int[] c) {
        int jumps = -1;
        for(int i = 0; i < c.length; i++) {
            jumps++;
            if(i + 2 < c.length && c[i + 2] == 0) {
                i++;
            }
        }
        return jumps;
    }
    
}
