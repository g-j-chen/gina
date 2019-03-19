import java.util.Scanner;

public class LoopsEndingRemembering {
    public static void main(String[] args) {
        // program in this project exercises 36.1-36.5
        // actually this is just one program that is split in many parts
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Type numbers ");
        int sum = 0;
        int numOfNumbers = 0;
        int evens = 0;
        int odds = 0;
        
        while (true) {
            int a = Integer.parseInt(reader.nextLine());
                        
            if (a != -1) {
                sum += a;
                numOfNumbers++;
                if (a % 2 == 0) {
                    evens++;
                } else {
                    odds++;
                }
            } else {
                System.out.println("Thank you and see you later!");
                System.out.println("The sum is " + sum);
                System.out.println("How many numbers: " + numOfNumbers);
                double ave = 1.0 * sum / numOfNumbers;
                System.out.println("Average: " + ave);
                System.out.println("Even numbers: " + evens);
                System.out.println("Odd numbers: " + odds);
                break;
            }
        }

    }
}
