package com.code.Controller;

import com.code.Data.Category.ICategoryService;
import com.code.Data.Category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "getAll")
    private List<Category> getAll(){
        return categoryService.getAll();
    }


}
