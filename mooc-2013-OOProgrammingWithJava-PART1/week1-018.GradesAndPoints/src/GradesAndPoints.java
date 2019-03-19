
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Type the points [0-60]:");
        int pts = Integer.parseInt(reader.nextLine());
        
        String grade = "";
        
        if (pts <= 29) {
            grade = "failed";
        } else if (pts <= 34) {
            grade = "1";
        } else if (pts <= 39) {
            grade = "2";
        } else if (pts <= 44) {
            grade = "3";
        } else if (pts <= 49) {
            grade = "4";
        } else if (pts <= 60) {
            grade = "5";
        }
        
        System.out.println("Grade: " + grade);

    }
}
