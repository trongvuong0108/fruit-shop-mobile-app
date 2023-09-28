package com.code.Data.Product.DTO;

import com.code.Data.Category.Category;
import lombok.Data;

@Data
public class ProductResponse {
    private String name ;
    private float priceOut;
    private Category category;
    private String img;
    private float quantity;
}
