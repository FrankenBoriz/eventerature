package com.assignment3;

import com.assignment3.domain.Student;
import com.assignment3.repository.StudentRepository;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner seed(StudentRepository repository) {
        return args -> {
            log.info("seeding DB");
            Student s = new Student("pass", "Boris", "Oslo 23", "Boris@bor.bo", "ave3615", "12345678");
            repository.save(s);

            log.info("seeded");

            Iterable<Student> fromdb = repository.findAll();

            fromdb.forEach(e -> log.info(e.getName()));

            Logger logger = LoggerFactory.getLogger(Main.class);
        };
    }
}
