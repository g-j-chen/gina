/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocolatefeast;

/**
 *
 * @author ginaj
 */
public class ChocolateFeast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(chocolateFeast(10, 2, 5));
        System.out.println(chocolateFeast(12, 4, 4));
        System.out.println(chocolateFeast(6, 2, 2));
    }
    
     static int chocolateFeast(int n, int c, int m) {
        int noOfWrappers = n / c;
        int noOfChocs = n / c;
        
        while(noOfWrappers >= m) {
            int temp = noOfWrappers / m;
            noOfChocs += temp;
            noOfWrappers = (noOfWrappers % m) + temp;
        }
        return noOfChocs;
    }
}
