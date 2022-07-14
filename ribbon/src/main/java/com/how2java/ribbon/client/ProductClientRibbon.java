package com.how2java.ribbon.client;

import com.how2java.ribbon.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-05 16:34
 * Ribbon 客户端， 通过 restTemplate 访问数据微服务获得数据
 */
@Component
public class ProductClientRibbon {
    @Autowired
    RestTemplate restTemplate;
    public List<Product> listProdcuts(){
        return  restTemplate.getForObject("http://PRODUCT-DATA-SERVICE/products",List.class);
    }
}
