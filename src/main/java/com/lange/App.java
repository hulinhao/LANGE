package com.lange;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 * @author lange
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.lange.game.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
