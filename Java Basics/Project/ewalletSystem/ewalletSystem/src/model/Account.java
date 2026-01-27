package model;

public class Account {

    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private Integer age;
    private double balance;

  
    private boolean isAdmin;
    private boolean active;
  

    public Account() {
        this.active = true;
        this.isAdmin = false;
        this.balance = 0;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.active = true;
        this.isAdmin = false;
        this.balance = 0;
    }

    public Account(int id, String username, String password,
                   String phoneNumber, String address, Integer age) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.balance = 0;
        this.active = true;
        this.isAdmin = false;
    }

    public Account(int id, String username, String password,
                   String phoneNumber, String address, Integer age, double balance) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
        this.balance = balance;
        this.active = true;
        this.isAdmin = false;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
    @Override
    public String toString() {
        return "Account{\n" +
                "  id=" + id + ",\n" +
                "  username='" + username + "',\n" +
                "  phoneNumber='" + phoneNumber + "',\n" +
                "  address='" + address + "',\n" +
                "  age=" + age + ",\n" +
                "  balance=" + balance + ",\n" +
                "  isAdmin=" + isAdmin + ",\n" +
                "  active=" + active + "\n" +
                '}';
    }
}
