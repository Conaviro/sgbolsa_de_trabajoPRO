package com.ug.ec;

import com.ug.ec.dto.ComunidadDto;
import com.ug.ec.model.responses.ComunidadResponsesModel;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SgbTrabajoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgbTrabajoApplication.class, args);
	}
        
        @Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

	

}
