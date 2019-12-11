/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author ginaj
 */
public class Vampire {
    
    private int x;
    private int y;
    private int length;
    private int height;
    private Random random = new Random();
    
    public Vampire(int length, int height) {
        this.length = length;
        this.height = height;
        this.x = random.nextInt(length);
        this.y = random.nextInt(height);
        
        initialPositionNotZero();
    }
    
    public void initialPositionNotZero() {
        while(x == 0) {
            x = random.nextInt(length);
        }
        while(y == 0) {
            y = random.nextInt(height);
        }
    }
    
    public void resetInitialPosition() {
        x = random.nextInt(length);
        y = random.nextInt(height);
        
        initialPositionNotZero();
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void move() {
        int direction = random.nextInt(4);
        switch(direction) {
            case 0:
                if(y > 0) {
                    y--;
                }   break;
            case 1:
                if(y < height - 1) {
                    y++;
                }   break;
            case 2:
                if(x > 0) {
                    x--;
                }   break;
            case 3:
                if(x < length - 1) {
                    x++;
                }   break;
            default:
                break;
        }
    }
    
    @Override
    public String toString() {
        return "v " + x + " " + y;
    }
    
    public String coordinates() {
        return x + "x" + y + "y";
    }
    
}
