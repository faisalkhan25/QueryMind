package io.github.faisalkhan25.categoryService.controllers;

import io.github.faisalkhan25.categoryService.dtos.CategoryRequestDto;
import io.github.faisalkhan25.categoryService.dtos.CategoryResponseDto;
import io.github.faisalkhan25.categoryService.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto requestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.createCategory(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseDto);
    }
    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(
            @Valid @RequestBody CategoryRequestDto requestDto,
            @PathVariable String id) {
        return ResponseEntity.ok(categoryService.updateCategory(requestDto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
