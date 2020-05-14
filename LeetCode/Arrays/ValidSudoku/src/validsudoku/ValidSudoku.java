/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validsudoku;

/**
 *
 * @author ginaj
 */
public class ValidSudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] board = {{'.','3','.','.','7','.','.','.','9'}, 
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','.','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};
        

        System.out.println(isValidSudoku(board));
        
        char[][] board2 = {{'.','.','4','.','.','.','6','3','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'5','.','.','.','.','.','.','9','.'},
                            {'.','.','.','5','6','.','.','.','.'},
                            {'4','.','3','.','.','.','.','.','1'},
                            {'.','.','.','7','.','.','.','.','.'},
                            {'.','.','.','5','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'}};
        
        System.out.println(isValidSudoku(board2));
    }
    
    public static boolean isValidSudoku(char[][] board) {
        if(!checkRows(board)) {
            return false;
        }
        if(!checkColumns(board)) {
            return false;
        }
        for(int i = 0; i < board.length; i+=3) {
            for(int j = 0; j < board[i].length; j+=3) {
                if(!checkBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean checkRows(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            int row = 0;
            for(int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if(Character.isDigit(c)) {
                    int n = Character.getNumericValue(c);
                    if(((1<<(n - 1))&row) > 0) {
                        return false;
                    } else {
                        row |= (1<<(n - 1));
                    }
                }
            }
        }
        return true;
    }
    
    public static boolean checkColumns(char[][] board) {
        int i = 0;
        for(int j = 0; j < board[i].length; j++) {
            int column = 0;
            while(i < board.length) {
                char c = board[i][j];
                if(Character.isDigit(c)) {
                    int n = Character.getNumericValue(c);
                    if(((1<<(n - 1))&column) > 0) {
                        return false;
                    } else {
                        column |= (1<<(n - 1));
                    }
                }
                i++;
            }
            i = 0;
        }
        return true;
    }
    
    public static boolean checkBox(char[][] board, int i, int j) {
        int box = 0;
        for(int k = i; k < (i + 3); k++) {
            for(int l = j; l < (j + 3); l++) {
                char c = board[k][l];
                if(Character.isDigit(c)) {
                    int n = Character.getNumericValue(c);
                    if(((1<<(n - 1))&box) > 0) {
                        return false;
                    } else {
                        box |= (1<<(n - 1));
                    }
                }
            }
            
        }
        return true;
    }
    
}
