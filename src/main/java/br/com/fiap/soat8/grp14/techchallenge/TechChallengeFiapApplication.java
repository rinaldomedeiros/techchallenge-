package br.com.fiap.soat8.grp14.techchallenge;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechChallengeFiapApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengeFiapApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
