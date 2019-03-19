/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ginaj
 */
public class MindfulDictionary {
    
    private Map<String, String> finnishToEnglish;
    private Map<String, String> englishToFinnish;
    private File file;
    
    public MindfulDictionary() {
        this.finnishToEnglish = new HashMap<String, String>();
        this.englishToFinnish = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this();
        this.file = new File(file);
    }
    
    public void add(String word, String translation) {
        if(!finnishToEnglish.containsKey(word)) {
            finnishToEnglish.put(word, translation);
            englishToFinnish.put(translation, word);
        }
    }
    
    public String translate(String word) {
        if(finnishToEnglish.containsKey(word)) {
            return finnishToEnglish.get(word);
        }
        if(englishToFinnish.containsKey(word)) {
            return englishToFinnish.get(word);
        }
        return null;
    }
    
    public void remove(String word) {
        if(finnishToEnglish.containsKey(word)) {
            String translation = finnishToEnglish.remove(word);
            englishToFinnish.remove(translation);
        }
        if(englishToFinnish.containsKey(word)) {
            String translation = englishToFinnish.remove(word);
            finnishToEnglish.remove(translation);
        }
    }
    
    public boolean load() {
        try {
            Scanner reader = new Scanner(file);
            
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split(":");
                add(words[0], words[1]);
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
    
    public boolean save() {
        try {
            FileWriter writer = new FileWriter(file);
            for(String word : finnishToEnglish.keySet()) {
                writer.write(word + ":" + finnishToEnglish.get(word) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
