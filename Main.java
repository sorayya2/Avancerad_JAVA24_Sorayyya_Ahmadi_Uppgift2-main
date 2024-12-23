package student_managment_system;

import file_management.FileHandler;

// Klassen är till för att hantera namn och betyg för en student.

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.createFile();

        System.out.println("Welcome to the Student Management System!");
        StudentMenu menu = new StudentMenu();
        menu.runMenu();

    }
}
