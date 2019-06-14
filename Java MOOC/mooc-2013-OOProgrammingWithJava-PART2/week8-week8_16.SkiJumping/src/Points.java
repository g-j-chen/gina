
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Points {
    private int jumpLength;
    private ArrayList<Integer> votes;
    private Random random;
    
    public Points() {
        this.random = new Random();
        this.jumpLength = random.nextInt(61) + 60;
        this.votes = new ArrayList<Integer>();
        generateVotes();
    }
    
    public int getJumpLength() {
        return this.jumpLength;
    }
    
    public void generateVotes() {
        for (int i = 0; i < 5; i++) {
            votes.add(random.nextInt(11) + 10);
        }
    }
    
    public void printVotes() {
        System.out.print("[");
        for (int i = 0; i < 4; i++) {
            System.out.print(votes.get(i) + ", ");
        }
        System.out.print(votes.get(4) + "]");
    }
    
    public int calculateScore() {
        int total = 0;
        Collections.sort(votes);
        for (int i = 1; i < votes.size() - 1; i++) {
            total += votes.get(i);
        }
        return total + jumpLength;
    }
}
