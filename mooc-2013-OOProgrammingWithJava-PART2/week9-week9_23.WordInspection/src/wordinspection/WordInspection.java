/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ginaj
 */
public class WordInspection {
    private File file;
    
    public WordInspection(File file) {
        this.file = file;
    }
       
    public int wordCount() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        int nWords = 0;
        
        while (reader.hasNext()) {
            nWords++;
            reader.next();
        }
        return nWords;
    }
    
    public List<String> wordsContainingZ() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> zWords = new ArrayList<String>();
        
        while (reader.hasNext()) {
            String word = reader.next();
            if (word.contains("z")) {
                zWords.add(word);
            }
        }
        
        return zWords;
    }
    
    public List<String> wordsEndingInL() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> endingInL = new ArrayList<String>();
        
        while (reader.hasNext()) {
            String word = reader.next();
            if (word.endsWith("l")) {
                endingInL.add(word);
            }
        }
        
        return endingInL;
        
    }
    
    public List<String> palindromes() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> palindrome = new ArrayList<String>();
        
        while (reader.hasNext()) {
            String word = reader.next();
            int front = 0;
            int back = word.length() - 1;
            boolean isPalindrome = true;
            
            while (front < back) {
                if (word.charAt(front) != word.charAt(back)) {
                    isPalindrome = false;
                    break;
                }
                front++;
                back--;
            }
            
            if (isPalindrome) {
                palindrome.add(word);
            }
        }
        
        return palindrome;
    }
    
    
    public List<String> wordsWhichContainAllVowels() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> allVowels = new ArrayList<String>();
        char[] vowels = "aeiouyäö".toCharArray();
        
        
        while (reader.hasNext()) {
            String word = reader.next();
            boolean containsAllVowels = true;
            for (char vowel : vowels) {
                if (!word.contains("" + vowel)) {
                    containsAllVowels = false;
                    break;
                }
            }
            if (containsAllVowels) {
                allVowels.add(word);
            }
        }
        return allVowels;
    }
}
