package com.gong.url;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 主程序入口
 *
 * @author gongjunbing
 * @date 2020/03/12 23:07
 **/
@SpringBootApplication
@MapperScan("com.gong.url.mapper")
@EnableTransactionManagement
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
