package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("redirect", "/ads/create");
            response.sendRedirect("/login");
            return;
        }
        List<Category> categories = DaoFactory.getCategoriesDao().allCats();
        request.getSession().setAttribute("categories", categories);
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        long categoryLong = Long.parseLong(request.getParameter("categorySelect"));
        Category category = DaoFactory.getCategoriesDao().getByCategoryID(categoryLong);
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description"),
            category
        );
        long adId = DaoFactory.getAdsDao().insert(ad);
        DaoFactory.getAdsCategoriesDao().joiningAdsToCategories(adId, ad.getCategory().getCategoryID());
        response.sendRedirect("/ads");
    }
}
