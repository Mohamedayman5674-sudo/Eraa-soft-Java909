package RE.oneToOne;

public class Phone {
private int id;
private String phoneNumber;
private Employee employee;
    public Phone(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if (employee != null && employee.getPhone() != this) {
            employee.setPhone(this);
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
