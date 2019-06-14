/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acmteam;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class ACMTeam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] input = {"10101", "11100", "11010", "00101"};
        System.out.println(Arrays.toString(acmTeam(input)));
    }
    
    static int[] acmTeam(String[] topic) {
        int n = topic.length;
        BigInteger[] bigIntArray = new BigInteger[n];

        for(int i = 0; i < n; i++) {
            bigIntArray[i] = new BigInteger(topic[i], 2);
        }

        int noOfTeams = 0;
        int maxTopics = 0;

        for(int i = 0; i < topic.length - 1; i++) {
            for(int j = i + 1; j < topic.length; j++) {
                BigInteger iOrj = bigIntArray[i].or(bigIntArray[j]);
                int bitCount = iOrj.bitCount();
                if(bitCount > maxTopics) {
                    maxTopics = bitCount;
                    noOfTeams = 1;
                } else if(bitCount == maxTopics) {
                    noOfTeams++;
                }
            }
        }
        int answer[] = {maxTopics, noOfTeams};
        return answer;

    }
    
}
