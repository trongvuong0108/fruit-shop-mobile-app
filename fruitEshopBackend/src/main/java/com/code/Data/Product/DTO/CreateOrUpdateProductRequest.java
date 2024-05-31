package com.code.Data.Product.DTO;

import com.code.Data.Category.Category;
import com.code.Data.Product.ProductBase;
import com.code.Enum.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateProductRequest extends ProductBase {
    private Category category;
    private Action action;
    private  MultipartFile img;
}
