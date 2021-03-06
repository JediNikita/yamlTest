package com.yodaplus.yamltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.yodaplus.controller", "com.yodaplus.yamltest.model", "com.yodaplus.yamltest.service"})
public class YamlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamlTestApplication.class, args);
	}
	
}
