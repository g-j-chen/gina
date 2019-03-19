package personnel;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Person arto = new Person("Arto", Education.D);
        Person bob = new Person("Bob", Education.M);
        Person carl = new Person("Carl", Education.B);
        Person david = new Person("David", Education.D);
        Person edward = new Person("Edward", Education.GRAD);
        Person fred = new Person("Fred", Education.M);
        Person george = new Person("George", Education.B);
        
        List<Person> group = new ArrayList<Person>();
        group.add(arto);
        group.add(bob);
        group.add(carl);
        group.add(david);
        
        Employees employees = new Employees();
        
        employees.add(group);
        employees.print();
        System.out.println("");
        
        employees.add(edward);
        employees.add(fred);
        employees.add(george);
        
        employees.print();
        System.out.println("");
        
        employees.print(Education.D);
        System.out.println("");
        
        employees.fire(Education.GRAD);
        employees.print();
    }
}
