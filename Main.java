import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager mgr = new StudentManager();
        int choice;

        do {
            System.out.println("=============================================");
            System.out.println("\n=== Student Management System ===");
            System.out.println("\n=== Built By : Gulnaz ===");
            System.out.println("=============================================");

            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Student Details");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Generate Result");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Roll No: "); 
                    int roll = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Name: ");     String name = sc.nextLine();
                    System.out.print("Age: ");      int age = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Marks (3 subjects, space se alag): ");
                    String[] m = sc.nextLine().trim().split("\\s+");
                    mgr.addStudent(new Student(roll, name, age,
                            Integer.parseInt(m[0]), Integer.parseInt(m[1]), Integer.parseInt(m[2])));
                    break;
                case 2:
                    System.out.print("Search roll no and name (1=Roll, 2=Name): ");
                    int t = Integer.parseInt(sc.nextLine().trim());
                    Student found;
                    if (t == 1) {
                        System.out.print("Roll No: ");
                        found = mgr.searchStudent(Integer.parseInt(sc.nextLine().trim()));
                    } else {
                        System.out.print("Name: ");
                        found = mgr.searchStudent(sc.nextLine());
                    }
                    if (found != null) found.display(); else System.out.println("Student not found.");
                    break;
                case 3:
                    System.out.print("Roll No: ");  int r = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("New Name: "); String n = sc.nextLine();
                    System.out.print("New Age: ");  int a = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("New Marks (3 subjects): ");
                    String[] nm = sc.nextLine().trim().split("\\s+");
                    mgr.updateStudent(r, n, a, Integer.parseInt(nm[0]), Integer.parseInt(nm[1]), Integer.parseInt(nm[2]));
                    break;
                case 4:
                    System.out.print("Roll No: ");
                    mgr.deleteStudent(Integer.parseInt(sc.nextLine().trim()));
                    break;
                case 5:
                    mgr.displayAll();
                    break;
                case 6:
                case 7:
                    System.out.print("Roll No: ");
                    Student s = mgr.searchStudent(Integer.parseInt(sc.nextLine().trim()));
                    if (s == null) System.out.println("Student not found.");
                    else if (choice == 6) System.out.println("Grade: " + s.calculateGrade());
                    else System.out.println("Result: " + s.generateResult());
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}