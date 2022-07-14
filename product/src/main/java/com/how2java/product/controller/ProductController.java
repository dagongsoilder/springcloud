package com.how2java.product.controller;

import com.how2java.product.pojo.Product;
import com.how2java.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-04 17:38
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/products")
    public Object products(){
        List<Product> ps = productService.listProducts();
        return ps;
    }

}
