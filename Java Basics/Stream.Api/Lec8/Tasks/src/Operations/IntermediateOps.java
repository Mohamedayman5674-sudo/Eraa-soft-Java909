package Operations;

import Data.DataSource;

import java.util.List;

public class IntermediateOps {
public static void run(){
    List<String> names = DataSource.getNames();
    List<Integer>numbers = DataSource.getNumbers();
countLongString(names);
    findFirst(names);
    anyDivisibleByFive(numbers);
    collectToSet(names);
    skipThree(names);

}
private static void countLongString(List<String> names){
   long count= names.stream()
           .filter(name -> name != null && name.length() > 5)
           .count();
    System.out.println("Strings longer than 5: " + count);
}


    private static void findFirst(List<String> names) {
        names.stream()
                .filter(name -> name != null && name.startsWith("A"))
                .findFirst()
                .ifPresent(name -> System.out.println("First starting with A: " + name));
    }

private static void anyDivisibleByFive(List<Integer>numbers){
    boolean exists = numbers.stream().anyMatch(number -> number % 5 == 0);
    System.out.println("Number of Divisible By Five: " + exists);

}

private static void collectToSet(List<String>names){
    System.out.println("Collected to Set:");
    names.stream()
            .filter(name -> name != null)
            .collect(java.util.stream.Collectors.toSet())
            .forEach(System.out::println);

}
    private static void skipThree(List<String> names) {
        System.out.println("Skipping first 3:");
        names.stream()
                .skip(3)
                .forEach(System.out::println);
    }



}