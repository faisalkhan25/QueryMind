package io.github.faisalkhan25.quizService.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {
    private String id;
    private String title;
    private String description;
    private Boolean active;
}
