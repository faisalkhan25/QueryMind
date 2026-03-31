package io.github.faisalkhan25.quizService.repositories;

import io.github.faisalkhan25.quizService.collections.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByCategory(String category);
    Optional<Quiz> findByTitle(String title);
}
