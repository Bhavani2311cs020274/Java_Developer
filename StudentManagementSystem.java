
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // Student class with String ID
    public static class Student {

        private String id;
        private String name;
        private double marks;

        public Student(String id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks;
        }
    }

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Record Management :-");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();  // discard invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 ->
                    addStudent();
                case 2 ->
                    viewStudents();
                case 3 ->
                    updateStudent();
                case 4 ->
                    deleteStudent();
                case 5 ->
                    System.out.println("Exiting program...");
                default ->
                    System.out.println("Invalid choice, try again!");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID (letters & numbers allowed): ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter numeric marks.");
            scanner.next(); // discard invalid input
        }
        double marks = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\nStudent Records :-");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new marks: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter numeric marks.");
                scanner.next();
            }
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            student.setName(newName);
            student.setMarks(newMarks);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
