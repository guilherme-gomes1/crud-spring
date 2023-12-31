package com.guilherme.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.guilherme.crudspring.enums.Category;
import com.guilherme.crudspring.enums.Status;
import com.guilherme.crudspring.model.Course;
import com.guilherme.crudspring.model.Lesson;
import com.guilherme.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular");
			c.setCategory(Category.FRONT_END);
			c.setStatus(Status.ACTIVE);

			Lesson l = new Lesson();
			l.setName("null");
			l.setYoutubeUrl("null");
			l.setCourse(c);

			Lesson l1 = new Lesson();
			l1.setName("null12");
			l1.setYoutubeUrl("null21");
			l1.setCourse(c);
			
			c.getLessons().add(l);
			c.getLessons().add(l1);

			courseRepository.save(c);
		};
	}

}
