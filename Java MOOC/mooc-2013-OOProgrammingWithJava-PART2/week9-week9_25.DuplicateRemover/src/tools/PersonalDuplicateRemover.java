/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ginaj
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> words;
    private int nDuplicates;
    
    public PersonalDuplicateRemover() {
        this.words = new HashSet<String>();
        this.nDuplicates = 0;
    }

    @Override
    public void add(String characterString) {
        if (!words.contains(characterString)) {
            words.add(characterString);
        } else {
            nDuplicates++;
        }
        
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return nDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
    }

    @Override
    public void empty() {
        words.clear();
        nDuplicates = 0;
    }
    
}
