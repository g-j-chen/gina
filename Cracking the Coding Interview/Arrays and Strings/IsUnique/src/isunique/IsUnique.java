/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isunique;

/**
 *
 * @author ginaj
 */
public class IsUnique {

    /**
     * @param s
     * @return 
     */
    public static boolean isUnique(String s) {
	if(s.length() > 128) {
            return false;
        }
        int[] freq = new int[128];		
	for(int i = 0; i < s.length(); i++) {
            int ascii = s.charAt(i);
		if(freq[ascii] > 0) {		
                    return false;
		}
		freq[ascii]++;
	}
	return true;
}

    public static void main(String[] args) {
        // TODO code application logic here
        boolean a = isUnique("abcde");
        System.out.println(a);
        boolean b = isUnique("aaa");
        System.out.println(b);
    }
    
}
