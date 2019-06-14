/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taumbday;

/**
 *
 * @author ginaj
 */
public class TaumBday {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(taumBday(10, 10, 1, 1, 1));
        System.out.println(taumBday(5, 9, 2, 3, 4));
        System.out.println(taumBday(3, 6, 9, 1, 1));
        System.out.println(taumBday(7, 7, 4, 2, 1));
        System.out.println(taumBday(3, 3, 1, 9, 2));
    }
    
    static long taumBday(long b, long w, long bc, long wc, long z) {
        long answer = 0;
        if(Math.abs(bc - wc) > z) {
            long leastCost = Math.min(bc, wc);
            if(leastCost == bc) {
                answer = ((b + w) * bc) + (w * z);
            } else {
                answer = ((b + w) * wc) + (b * z);
            }
        } else {
            answer = (b * bc) + (w * wc);
        }
        return answer;
    }
}
