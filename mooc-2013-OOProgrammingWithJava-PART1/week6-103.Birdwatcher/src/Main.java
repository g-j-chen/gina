import java.util.Scanner;
import java.util.ArrayList;

public class Main {  

    public static void main(String[] args) {
    // implement your program here
    // do not put all to one method/class but rather design a proper structure to your program
        
    // Your program should use only one Scanner object, i.e., it is allowed to call 
    // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        ArrayList<Birds> birdList = new ArrayList<Birds>();
        Scanner scanner = new Scanner(System.in);
    
        while(true) {
            System.out.println("?");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("Add")) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Latin name: ");
                String latinName = scanner.nextLine();
                birdList.add(new Birds(name, latinName));
            } else if (command.equalsIgnoreCase("Observation")) {
                System.out.print("What was observed? ");
                String birdObserved = scanner.nextLine();
                boolean observed = false;
                for (Birds bird : birdList) {
                    if (bird.getName().equalsIgnoreCase(birdObserved)) {
                        bird.birdSighted();
                        observed = true;
                    }
                }
                if (false == observed) {
                    System.out.println("Is not a bird!");
                }
            } else if (command.equalsIgnoreCase("Statistics")) {
                for (Birds bird : birdList) {
                    System.out.println(bird.toString());
                }
            } else if (command.equalsIgnoreCase("Show")) {
                System.out.println("What? ");
                String showBird = scanner.nextLine();
                for (Birds bird : birdList) {
                    if (bird.getName().equalsIgnoreCase(showBird)) {
                        System.out.println(bird.toString());
                    }
                }
            } else if (command.equalsIgnoreCase("Quit")) {
                break;
            }
        }
    }
}
