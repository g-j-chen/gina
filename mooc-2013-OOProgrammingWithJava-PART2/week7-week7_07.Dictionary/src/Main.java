
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String input = "add\n" + "cheese\n" + "juusto\n" +
                       "add\n" + "beer\n" + "olut\n" +
                       "add\n" + "book\n" + "kirja\n" +
                       "translate\n" + "beer\n" +
                       "quit\n";
        Scanner reader = new Scanner(input);
        
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();
         
    }
}
