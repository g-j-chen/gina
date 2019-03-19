
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
public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
    
    public NightSky(double density) {
        this.density = density;
        this.width = 20;
        this.height = 10;
    }
    
    public NightSky(int width, int height) {
        this.density = 0.1;
        this.width = width;
        this.height = height;
    }
    
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
    }
    
    public void printLine() {
        String skyPrint = "";
        Random rand = new Random();
        for (int i = 0; i < this.width; i++) {
            double randomNumber = rand.nextDouble();
            if (randomNumber <= this.density) {
                skyPrint += "*";
                starsInLastPrint++;
            } else {
                skyPrint += " ";
            }
            
        }
        System.out.println(skyPrint);
    }
    
    public void print() {
        starsInLastPrint = 0;
        for (int i = 0; i < this.height; i++) {
            printLine();
        }
    }
    
    public int starsInLastPrint() {
        return starsInLastPrint;
    }
}
