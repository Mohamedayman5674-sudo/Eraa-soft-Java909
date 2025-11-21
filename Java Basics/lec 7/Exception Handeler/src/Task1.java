import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Start App-------");

        System.out.print("Enter number num1: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter number num2: ");
        int num2 = scanner.nextInt();

        try {
            int result = num1 / num2;
            System.out.println("Result = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
    }
}


//Scanner scanner=new Scanner(System.in);
//
//        System.out.println("Enter the first number");
//int num1=scanner.nextInt();
//
//        System.out.println("Enter the second number");
//int num2=scanner.nextInt();
//
//        try {
//result =num1/num2;
//
//        }catch (ArithmeticException exception){
//        System.out.println( "Error: Cannot divide by zero!" );
//        }
//                System.out.println("result="+ result);