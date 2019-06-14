
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
    private String teamName;
    private ArrayList<Player> players;
    private int maxSize;
    
    public Team(String name) {
        this.teamName = name;
        this.players = new ArrayList<Player>();
        this.maxSize = 16;
    }
    
    
    public String getName() {
        return this.teamName;
    }
    
    public void addPlayer(Player name) {
        if (this.players.size() < this.maxSize) {
            this.players.add(name);
        }
    }
    
    public void printPlayers() {
        String temp = "";
        for (Player players : this.players) {
            temp += players + "\n";            
        }
        System.out.println(temp);
    }
    
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    
    public int size() {
        return this.players.size();
    }
    
    public int goals() {
        int teamGoals = 0;
        for (Player players : this.players) {
            teamGoals += players.goals();
        }
        return teamGoals;
    }
}
