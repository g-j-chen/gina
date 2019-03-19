/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author ginaj
 */
public class Worm {
    
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> worm;
    private boolean grow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(x, y));
        this.grow = false;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        direction = dir;
    }
    
    public int getLength() {
        return worm.size();
    }
    
    public List<Piece> getPieces() {
        return worm;
    }
    
    public void move() {
        int newX = worm.get(worm.size() - 1).getX();
        int newY = worm.get(worm.size() - 1).getY();
        
        if(null != direction) switch (direction) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                break;
        }
        if(getLength() > 2 && !grow) {
            worm.remove(0);
        }
        
        if(grow == true) {
            grow = false;
        }
        
        worm.add(new Piece(newX, newY));
    }
    
    public void grow() {
        grow = true;
    }
    
    public boolean runsInto(Piece piece) {
        for(Piece p : worm) {
            if(p.getX() == piece.getX() && p.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean runsIntoItself() {
        int headX = getWormHead().getX();
        int headY = getWormHead().getY();
        
        for(int i = 0; i < worm.size() - 1; i++) {
            if(worm.get(i).getX() == headX && worm.get(i).getY() == headY) {
                return true;
            }
        }
        
        return false;
    }
    
    public Piece getWormHead() {
        return worm.get(getLength() - 1);
    }
}
