package com.code.Data.ProductImg;

import com.code.Entity.productImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProductImgServiceImpl implements IProductImgService {

    private final IProductImgRepository productImgRepository ;

    public IProductImgServiceImpl(IProductImgRepository product_imgRepository) {
        this.productImgRepository = product_imgRepository;
    }

    @Override
    public void save(productImg product_img) {
        productImgRepository.save(product_img);
    }
    @Override
    public List<productImg> getByProduct(String name) {
        List<productImg> product_imgs =  productImgRepository.findAll();
        List<productImg> result = new ArrayList<productImg>();
        for (productImg img:product_imgs) {
            if(img.getProduct().getName().equals(name)) result.add(img);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        productImgRepository.deleteById(id);
    }


}
