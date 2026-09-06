package br.edu.ufersa.pw.todo.buggytrip;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner{

		@Value("${var:valor default na classe TodoApiaplication}")
		String teste;
		 public void run(ApplicationArguments args) throws Exception {
			 System.out.println("Rodou Corretamente!com " + teste);

		 }



	 }
}
