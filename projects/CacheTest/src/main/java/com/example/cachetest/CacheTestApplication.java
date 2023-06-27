package com.example.cachetest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.example.cachetest.mapper","mapper"})
public class CacheTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheTestApplication.class, args);
    }

}
