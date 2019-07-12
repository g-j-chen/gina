/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setmatrixzeroes;

/**
 *
 * @author ginaj
 */
public class SetMatrixZeroes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[] rowZeroes = new boolean[rows];
        boolean[] columnZeroes = new boolean[columns];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0) {
                    rowZeroes[i] = true;
                    columnZeroes[j] = true;
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(rowZeroes[i] || columnZeroes[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
