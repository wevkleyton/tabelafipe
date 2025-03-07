package br.com.tabelafipe.tabelafipe;

import br.com.tabelafipe.tabelafipe.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelafipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabelafipeApplication.class, args);
	}

	public void run(String... args) throws  Exception{

		Principal principal = new Principal();
	}

}
