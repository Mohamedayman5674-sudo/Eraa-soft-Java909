public class Task3 {

    public static void printUpper(String string) {

        try {
            System.out.println(string.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println(" String is null!");
        }
    }

    public static void main(String[] args) {
        printUpper(null);
    }
}







