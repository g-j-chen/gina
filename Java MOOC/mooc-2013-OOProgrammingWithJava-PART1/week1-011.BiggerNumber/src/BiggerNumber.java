
import java.util.Scanner;

public class BiggerNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Implement your program here. Remember to ask the input from user
        System.out.println("Type a number: ");
        int firstNum = Integer.parseInt(reader.nextLine());
        System.out.println("Type another number: ");
        int secondNum = Integer.parseInt(reader.nextLine());
        
        int biggerNum = Math.max(firstNum, secondNum);
        System.out.println("The bigger of the two numbers given was: " + biggerNum);
    }
}
