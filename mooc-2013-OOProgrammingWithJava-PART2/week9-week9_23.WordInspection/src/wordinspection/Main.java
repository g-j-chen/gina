package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection w = new WordInspection(file);
        
        System.out.println(w.wordCount());
        System.out.println(w.wordsContainingZ());
        System.out.println(w.wordsEndingInL());
        System.out.println(w.palindromes());
        System.out.println(w.wordsWhichContainAllVowels());

    }
}
