/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Change {
    private char fromCharacter;
    private char toCharacter;
    
    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        String changedString = "";
        for (int i = 0; i < characterString.length(); i++) {
            if (characterString.charAt(i) == this.fromCharacter) {
                changedString += this.toCharacter;
            } else{
                changedString += characterString.charAt(i);
            }
        }
        return changedString;
        
        //return characterString.replace(fromCharacter, toCharacter);
    }
    
}
