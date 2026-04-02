package io.github.faisalkhan25.quizService.mapper;

import io.github.faisalkhan25.quizService.collections.Quiz;
import io.github.faisalkhan25.quizService.dtos.QuizRequestDto;
import org.springframework.stereotype.Component;

@Component
public class QuizMapper {
    public void update(Quiz quiz, QuizRequestDto requestDto) {
        quiz.setTitle(requestDto.getTitle());
        quiz.setDescription(requestDto.getDescription());
        quiz.setMaxMarks(requestDto.getMaxMarks());
        quiz.setTimeLimit(requestDto.getTimeLimit());
        quiz.setCreatedBy(requestDto.getCreatedBy());
        quiz.setTotalQuestions(requestDto.getTotalQuestions());
        quiz.setPassingMarks(requestDto.getPassingMarks());
        quiz.setCategoryId(requestDto.getCategoryId());
        quiz.setLive(requestDto.getLive());
    }
}
