/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ginaj
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dictionary;
    
    public PersonalMultipleEntryDictionary() {
        this.dictionary = new HashMap<String, Set<String>>();
    }
    
    @Override
    public void add(String word, String entry) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, new HashSet());
        }
        dictionary.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if (!dictionary.containsKey(word)) {
            return null;
        }
        return dictionary.get(word);
    }

    @Override
    public void remove(String word) {
        dictionary.remove(word);
    }
    
    
}
