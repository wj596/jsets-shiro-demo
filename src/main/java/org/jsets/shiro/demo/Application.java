package org.jsets.shiro.demo;

import org.jsets.shiro.config.EnableJsetsShiro;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.jsets.shiro.demo.mapper")
@EnableCaching
@EnableJsetsShiro
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}