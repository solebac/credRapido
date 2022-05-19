package com.solebac.credRapido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CredRapidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredRapidoApplication.class, args);
		/*System.out.println(new BCryptPasswordEncoder().encode("test")); Test: Gerando Senha*/
	}

}
