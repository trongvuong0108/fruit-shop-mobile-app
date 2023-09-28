package com.code.Data.Product.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
public Enum Action{

        }
@Data
public class CreateOrUpdateProductRequest {
    private String name ;
    private String quantity ;
    private String priceIn ;
    private String priceOut;
    private MultipartFile pic;
    private int categoryId;
    private int action;
}
