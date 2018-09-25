package com.swp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swp.mapper")
public class Springboot6MybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot6MybatisXmlApplication.class, args);
	}
}
