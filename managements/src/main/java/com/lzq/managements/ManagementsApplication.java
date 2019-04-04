package com.lzq.managements;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.lzq.managements.dao")
@EnableScheduling
public class ManagementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementsApplication.class, args);
    }
}
