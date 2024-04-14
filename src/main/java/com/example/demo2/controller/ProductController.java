package com.example.demo2.controller;

import com.example.demo2.DAO.CategoryDAO;
import com.example.demo2.DAO.ProductDAO;
import com.example.demo2.model.Category;
import com.example.demo2.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addGet":
                addProductGet(req, resp);
                break;
            default:
                findAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("product/list.jsp").forward(req, res);
    }

    private void addProductGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("product/create.jsp").forward(req, res);
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int cId = Integer.parseInt(req.getParameter("cId"));
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(categoryDAO.findById(cId));
        productDAO.addProduct(product);
        res.sendRedirect("products");
    }
}
