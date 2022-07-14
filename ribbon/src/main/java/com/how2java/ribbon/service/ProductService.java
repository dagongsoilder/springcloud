package com.how2java.ribbon.service;

import com.how2java.ribbon.client.ProductClientRibbon;
import com.how2java.ribbon.pojo.Product;
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
    ProductClientRibbon productClientRibbon;
    public List<Product> listProducts(){
        return productClientRibbon.listProdcuts();
    }

}
