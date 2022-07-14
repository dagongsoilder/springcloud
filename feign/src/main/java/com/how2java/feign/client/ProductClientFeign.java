package com.how2java.feign.client;

import com.how2java.feign.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author wbinbin
 * @create 2022-07-05 21:40
 * Feign 客户端， 通过注解的方式 访问数据微服务获得数据
 */
//这就表示，如果访问的 PRODUCT-DATA-SERVICE数据微服务 不可用的话，就调用 ProductClientFeignHystrix 来进行反馈信息。
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {
    @GetMapping("/products")
    public List<Product> listProducts();
}
