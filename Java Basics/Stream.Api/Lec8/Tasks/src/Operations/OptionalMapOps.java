package Operations;

import Data.DataSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalMapOps {

    public static void run() {

        List<List<String>> nested = DataSource.getNestedWords();

        flatten(nested);
        uniqueChars();
        optionals();
        mapLengths();
        wordsStartingWithA();
    }

    private static void flatten(List<List<String>> nested) {
        System.out.println("Flattened:");
        nested.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    private static void uniqueChars() {
        System.out.println("Unique chars:");
        List<String> words = List.of("Java", "Stream");
        words.stream()
                .flatMap(w -> w.chars().mapToObj(c -> (char) c))
                .distinct()
                .forEach(System.out::println);
    }

    private static void optionals() {
        List<Optional<String>> list =
                List.of(Optional.of("Ali"), Optional.empty(), Optional.of("Sara"));

        list.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }

    private static void mapLengths() {
        List<String> names = DataSource.getNames();
        names.stream()
                .filter(n -> n != null)
                .map(String::length)
                .forEach(System.out::println);
    }

    private static void wordsStartingWithA() {
        List<String> names = DataSource.getNames();
        names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
