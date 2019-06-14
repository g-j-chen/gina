/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author ginaj
 */
public class Cow implements Alive, Milkable {
    
    private String name;
    private double udderCapacity;
    private double milkAmount;
    
    private static final String[] NAMES = new String[] {
        "Anu", "Arpa", "Essi", "Heluna", "Hely", "Hento", "Hilke", "Hilsu", "Hymy",
        "Ihq", "Ilme", "Ilo", "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", 
        "Mella", "Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length - 1)];
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.milkAmount = 0;
    }
    
    public Cow(String name) {
        this.name = name;
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.milkAmount = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCapacity() {
        return udderCapacity;
    }
    
    public double getAmount() {
        return milkAmount;
    }
    
    @Override
    public String toString() {
        return name + " " + Math.ceil(milkAmount) + "/" + Math.ceil(udderCapacity);
    }

    @Override
    public void liveHour() {
        double amount = new Random().nextDouble() * 1.3 + 0.7;
        if(milkAmount + amount > udderCapacity) {
            milkAmount = udderCapacity;
        } else {
            milkAmount += amount;
        }
    }

    @Override
    public double milk() {
        double milked = milkAmount;
        milkAmount = 0;
        return milked;
    }
    

}
