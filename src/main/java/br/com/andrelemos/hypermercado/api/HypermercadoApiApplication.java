package br.com.andrelemos.hypermercado.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.andrelemos.hypermercado.api.config.HypermercadoApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(HypermercadoApiProperties.class)
public class HypermercadoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypermercadoApiApplication.class, args);
	}
}
