package item.model;

import java.util.Date;

public class Item {

    private Long id;
    private String name;
    private double price;
    private int totalNumber;

    // ===== Item Details (NEW) =====
    private String desc;
    private Date issueDate;
    private Date expiryDate;

    public Item() {
    }

    public Item(String name, double price, int totalNumber) {
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    public Item(Long id, String name, double price, int totalNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    // ===== Getters / Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    // ===== Details Getters / Setters =====

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
