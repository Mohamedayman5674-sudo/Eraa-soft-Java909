import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = {5, 10, 15, 20, 25};


        try {
            System.out.println("Enter index(0,4):");
            int index = scanner.nextInt();
            System.out.println("result:= " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid index");

        }


    }
}
