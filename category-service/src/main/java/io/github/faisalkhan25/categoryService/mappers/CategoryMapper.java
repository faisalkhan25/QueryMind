package io.github.faisalkhan25.categoryService.mappers;


import io.github.faisalkhan25.categoryService.dtos.CategoryRequestDto;
import io.github.faisalkhan25.categoryService.dtos.CategoryResponseDto;
import io.github.faisalkhan25.categoryService.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequestDto requestDto) {
        return Category.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .active(requestDto.getActive())
                .build();
    }
    public CategoryResponseDto toResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .active(category.getActive())
                .build();
    }
}
