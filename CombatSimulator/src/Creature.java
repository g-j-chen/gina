/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Creature {
    private Team team;
    private String creatureName;
    private int armourClass;
    private int maxPoints;
    private int attackModifier;
    private String attackDamage;
    private int currentHP;
    
    public Creature(Team team, String creatureName, int armourClass, int maxPoints, int attackModifier, String attackDamage) {
        this.team = team;
        this.creatureName = creatureName;
        this.armourClass = armourClass;
        this.maxPoints = maxPoints;
        this.attackModifier = attackModifier;
        this.attackDamage = attackDamage;
        this.currentHP = maxPoints;
    }
    
    public int attack(Creature creature) {
        DiceRoller a = new DiceRoller("1d20");
        int attackRoll = a.roll();
        DiceRoller d = new DiceRoller(this.attackDamage);
        int damageRoll = 0;
        if (attackRoll == 20) {
            damageRoll = d.critRoll();
        } else if (attackRoll + this.attackModifier >= creature.armourClass) {
            damageRoll = d.roll();
        }
        creature.takeDamage(damageRoll);
        if (creature.getCurrentHP() <= 0) {
            creature.team.removeCreature(creature);
        }
        return damageRoll;
    } 
    
    public int takeDamage(int damage) {
        return this.currentHP -= damage;
    }
    
    
    @Override
    public String toString() {
        return this.creatureName + ", HP: " + this.currentHP;
    }
    
    public int getCurrentHP() {
        return this.currentHP;
    }
    
    public int getArmourClass() {
        return this.armourClass;
    }
    
}
