package com.code.Data.Product;

import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;

import java.util.List;


public interface IProductService {
    public void save(CreateOrUpdateProductRequest request);
    public Product findByName(String name);
    public List<Product> getAll();
    public Product findById(int id);
    public void delete(int id);
    public void disable(int id);
    public void enable(int id);
}
