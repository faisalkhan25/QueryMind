package io.github.faisalkhan25.quizService.controller;

import io.github.faisalkhan25.quizService.dtos.QuizRequestDto;
import io.github.faisalkhan25.quizService.dtos.QuizResponseDto;
import io.github.faisalkhan25.quizService.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    private final QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<QuizResponseDto> createQuiz(@Valid @RequestBody QuizRequestDto requestDto) {
        QuizResponseDto responseDto = quizService.createQuiz(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PatchMapping
    public ResponseEntity<QuizResponseDto> updateQuiz(
            @Valid @RequestBody QuizRequestDto requestDto,
            String quizId) {
        QuizResponseDto responseDto = quizService.updateQuiz(requestDto, quizId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponseDto> getQuizById(@PathVariable("id") String quizId) {
        QuizResponseDto responseDto = quizService.getQuizById(quizId);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizById(@PathVariable("id") String quizId) {
        quizService.deleteQuiz(quizId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuizResponseDto>> getAllQuizs() {
        List<QuizResponseDto> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}
