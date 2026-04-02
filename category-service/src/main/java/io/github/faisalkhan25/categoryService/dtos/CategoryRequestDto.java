package io.github.faisalkhan25.categoryService.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequestDto {
    @NotEmpty(message = "Title is Required")
    private String title;
    @NotEmpty(message = "Description is Required")
    private String description;
    @NotNull(message = "Provide the Status: true/false")
    private Boolean active;
}
