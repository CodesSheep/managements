package com.lzq.managements;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzq.managements.dao")
public class ManagementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementsApplication.class, args);
    }
}
