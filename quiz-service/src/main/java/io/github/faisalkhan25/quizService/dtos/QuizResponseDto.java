package io.github.faisalkhan25.quizService.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizResponseDto {
    private String id;
    private String title;
    private String description;
    private Long maxMarks;
    private Double timeLimit;
    private String createdBy;
    private String totalQuestions;
    private Long passingMarks;
    private String categoryId;
    private Boolean live;
}
