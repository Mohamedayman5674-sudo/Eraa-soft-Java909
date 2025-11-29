package Models;

public class Student {
    public String name;
    public String department;
    public int grade;

    public Student(String name, String department, int grade) {
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getGrade() { return grade; }

    @Override
    public String toString() {
        return name + " - " + department + " - " + grade;
    }
}
