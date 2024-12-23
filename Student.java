package student_managment_system;

public class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

      //Hämtar namnet
    public String getName() {
        return name;
    }


     // Hämtar betyget
    public String getGrade() {
        return grade;
    }

}
