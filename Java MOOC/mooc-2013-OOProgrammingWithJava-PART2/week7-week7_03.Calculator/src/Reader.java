
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ginaj
 */
public class Reader {
    private Scanner scanner;
    
    public Reader() {
        scanner = new Scanner(System.in);
    }
    
    public String readString() {
        return scanner.nextLine();
    }
    
    public int readInteger() {
        return Integer.parseInt(scanner.nextLine());
    }
}
