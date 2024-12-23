package student_managment_system;

import java.util.Scanner;
import file_management.FileHandler;


public class StudentMenu {
    private boolean ongoing;
    private Scanner scanner;
    private StudentManagment studentManagment;
    private String file;

    public StudentMenu() {
        ongoing = true;
        scanner = new Scanner(System.in);
        studentManagment = StudentManagment.getInstance();
        file = "students.txt";
    }


    public void runMenu() {
        while (ongoing) {
            showMenu();
        }
        scanner.close();
    }

    public void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add new student");
        System.out.println("2. Save students to file (For next session)");
        System.out.println("3. Load students from file");
        System.out.println("4. Search for student by ID");
        System.out.println("5. Show all students (Remember to load all students from previous session!)");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            doMenuChoice(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 6.");
        }
    }


    public void doMenuChoice(int choice) {
        switch (choice) {
            case 1 -> enterStudentInformation();
            case 2 -> saveItToFile();
            case 3 -> readFromFile();
            case 4 -> searchForStudent();
            case 5 -> displayAllStudents();
            case 6 -> exitProgram();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }


    private void enterStudentInformation() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        studentManagment.putStudentInMap(id, name, grade);
        System.out.println("Student added.");
    }


    private void saveItToFile() {
        FileHandler.saveItToFile(file, studentManagment.getStudents());
    }


    private void readFromFile() {
        System.out.println("Warning: Current data will be replaced by data from file.");
        studentManagment.getStudents().clear();
        FileHandler.readFromFile(file, studentManagment);
    }


    private void searchForStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        Student student = studentManagment.getStudentById(id);
        if (student != null) {
            System.out.println("Student found. Name: " + student.getName() + ", Grade: " + student.getGrade());
        } else {
            System.out.println("No student found with the given ID.");
        }
    }

    private void displayAllStudents() {
        studentManagment.showAllStudents();
    }

    private void exitProgram() {
        ongoing = false;
        System.out.println("Thank you for using the Student Management System!");
    }
}
