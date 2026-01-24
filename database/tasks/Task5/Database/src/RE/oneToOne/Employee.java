package RE.oneToOne;



public class Employee {
    private int id;
    private String name;
    private int age;
    private Phone phone;
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
        if (phone != null && phone.getEmployee() != this) {
            phone.setEmployee(this);
        }
    }

    public Phone getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
