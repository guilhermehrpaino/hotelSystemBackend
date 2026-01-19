package br.com.systemhotel;

import br.com.systemhotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemhotelApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemhotelApplication.class, args);
	}



}
