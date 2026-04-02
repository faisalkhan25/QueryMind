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
        String id = "CATEGORY-" + UUID.randomUUID().toString();
        Category category = categoryMapper.toEntity(requestDto);
        category.setId(id);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto requestDto, String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This category doesn't exist"));

        categoryMapper.updateCategory(category, requestDto);

        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toResponseDto(updatedCategory);
    }

    @Override
    public void deleteCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(String categoryId) {

        return categoryRepository.findById(categoryId)
                .map(categoryMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + categoryId + " doesn't exist"));
    }
}
