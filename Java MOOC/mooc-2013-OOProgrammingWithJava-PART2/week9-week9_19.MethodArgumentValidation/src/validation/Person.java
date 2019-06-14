package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (null == name || name.length() > 40 || name.isEmpty()) {
            throw new IllegalArgumentException("Not a valid name");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0-120");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
