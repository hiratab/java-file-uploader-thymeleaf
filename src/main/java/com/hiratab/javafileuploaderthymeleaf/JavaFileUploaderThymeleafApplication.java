package com.hiratab.javafileuploaderthymeleaf;

import com.hiratab.javafileuploaderthymeleaf.configurations.StorageProperties;
import com.hiratab.javafileuploaderthymeleaf.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class JavaFileUploaderThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFileUploaderThymeleafApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
