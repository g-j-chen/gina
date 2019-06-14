/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author ginaj
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    private Random random;

    public PersonalBoard(int width, int height) {
        super(width, height);
        this.random = new Random();
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for(int i = 0; i < super.getWidth(); i++) {
            for(int j = 0; j < super.getHeight(); j++) {
                double d = random.nextDouble();
                getBoard()[i][j] = d <= probabilityForEachCell && probabilityForEachCell != 0;
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x >= super.getWidth() || x < 0 || 
                y >= super.getHeight() || y < 0) {
            return false;
        }
        return super.getBoard()[x][y];
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x >= 0 && x <= super.getWidth() && 
                y >= 0 && y <= super.getHeight()) {
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x >= 0 && x <= super.getWidth() && 
                y >= 0 && y <= super.getHeight()) {
            getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numberAlive = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(i < 0 || j < 0 ||
                        i >= super.getWidth() || j >= super.getHeight()) {
                    continue;
                }
                if(i == x && j == y) {
                    continue;
                }
                if(super.getBoard()[i][j] == true) {
                    numberAlive++;
                }
            }
        }
        return numberAlive;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if(isAlive(x, y)) {
            if(livingNeighbours < 2) {
                turnToDead(x, y);
            } else if(livingNeighbours > 3) {
                turnToDead(x, y);
            } else if(livingNeighbours == 2 || livingNeighbours == 3) {
                turnToLiving(x, y);
            }
        } else {
            if(livingNeighbours < 2) {
                turnToDead(x, y);
            } else if(livingNeighbours == 3) {
                turnToLiving(x, y);
            } else if(livingNeighbours > 3) {
                turnToDead(x, y);
            }
        }
    }
    
}
