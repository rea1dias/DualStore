package com.example.DualStore.Service;

import com.example.DualStore.Model.Category;

import java.util.List;

public interface CategoryService {


    public Category saveCategory(Category category);

    public Boolean existCategory(String name);

    public List<Category> getAllCategory();

    public Boolean deleteCategory(int id);

    public Category getCategoryById(int id);

}
