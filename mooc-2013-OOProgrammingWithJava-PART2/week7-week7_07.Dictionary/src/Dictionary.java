
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Dictionary {
    private HashMap<String, String> dictionary;
    
    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        }
        return null;
    }
    
    public void add(String word, String translation) {
        this.dictionary.put(word, translation);
    }
    
    public int amountOfWords() {
        return this.dictionary.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<String>();
        /*for (HashMap.Entry<String, String> entry : this.dictionary.entrySet()) {
            list.add(entry.getKey() + " = " + entry.getValue());
        }*/
        for (String key : this.dictionary.keySet()) {
            list.add(key + " = " + this.dictionary.get(key));
        }
        return list;
    }


}
