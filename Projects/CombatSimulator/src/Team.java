
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Team {
    private ArrayList<Creature> team;
    private String name;
    
    public Team(String name) {
        this.team = new ArrayList<>();
        this.name = name;
    }
    
    public void add(Creature creature) {
        team.add(creature);
    }
    
    public void removeCreature(Creature creature) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).equals(creature)) {
                team.remove(i);
            }
        }
    }
    
    public Creature getWeakest(Team team) {      
        Creature tempLowest = team.getCreature(0);
        for (int i = 0; i < team.teamSize(); i++) {
            if (team.getCreature(i).getCurrentHP() < tempLowest.getCurrentHP()) {
                tempLowest = team.getCreature(i);
            }
        }
        return tempLowest;
    }
    
    public void attackOtherTeam(Team otherTeam) {
        for (Creature c : this.team) {
            Creature otherWeakest = getWeakest(otherTeam);
            c.attack(otherWeakest);
            if (otherWeakest.getCurrentHP() <= 0) {
                otherTeam.removeCreature(otherWeakest);
                if (!otherTeam.teamAlive()) {
                    break;
                }
            }
        }
    }
    
    public boolean teamAlive() {
        if (team.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public int teamSize() {
        return this.team.size();
    }
    
    public void printTeam() {
        for (Creature c : this.team) {
            System.out.println(c);
        }
    }
    
    public Creature getCreature(int index) {
        return team.get(index);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
