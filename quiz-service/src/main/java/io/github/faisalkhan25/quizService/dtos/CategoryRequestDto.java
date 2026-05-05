package io.github.faisalkhan25.quizService.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategoryRequestDto {

    @NotEmpty(message = "Title is Required")
    private String title;

    @NotEmpty(message = "Description is Required")
    private String description;

    @NotNull(message = "Provide the Status: true/false")
    private Boolean active;
}
