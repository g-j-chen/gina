import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Type a number: ");
        int n = Integer.parseInt(reader.nextLine());
        int factorial = 1;
        
        if (n == 0) {
            factorial = 1;
        } else {
            while (n > 0) {
                factorial *= n;
                n--;
            }
        }
        
        System.out.println("Factorial is: " + factorial);
        

    }
}
