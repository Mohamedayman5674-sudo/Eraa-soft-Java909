package item.service.impl;

import item.model.User;
import item.service.UserService;

import javax.sql.DataSource;
import java.sql.*;

public class UserServiceImpl implements UserService {

    private final DataSource dataSource;

    public UserServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean signup(User user) {
        String sql = "INSERT INTO USERS_909 (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Email already exists");
        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return false;
    }

    @Override
    public User login(String email, String password) {
        String sql = "SELECT * FROM USERS_909 WHERE EMAIL=? AND PASSWORD=?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                return user;
            }

        } catch (Exception e) {
            System.out.println("ex => " + e.getMessage());
        }
        return null;
    }
}