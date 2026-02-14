package item.model;

import java.util.Date;

public class ItemDetails {

    private Long id;
    private String description;
    private Date issueDate;
    private Date expiryDate;

    public ItemDetails() {
    }

    public ItemDetails(Long id, String description, Date issueDate, Date expiryDate) {
        this.id = id;
        this.description = description;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
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
