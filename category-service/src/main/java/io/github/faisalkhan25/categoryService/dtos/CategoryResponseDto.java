package io.github.faisalkhan25.categoryService.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDto {
    private String id;
    private String title;
    private String description;
    private Boolean active;
}
