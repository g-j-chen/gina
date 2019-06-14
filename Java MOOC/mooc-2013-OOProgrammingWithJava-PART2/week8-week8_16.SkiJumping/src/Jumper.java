
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Jumper implements Comparable<Jumper> {
    private String name;
    private Map<Integer, Points> points;
    
    public Jumper(String name) {
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public void jump(int round) {
        points.put(round, new Points());
    }
    
    public int totalScore() {
        int total = 0;
        for (Points p : points.values()) {
            total += p.calculateScore();
        }
        return total;
    }
               
    @Override
    public int compareTo(Jumper other) {
        return this.totalScore() - other.totalScore();
    }
    
    public void printRoundLength(int round) {
        Points roundPoints = points.get(round);
        System.out.println(roundPoints.getJumpLength());
    }
    
    public void printLengths() {
        for (int i = 1; i <= this.points.size(); i++) {
            if (i < this.points.size()) {
                System.out.print(this.points.get(i).getJumpLength() + "m, ");
            } else {
                System.out.print(this.points.get(i).getJumpLength() + "m");
            }
        }
    }
    
    public void printJumpResults(int round) {
        System.out.println("  " + this.name);
        System.out.println("    length: " + this.points.get(round).getJumpLength());
        System.out.print("    judge votes: ");
        this.points.get(round).printVotes();
        System.out.println();
    }
    
}
