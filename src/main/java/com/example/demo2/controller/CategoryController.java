package com.example.demo2.controller;

import com.example.demo2.DAO.CategoryDAO;
import com.example.demo2.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryController extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addGet":
                addCategoryGet(req, resp);
                break;
            case "detail":
                findOne(req, resp);
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
                addCategory(req, resp);
                break;
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Category> categories = categoryDAO.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("category/list.jsp").forward(req, res);
    }

    private void findOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDAO.findById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("category/detail.jsp").forward(req, res);
    }

    private void addCategoryGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("category/create.jsp");
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        Category category = new Category();
        category.setName(name);
        categoryDAO.addCategory(category);
        res.sendRedirect("categories");
    }
}
