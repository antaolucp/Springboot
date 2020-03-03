package com.dxh.bookillustration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan("com.dxh.bookillustration.mapper")
@SpringBootApplication
@EnableAsync
public class BookillustrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookillustrationApplication.class, args);
    }

}
