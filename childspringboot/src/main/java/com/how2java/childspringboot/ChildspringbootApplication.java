package com.how2java.childspringboot;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ChildspringbootApplication {

    public static void main(String[] args) {
        int port=8761;
        if (!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }

       new SpringApplicationBuilder(ChildspringbootApplication.class).properties("server.port="+port).run(args);
    }

}
