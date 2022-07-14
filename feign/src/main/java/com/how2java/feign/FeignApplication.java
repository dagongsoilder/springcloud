package com.how2java.feign;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {

    public static void main(String[] args) {
        //判断rabbitmq是否启动
        int rabbitMqPort=5672;
        if (!NetUtil.isUsableLocalPort(rabbitMqPort)){
            System.err.printf("未在端口%d 发现 rabbitMQ服务，请检查rabbitMQ 是否启动", rabbitMqPort );
            System.exit(1);
        }
        int port = 0;
        int defaultPort = 8012;
        Future<Integer> future = ThreadUtil.execAsync(() ->{
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8012 、 8013  或者  8014，超过5秒将默认使用"+defaultPort);
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String strPort = scanner.nextLine();
                if(!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                    continue;
                }
                else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });

            try {
                port=future.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException|ExecutionException|TimeoutException e) {
                e.printStackTrace();
            }


        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(FeignApplication.class).properties("server.port=" + port).run(args);
    }
    @Bean
    /**
     * 服务器链路追踪抽样方式：持续
     */
    public Sampler defaultSimple(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
