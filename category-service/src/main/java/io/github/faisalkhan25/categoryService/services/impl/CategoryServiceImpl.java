package io.github.faisalkhan25.categoryService.services.impl;

import io.github.faisalkhan25.categoryService.dtos.CategoryRequestDto;
import io.github.faisalkhan25.categoryService.dtos.CategoryResponseDto;
import io.github.faisalkhan25.categoryService.entities.Category;
import io.github.faisalkhan25.categoryService.exceptions.ResourceNotFoundException;
import io.github.faisalkhan25.categoryService.mappers.CategoryMapper;
import io.github.faisalkhan25.categoryService.repositories.CategoryRepository;
import io.github.faisalkhan25.categoryService.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = categoryMapper.toEntity(requestDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto requestDto) {
        return null;
    }

    @Override
    public void deleteCategory(CategoryRequestDto requestDto) {

    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {
        String generatedId = "CATEGORY-" + UUID.randomUUID() + "-" + categoryId;
        return categoryRepository.findById(generatedId)
                .map(categoryMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + categoryId + " doesn't exist"));
    }
}
