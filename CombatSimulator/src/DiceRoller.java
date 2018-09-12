/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class DiceRoller {
    private String diceNotation;
    private int numberDice;
    private int diceType;
    private int modifier;
    
    public DiceRoller(String diceNotation) {
        this.diceNotation = diceNotation;
        
        String[] dice = diceNotation.split("d");
        this.numberDice = Integer.parseInt(dice[0]);
        
        String[] dice2 = dice[1].split("[+-]");
        this.diceType = Integer.parseInt(dice2[0]);
        
        if (dice2.length == 2) {
            this.modifier = Integer.parseInt(dice2[1]);
            if (diceNotation.contains("-")) {
                this.modifier *= -1;
            }
        }                
    }
    
    public int roll() {
        int valueRolled = 0;
        for (int i = 0; i < this.numberDice; i++) {
            valueRolled += (int)(Math.random() * this.diceType + 1);
        }
        valueRolled += this.modifier;
        if (valueRolled < 0) {
            valueRolled = 0;
        }
        return valueRolled;
    }
    
    public int critRoll() {
        int valueRolled = 0;
        for (int i = 0; i < this.numberDice * 2; i++) {
            valueRolled += (int)(Math.random() * this.diceType + 1);
        }
        valueRolled += this.modifier;
        if (valueRolled < 0) {
            valueRolled = 0;
        }
        return valueRolled;
    }
}
