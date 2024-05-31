package com.code.Controller;

import com.code.Data.Category.Category;
import com.code.Data.Category.ICategoryService;
import com.code.Data.Product.DTO.ProductResponse;
import com.code.Data.Product.IProductService;
import com.code.Data.ProductImg.IProductImgService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "home")
public class HomeController {
    private final IProductService productService;
    private final IProductImgService productImgService;
    private final ICategoryService categoryService;
    public HomeController(IProductService productService, IProductImgService productImgService, ICategoryService categoryService) {
        this.productService = productService;
        this.productImgService = productImgService;
        this.categoryService = categoryService;
    }

    @GetMapping(value = "getAll")
    public List<ProductResponse> getAll(){
        List<ProductResponse> result = new ArrayList<>();
        return result;
    }
    @GetMapping(value = "getImgByProduct")
    public List<String> getImgByProduct(@RequestParam("name") String name ){
        List<String> res = new ArrayList<>();
        return res;
    }

    @GetMapping(value = "getCate")
    public List<Category> getCate(){
        return categoryService.getAll();
    }

    @GetMapping(value = "getByCate")
    public List<ProductResponse> getByCate(@RequestParam("cate")String name){
        List<ProductResponse> result = new ArrayList<>();
        return result;
    }

    @GetMapping(value = "find")
    public List<ProductResponse> find(@RequestParam("kw")String kw){
        List<ProductResponse> result = new ArrayList<>();
        return result;
    }

    @PostMapping(value = "getSameCate")
    public List<ProductResponse> getSameCate(@RequestBody ProductResponse productModel){
        List<ProductResponse> result = new ArrayList<>();
        return result;
    }

}
