package com.codeup.adlister.models;

public class Category {
    private String categoryName;
    private long categoryID;

    public Category() {
    }

    public Category(String categoryName, long categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }
}
