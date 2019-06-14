/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndcombat;

/**
 *
 * @author ginaj
 */
public class Turn {
    private String action;
    private String bonusAction;
    private int movement;
    
    public Turn(String action, String bonusAction, int movement) {
        this.action = action;
        this.bonusAction = bonusAction;
        this.movement = movement;
    }
    
    //Actions: attack, cast spell, dash, disengage, dodge
    //Bonus actions: offhand attack, cast spell
    //Movement: stand up, move
}
