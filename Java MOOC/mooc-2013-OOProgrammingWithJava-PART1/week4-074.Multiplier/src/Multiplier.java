/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Multiplier {
    private int number;
    
    public Multiplier(int numberGiven) {
        this.number = numberGiven;
    }
    
    public int multiply(int otherNumber) {
        return this.number * otherNumber;
    }
}
