
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // Scanner reader = new Scanner(System.in);
        // write here code to ensure that BoundedCounter works as expected
        // before starting 78.3 remove the extra code and use the skeleton shown
        // in the assignment
        
        BoundedCounter seconds = new BoundedCounter(59);
        BoundedCounter minutes = new BoundedCounter(59);
        BoundedCounter hours = new BoundedCounter(23);
        
        /*
        System.out.print("Seconds: ");
        int s = Integer.parseInt(reader.nextLine());
        System.out.print("Minutes: ");
        int m = Integer.parseInt(reader.nextLine());
        System.out.print("Hours: ");
        int h = Integer.parseInt(reader.nextLine());
        */
        
        seconds.setValue(50);
        minutes.setValue(59);
        hours.setValue(23);
        
        /*
        int i = 0;
        while (i < 121) {
            System.out.println(hours + ":" + minutes + ":" + seconds);
            seconds.next();
            if (seconds.getValue() == 0) {
                minutes.next();
                if (minutes.getValue() == 0) {
                    hours.next();
                }
            }
            i++;
        }
        */
        
        while (true) {
            System.out.println(hours + ":" + minutes + ":" + seconds);
            Thread.sleep(1000);
            seconds.next();
            if (seconds.getValue() == 0) {
                minutes.next();
                if (minutes.getValue() == 0) {
                    hours.next();
                }
            }
        }
    }
}
