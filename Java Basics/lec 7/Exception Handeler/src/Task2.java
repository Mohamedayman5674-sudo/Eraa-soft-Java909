import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start App-------");

        System.out.println("Enter a number: ");
        String value = scanner.nextLine();
        int number = 0;

        try {
            number = Integer.parseInt(value);
            System.out.println("NUmber is " + number);

        } catch (NumberFormatException exception) {
            System.out.println("Invalid number");
        }

    }
}