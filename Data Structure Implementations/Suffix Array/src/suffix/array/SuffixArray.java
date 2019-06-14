/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suffix.array;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */

//Naive way to construct suffix array. N^2 * log N time.
public class SuffixArray {
    
    private String word;
    
    public class Pair implements Comparable {
        private Integer i;
        private String s;
        
        public Pair(Integer i, String s) {
            this.i = i;
            this.s = s;
        }
        
        public Integer getInt() {
            return this.i;
        }
        
        public String getString() {
            return this.s;
        }

        @Override
        public int compareTo(Object o) {
            return this.s.compareTo(((Pair) o).s);
        }
        
        @Override
        public String toString() {
            return this.i + " " + this.s;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    private int[] createSuffixArray(String str) {
        this.word = str;
        int n = this.word.length();
        Pair[] pairArray = new Pair[n];
        for(int i = 0; i < n; i++) {
            Pair p = new Pair(i, this.word.substring(i, n));
            pairArray[i] = p;
        }        
        
        Arrays.sort(pairArray);
        System.out.println(Arrays.toString(pairArray));
        
        int[] suffixArray = new int[n];
        for(int i = 0; i < pairArray.length; i++) {
            suffixArray[i] = pairArray[i].getInt();
        }
        System.out.println(Arrays.toString(suffixArray));
        return suffixArray;
    }
    
    private boolean contains(String pattern, int[] suffixArray) {
        System.out.println(this.word);
        int left = 0;
        int right = this.word.length() - 1;
        int mid = 0;
        int result = 0;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            int end = Math.min(this.word.length() - 1, (mid + pattern.length()));
            result = pattern.compareTo(this.word.substring(suffixArray[mid], end));
            System.out.println(result);
            
            if(result == 0) {
                System.out.println("Pattern found at index " + suffixArray[mid]);
                return true;
            }
            if(result < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Pattern not found");
        return false;
    }
    


    
    public static void main(String[] args) {
        // TODO code application logic here
        SuffixArray sufArray = new SuffixArray();
        int[] suffixArray = sufArray.createSuffixArray("banana");
        sufArray.contains("nan", suffixArray);
        
        //BetterSuffixArray bsArray = new BetterSuffixArray("banana");
        //System.out.println(bsArray);       
       
    }    
}

//Trying to write better suffix array create function...
/*
class BetterSuffixArray {
    private String base;

    BetterSuffixArray(String base) {
        Integer[] indexes = new Integer[base.length()];
        for (Integer i = 0; i < base.length(); i++) {
                indexes[i] = i;
        }

        
        Arrays.sort(indexes, (a, b) -> {
            String strA = this.base.substring(a, base.length());
            String strB = this.base.substring(b, base.length());
            return strA.compareTo(strB);
        });
    }
} */

