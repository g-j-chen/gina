
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// This is not an exercise but a "sandbox" where you can freely test
// whatever you want

public class Application {

    
    public static void main(String[] args) {

        // Write the code here. You can run the code by 
        // selecting Run->Run File from the menu or by pressing Shift+F6
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            
            long prime = 2;
            
            while(n > prime) {
                if(n % prime == 0) {
                    n = n / prime;
                } else {
                    prime++;
                }
            }
            System.out.println(prime);
            
            
        }
            
    }   
}
