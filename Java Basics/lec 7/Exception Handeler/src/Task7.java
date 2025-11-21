import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter age");
            int age = scanner.nextInt();
            if (age < 18)
                throw new InvalidAgeException("Age must be 18 or above!");
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());

        }


    }
}
