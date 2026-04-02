package io.github.faisalkhan25.quizService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuizConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
