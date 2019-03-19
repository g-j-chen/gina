public class Person implements Comparable<Person>{

    private int salary;
    private String name;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return name + " " + salary;
    }
    
    public int compareTo(Person person) {
        if(this.salary == person.salary) {
            return 0;
        } else if(this.salary > person.salary) {
            return -1;
        } else {
            return 1;
        }        
    }

}
