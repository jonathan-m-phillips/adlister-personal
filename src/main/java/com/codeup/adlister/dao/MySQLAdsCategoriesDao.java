package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsCategoriesDao extends MySQLDao implements AdsCategories{
    public MySQLAdsCategoriesDao(Config config) {
        super(config);
    }

    public long joiningAdsToCategories (long adId, long catId) {
        try {
            String insertQuery = "INSERT INTO ads_categories(ad_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adId);
            stmt.setLong(2, catId);
            ResultSet rs = stmt.executeQuery();
            return ;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in adding to ad_categories", e);
        }
    }

    public List<Long> getCategoriesByAdId(long adId) {
        try {
            String query = "SELECT * FROM ads_categories WHERE ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, adId);
            return createCategoriesFromList(stmt.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error in adding to ad_categories", e);
        }
    }

    private long extractCategoryId(ResultSet rs) throws SQLException {
        return rs.getLong("id");
    }

    private List<Long> createCategoriesFromList(ResultSet rs) throws SQLException {
        List<Long> categories = new ArrayList<>();

        while (rs.next()) {
            categories.add(extractCategoryId(rs));
        }
        return categories;
    }
}
