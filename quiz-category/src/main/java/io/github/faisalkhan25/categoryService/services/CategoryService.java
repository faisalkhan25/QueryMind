package io.github.faisalkhan25.categoryService.services;


import io.github.faisalkhan25.categoryService.dtos.CategoryRequestDto;
import io.github.faisalkhan25.categoryService.dtos.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);
    CategoryResponseDto updateCategory(CategoryRequestDto requestDto, String id);
    void deleteCategoryById(String categoryId);
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(String categoryId);
}
