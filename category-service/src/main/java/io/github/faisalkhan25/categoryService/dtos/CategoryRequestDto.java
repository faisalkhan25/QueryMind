package io.github.faisalkhan25.categoryService.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequestDto {
    private String title;
    private String description;
    private Boolean active;
}
