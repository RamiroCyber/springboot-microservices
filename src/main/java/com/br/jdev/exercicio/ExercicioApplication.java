package com.br.jdev.exercicio;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.br.jdev.exercicio.entities.User;
import com.br.jdev.exercicio.repositories.UserRepository;

@SpringBootApplication
public class ExercicioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExercicioApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

	/*	User user1 = new User("ramiro", "01581817171", "avenida jose", "ramiro.dr@gmail.com", new Date());

		user1.getPhones().addAll(Arrays.asList("3215484", "85484845"));

		userRepository.save(user1);
*/
	}

}
