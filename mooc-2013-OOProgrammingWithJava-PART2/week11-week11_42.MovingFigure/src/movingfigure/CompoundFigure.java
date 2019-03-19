/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class CompoundFigure extends Figure {
    
    private ArrayList<Figure> compoundFigure;
    
    public CompoundFigure(int x, int y) {
        super(x, y);
        this.compoundFigure = new ArrayList<Figure>();
    }

    public CompoundFigure() {
        super(0, 0);
        this.compoundFigure = new ArrayList<Figure>();
    }
    
    
    public void add(Figure f) {
        compoundFigure.add(f);
    }

    @Override
    public void draw(Graphics graphics) {
        for(Figure f : compoundFigure) {
            f.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Figure f : compoundFigure) {
            f.x += dx;
            f.y += dy;
        }
    }
}
