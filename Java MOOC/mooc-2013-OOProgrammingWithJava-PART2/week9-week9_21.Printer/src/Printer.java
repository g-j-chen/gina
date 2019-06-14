
import java.io.File;
import java.io.FileNotFoundException;
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
public class Printer {
    private File file;
    
    public Printer(String filename) throws Exception {
        this.file = new File(filename);
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException {
        Scanner reader = new Scanner(this.file);
        String line = "";
        
        while(reader.hasNextLine()) {
            String test = reader.nextLine();
            if (test.contains(word)) {
                line += test + "\n";
            }
        }
        System.out.print(line);
    }
}
