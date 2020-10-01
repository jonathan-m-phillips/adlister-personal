package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    List<Category> allCats(); // working properly
    Category searchByCategoryName(String type);
    Category getByCategoryID(long categoryId);
}
