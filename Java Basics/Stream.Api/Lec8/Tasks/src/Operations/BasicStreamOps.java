package Operations;

import Data.DataSource;

import java.util.List;

public class BasicStreamOps {

    public static void run() {
        List<Integer> numbers = DataSource.getNumbers();
        List<String> names = DataSource.getNames();

        filterEven(numbers);           //تُرجع العناصر الزوجية فقط من المصفوفة numbers.
        startWithLetter(names, "A");       //تُرجع الأسماء التي تبدأ بحرف معيّن (في المثال: حرف A).
        uppercase(names);                  //تحوّل كل العناصر النصية إلى حروف كبيرة (Uppercase).
        sortDescending(numbers);           //ترتّب الأرقام ترتيبًا تنازليًا (من الأكبر إلى الأصغر).
        removeDuplicates(numbers);         //تحذف القيم المكرّرة من المصفوفة وتُرجع قيمًا فريدة فقط.
    }

    private static void filterEven(List<Integer> numbers) {
        System.out.println("Even numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    private static void startWithLetter(List<String> names, String letter) {
        System.out.println("Names starting with " + letter + ":");
        names.stream()
                .filter(n -> n != null && n.startsWith(letter))
                .forEach(System.out::println);
    }

    private static void uppercase(List<String> names) {
        System.out.println("Uppercase:");
        names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void sortDescending(List<Integer> numbers) {
        System.out.println("Sorted descending:");
        numbers.stream()
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);
    }

    private static void removeDuplicates(List<Integer> numbers) {
        System.out.println("Distinct:");
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
