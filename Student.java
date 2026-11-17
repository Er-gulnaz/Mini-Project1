//
public class Student extends Person implements Gradable {
    private int rollNo;
    private int[] marks = new int[3];            // 3 subjects ke marks

    // STATIC MEMBERS: 
    private static int totalStudents = 0;
    public static final String COLLEGE = "ABC College";

    // Constructors
    public Student() {
        super();                                  // parent ka constructor
        totalStudents++;
    }

    public Student(int rollNo, String name, int age, int m1, int m2, int m3) {
        super(name, age);
        this.rollNo = rollNo;
        marks[0] = m1; marks[1] = m2; marks[2] = m3;
        totalStudents++;
    }

    public static int getTotalStudents() { return totalStudents; }
    public static void decreaseCount() { totalStudents--; }

    public int getRollNo() { return rollNo; }

    public void setMarks(int m1, int m2, int m3) {
        marks[0] = m1; marks[1] = m2; marks[2] = m3;
    }

    public int getTotal() { return marks[0] + marks[1] + marks[2]; }

    public double getPercentage() { return getTotal() / 3.0; }

    @Override
    public String calculateGrade() {
        double p = getPercentage();
        if (p >= 90) return "A+";
        else if (p >= 75) return "A";
        else if (p >= 60) return "B";
        else if (p >= 40) return "C";
        else return "F";
    }

    @Override
    public String generateResult() {
        return calculateGrade().equals("F") ? "FAIL" : "PASS";
    }

    public void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);          // protected member use ho raha hai
        System.out.println("Age     : " + getAge());      // private ko getter se access
        System.out.println("Marks   : " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.println("Total   : " + getTotal() + "  Percentage: " + String.format("%.2f", getPercentage()) + "%");
        System.out.println("Grade   : " + calculateGrade() + "  Result: " + generateResult());
        System.out.println("-----------------------------------");
    }
}