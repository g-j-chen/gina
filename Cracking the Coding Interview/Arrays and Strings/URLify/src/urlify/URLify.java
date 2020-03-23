/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlify;

/**
 *
 * @author ginaj
 */
public class URLify {
    
    public static void urlify(String s, int strLen) {
	char[] arr = s.toCharArray();
	int numSpaces = 0;
	for(int a = 0; a < strLen; a++) {
            if(arr[a] == ' ') {
                    numSpaces++;
            }
        }
        int j = strLen + numSpaces*2 - 1;
	int i = strLen - 1;
	
	while(i != j) {
            if(arr[i] == ' ') {
                arr[j] = '0';
                arr[j - 1] = '2';
                arr[j - 2] = '%';
                j = j - 2;
            } else {
                arr[j] = arr[i];
            }
            i--;
            j--;
	}
	System.out.println(arr);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String a = "Mr John Smith      ";
        urlify(a, 13);
    }
    
}
