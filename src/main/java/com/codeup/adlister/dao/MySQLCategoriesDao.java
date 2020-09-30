package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao extends MySQLDao implements Categories {
    public MySQLCategoriesDao(Config config) {
        super(config);
    }

    @Override
    public List<Category> allCats() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Category searchByCategoryName(String type) {
        return null;
    }

    @Override
    public long searchByCategoryID(Category category) {
        return 0;
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getString("name"),
                rs.getLong("id")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }
}
