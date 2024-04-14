package com.example.demo2.DAO;

import com.example.demo2.DAO.connection.MyConnection;
import com.example.demo2.model.Category;
import com.example.demo2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private String SELECT_ALL = "select * from product;";
    private String SELECT_BY_ID = "select * from product where id = ?;";
    private String INSERT_INTO = "insert into product(name, price, quantity, category_id) value (?,?,?,?);";
    private Connection connection;
    private CategoryDAO categoryDAO;


    public ProductDAO() {
        connection = MyConnection.getInstance();
        categoryDAO = new CategoryDAO();
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int cId = rs.getInt("category_id");
                Category category = categoryDAO.findById(cId);
                products.add(new Product(id, name, price, quantity, category));
            }
        } catch (SQLException | ClassCastException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(Product product) {
        try(PreparedStatement ps = connection.prepareStatement(INSERT_INTO)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setInt(4, product.getCategory().getId());
            ps.executeUpdate();
        } catch (SQLException | ClassCastException e) {
            e.printStackTrace();
        }
    }
}
