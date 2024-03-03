package com.aagterra.transportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.aagterra.transportes", "com/aagterra/transportes/controller", "com/aagterra/transportes/exception", "model.tms", "com/aagterra/transportes/repository", "service"})
//@EntityScan(basePackages = {"model.tms.despesas", "model.tms.faturamento", "model.tms.socios"})
public class TransportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportesApplication.class, args);
		System.out.println("Hola mundo");
	}

}
