package com.how2java.feign.service;

import com.how2java.feign.client.ProductClientFeign;
import com.how2java.feign.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-05 16:40
 */
@Service
public class ProductService {
    @Autowired
    ProductClientFeign productClientFeign;
    public List<Product> listProducts(){
        return productClientFeign.listProducts();
    }

}
