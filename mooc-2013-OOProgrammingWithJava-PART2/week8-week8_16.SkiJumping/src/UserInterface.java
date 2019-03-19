
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class UserInterface {
    private Scanner reader;
    private Tournament tournament;
    
    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.tournament = new Tournament();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        addJumpers();
        playTournament();
    }
    
    public void addJumpers() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            
            if (name.isEmpty()) {
                break;
            }
            this.tournament.addJumper(name);
            
        }
    }
    
    public void playTournament() {
        System.out.println("\nThe tournament begins!");
        
        while (true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            
            if(input.equals("jump")) {
                System.out.println("\nRound " + this.tournament.getRound());
                System.out.println();
                System.out.println("Jumping order:");
                this.tournament.printJumpOrder();
                System.out.println();
                this.tournament.playRound();
            } else {
                System.out.println("\nThanks!\n");
                this.tournament.printFinalResults();
                break;
            }
        }
    }
}
