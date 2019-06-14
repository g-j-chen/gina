
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ginaj
 */
public class CombatSimulator {
    private Team teamA;
    private Team teamB;

    public CombatSimulator(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }
    
    
    public void start() {           
        Team firstTeam;
        Team secondTeam;
        if (Math.random() < 0.5) {
            firstTeam = teamA;
            secondTeam = teamB;
        } else {
            firstTeam = teamB;
            secondTeam = teamA;
        }
        
        
        while(true) {   
            System.out.println(firstTeam.toString() + ":");
            firstTeam.printTeam();
            System.out.println(secondTeam.toString() + ":");
            secondTeam.printTeam();
            System.out.println("");
            
            firstTeam.attackOtherTeam(secondTeam);
            secondTeam.attackOtherTeam(firstTeam);
            
            if(!firstTeam.teamAlive()) {
                System.out.println(secondTeam.toString() + " wins!");
                secondTeam.printTeam();
                break;
            }
            if(!secondTeam.teamAlive()) {
                System.out.println(firstTeam.toString() + " wins!");
                firstTeam.printTeam();
                break;
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Team teamA = new Team("Team A");
        Team teamB = new Team("Team B");
        
        
        teamA.add(new Creature(teamA, "Guard", 16, 11, +3, "1d8+1"));
        teamA.add(new Creature(teamA, "Guard", 16, 11, +3, "1d8+1"));
        teamA.add(new Creature(teamA, "Guard", 16, 11, +3, "1d8+1"));
        
        teamB.add(new Creature(teamB, "Bugbear", 16, 27, +4, "2d8+2"));
        teamB.add(new Creature(teamB, "Kobold", 12, 5, +4, "1d4+2"));
        
        
        CombatSimulator cs = new CombatSimulator(teamA, teamB);
        cs.start();
        
        
        /*
        Creature guard = new Creature(teamA, "Guard", 16, 11, +3, "1d8+1");
        Creature guard2 = new Creature(teamA, "Guard2", 16, 11, +3, "1d8+1");
        Creature guard3 = new Creature(teamA, "Guard3", 16, 11, +3, "1d8+1");
        
        Creature bugbear = new Creature(teamB, "Bugbear", 16, 27, +4, "2d8+2");
        Creature kobold = new Creature(teamB, "Kobold", 12, 5, +4, "1d4+2");
        Creature blackBear = new Creature(teamB, "Black Bear", 11, 19, +3, "2d4+2");
        
        teamA.add(guard);
        teamA.add(guard2);
        teamA.add(guard3);
        
        teamB.add(bugbear);
        teamB.add(kobold);
        teamB.add(blackBear);
        
        System.out.println("Team A:");
        teamA.printTeam();
        System.out.println("Team B:");
        teamB.printTeam();
        System.out.println("");
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Weakest on Team B:");
            Creature weakestB = teamB.getWeakest();
            System.out.println(weakestB);
            System.out.println("");

            System.out.println("Weakest on Team A:");
            Creature weakestA = teamA.getWeakest();
            System.out.println(weakestA);
            System.out.println("");

            System.out.println("Team A attacking...");
            teamA.attackOtherTeam(teamB);
            System.out.println("Team B:");
            teamB.printTeam();

            System.out.println("Team B attacking...");
            teamB.attackOtherTeam(teamA);
            System.out.println("Team A:");
            teamA.printTeam();
        }
        */
        
    }
    
}
