package com.ty.food.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty.food")
public class Config{

	@Bean
	public EntityManager getEntityManager(){
		return Persistence.createEntityManagerFactory("vikas").createEntityManager();
	}
}