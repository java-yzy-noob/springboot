package com.javasm.management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javasm.*.Dao")  // 扫描mapper类,注入到spring容器中
public class ManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementSystemApplication.class, args);
    }
}
