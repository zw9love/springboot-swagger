package com.roncoo.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * @author zengwei
 */
//@ServletComponentScan
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.roncoo.swagger")
public class ConfigApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigApplication.class);
	}
	public static void main(String[] args) {

		SpringApplication.run(ConfigApplication.class, args);
	}
}
