package com.example.Ejercicio1;

import com.example.Ejercicio1.models.Lapto;
import com.example.Ejercicio1.repository.LaptoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio1Application.class, args);

		LaptoRepository repository = context.getBean(LaptoRepository.class);

		Lapto lapto1 = new Lapto(
				null,
				"Hp",
				"HP-bsa14542",
				150000.0);

		Lapto lapto2 = new Lapto(
				null,
				"ASUS",
				"RAPTOR",
				450000.0);

		repository.save(lapto1);
		repository.save(lapto2);

		System.out.println(repository.findAll().size());

	}




}
