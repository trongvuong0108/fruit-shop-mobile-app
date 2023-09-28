package com.code.Data.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAll();
    public Category findById(int id);
    public void save(Category category);
}
