package com.example.demo5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DirectorDAO {
    private Connection connection;

    public DirectorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Director> findAll() {
        List<Director> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from director");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                result.add(new Director(id, name, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
