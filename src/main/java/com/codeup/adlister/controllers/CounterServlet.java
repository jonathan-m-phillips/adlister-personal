package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        counter += 1;
        response.getWriter().println("<h1>The count is " + counter + ".</h1>");
        List<Category> categoryList = DaoFactory.getCategoriesDao().allCats();
        for (Category category : categoryList) {
            System.out.println(category.getCategoryName());
        }
        List<Long> catId = DaoFactory.getAdsCategoriesDao().getCategoriesByAdId(1);
    }
}
