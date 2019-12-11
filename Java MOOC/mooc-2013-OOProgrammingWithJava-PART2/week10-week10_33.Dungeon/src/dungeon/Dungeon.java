/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author ginaj
 */
public class Dungeon {
    
    private int length;
    private int height;
    private int movesRemaining;
    private boolean vampiresMove;
    private Scanner reader;
    private Random random = new Random();
    private Player player;
    private List<Vampire> vampires;


    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = new ArrayList<Vampire>();
        this.movesRemaining = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(this.length, this.height);
        this.reader = new Scanner(System.in);
        
        for(int i = 0; i < vampires; i++) {
            this.vampires.add(new Vampire(this.length, this.height));
        }
        
    }
    
    public void drawDungeon() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < length; x++) {
                xCoordinateLoop:
                while(true) {
                    if(player.coordinates().equals(x + "x" + y + "y")) {
                        System.out.print("@");
                        break;
                    }
                    
                    for(int i = 0; i < vampires.size(); i++) {
                        if(vampires.get(i).coordinates().equals(x + "x" + y + "y")) {
                            System.out.print("v");
                            break xCoordinateLoop;
                        }
                    }
                    System.out.print(".");
                    break;
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void printCoordinates() {
        System.out.println(movesRemaining + "\n\n" + player);
        for(Vampire v : vampires) {
            System.out.println(v);
        }
        System.out.println("");
    }
    
    public boolean checkOverlap() {
        for(int i = 0; i < vampires.size() - 1; i++) {
            for(int j = i + 1; j < vampires.size(); j++) {
                if(vampires.get(i).coordinates().equals(vampires.get(j).coordinates())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void resetInitialPositions() {
        for(Vampire v : vampires) {
            v.resetInitialPosition();
        }
    }
    
    public void playerAndVampiresMove() {
        String input = reader.nextLine();
        char[] command = input.toCharArray();
        for(int i = 0; i < command.length; i++) {
            player.command(command[i]);
            if(vampiresMove) {
                vampiresMove();
            }
            playerKillVampire();
        }
    }
    
    public void vampiresMove() {
        List<Vampire> positionsAtStartOfTurn = new ArrayList<Vampire>(vampires);
        while(true) {    
            for(Vampire v : vampires) {
                v.move();
            }
            if(checkOverlap()) {
                vampires = positionsAtStartOfTurn;
                continue;
            }
            break;
        }
    }
    
    public void playerKillVampire() {
        for(int r = 0; r < vampires.size(); r++) {
            if(vampires.get(r).coordinates().equals(player.coordinates())) {
                vampires.remove(r);
            }
        }
    }
    
    
    public void run() {

        while(movesRemaining > 0) {

            printCoordinates();
            
            while(checkOverlap()) {
                resetInitialPositions();
            }
            
            drawDungeon();
            
            playerAndVampiresMove();
            if(vampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            
            movesRemaining--;
        }
        
        if(!vampires.isEmpty()) {
            System.out.println("YOU LOSE");
        }
    }
}
