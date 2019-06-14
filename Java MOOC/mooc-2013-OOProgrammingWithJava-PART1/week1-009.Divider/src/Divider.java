
import java.util.Scanner;

public class Divider {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Implement your program here. Remember to ask the input from user.
        System.out.println("Type a number: ");
        int dividend = Integer.parseInt(reader.nextLine());
        System.out.println("Type another number: ");
        int divisor = Integer.parseInt(reader.nextLine());
        
        double result = 1.0 * dividend / divisor;
        System.out.println("Division: " + dividend + "/" + divisor + " = " + result);
    }
}
