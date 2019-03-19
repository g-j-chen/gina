/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class Player {
    
    private int x;
    private int y;
    private int length;
    private int height;
    
    public Player(int length, int height) {
        this.x = 0;
        this.y = 0;
        this.length = length - 1;
        this.height = height - 1;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void command(char command) { 
        switch (command) {
            case 'w':
                if(y > 0) {
                    y--;
                }   break;
            case 's':
                if(y < height) {
                    y++;
                }   break;
            case 'a':
                if(x > 0) {
                    x--;
                }   break;
            case 'd':
                if(x < length) {
                    x++;
                }   break;
            default:
                break;
        }

    }
    
    @Override
    public String toString() {
        return "@ " + x + " " + y;
    }
    
    public String coordinates() {
        return x + "x" + y + "y";
    }
}
