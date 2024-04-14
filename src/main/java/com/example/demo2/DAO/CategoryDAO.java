package com.example.demo2.DAO;

import com.example.demo2.DAO.connection.MyConnection;
import com.example.demo2.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private String SELECT_ALL = "select * from category;";
    private String SELECT_BY_ID = "select * from category where id = ?;";
    private String INSERT_INTO = "insert into category(name) value (?);";
    private Connection connection;

    public CategoryDAO() {
        connection = MyConnection.getInstance();
    }

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (SQLException | ClassCastException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Category findById(int id) {
        try(PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                return new Category(id, name);
            }
        } catch (SQLException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCategory(Category category) {
        try(PreparedStatement ps = connection.prepareStatement(INSERT_INTO)) {
            ps.setString(1, category.getName());
            ps.executeUpdate();
        } catch (SQLException | ClassCastException e) {
            e.printStackTrace();
        }
    }
}
