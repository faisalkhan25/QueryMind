package io.github.faisalkhan25.quizService.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizRequestDto {

    @NotEmpty(message = "Provide Title of Quiz")
    private String title;

    @NotEmpty(message = "Provide Description of the Quiz")
    private String description;

    @NotNull(message = "Provide max marks of the quiz")
    @Positive(message = "provide the valid max marks")
    private Long maxMarks;

    @NotNull(message = "Provide time limit of the quiz")
    @Positive(message = "provide the valid time limit")
    private Double timeLimit;

    @NotEmpty(message = "Provide the author of the quiz")
    private String createdBy;

    @NotNull(message = "provide the number of questions present in the quiz")
    @Positive(message = "provide the valid question number")
    private Integer totalQuestions;

    @NotNull(message = "Provide the passing marks")
    @Positive(message = "Passing marks should be positive")
    private Long passingMarks;

    @NotEmpty(message = "Provide the category ID")
    private String categoryId;

    @NotNull(message = "Field must not be null")
    private Boolean live;
}
