package io.github.faisalkhan25.quizService.service;

import io.github.faisalkhan25.quizService.dtos.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto getCategoryById(String id);
}