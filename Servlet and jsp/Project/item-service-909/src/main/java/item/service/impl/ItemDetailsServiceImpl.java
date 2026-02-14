package item.service.impl;

import item.model.ItemDetails;
import item.service.ItemDetailsService;

import javax.sql.DataSource;
import java.sql.*;

public class ItemDetailsServiceImpl implements ItemDetailsService {

    private final DataSource dataSource;

    public ItemDetailsServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // ================= GET BY ID =================
    @Override
    public ItemDetails getByItemId(Long id) {
        String sql = "SELECT * FROM ITEM_DETAILS_909 WHERE ID=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ItemDetails d = new ItemDetails();
                d.setId(rs.getLong("ID"));
                d.setDesc(rs.getString("DESCRIPTION"));
                d.setIssueDate(rs.getDate("ISSUE_DATE"));
                d.setExpiryDate(rs.getDate("EXPIRY_DATE"));
                return d;
            }

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return null;
    }

    // ================= ADD DETAILS =================
    @Override
    public boolean addDetails(ItemDetails d) {
        String sql = "INSERT INTO ITEM_DETAILS_909 (ID, DESCRIPTION, ISSUE_DATE, EXPIRY_DATE) VALUES (?, ?, ?, ?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, d.getId());
            ps.setString(2, d.getDesc());
            ps.setDate(3, new java.sql.Date(d.getIssueDate().getTime()));
            ps.setDate(4, new java.sql.Date(d.getExpiryDate().getTime()));

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return false;
    }

    // ================= DELETE DETAILS =================
    @Override
    public boolean deleteDetails(Long id) {
        String sql = "DELETE FROM ITEM_DETAILS_909 WHERE ID=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return false;
    }

    // ================= UPDATE DETAILS =================
    @Override
    public boolean updateDetails(ItemDetails d) {
        String sql = "UPDATE ITEM_DETAILS_909 SET DESCRIPTION=?, ISSUE_DATE=?, EXPIRY_DATE=? WHERE ID=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getDesc());
            ps.setDate(2, new java.sql.Date(d.getIssueDate().getTime()));
            ps.setDate(3, new java.sql.Date(d.getExpiryDate().getTime()));
            ps.setLong(4, d.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return false;
    }
}