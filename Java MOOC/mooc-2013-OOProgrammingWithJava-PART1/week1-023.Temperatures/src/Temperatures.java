
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // Write your code here. 
        while (true) {
            System.out.println("Input temperatures:");
            double temp = Double.parseDouble(reader.nextLine());
            if (temp >= -30.0 && temp <= 40.0) {
                Graph.addNumber(temp);
            }
            
          

        // Graph is used as follows:
        
        // Remove or comment out these lines above before trying to run the tests.
        }
    }
}
