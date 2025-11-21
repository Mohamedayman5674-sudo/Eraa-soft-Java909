public class Task9 {
    public static void Method1() throws Exception {

        throw new Exception("Error is Method1");


    }

    public static void Method2() throws Exception {
        Method1();
    }

    public static void main(String[] args) {

        try {
            Method2();
        } catch (Exception exception) {
            System.out.println("Caught " + exception.getMessage());
        }


    }
}

