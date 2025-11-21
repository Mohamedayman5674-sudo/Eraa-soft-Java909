public class Task11 {
    public static void main(String[] args) {
        System.out.println("Start App-------");
        try {


            int result = 10 / 0;

            System.out.println("result is " + result);
        } catch (ArithmeticException exception) {
            System.out.println("error: division by zero");

        } finally {
            System.out.println("Finally block .");
        }

    }
}