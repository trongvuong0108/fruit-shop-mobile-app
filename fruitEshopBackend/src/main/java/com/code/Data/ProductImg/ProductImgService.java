package com.code.Data.ProductImg;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImgService implements IProductImgService {

    private final IProductImgRepository productImgRepository ;

    public ProductImgService(IProductImgRepository product_imgRepository) {
        this.productImgRepository = product_imgRepository;
    }

    @Override
    public void save(ProductImg product_img) {
        productImgRepository.save(product_img);
    }
    @Override
    public List<ProductImg> getByProduct(String name) {
        List<ProductImg> product_imgs =  productImgRepository.findAll();
        List<ProductImg> result = new ArrayList<ProductImg>();
        for (ProductImg img:product_imgs) {
            if(img.getProduct().getName().equals(name)) result.add(img);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        productImgRepository.deleteById(id);
    }


}
