
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
public class TextUserInterface {
    private Dictionary dictionary;
    private Scanner reader;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.dictionary = dictionary;
        this.reader = reader;
    }
    
    public void start() {
        startStatement();
        
        while (true) {
            System.out.println("Statement:");
            
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }
    
    public void startStatement() {
        System.out.println("Statements:");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks for a Finnish word and prints its translation");
        System.out.println("quit - quits the text user interface");
    }
    
    public void add() {
        System.out.print("In Finnish: ");
        String finnishWord = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        this.dictionary.add(finnishWord, translation);
    }
    
    public void translate() {
        System.out.print("Give a word: ");
        String toTranslate = reader.nextLine();
        System.out.println("Translation: " + this.dictionary.translate(toTranslate));
    }
    
}
