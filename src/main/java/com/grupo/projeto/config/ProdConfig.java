package com.grupo.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.grupo.projeto.service.DBService;

@Configuration
@Profile("prod")
public class ProdConfig {

	//Atenção essa classe só devera ser realizada apenas uma vez
	/*@Autowired
	private DBService service;
	
	@Bean
	public void instanciaDB() {	
		this.service.instanceDB();
	}*/
}
