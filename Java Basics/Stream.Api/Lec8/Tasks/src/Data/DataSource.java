package Data;

import Models.Employee;
import Models.Student;

import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static List<Integer> getNumbers() {
        return Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
    }

    public static List<String> getNames() {
        return Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila",
                "Kareem", "Nada", "Nour", "Samy", "", null);
    }

    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
    }

    public static List<List<String>> getNestedWords() {
        return Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );
    }
}
