import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {

    protected String StudentId; 
    protected String name;
    private double programmingFundamentalsMarks;
    private double databaseManagementSystemMarks;

    public Student(String StudentId, String name) {
        this.StudentId = StudentId;
        this.name = name;
        this.programmingFundamentalsMarks = 0.0;
        this.databaseManagementSystemMarks = 0.0;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setId(String id) {
        this.StudentId = StudentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgrammingFundamentalsMarks() {
        return programmingFundamentalsMarks;
    }

    public void setProgrammingFundamentalsMarks(double programmingFundamentalsMarks) {
        this.programmingFundamentalsMarks = programmingFundamentalsMarks;
    }

    public double getDatabaseManagementSystemMarks() {
        return databaseManagementSystemMarks;

    }

    public void setDatabaseManagementSystemMarks(double databaseManagementSystemMarks) {
        this.databaseManagementSystemMarks = databaseManagementSystemMarks;
    }

    @Override
    public String toString() {
        return "ID: " + StudentId + ", Name: " + name + ", PF Marks: " + programmingFundamentalsMarks + ", DBMS Marks: " + databaseManagementSystemMarks;
    }
}

// Undergraduate student class
class UndergraduateStudent extends Student {
    private String major;

    public UndergraduateStudent(String StudentId, String name, String major) {
        super(StudentId, name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() + ", Major: " + major;
    }
}

// Graduate student class
class GraduateStudent extends Student {
    private String researchArea;

    public GraduateStudent(String id, String name, String researchArea) {
        super(id, name);
        this.researchArea = researchArea;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    @Override
    public String toString() {
        return super.toString() + ", Research Area: " + researchArea;
    }
}

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Student already exists.");
                return;
            }
        }

        students.add(student);
    }

    public Student findStudent(String StudentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(StudentId)) {

                return student;
            }
        }
        return null;
    }

    public void updateStudent(String StudentId, String newName) {
        Student student = findStudent(StudentId);
        if (student != null) {
            student.setName(newName);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void  deleteStudent(String StudentId) {
        
        Student student = findStudent(StudentId);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void updateStudentMarks(String StudentId, double pfMarks, double dbmsMarks) {
        Student student = findStudent(StudentId);
        if (student != null) {
            student.setProgrammingFundamentalsMarks(pfMarks);
            student.setDatabaseManagementSystemMarks(dbmsMarks);
        } else {
            System.out.println("Student not found.");
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}

class StudentMenu {
    private StudentManager studentManager;
    private Scanner scanner;

    public StudentMenu() {
        studentManager = new StudentManager();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {

            System.out.println("1. Add Undergraduate Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. Update Student Name");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addUndergraduateStudent();
                    break;
                case 2:
                    addGraduateStudent();
                    break;
                case 3:
                    updateStudentName();
                    break;
                case 4:
                    updateStudentMarks();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addUndergraduateStudent() {
        System.out.print("Enter Student ID: ");
        String StudentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();
        UndergraduateStudent student = new UndergraduateStudent(StudentId, name, major);
        studentManager.addStudent(student);
        System.out.println("Undergraduate Student added successfully.");
    }

    private void addGraduateStudent() {
        System.out.print("Enter Student ID: ");
        String StudentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Research Area: ");
        String researchArea = scanner.nextLine();
        GraduateStudent student = new GraduateStudent(StudentId, name, researchArea);
        studentManager.addStudent(student);
        System.out.println("Graduate Student added successfully.");
    }

    private void updateStudentName() {
        System.out.print("Enter Student ID: ");
        String StudentId = scanner.nextLine();
        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        studentManager.updateStudent(StudentId, newName);
        System.out.println("Student name updated successfully.");
    }

    private void updateStudentMarks() {
        System.out.print("Enter Student ID: ");
        String StudentId = scanner.nextLine();

        System.out.print("Enter Programming Fundamentals Marks: ");
        double pfMarks = scanner.nextDouble();
        System.out.print("Enter Database Management System Marks: ");
        double dbmsMarks = scanner.nextDouble();
        studentManager.updateStudentMarks(StudentId, pfMarks, dbmsMarks);
        System.out.println("Student marks updated successfully.");
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID: ");
        String StudentId = scanner.nextLine();
        studentManager.deleteStudent(StudentId);
        System.out.println("Student deleted successfully.");
    }

    private void displayStudents() {
        List<Student> students = studentManager.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class App {
    public static void main(String[] args) {
        StudentMenu menu = new StudentMenu();
        menu.displayMenu();
    }
}
