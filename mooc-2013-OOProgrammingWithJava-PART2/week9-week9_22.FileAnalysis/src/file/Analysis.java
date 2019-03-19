/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ginaj
 */
public class Analysis {
    private File file;
    
    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file, "UTF-8");
        int lineCount = 0;
        
        while (reader.hasNextLine()) {
            lineCount++;
            reader.nextLine();
        }
        return lineCount;
    }
    
    public int characters() throws Exception {
        Scanner s = new Scanner(this.file, "UTF-8");
        int charCount = 0;
    
        while (s.hasNext()) {
            String line = s.nextLine();
            charCount += line.length() + 1;
        }
        return charCount;
    }
}
