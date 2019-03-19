
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write here the main program
        Scanner reader = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        
        while(true) {
            System.out.println("Name: ");
            String name = reader.nextLine();
            if(name.equals("")) {
                break;
            }
            System.out.println("Student number: ");
            String studentNumber = reader.nextLine();
        
            list.add(new Student(name, studentNumber));
        }
        
        for (Student stu : list) {
            System.out.println(stu);
        }
        
        System.out.println("Give search term: ");
        String searchTerm = reader.nextLine();
        System.out.println("Results:");
        for (Student student : list) {
            if (student.getName().contains(searchTerm)) {
                System.out.println(student);
            }
        }
    }
}
