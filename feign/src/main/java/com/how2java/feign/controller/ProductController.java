package com.how2java.feign.controller;

import com.how2java.feign.pojo.Product;
import com.how2java.feign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-05 16:42
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Value("${version}")
    String version;
    @RequestMapping("/products")
    public Object products(Model m) {
        List<Product> ps=productService.listProducts();
        m.addAttribute("ps",ps);
        m.addAttribute("version",version);
        return "products";
    }


}
