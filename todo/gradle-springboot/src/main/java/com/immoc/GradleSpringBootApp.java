package com.immoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GradleSpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(GradleSpringBootApp.class, args);
	}
}
