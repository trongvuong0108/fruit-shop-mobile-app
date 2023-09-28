package com.code.Data.Product;

import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;
import com.code.Enum.Action;
import com.code.Services.FileUploadService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepo;
    private final FileUploadService fileUploadService;
    public ProductService(IProductRepository productRepo, FileUploadService fileUploadService) {
        this.productRepo = productRepo;
        this.fileUploadService = fileUploadService;
    }
    @Override
    public void save(CreateOrUpdateProductRequest request) {
        String img = "";
        LocalDateTime today = LocalDateTime.now();
        Product product = null;
        if(request.getImg() != null){
            img = fileUploadService.uploadFile(request.getImg());
        }
        if(request.getAction() == Action.CREATE)
             product = new Product(request,img,true, today,null);
        else
            product = new Product(request,img,true, null ,today);
        productRepo.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        productRepo.delete(productRepo.findById(id).get());
    }

    @Override
    public void disable(int id) {
        Product product =  productRepo.findById(id).get();
        if(product != null){
            product.setEnable(false);
            productRepo.save(product);
        } else {

        }
    }

    @Override
    public void enable(int id) {

    }
}
