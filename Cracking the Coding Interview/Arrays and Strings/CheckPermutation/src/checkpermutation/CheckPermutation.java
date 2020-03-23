/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpermutation;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class CheckPermutation {

    /**
     * @param a
     * @param b
     * @return 
     */
    public static boolean isPermutation(String a, String b) {
	if(a.length() != b.length()) {
            return false;
	}
	int[] afreq = new int[128];
	for(int i = 0; i < a.length(); i++) {
            int index = a.charAt(i);
            afreq[index]++;
	}
	
        int[] bfreq = new int[128];
	for(int j = 0; j < b.length(); j++) {
            int index = b.charAt(j);
            bfreq[index]++;
	}
        
	return Arrays.equals(afreq, bfreq);
}

    public static void main(String[] args) {
        // TODO code application logic here
        boolean p = isPermutation("onep", "neo");
        System.out.println(p);
    }
    
}
