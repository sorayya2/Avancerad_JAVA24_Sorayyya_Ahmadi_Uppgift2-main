package student_managment_system;

import java.util.HashMap;
import java.util.Map;


public class StudentManagment {
    private static StudentManagment instance;
    private HashMap<String, Student> students;

    private StudentManagment() {
        students = new HashMap<>();
    }

     //Hämtar instans
    public static StudentManagment getInstance() {
        if(instance == null) {
            instance = new StudentManagment();
        }
        return instance;
    }

    public void putStudentInMap(String id, String name, String grade) {
        Student student = new Student(name, grade);
        students.put(id, student);
    }


    public Student getStudentById(String id) {
        return students.get(id); // Hämtar studenten baserat på ID
    }

    public HashMap<String, Student> getStudents() {
        return students;
    }
}
