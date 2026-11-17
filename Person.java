//package student;                       // PACKAGE:

// Parent class (Inheritance ke liye)
public class Person {
    protected String name;             // protected
    private int age;                   // private
    public String city = "India";      // public

    public Person() {                  // default constructor
        name = "Unknown";
        age = 0;
    }

    public Person(String name, int age) {   // parameterized constructor
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}