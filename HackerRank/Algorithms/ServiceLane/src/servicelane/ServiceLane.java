/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicelane;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class ServiceLane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] width = {2, 3, 1, 2, 3, 2, 3, 3};
        int[][] cases = {{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}};
        System.out.println(Arrays.toString(serviceLane(width, cases)));
    }
    
    static int[] serviceLane(int[] width, int[][] cases) {
        int[] answer = new int[cases.length];

        for(int i = 0; i < cases.length; i++) {
            int start = cases[i][0];
            int end = cases[i][1];
            int minWidth = Integer.MAX_VALUE;
            while(start <= end) {
                minWidth = width[start] < minWidth ? width[start] : minWidth;
                start++;
            }
            answer[i] = minWidth;
        }
        return answer;
    }
}
