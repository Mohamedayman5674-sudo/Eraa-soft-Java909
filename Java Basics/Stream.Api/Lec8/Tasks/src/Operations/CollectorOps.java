package Operations;

import java.util.*;
import java.util.stream.*;
import Models.*;
import Data.DataSource;

public class CollectorOps {

    public static void run() {
        List<Employee> employees = DataSource.getEmployees();

        System.out.println("Average Salary:");
        double avgSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);

        System.out.println("Employees Grouped by Department:");
        Map<String, List<Employee>> grouped =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(grouped);
    }
}

