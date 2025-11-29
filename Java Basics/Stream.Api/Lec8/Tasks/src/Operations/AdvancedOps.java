package Operations;

import Data.DataSource;
import Models.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedOps {

    public static void run() {
        List<Employee> employees = DataSource.getEmployees();
        List<Integer> nums = DataSource.getNumbers();
        List<String> names = DataSource.getNames();

        sortEmployees(employees);
        secondHighest(nums);
        findDuplicates(nums);
        removeNullEmpty(names);
        partitionStudents();
    }

    private static void sortEmployees(List<Employee> list) {
        System.out.println("Sorted employees:");
        list.stream()
                .sorted(
                        java.util.Comparator.comparing(Employee::getSalary)
                                .thenComparing(Employee::getName)
                )
                .forEach(e ->
                        System.out.println(e.getName() + " - " + e.getSalary()));
    }

    private static void secondHighest(List<Integer> nums) {
        nums.stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .ifPresent(n -> System.out.println("Second highest: " + n));
    }

    private static void findDuplicates(List<Integer> nums) {
        System.out.println("Duplicates:");
        nums.stream()
                .filter(n -> nums.indexOf(n) != nums.lastIndexOf(n))
                .distinct()
                .forEach(System.out::println);
    }

    private static void removeNullEmpty(List<String> names) {
        System.out.println("Cleaned names:");
        names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .forEach(System.out::println);
    }

    private static void partitionStudents() {
        var students = DataSource.getStudents();
        Map<Boolean, List<Models.Student>> map =
                students.stream()
                        .collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));
        System.out.println(map);
    }
}

