public class Task12 {
    public static void main(String[] args) {


        try {

            try {
                int num = 10 / 0;
                System.out.println("num is " + num);

            } catch (ArithmeticException exception) {
                System.out.println("Inner catch: Divide by zero!");

                throw exception;
            }
        } catch (Throwable exception) {
            System.out.println("Outer catch: Error!");
        }


    }
}
