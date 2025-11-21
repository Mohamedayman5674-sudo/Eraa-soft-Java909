import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task5 {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("mohamed.txt");
            System.out.println("File Read Successfully");

        } catch (FileNotFoundException exception) {

            System.out.println("File not found");

        }


    }
}
