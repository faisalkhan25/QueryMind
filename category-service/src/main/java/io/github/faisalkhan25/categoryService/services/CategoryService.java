package io.github.faisalkhan25.categoryService.services;


import io.github.faisalkhan25.categoryService.dtos.CategoryRequestDto;
import io.github.faisalkhan25.categoryService.dtos.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
    CategoryResponseDto updateCategory(CategoryRequestDto requestDto);
    void deleteCategory(CategoryRequestDto requestDto);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(Long categoryId);
}
