package com.code.Data.ProductImg;

import java.util.List;

public interface IProductImgService {
    public void save(ProductImg product_img);
    public List<ProductImg> getByProduct(String name);

    public void delete(int id);
}
