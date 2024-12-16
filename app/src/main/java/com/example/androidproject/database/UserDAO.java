package com.example.androidproject.database;

import com.example.androidproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Metodă pentru autentificare
    public static User authenticateUser(String email, String password) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                user = new User(id, name, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (stmt != null) stmt.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    // Metodă pentru crearea unui utilizator
    public static boolean createUser(String name, String email, String password) {
        Connection connection = null;
        PreparedStatement stmt = null;
        boolean isCreated = false;

        try {
            connection = DBConnection.getConnection();
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int rowsInserted = stmt.executeUpdate();
            isCreated = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isCreated;
    }
}
