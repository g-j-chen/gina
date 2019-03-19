/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author ginaj
 */
public class Square extends Figure {
    
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }
    
    

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.x, super.y, sideLength, sideLength);
    }
    
}
