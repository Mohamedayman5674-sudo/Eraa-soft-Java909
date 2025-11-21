public class Task6 {
    public static void main(String[] args) {
        String string = null;
        int num1 = 10;
        int num2 = 0;
        try {
            System.out.println(string.length());

            int result = num1 / num2;
            System.out.println("Result is :" + result);

        } catch (NullPointerException exception) {

            System.out.println("NullPointerException");
        } catch (ArithmeticException exception) {

            System.out.println("ArithmeticException");
        }
    }
}