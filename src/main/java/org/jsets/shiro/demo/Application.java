package org.jsets.shiro.demo;

import org.jsets.jdbc.config.EnableJsetsJdbc;
import org.jsets.shiro.config.EnableJsetsShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJsetsJdbc
@EnableJsetsShiro
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}