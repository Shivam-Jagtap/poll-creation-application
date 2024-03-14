package com.shivam;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shivam.dao.PollCreationDaoImpl;

@SpringBootApplication
public class PollCreationApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollCreationApplicationServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
}
