package com.how2java.feign.client;

import com.how2java.feign.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-13 19:24
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign{
    @Override
    public List<Product> listProducts() {
        List<Product> result =new ArrayList<Product>();
        result.add(new Product(0,"产品数据微服务不可用",0));
        return result;
    }
}
