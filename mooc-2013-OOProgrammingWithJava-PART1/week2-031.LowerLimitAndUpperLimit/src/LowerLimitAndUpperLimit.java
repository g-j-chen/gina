
import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // write your code here
        System.out.print("First number: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.print("Second number: ");
        int second = Integer.parseInt(reader.nextLine());
        
        if (first <= second) {
            int i = first;
            while (i <= second) {
                System.out.println(i);
                i++;
            }
        }

    }
}
