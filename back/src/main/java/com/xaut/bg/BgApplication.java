package com.xaut.bg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xaut.bg.mapper")
public class BgApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgApplication.class, args);
	}
}
