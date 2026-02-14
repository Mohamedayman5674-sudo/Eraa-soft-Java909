package item.service.impl;

import item.model.Item;
import item.service.ItemService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private final DataSource dataSource;
    private static final String TABLE = "ITEM_909";

    public ItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // ================= GET ALL WITH JOIN =================
    @Override
    public List<Item> getAllItems() {

        List<Item> items = new ArrayList<>();

        String sql =
                "SELECT i.ID, i.NAME, i.PRICE, i.TOTAL_NUMBER, " +
                "d.DESCRIPTION, d.ISSUE_DATE, d.EXPIRY_DATE " +
                "FROM ITEM_909 i " +
                "LEFT JOIN ITEM_DETAILS_909 d ON i.ID = d.ID " +
                "WHERE i.ACTIVE = 1";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Item item = new Item();
                item.setId(rs.getLong("ID"));
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getDouble("PRICE"));
                item.setTotalNumber(rs.getInt("TOTAL_NUMBER"));

                // ===== DETAILS =====
                item.setDesc(rs.getString("DESCRIPTION"));
                item.setIssueDate(rs.getDate("ISSUE_DATE"));
                item.setExpiryDate(rs.getDate("EXPIRY_DATE"));

                items.add(item);
            }

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return items;
    }

    // ================= GET BY ID WITH JOIN =================
    @Override
    public Item getItemById(Long id) {

        String sql =
                "SELECT i.ID, i.NAME, i.PRICE, i.TOTAL_NUMBER, " +
                "d.DESCRIPTION, d.ISSUE_DATE, d.EXPIRY_DATE " +
                "FROM ITEM_909 i " +
                "LEFT JOIN ITEM_DETAILS_909 d ON i.ID = d.ID " +
                "WHERE i.ID = ? AND i.ACTIVE = 1";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Item item = new Item();
                    item.setId(rs.getLong("ID"));
                    item.setName(rs.getString("NAME"));
                    item.setPrice(rs.getDouble("PRICE"));
                    item.setTotalNumber(rs.getInt("TOTAL_NUMBER"));

                    item.setDesc(rs.getString("DESCRIPTION"));
                    item.setIssueDate(rs.getDate("ISSUE_DATE"));
                    item.setExpiryDate(rs.getDate("EXPIRY_DATE"));

                    return item;
                }
            }

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return null;
    }

    // ================= GET BY NAME =================
    @Override
    public Item getItemByName(String name) {

        String sql = "SELECT * FROM " + TABLE + " WHERE NAME = ? AND ACTIVE = 1";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapItem(rs);
            }

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return null;
    }

    // ================= ADD =================
    @Override
    public boolean addItem(Item item) {

        String sql = "INSERT INTO " + TABLE +
                " (NAME, PRICE, TOTAL_NUMBER, ACTIVE) VALUES (?, ?, ?, 1)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumber());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return false;
    }

    // ================= UPDATE =================
    @Override
    public boolean updateItem(Item item) {

        String sql = "UPDATE " + TABLE +
                " SET NAME=?, PRICE=?, TOTAL_NUMBER=? WHERE ID=? AND ACTIVE = 1";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumber());
            ps.setLong(4, item.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return false;
    }

    // ================= SOFT DELETE =================
    @Override
    public boolean removeItem(Long id) {

        String sql = "UPDATE " + TABLE + " SET ACTIVE = 0 WHERE ID=?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }

        return false;
    }

    // ================= MAP =================
    private Item mapItem(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong("ID"));
        item.setName(rs.getString("NAME"));
        item.setPrice(rs.getDouble("PRICE"));
        item.setTotalNumber(rs.getInt("TOTAL_NUMBER"));
        return item;
    }
}