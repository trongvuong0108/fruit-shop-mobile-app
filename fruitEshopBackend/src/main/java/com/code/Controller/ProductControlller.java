package com.code.Controller;

import com.code.Data.Category.ICategoryService;
import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;
import com.code.Data.Product.IProductService;
import com.code.Data.Product.Product;
import com.code.Data.ProductImg.IProductImgService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductControlller {
    private final IProductService productService;
    private final IProductImgService productImgService;
    private final ICategoryService categoryService;
    public ProductControlller(IProductService productService, IProductImgService productImgService, ICategoryService categoryService) {
        this.productService = productService;
        this.productImgService = productImgService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "GetAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping(value = "CreateProduct")
    public void save(@RequestBody CreateOrUpdateProductRequest request){
    }


    @PostMapping(value = "UpdateProductById")
    public void update(@RequestBody CreateOrUpdateProductRequest request){
        productService.save(request);
    }

    @GetMapping(value = "DeleteProductById")
    public void update(@RequestParam int id){
    }

    @GetMapping(value = "AddProductImg")
    public void addImg(
            @RequestParam("name") String name ,
            @RequestParam("pic") MultipartFile pic
    ){
    }
}
