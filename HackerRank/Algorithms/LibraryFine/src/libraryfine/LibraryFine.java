/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryfine;

/**
 *
 * @author ginaj
 */
public class LibraryFine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(libraryFine(9, 6, 2015, 6, 6, 2015));
    }
    
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;
        if(y1 - y2 > 0) {
            fine = 10000;
        } else if(y1 < y2) {
            fine = 0;
        } else if(m1 - m2 > 0 && y1 == y2) {
            fine = (m1 - m2) * 500;
        } else if(d1 - d2 > 0 && m1 == m2) {
            fine = (d1 - d2) * 15;
        }
        return fine;
    }
    
}
