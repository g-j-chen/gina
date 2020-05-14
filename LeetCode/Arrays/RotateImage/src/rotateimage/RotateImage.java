/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotateimage;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class RotateImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] inputMatrix1 = {{1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}};
        rotate(inputMatrix1);
        System.out.println(print2DArray(inputMatrix1));
        
        int[][] inputMatrix2 = {{1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}};
        rotate(inputMatrix2);
        System.out.println(print2DArray(inputMatrix2));
        
    }
    
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
    
    public static String print2DArray(int[][] matrix) {
        int n = matrix.length;
        String result = "";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result += matrix[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }
}