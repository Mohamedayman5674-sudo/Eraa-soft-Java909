package Operations;

import Data.DataSource;
import java.util.List;

public class NumericOps {

    public static void run() {
        List<Integer> numbers = DataSource.getNumbers();

        sum(numbers);
        max(numbers);
        min(numbers);
        multiply(numbers);
        countPositive(numbers);
    }

    private static void sum(List<Integer> numbers) {
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);
    }

    private static void max(List<Integer> numbers) {
        numbers.stream().max(Integer::compareTo)
                .ifPresent(n -> System.out.println("Max = " + n));
    }

    private static void min(List<Integer> numbers) {
        numbers.stream().min(Integer::compareTo)
                .ifPresent(n -> System.out.println("Min = " + n));
    }

    private static void multiply(List<Integer> numbers) {
        int mul = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Multiplication = " + mul);
    }

    private static void countPositive(List<Integer> numbers) {
        long count = numbers.stream().filter(n -> n > 0).count();
        System.out.println("Positive count = " + count);
    }
}

