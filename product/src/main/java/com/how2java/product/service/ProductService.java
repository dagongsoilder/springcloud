package com.how2java.product.service;

import com.how2java.product.pojo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-04 17:39
 */
@Service
public class ProductService {
    @Value("${server.port}")
    String port;
    public List<Product> listProducts(){
        List<Product> ps=new ArrayList<Product>();
        ps.add(new Product(1,"product a from port:"+port,50));
        ps.add(new Product(2,"product a from port:"+port,150));
        ps.add(new Product(3,"product a from port:"+port,250));
        return  ps;
    }

}
