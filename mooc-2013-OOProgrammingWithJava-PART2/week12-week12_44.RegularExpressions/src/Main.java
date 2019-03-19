import java.util.Scanner;


public class Main {
    
    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]*");
    }

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean clockTime(String string) {
        return string.matches("([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])");
    }
    
    public static void main(String[] args) {
        // write test code here
        System.out.print("Give a string: ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if(clockTime(word)) {
            System.out.println("The form is fine");
        } else {
            System.out.println("The form is wrong");
        }
        
    }

}
