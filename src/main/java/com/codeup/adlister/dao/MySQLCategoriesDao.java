package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public class MySQLCategoriesDao extends MySQLDao implements Categories {
    public MySQLCategoriesDao(Config config) {
        super(config);
    }

    @Override
    public Category searchByCategory(String type) {
        return null;
    }
}
