package com.open.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liuxiaowei
 * @date 2022年10月10日 16:54
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class FeiOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeiOrderApplication.class, args);
    }
}
