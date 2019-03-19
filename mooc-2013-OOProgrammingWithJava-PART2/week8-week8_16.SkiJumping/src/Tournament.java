
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Tournament {
    private int round;
    private ArrayList<Jumper> jumpers;
    private Points points;
    
    public Tournament() {
        this.jumpers = new ArrayList<Jumper>();
        this.round = 1;
        this.points = new Points();
    }
    
    public void addJumper(String name) {
        this.jumpers.add(new Jumper(name));
    }
    
    public int getRound() {
        return this.round;
    }
    
    public void playRound() {
        sortJumpers();
        for (Jumper j : jumpers) {
            j.jump(this.round);
        }
        printRoundResults();
        this.round++;
    }
    
    public void sortJumpers() {
        Collections.sort(jumpers);
    }
    
    public void printJumpOrder() {
        sortJumpers();
        int i = 1;
        for (Jumper j : jumpers) {
            System.out.println("  " + i + ". " + j.getName() + " (" + j.totalScore() + " points)");
            i++;
        }
    }
    
    public void printRoundResults() {
        System.out.println("Results of round " + this.round);
        for (Jumper j : jumpers) {
            j.printJumpResults(this.round);
            
        }
    }
    
    public void printFinalResults() {
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        for (int i = 0; i < jumpers.size(); i++) {
            Jumper j = jumpers.get(i);
            
            System.out.println((i + 1) + "           " + j.getName() + " (" + j.totalScore() + " points)");
            System.out.print("            jump lengths: ");
            j.printLengths();
            System.out.print("\n");
        }
    }
    
    
}
