package io.github.faisalkhan25.quizService.service.impl;

import io.github.faisalkhan25.quizService.collections.Quiz;
import io.github.faisalkhan25.quizService.dtos.QuizRequestDto;
import io.github.faisalkhan25.quizService.dtos.QuizResponseDto;
import io.github.faisalkhan25.quizService.exception.ResourceNotFoundException;
import io.github.faisalkhan25.quizService.mapper.QuizMapper;
import io.github.faisalkhan25.quizService.repositories.QuizRepository;
import io.github.faisalkhan25.quizService.service.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;
    private final QuizMapper quizMapper;
    public QuizServiceImpl(QuizRepository quizRepository, ModelMapper modelMapper, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.quizMapper = quizMapper;
    }

    @Override
    public QuizResponseDto createQuiz(QuizRequestDto requestDto) {
        Quiz quiz = modelMapper.map(requestDto, Quiz.class);
        // Before saving the quiz to database first check is the category id valid by making the
        // call to category-service.
        Quiz savedQuiz = quizRepository.save(quiz);
        return modelMapper.map(savedQuiz, QuizResponseDto.class);
    }

    @Override
    public QuizResponseDto updateQuiz(QuizRequestDto requestDto, String quizId) {
        // before updating the quiz check the category id is valid or not by making HTTP request
        // category-service

        Quiz quiz = quizRepository.findById(quizId).orElseThrow(
                () -> new ResourceNotFoundException("Quiz with id: " + quizId + " not found"));
        quizMapper.update(quiz, requestDto);
        Quiz savedQuiz = quizRepository.save(quiz);
        return modelMapper.map(savedQuiz, QuizResponseDto.class);
    }

    @Override
    public QuizResponseDto getQuizById(String quizId) {
        return quizRepository.findById(quizId)
                .map(quiz -> modelMapper.map(quiz, QuizResponseDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Quiz with id: " + quizId + " does not exist"));
    }

    @Override
    public void deleteQuiz(String quizId) {
        quizRepository.findById(quizId).orElseThrow(
                () -> new ResourceNotFoundException("Quiz with id: " + quizId + " not found"));
        quizRepository.deleteById(quizId);
    }

    @Override
    public List<QuizResponseDto> getAllQuizzes() {
        return quizRepository.findAll().stream()
                .map(quiz -> modelMapper.map(quiz, QuizResponseDto.class))
                .toList();
    }
}
