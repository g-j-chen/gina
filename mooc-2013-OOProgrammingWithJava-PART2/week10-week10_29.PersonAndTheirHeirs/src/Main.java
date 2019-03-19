
import java.util.ArrayList;
import java.util.List;
import people.Person;
import people.Student;
import people.Teacher;



public class Main {

    public static void printDepartment(List<Person> people) {
        for( Person p : people) {
            System.out.println(p);
        }
    }
    
    public static void main(String[] args) {
        // test your code here
        List<Person> people = new ArrayList<Person>();
        people.add(new Teacher("Pekka Mikkola", "Korsontir Street 1 0310 Vantaa", 1200));
       
        people.add(new Student("Olli Hyde", "Ida Street 1 00400 Helsinki"));
        
        printDepartment(people);

    }
}
