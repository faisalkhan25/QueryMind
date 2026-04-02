package io.github.faisalkhan25.quizService.service;

import io.github.faisalkhan25.quizService.dtos.QuizRequestDto;
import io.github.faisalkhan25.quizService.dtos.QuizResponseDto;

import java.util.List;

public interface QuizService {
    QuizResponseDto createQuiz(QuizRequestDto requestDto);
    QuizResponseDto updateQuiz(QuizRequestDto requestDto, String quizId);
    QuizResponseDto getQuiz(String quizId);
    void deleteQuiz(String quizId);
    List<QuizResponseDto> getAllQuizzes();
}
