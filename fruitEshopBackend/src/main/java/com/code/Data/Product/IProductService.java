package com.code.Data.Product;

import java.util.List;


public interface IProductService {
    public void save(Product product);
    public Product findByName(String name);
    public List<Product> getAll();

    public Product findById(int id);

    public void delete(int id);
}
