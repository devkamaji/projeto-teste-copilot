package br.com.ganog.projetotestecopilot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoTesteCopilotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTesteCopilotApplication.class, args);
	}

}
