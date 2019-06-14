
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Airport tul = new Airport();
        
        Scanner reader = new Scanner(System.in);
        
        UserInterface tulUI = new UserInterface(tul, reader);
        tulUI.start();
    }
}
