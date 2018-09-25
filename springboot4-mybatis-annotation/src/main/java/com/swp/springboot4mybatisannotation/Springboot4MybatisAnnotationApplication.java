package com.swp.springboot4mybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swp.springboot4mybatisannotation.mapper")
public class Springboot4MybatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot4MybatisAnnotationApplication.class, args);
	}
}
