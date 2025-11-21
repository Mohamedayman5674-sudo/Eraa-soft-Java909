import java.io.FileReader;
import java.io.IOException;

public class Task10 {

    public static void readFile() throws IOException {
        FileReader fileReader = new FileReader("Mohamed.txt");
        fileReader.read();
        fileReader.close();


    }

    public static void main(String[] args) throws IOException {

        try {
            readFile();
        } catch (IOException exception) {

            System.out.println("Error" + exception.getMessage());
        }


    }
}
