package com.basicjpaweb.basicjpaweb.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student night = new Student(1L,"NightFury","nightfury@berk.com", LocalDate.of(2000, Month.APRIL,4));
            Student light = new Student(2L,"LightFury","lightfury@berk.com", LocalDate.of(2000, Month.APRIL,4));
            studentRepository.saveAll(Arrays.asList(night,light));
        };
    }

}
