package RE.oneToOne;


public class Main {
    public static void main(String[] args) {


        Employee employee = new Employee(1, "Ahmed", 28);
        Phone phone = new Phone(101, "01012345678");

        employee.setPhone(phone);

        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Phone: " + employee.getPhone().getPhoneNumber());

        System.out.println("Phone Owner: " + phone.getEmployee().getName());

    }
}