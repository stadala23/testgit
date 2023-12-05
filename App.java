import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    protected String id;
    protected String name;
    private double programmingFundamentalsMarks;
    private double databaseManagementSystemMarks;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.programmingFundamentalsMarks = 0.0;
        this.databaseManagementSystemMarks = 0.0;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgrammingFundamentalsMarks() {
        return this.programmingFundamentalsMarks;
    }

    public void setProgrammingFundamentalsMarks(double programmingFundamentalsMarks) {
        this.programmingFundamentalsMarks = programmingFundamentalsMarks;
    }

    public double getDatabaseManagementSystemMarks() {
        return this.databaseManagementSystemMarks;
    }

    public void setDatabaseManagementSystemMarks(double databaseManagementSystemMarks) {
        this.databaseManagementSystemMarks = databaseManagementSystemMarks;
    }
    

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", PF Marks: " + programmingFundamentalsMarks + ", DBMS Marks: " + databaseManagementSystemMarks;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

       public void addStudent(String id, String name) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Student already exists.");
                return;
            }
        }
        students.add(new Student(id, name));
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(String id, String newName) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.setName(newName);
                return;
            }
        }
        System.out.println("Student not found.");
    }

       public void deleteStudent(String id) {
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudentMarks(String id, double pfMarks, double dbmsMarks) {
        Student student = findStudent(id);
        if (student != null) {
            student.setProgrammingFundamentalsMarks(pfMarks);
            student.setDatabaseManagementSystemMarks(dbmsMarks);
        }
    }

    
    public List<Student> getStudents() {
        return students;
    }
}



class Menu {
    private StudentManager studentManager;
    private Scanner scanner;

    public Menu() {
        studentManager = new StudentManager();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Name");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudentName();
                    break;
                case 3:
                    updateStudentMarks();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    displayStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        Student student = new Student(id, name);
        studentManager.addStudent(student.getId(),student.getName());
        System.out.println("Student added successfully.");
    }

    private void updateStudentName() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        studentManager.updateStudent(id, newName);
        System.out.println("Student name updated successfully.");
    }

    private void updateStudentMarks() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Programming Fundamentals Marks: ");
        double pfMarks = scanner.nextDouble();
        System.out.print("Enter Database Management System Marks: ");
        double dbmsMarks = scanner.nextDouble();
        studentManager.updateStudentMarks(id, pfMarks, dbmsMarks);
        System.out.println("Student marks updated successfully.");
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        studentManager.deleteStudent(id);
        System.out.println("Student deleted successfully.");
    }

    private void displayStudents() {
        List<Student> students = studentManager.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class app {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
