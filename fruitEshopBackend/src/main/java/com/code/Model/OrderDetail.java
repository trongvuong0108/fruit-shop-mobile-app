package com.code.Model;

import com.code.Data.Product.DTO.ProductResponse;
import lombok.Data;

@Data
public class OrderDetail {
    private ProductResponse productModel ;
    private float quality;
}
